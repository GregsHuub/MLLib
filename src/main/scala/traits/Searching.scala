package traits

import entityScala.Book

import scala.collection.mutable

trait Searching {

//overload
  def findBy(title: String, year: Int, author: String): mutable.Map[Long, Book]

  def findBy(title: Option[String]): mutable.Map[Long, Book]

  def findBy(year: Int): mutable.Map[Long, Book]

  def findBy(author: String): mutable.Map[Long, Book]

  def findBy(title: String, author: String) : mutable.Map[Long, Book]

  def findBy(title: String, year: Int) : mutable.Map[Long, Book]

  def findBy(author: Option[String], year: Int) : mutable.Map[Long, Book]


}
