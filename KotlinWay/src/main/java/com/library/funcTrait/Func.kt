package com.library.funcTrait

interface Func<T>: Searching<T> {

    fun create(title: String, author: String, year: Int): T
    fun fullDescriptionsList(): Map<Long, T>
    fun getBooksViaMap(): Map<Long, T>
    fun lentBook(id: Long, yourName: String)

}