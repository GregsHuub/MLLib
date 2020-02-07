package com.library.funcTrait

import java.util.concurrent.ConcurrentHashMap

interface SetUp<T> {

    fun setUpDatabase():ConcurrentHashMap<Long, T>
}