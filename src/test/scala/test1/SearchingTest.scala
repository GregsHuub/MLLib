package test1


import entityScala.Book
import implem.{BookImplement, SearchingImpl}
import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable

class SearchingTest extends AnyFlatSpec {


  private val bookImplement = new BookImplement()
  private val searchingImpl = new SearchingImpl(bookImplement)

  "Result" should ("return matches positions from map by various values") in {
    bookImplement.setupDataBase()
    val result: mutable.LinkedHashMap[Long, Book] = searchingImpl.findBy(2016)

    val expectMap = mutable.LinkedHashMap[Long, Book](2L -> bookImplement.bookListPass()(2L),
      7L -> bookImplement.bookListPass()(7L))
    assert(result == expectMap)
    //    assert(2 === 2)


  }


}
