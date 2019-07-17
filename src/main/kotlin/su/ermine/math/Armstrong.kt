package su.ermine.math

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
        for (z in n..9) {
            for (k in z..9) {
                println("Value = $n$z$k")
            }
        }
    }

    val end = System.currentTimeMillis()
    val sec = (end - start) / 1000f
    println("$sec seconds")

    return ""
}