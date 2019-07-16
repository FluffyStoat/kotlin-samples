package su.ermine.math

import java.util.*

class PolishNotationByStack {
    private val priority = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)
    private val tokens : Stack<String> = Stack()
    private val operators : Stack<Char> = Stack()

    companion object {
        @JvmStatic fun main(args : Array<String>) {
            for (arg in args) {
                val app  = PolishNotationByStack()
                app.calc(arg)
            }
        }
    }

    fun calc(function : String) : String{
        for (c in function.replace(" ", "").toCharArray()) {
            when (c) {
                '(' -> operators.push(c)
                ')' -> {
                    while (!operators.empty()) {
                        val op = operators.pop()
                        if (op == '(') {
                            break
                        }
                        val op2 = tokens.pop().toInt()
                        val op1 = tokens.pop().toInt()
                        tokens.push(operation(op, op1, op2))
                    }
                }
                '+', '-', '/', '*' -> action(c)
                else -> {
                    tokens.push(
                        if (!tokens.empty()) { tokens.pop() } else { "" } + c.toString()
                    )
                }
            }
        }

        while (!operators.empty()) {
            val op2 = tokens.pop().toInt()
            val op1 = tokens.pop().toInt()
            val op = operators.pop()
            tokens.push(operation(op, op1, op2))
        }

        println("************* $function *******************")

        var result = "NaN"
        while (!tokens.isEmpty()) {
            result = tokens.pop()
        }

        println("Result: $result")

        return result
    }

    private fun check(operator1 : Char, operator2 : Char) : Boolean {
        return priority.getOrDefault(operator1, 0) >= priority.getOrDefault(operator2, 0) || operator2 == ')'
    }

    private fun operation(operator : Char, operand1 : Int, operand2 : Int) : String {
        return when (operator) {
            '+' -> (operand1 + operand2).toString()
            '-' -> (operand1 - operand2).toString()
            '/' -> (operand1 / operand2).toString()
            '*' -> (operand1 * operand2).toString()
            else -> ""
        }
    }

    private fun action(c : Char) {
        while (!operators.empty()) {
            if (!operators.empty() && check(operators.peek(), c)) {
                val op2 = tokens.pop().toInt()
                val op1 = tokens.pop().toInt()
                val op = operators.pop()
                tokens.push(operation(op, op1, op2))
            } else {
                break
            }
        }
        tokens.push("")
        operators.push(c)
    }
}