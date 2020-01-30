import implem.{BookImplement, SearchingImpl}

object AppMain {


  def main(args: Array[String]): Unit = {
    BookImplement.setupDataBase()
    BookImplement.getListOfBooks()

    //title = Option(String)
    // author = string
//    println("po roku 2009:\n" + SearchingImpl.findBy(2009))
//    println("po roku tytule The:\n" + SearchingImpl.findBy(Option("The")))
    println("----- by author")
    println(SearchingImpl.findBy("Sapkowski"))
    println(SearchingImpl.findBy("Sapkowski").size)
    println("----")
    println("---- by title")
    println(SearchingImpl.findBy(Option("The")))
    println(SearchingImpl.findBy(Option("The")).size)
    println("----")
    println("----title and author")
    println(SearchingImpl.findBy("i",2016, "n"))


  }
}
