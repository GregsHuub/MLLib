package implem

import entityScala.Book
import traits.Searching

import scala.collection.mutable

object SearchingImpl extends Searching {

  val map = BookImplement.bookListPass()
  override def findBy(title: String, year: Int, author: String): mutable.Map[Long, Book] = {
    val returnMap: mutable.Map[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.toLowerCase)
      && v._2.year == year
      && v._2.author.toLowerCase.contains(author.toLowerCase))
    returnMap
  }

  override def findBy(title: Option[String]): mutable.Map[Long, Book] = {
    val returnedMap: mutable.Map[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.get.toLowerCase))
    returnedMap
  }

  override def findBy(year: Int): mutable.Map[Long, Book] = {
    val returnedMap: mutable.Map[Long, Book] = map.filter(v => v._2.year == year)
    returnedMap
  }

  override def findBy(author: String): mutable.Map[Long, Book] = {
    val returnedMap: mutable.Map[Long, Book] = map.filter(v => v._2.author.toLowerCase.contains(author.toLowerCase))
    returnedMap
  }

  override def findBy(title: String, author: String): mutable.Map[Long, Book] = {
    val returnedMap: mutable.Map[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.toLowerCase)
      && v._2.author.toLowerCase.contains(author.toLowerCase))
    returnedMap
  }

  override def findBy(title: String, year: Int): mutable.Map[Long, Book] = {
    val returnedMap: mutable.Map[Long, Book] = map.filter(v => v._2.title.toLowerCase.contains(title.toLowerCase)
      && v._2.year == year)
    returnedMap
  }

  override def findBy(author: Option[String], year: Int): mutable.Map[Long, Book] = {
    val returnedMap: mutable.Map[Long, Book] = map.filter(v => v._2.author.toLowerCase.contains(author.get.toLowerCase)
      && v._2.year == year)
    returnedMap
  }
}
