class KatasSolution {
    // Function to find the sum of all even numbers in a list
    fun sumOfEvens(numbers: List<Int>): Int {
        // Filter the list to keep only even numbers and then sum them
        return numbers.filter { it % 2 == 0 }.sum()
    }

    // Function to square each number in a list and return the results in a new list
    fun squareNumbers(numbers: List<Int>): List<Int> {
        // Map each number to its square and collect the results into a new list
        return numbers.map { it * it }
    }

    // Function to find the maximum number in a list
    fun findMaxNumber(numbers: List<Int>): Int? {
        // Use the maxOrNull function to find the maximum number
        return numbers.maxOrNull()
    }
}



