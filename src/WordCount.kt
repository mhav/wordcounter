import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    //println("Please enter the path to a input file:")
    //val input = readLine()
    val input = "input.txt"

    val inputStream: InputStream = File(input).inputStream()
    val allTheWords = inputStream.bufferedReader().use { it.readText() }

    val words = allTheWords.replace("\n", " ").replace("\r", "")
            .replace(",", "").replace(".","")
            .replace("\n", " ").split(" ")

    val wordMap = mutableMapOf<String, Int>()
    for (word in words) {
        if (wordMap[word.capitalize()] == null) {
            wordMap[word.capitalize()] = 1
        } else {
            val wordCount = wordMap[word.capitalize()]!!
            wordMap[word.capitalize()] = wordCount + 1
        }
    }

    println(wordMap.toList().sortedByDescending { it.second }.toMap())
}