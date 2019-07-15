package su.ermine

import java.util.*

fun main() {
    val function = "(22 + 31 - 3) * (45 - 23 / (2 - 1) )"
    calc(function.replace(" ", ""))
}

fun calc(function : String) {
    val stack : Stack<String> = Stack()

    var oper = ""
    var sign = ""
    for (c in function.toCharArray()) {
        when (c) {
            '(' -> {
                if (oper != "") stack.push(oper)
                if (sign != "") stack.push(sign)
                sign = ""
                oper = ""
                stack.push("(")
            }
            ')' -> {
                if (oper != "") stack.push(oper)
                if (sign != "") stack.push(sign)
                sign = ""
                oper = ""
                stack.push(")")
            }
            '+' -> {
                if (oper != "") stack.push(oper)
                if (sign != "") stack.push(sign)
                sign = "+"
                oper = ""
            }
            '-' -> {
                if (oper != "") stack.push(oper)
                if (sign != "") stack.push(sign)
                sign = "-"
                oper = ""
            }
            '/' -> {
                if (oper != "") stack.push(oper)
                if (sign != "") stack.push(sign)
                sign = "/"
                oper = ""
            }
            '*' -> {
                if (oper != "") stack.push(oper)
                if (sign != "") stack.push(sign)
                sign = "*"
                oper = ""
            }
            else -> {
                oper += c
            }
        }
    }

    while (!stack.isEmpty()) {
        System.err.println(stack.pop())
    }
}