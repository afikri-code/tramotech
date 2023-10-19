import de.tramotech.fileutils.PreNameFileLoader
import de.tramotech.fileutils.SurNameFileLoader
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.system.measureTimeMillis

suspend fun main(args: Array<String>) {

    val root = "/Users/afikri"
    val preNamesilePath = "$root/dev/data/Namen1/Vornamen_Jungen_2008.csv"
    val surNamesFilePath = "$root/dev/data/Namen1/nachnamen.txt"
    val executionTime = measureTimeMillis {
        coroutineScope { val preNameFileLoader = PreNameFileLoader(preNamesilePath)
            val surNameFileLoader = SurNameFileLoader(surNamesFilePath)

            val preNames = async { preNameFileLoader.loadNames() }
            val surNames = async {surNameFileLoader.loadNames()}

            println("Number of surnames: ${surNames.await().size}")
            println("Number of prenames: ${preNames.await().size}") }


    }

}
