import DAO.BookService;
import Entity.Book;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class Services {

    private static BookService methods = new BookService();
    private static Map<Long, Book> bookskMap = new ConcurrentHashMap<>();
    private static List<Book> expectListOfBooks = new ArrayList<>();

    @BeforeAll
    public static void createBooks() {
        System.out.println("Start testing, create instances");
        Book book = methods.createBook("Tytul", 2000, "Autor");
        Book book1 = methods.createBook("Tytul1", 2001, "Autor1");
        Book book2 = methods.createBook("Tytul2", 2002, "Autor2");
        Book book3 = methods.createBook("Tytul3", 2003, "Autor3");
        Book book4 = methods.createBook("Tytul4", 2004, "Autor4");
        Book book5 = methods.createBook("Tytul5", 2005, "Autor5");
        expectListOfBooks.add(book);
        expectListOfBooks.add(book1);
        expectListOfBooks.add(book2);
        expectListOfBooks.add(book3);
        expectListOfBooks.add(book4);
        expectListOfBooks.add(book5);

    }

    @DisplayName("Find by id")
    @Test
    public void checkById() {
        System.out.println("Check by id test");
        assertEquals(expectListOfBooks.get(0), methods.getSingleBookByMapId(1L));
        assertEquals(expectListOfBooks.get(1), methods.getSingleBookByMapId(2L));
        assertEquals(expectListOfBooks.get(2), methods.getSingleBookByMapId(3L));
        assertEquals(expectListOfBooks.get(3), methods.getSingleBookByMapId(4L));
        assertEquals(expectListOfBooks.get(4), methods.getSingleBookByMapId(5L));
        assertNotEquals(expectListOfBooks.get(3), methods.getSingleBookByMapId(5L));
        System.out.println("assertions done");

    }

    @DisplayName("Find All books by method(getList)")
    @Test
    public void checkList() {
        assertEquals(expectListOfBooks.get(0), methods.getListOfBooks().get(1L));
        assertEquals(expectListOfBooks.get(1), methods.getListOfBooks().get(2L));
        assertEquals(expectListOfBooks.get(2), methods.getListOfBooks().get(3L));
        assertEquals(expectListOfBooks.get(3), methods.getListOfBooks().get(4L));
        assertEquals(expectListOfBooks.get(4), methods.getListOfBooks().get(5L));
    }

    @DisplayName("Check Lent status")
    @Test
    public void lentStatus() {
        Book book = methods.createBook("Tytulowa1", 3000, "Author1");  //  7L
        Book book1 = methods.createBook("Tytulowa2", 3001, "Author2"); // 8L
        Book book2 = methods.createBook("Tytulowa3", 3002, "Author3"); // 9L


        Book wynajeta1 = methods.lentBook("najemca", 7L);
        Book wynajeta2 = methods.lentBook("najemca", 8L);
        Book wynajeta3 = methods.lentBook("najemca", 9L);

        assertSame(book,wynajeta1);
        assertSame(book1,wynajeta2);
        assertSame(book2,wynajeta3);

        assertEquals("najemca", wynajeta1.getPerson());
        assertEquals(true, wynajeta1.getLentStatus());

        assertNotEquals(false, wynajeta2.getLentStatus());
        assertNotEquals(false, wynajeta3.getLentStatus());

    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Finished");
        System.out.println("Close connection");
//        clean garbage collector
        System.gc();

    }




}
