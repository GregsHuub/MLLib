package com.library.implementation

import com.library.entityKotli.Book
import com.library.entityKotli.Owner
import com.library.enums.Data.DanBrown as DB
import com.library.enums.Data.Rowling as RW
import com.library.enums.Data.Sapkowski as SP
import com.library.funcTrait.Func
import com.library.funcTrait.SetUp
import java.util.concurrent.ConcurrentHashMap

fun main() {

    val imp = Implementation()
    imp.setUpDatabase()
    val findByWords = imp.findByWordsTEST("Sapkowski", 2016)
    findByWords.forEach { v -> v.fullDescription() }

//    val lista: List<String> = listOf("aasda", "cxzczxczc")
//    imp.findById(1).description()
//    imp.lentBook(1, "Greg!!!")
//    imp.findById(1).fullDescription()
//    imp.fullDescriptionsList()

}

var map = ConcurrentHashMap<Long, Book>()

class Implementation() : Func<Book>, SetUp<Book> {

    init {
        map
    }

    override fun create(title: String, author: String, year: Int): Book {
        val book: Book = Book(title, author, year, false)
        map[map.size.toLong() + 1] = book
        return book
    }

    override fun fullDescriptionsList(): Map<Long, Book> {
        map.forEach { (k, v) ->
            println("Pos: $k, title:${v.title}," +
                    " author:${v.author}, year: ${v.author}, " +
                    "lent status:${v.lentStatus}, ${v.owner ?: "owner: ${v.owner}"}," +
                    " hashID:<${v.hashID}>, UpdateTIME:${v.addingTime}")
        }
        return map
    }


    override fun findById(id: Long): Book {
        return if (map.containsKey(id)) {
            map[id] as Book
        } else {
            println("This id doesnt exist in database :)")
            map.getOrDefault(id, Book("", "", 0, false))
        }

    }

    override fun setUpDatabase(): ConcurrentHashMap<Long, Book> {
        map[1] = Book(DB.ANGELS.title, DB.ANGELS.author, DB.ANGELS.year)
        map[2] = Book(DB.INFERNO.title, DB.INFERNO.author, DB.INFERNO.year)
        map[3] = Book(DB.LOSTSYMBOLS.title, DB.LOSTSYMBOLS.author, DB.LOSTSYMBOLS.year)
        map[4] = Book(DB.ORIGIN.title, DB.ORIGIN.author, DB.ORIGIN.year)
        map[5] = Book(RW.HP1.title, RW.HP1.auhtor, RW.HP1.year)
        map[6] = Book(RW.HP5.title, RW.HP5.auhtor, RW.HP5.year)
        map[7] = Book(SP.ELFSBLOOD.title, SP.ELFSBLOOD.author, SP.ELFSBLOOD.year)
        map[8] = Book(SP.WITCHER1.title, SP.WITCHER1.author, SP.WITCHER1.year)
        map[9] = Book(SP.WITCHER2.title, SP.WITCHER2.author, SP.WITCHER2.year)
        map[10] = Book(SP.WITCHER3.title, SP.WITCHER3.author, SP.WITCHER3.year)
        map[11] = Book(SP.WITCHER4.title, SP.WITCHER4.author, SP.WITCHER4.year)
        return map
    }


     fun findByWordsTEST(vararg words: Any): MutableList<Book> {
        var returnList:MutableList<Book> = mutableListOf()
        words.forEach { word ->
            if(word is Int){
                map.forEach{(_,v) ->
                    run {
                        if (v.year == word.toInt()) {
                            returnList.add(v)
                        } ;
                        if (v.title.contains(word.toString())) {
                            returnList.add(v)
                        }
                    }
                }
            }

        }

        return returnList
    }

override fun getBooksViaMap(): Map<Long, Book> {
    return map
}

override fun lentBook(id: Long, yourName: String) {

    if (!findById(id).lentStatus && findById(id).year != 0) {
        findById(id).owner = yourName
        findById(id).lentStatus = true
        if (findById(id).ownersHistory.containsKey(yourName)) {
            findById(id).ownersHistory.getValue(yourName).add(Owner(yourName))
        } else {
            findById(id).ownersHistory[yourName] = mutableListOf(Owner(yourName))
        }
        println("The Book is now yours for a month :) enjoy")
    } else {
        println("ID doesn't exist, or someone else got this book :)")
    }
}

    override fun findByWords(vararg words: Any): Map<Long, Book> {
       val mapa:Map<Long, Book> = emptyMap()
        return mapa
    }
}