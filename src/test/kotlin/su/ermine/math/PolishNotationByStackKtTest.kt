package su.ermine.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PolishNotationByStackKtTest {

    // for test https://www.symbolab.com/solver/linear-equation-calculator

    @Test
    @DisplayName("Calculation test")
    fun testCalc() {
        val result1 = PolishNotationByStack().calc("(22 + 31 - 3) * (45 - 23 / (2 - 1))")
        assertEquals("1100", result1)

        val result2 = PolishNotationByStack().calc("(22 + 31 * 3) * (45 - 24 / (2 - 1) * 2) - 5")
        assertEquals("-350", result2)

        val result3 = PolishNotationByStack().calc("(6 + 10 - 4) / ( 1 + 1 * 2) + 1")
        assertEquals("5", result3)

        val result4 = PolishNotationByStack().calc("((1 + 2) * 4) + 3")
        assertEquals("15", result4)

        val result5 = PolishNotationByStack().calc("71 - 22 * 4 + 13")
        assertEquals("-4", result5)

        val result6 = PolishNotationByStack().calc("8 / 2 + (1 + 4 * 3 - 13 + (2 + 1) -6) / 3")
        assertEquals("3", result6)
    }
}