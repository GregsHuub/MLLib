package com.library.entityKotli

import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.LinkedHashMap

fun main() {

    var book = Book("Wiedzmin", "Sapkowski", 1967)
    val book2 = Book("Wiedzmin", "Sapkowski", 1967)
    book2.owner = "SomeOne"
    book2.description()
}

class Book(val title: String, val author: String, val year: Int, var lentStatus: Boolean = false) : Serializable {

    var owner: String = ""
    val hashID = UUID.randomUUID().let { it.toString().subSequence(0, 8) }
    val addingTime = LocalDateTime.now().dater()
    var ownersHistory: LinkedHashMap<String, MutableList<Owner>> = LinkedHashMap()

    fun description() {
        if (owner.isBlank()) {
            println("title: $title, author: $author, year: $year, lentStatus: $lentStatus," +
                    " creating Time: $addingTime, hashID: $hashID")
        } else {
            println("title: $title, author: $author, year: $year," +
                    " lent Status: $lentStatus, creating Time: $addingTime, hashID: $hashID")
        }
    }

    fun fullDescription() {
        val historyValue = when {
            ownersHistory.isEmpty() -> "No owners history yet"
            else -> ownersHistory
        }

        println("""
                |title: $title, author: $author, year: $year, 
                |lent Status: $lentStatus, creating Time: $addingTime, hashID: $hashID
                |history owners: $historyValue
                |""".trimMargin("|"))
    }

}

fun LocalDateTime.dater(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd")
    return this.format(formatter)

}

fun String.daterToDate(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd")
    return LocalDateTime.parse(this, formatter)

}