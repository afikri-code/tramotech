package de.tramotech.fileutils

import java.io.File
import java.nio.charset.Charset

/**
 * Author: Ahmed Fikri
 */
class FileReader {
    fun <T> readFile(fileName: String, rowMapper: (String) -> T): List<T> {
        val results = mutableListOf<T>()

        try {
            val file = File(fileName)
            if (file.exists()) {
                file.reader(Charset.forName("ISO-8859-1")).use { reader ->
                    reader.forEachLine { line ->
                        val mappedRow = rowMapper(line)
                        results.add(mappedRow)
                    }
                }
            } else {
                println("File not found: $fileName")
            }
        } catch (e: Exception) {
            println("Error reading file: $e")
        }

        return results
    }
}
