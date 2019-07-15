package su.ermine

import java.util.*

val priority = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)
val operands : Stack<String> = Stack()
val operators : Stack<Char> = Stack()

fun main() {
    val function1 = "(22 + 31 - 3) * (45 - 23 / (2 - 1))" // = 1100
    calc(function1.replace(" ", ""))

    println("************************")

    val function2 = "(22 + 31 * 3) * (45 - 24 / (2 - 1) * 2) - 5" // = -350
    calc(function2.replace(" ", ""))

    println("************************")

    val function3 = "(6 + 10 - 4) / ( 1 + 1 * 2) + 1" // =5
    calc(function3.replace(" ", ""))
}

fun check(operator1 : Char, operator2 : Char) : Boolean {
    return priority.getOrDefault(operator1, 0) >= priority.getOrDefault(operator2, 0) || operator2 == ')'
}

fun operation(operator : Char, operand1 : Int, operand2 : Int) : String {
    return when (operator) {
        '+' -> (operand1 + operand2).toString()
        '-' -> (operand1 - operand2).toString()
        '/' -> (operand1 / operand2).toString()
        '*' -> (operand1 * operand2).toString()
        else -> ""
    }
}

fun calc(function : String) {

    for (c in function.toCharArray()) {
        when (c) {
            '(' -> {
                operators.push(c)
            }
            ')' -> {
                while (!operators.empty()) {
                    val op = operators.pop()
                    if (op == '(') {
                        break
                    }
                    val op2 = operands.pop().toInt()
                    val op1 = operands.pop().toInt()
                    operands.push(operation(op, op1, op2))
                }
            }
            '+' -> {
                if (!operators.empty() && check(operators.peek(), c)) {
                    val op2 = operands.pop().toInt()
                    val op1 = operands.pop().toInt()
                    val op = operators.pop()
                    operands.push(operation(op, op1, op2))
                }
                operands.push("")
                operators.push(c)
            }
            '-' -> {
                if (!operators.empty() && check(operators.peek(), c)) {
                    val op2 = operands.pop().toInt()
                    val op1 = operands.pop().toInt()
                    val op = operators.pop()
                    operands.push(operation(op, op1, op2))
                }
                operands.push("")
                operators.push(c)
            }
            '/' -> {
                if (!operators.empty() && check(operators.peek(), c)) {
                    val op2 = operands.pop().toInt()
                    val op1 = operands.pop().toInt()
                    val op = operators.pop()
                    operands.push(operation(op, op1, op2))

                }
                operands.push("")
                operators.push(c)
            }
            '*' -> {
                if (!operators.empty() && check(operators.peek(), c)) {
                    val op2 = operands.pop().toInt()
                    val op1 = operands.pop().toInt()
                    val op = operators.pop()
                    operands.push(operation(op, op1, op2))
                }
                operands.push("")
                operators.push(c)
            }
            else -> {
                operands.push(
                    if (!operands.empty()) { operands.pop() } else { "" } + c.toString()
                )
            }
        }
    }

    if (!operators.empty()) {
        val op2 = operands.pop().toInt()
        val op1 = operands.pop().toInt()
        val op = operators.pop()
        operands.push(operation(op, op1, op2))
    }

    println("*************Operators*******************")

    while (!operators.isEmpty()) {
        println(operators.pop())
    }

    println("*************Operands*******************")

    while (!operands.isEmpty()) {
        println(operands.pop())
    }
}