package Repository;

import Entity.Book;

public interface BooksWriteUtils {

    Book createBook(String title, Integer year, String author);
    Book lentBook(String name, Long bookId);

}
