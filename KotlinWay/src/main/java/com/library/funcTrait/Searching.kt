package com.library.funcTrait

import com.library.entityKotli.Book

interface Searching<T> {

    fun findByWords(vararg words:Any): Map<Long, T>
    fun findById(id: Long): Book

}