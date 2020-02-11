package com.library.enums

enum class Data() {
    ;
    enum class Sapkowski(val title: String, val year: Int, val author: String = "Andrzej Sapkowski") {
        ELFSBLOOD("Elf's Blood", 1993),
        WITCHER1("Witcher I : storm season", 2014),
        WITCHER2("Witcher II : destiny sword", 2014),
        WITCHER3("Witcher III : elf's King", 2015),
        WITCHER4("Witcher IV : contempt time", 2016),
    }
    enum class DanBrown(val title: String, val year: Int, val author: String = "Dan Brown") {
        INFERNO("Inferno", 2016),
        ORIGIN("Origin", 2017),
        ANGELS("Angels and deamons", 2013),
        LOSTSYMBOLS("Lost Symbol", 2013);
    }
    enum class Rowling(val title:String, val year:Int, val auhtor: String = "J.K.Rowling") {
        HP1("Harry Potter: Chamber of secrets", 2006),
        HP5("Harry potter: princess of half blood", 2008)
    }

}