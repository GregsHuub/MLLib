package com.library.funcTrait

import com.library.entityKotli.Book

interface Searching<T> {

    fun findBook(vararg words: String, year:Int): Map<Long, T>
//    fun findBook(vararg words: Any): Map<Long, T>
    fun findBook(word:String): Map<Long, T>
    fun findBook(year:Int): Map<Long, T>
    fun findById(id: Long): Book

}