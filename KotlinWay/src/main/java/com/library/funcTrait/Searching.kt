package com.library.funcTrait

import com.library.entityKotli.Book
import java.util.concurrent.ConcurrentHashMap

interface Searching<T> {

    fun findByWords(title: String, author: String, year: Int): ConcurrentHashMap<Long, T>
    fun findById(id: Long): Book

}