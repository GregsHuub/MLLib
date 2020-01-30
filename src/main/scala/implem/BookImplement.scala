package implem

import entityScala.Book

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


class BookImplement {

  private var bookList = new mutable.LinkedHashMap[Long, Book]

  def setupDataBase(): mutable.LinkedHashMap[Long, Book] = {
    bookList = mutable.LinkedHashMap(
      1L -> createBook("The Kite Runner", 2018, "Khaled Hosseini")
      , 2L -> createBook("Origin", 2016, "Dan Brown")
      , 3L -> createBook("Inferno", 2009, "Dan Brown")
      , 4L -> createBook("Wither - The Last Wish", 2020, "Andrzej Sapkowski")
      , 5L -> createBook("Time of Contempt", 2014, "Andrzej Sapkowski")
      , 6L -> createBook("1984", 2008, "George Orwell")
      , 7L -> createBook("Sapiens", 2016, "Yuval Noah Harari")
      , 8L -> createBook("The Lord of the Rings", 1954, "J. R. R. Tolkien")
      , 9L -> createBook("Harry Potter and the Philosopher's Stone", 1997, "J. K. Rowling")
      , 10L -> createBook("The Hobbit", 1937, "J. R. R. Tolkien")
      , 11L -> createBook("And Then There Were None", 1939, "Agatha Christie"))
    bookList
  }

  def bookListPass(): mutable.LinkedHashMap[Long, Book] = {
    bookList
  }

  def createBook(title: String, year: Integer, author: String): Book = {
    val book = new Book(title, year, author)
    bookList((bookList.size + 1).toLong) = book
    book
  }

  def findBookById(id: Long): Option[Book] = {
    var temp = ArrayBuffer[Option[Book]]()
    if (bookList.get(id).isDefined) {
      temp += bookList.get(id)
    }
    temp(0)
  }

  def getListOfBooks(): Unit = {
    val available: Int = bookList.values.count(book => !book.lentStatus)
    bookList.foreach(x => {
      println(x)
      println(s"available: $available")
      println(s"lent: ${bookList.size - available}")
    })
    println("size: " + bookList.size)

  }

  def removeBook(id: Long) {
    if (!bookList.get(id).isDefined) {
      println(s"id:$id doesnt exist")
    }
    bookList.foreach(x => {
      if (x._1 == id && !x._2.lentStatus) {
        bookList.remove(id)
      }
    })
  }

  def lentItOut(name: String, bookId: Long) {
    bookList.map(x => {
      if (x._1 == bookId && !x._1.isNaN && !x._2.lentStatus) {
        x._2.lenter = name
        x._2.lentStatus = true
      }
    })
  }
}
