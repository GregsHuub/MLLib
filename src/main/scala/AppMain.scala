import implem.{BookImplement, SearchingImpl}

object AppMain {


  def main(args: Array[String]): Unit = {
    val bookImpl = new BookImplement()
    bookImpl.setupDataBase()
    val search = new SearchingImpl(bookImpl)

//    bookImpl.getListOfBooks()
    bookImpl.createBook("Nowa", 1222, "autor")
    bookImpl.getListOfBooks()



    //    title = Option(String)
    //     author = string
    println(search.findBy(1222))
    //        println("po roku 2009:\n" + searchImpl.findBy(2009))
    //        println("po roku tytule The:\n" + searchImpl.findBy(Option("The")))
    //        println("----- by author")
    //        println(searchImpl.findBy("Sapkowski"))
    //        println(searchImpl.findBy("Sapkowski").size)
    //        println("----")
    //        println("---- by title")
    //        println(searchImpl.findBy(Option("The")))
    //        println(searchImpl.findBy(Option("The")).size)
    //        println("----")
    //        println("----title and author")
    //        println(searchImpl.findBy("i", 2016, "n"))


  }
}
