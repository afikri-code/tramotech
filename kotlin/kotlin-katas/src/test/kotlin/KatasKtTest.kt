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

    @Test
    fun testFilterAndTransform() {
        val strings = listOf("apple", "banana", "cherry", "date")
        val result = katas.filterAndTransform(strings)
        assertEquals(listOf("APPLE", "BANANA", "DATE"), result)
    }

    @Test
    fun testCalculateAverageOfEvens() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val result = katas.calculateAverageOfEvens(numbers)
        assertEquals(6.0, result, 0.01)
    }

    @Test
    fun testFindDuplicates() {
        val numbers = listOf(1, 2, 2, 3, 4, 4, 4, 5, 5, 6)
        val result = katas.findDuplicates(numbers)
        assertEquals(listOf(2, 4, 5), result)
    }

    @Test
    fun testSortAndFilterPeople() {
        val people = listOf(Person("Alice", 28), Person("Bob", 35), Person("Charlie", 22), Person("David", 40))
        val result = katas.sortAndFilterPeople(people)
        val expected = listOf(Person("Bob", 35), Person("David", 40))
        assertEquals(expected, result)
    }

}

