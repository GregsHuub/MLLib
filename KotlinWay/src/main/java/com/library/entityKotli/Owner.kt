package com.library.entityKotli

import java.time.LocalDateTime



class Owner (val lenterName: String){

        val lentTimeStart = LocalDateTime.now().dater()
        val lentTimeFinish = LocalDateTime
                .now()
                .withMonth(LocalDateTime.now().monthValue + 1)
                .dater()
        lateinit var listOfBooks:List<Book>

        fun showOwnerBooks() = println(listOfBooks)
        override fun toString(): String {
                return "Owner = $lenterName', start: $lentTimeStart, finish: $lentTimeFinish"
        }

}