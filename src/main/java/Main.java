import DAO.BookService;
import Entity.Book;

import java.util.Map;

public class Main {
    public static void main(String[] args) {


        BookService methods = new BookService();
        methods.createBook("Wiedzmin",2017, "Sapkowski");
        methods.createBook("Potop",1992, "Mickiewicz");

        methods.lentBook("Grzegorz",1L);
        methods.getListOfBooks();


    }
}
