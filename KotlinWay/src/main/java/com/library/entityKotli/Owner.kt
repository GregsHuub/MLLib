package com.library.entityKotli

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit


class Owner(val lenterName: String) {


    val lentTimeStart = LocalDateTime.now().dater()
    val lentTimeFinish = LocalDateTime
            .now()
            .plusMonths(1)
            .plusHours(12)
            .dater()
    lateinit var listOfBooks: List<Book>

    fun showOwnerBooks() = println(listOfBooks)
    override fun toString(): String {
        return "Owner = $lenterName', start: $lentTimeStart, finish: $lentTimeFinish, \n${timeLeft(lentTimeStart, lentTimeFinish)}"
    }

    fun timeLeft(start:String, finish:String):String{
        val hoursBetween = ChronoUnit.HOURS.between(start.daterToDate(), finish.daterToDate())
        return "Time left: ${hoursBetween / 24} days and ${hoursBetween % 24} hours"

    }
}