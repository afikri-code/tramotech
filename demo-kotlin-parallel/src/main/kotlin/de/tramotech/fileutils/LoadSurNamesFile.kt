package de.tramotech.fileutils

class SurNameFileLoader(val filepath: String) {
    val reader = FileReader();
    val rowMapper: (String) -> String = { line -> line }
    fun loadNames() : List<String> {
        println("Loading surnames: ${System.currentTimeMillis()}")
        return reader.readFile(filepath,rowMapper);
    }
}