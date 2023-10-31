import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KatasKtTest {

     val katas = Katas()
    @Test
    fun sumOfEvens() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val result = katas.sumOfEvens(numbers)

        // Test the result
        assertEquals(30,result)
    }

    @Test
    fun squareNumbers() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val result = katas.squareNumbers(numbers)

        // Test the result
        assertEquals(listOf(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), result)
    }

    @Test
    fun findMaxNumber() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val result = katas.findMaxNumber(numbers)

        // Test the result
        assertEquals(10,result)
    }

}

