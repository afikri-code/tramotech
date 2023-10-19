package de.tramotech.fileutils

class PreNameFileLoader(val filepath: String) {
    val rowMapper: (String) -> String = { line ->
        val columns = line.split(";")
        if (columns.size > 1) {
            columns[1].trim()
        } else {
            ""
        }
    }

    val reader = FileReader()

    fun loadNames(): List<String> {
        println("Loading prenames: ${System.currentTimeMillis()}")
        return reader.readFile(filepath, rowMapper)
    }
}
