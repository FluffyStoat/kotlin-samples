package su.ermine.math

import java.lang.Math.pow

fun main() {
    testArmstrongNumbers()
}

// Long.MAX_VALUE = 9223372036854775807
/*
    111 122 133 144 155 166 177 188 199 222
    112 123 134 145
    113 124 135 146
    114 125 136 147
    115 126 137 148
    116 127 138 149
    117 128 139
    118 129
    119
*/

fun testArmstrongNumbers () : String {
    val start = System.currentTimeMillis()
    val limit = Long.MAX_VALUE

    var value = Long.MAX_VALUE
    var count = 0

    do {
        value /= 10
        count++
    } while (value != 0L)

    println("Count = $count")

    for (n in 0..count) {
        //println(pow(10.0, n.toDouble()))
        find(n)
    }

/*
    for (n in 0..count) {
        for (z in n..9) {
            for (k in z..9) {
                println("Value = $n$z$k")
            }
        }
    }
*/

    val end = System.currentTimeMillis()
    val sec = (end - start) / 1000f
    println("$sec seconds")

    return ""
}

/*
    При использовании конструктора нужно указать размер массива в первом параметре и лямбда-выражение во втором.


    val myArray = Array(5, { i -> i * 2 })
    println(myArray[3])
    Мы задали пять элементов и каждый элемент в цикле умножаем на 2. В итоге получим массив чисел 0, 2, 4, 6, 8.

    Создадим массив строк от "A" до "Z"


    val letters = Array<String>(26) { i -> ('A' + i).toString() }
    println(letters.joinToString(""))
    Лямбда-выражение принимает индекс элемента массива и возвращает значение, которое будет помещено в массив с этим индексом. Значение вычисляется путём сложения индекса с кодом символа и преобразованием результата в строку.
*/

fun find(n : Int) {
    if (n == 0) return

    val arr = IntArray(n) {i -> i + 1}

    print("Массив #$n")
    for (i in arr) {
        print("\t $i")
    }

    println()
}