package com.library.entityKotli

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

class Book(val title: String, val author: String, val year: Int, var lentStatus: Boolean = false) {

    var owner: String = ""
    val hashID = UUID.randomUUID().toString().subSequence(0, 8)
    val addingTime = LocalDateTime.now().dater()
    var ownersHistory: LinkedHashMap<String, MutableList<Owner>> = LinkedHashMap()

    fun description() {
        if (owner.isNullOrBlank()) {
            println("title: $title, author: $author, year: $year, lentStatus: $lentStatus," +
                    " creating Time: $addingTime, hashID: $hashID")
        } else {
            println("title: $title, author: $author, year: $year," +
                    " lent Status: $lentStatus, creating Time: $addingTime, hashID: $hashID")
        }
    }
    fun fullDescription() {
        println("""
                |title: $title, author: $author, year: $year, 
                |lent Status: $lentStatus, creating Time: $addingTime, hashID: $hashID
                |history owners: ${ownersHistory.values}
                |""".trimMargin("|"))
    }

}

fun LocalDateTime.dater(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd")
    return LocalDateTime.parse(this.toString(), formatter)

}