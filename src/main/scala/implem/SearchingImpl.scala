package implem

import entityScala.Book
import traits.Searching

import scala.collection.mutable

class SearchingImpl (bookImplement: BookImplement) extends Searching {


  val map: mutable.LinkedHashMap[Long, Book] = bookImplement.bookListPass()


  override def findBy(title: String, year: Int, author: String): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.toLowerCase)
      && v._2.year == year
      && v._2.author.toLowerCase.contains(author.toLowerCase))
    returnMap
  }

  override def findBy(title: Option[String]): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.get.toLowerCase))
    returnMap
  }

  override def findBy(year: Int): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.year == year)
    returnMap
  }

  override def findBy(author: String): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.author.toLowerCase.contains(author.toLowerCase))
    returnMap
  }

  override def findBy(title: String, author: String): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.toLowerCase)
      && v._2.author.toLowerCase.contains(author.toLowerCase))
    returnMap
  }

  override def findBy(title: String, year: Int): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.toLowerCase)
      && v._2.year == year)
    returnMap
  }

  override def findBy(author: Option[String], year: Int): mutable.LinkedHashMap[Long, Book] = {
    val returnMap: mutable.LinkedHashMap[Long, Book] = map.filter(v => v._2.author.toLowerCase.contains(author.get.toLowerCase)
      && v._2.year == year)
    returnMap
  }


}
