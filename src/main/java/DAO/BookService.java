package DAO;

import Entity.Book;
import Repository.BooksWriteUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookService implements BooksWriteUtils {

    private Map<Long, Book> listOfBooks = new ConcurrentHashMap<>();


    public Book createBook(String title, Integer year, String author) {
        Book newBook = new Book(title, year, author);
        listOfBooks.put(listOfBooks.size() + 1L, newBook);
        return newBook;
    }

    public Map<Long, Book> getListOfBooks() {
        long available = listOfBooks.values().stream().filter(book -> !book.getLentStatus()).count();
//        todo ZAKOMENTOWANE W RAMACH TESTOW
//        listOfBooks.entrySet().forEach(x -> System.out.println(x.toString().replace("=", " - ")));
//        System.out.println("available: " + available);
//        System.out.println("lent: " + (listOfBooks.size() - available));
        return listOfBooks;
    }


    public Book getSingleBookByMapId(Long id) {
        return listOfBooks.get(id);
    }


    public Book lentBook(String name, Long bookId) {
        Book book = listOfBooks.get(bookId);
        if (book.getLentStatus()) {
            System.out.println("Book is already lent");
        } else if (book == null) {
            System.out.println("Ksiazki o podanym ID nie ma w bazie danych");
        } else {
            book.setLentStatus(true);
            book.setPerson(name);
            System.out.println(String.format("Użytkowniku: %s, wynajales tytul: %s", name, book.getTitle()));
        }
        return book;
    }

    public void removeBook(Long id) {
        if (listOfBooks.get(id) != null && !listOfBooks.get(id).getLentStatus()) {
            listOfBooks.remove(id);
            System.out.println(String.format("Usunięto pozycję: %s, tytul: %s", id, listOfBooks.get(id).getTitle()));
        } else {
            System.out.printf("Pozycja o ID: %s nie istnieje, lub jest wynajęta", id);
        }
    }
    // TODO: 29.01.2020 add searcing


}
