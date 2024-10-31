package ee.ivkhkdev.services;

<<<<<<< HEAD
import ee.ivkhkdev.apphelpers.AppHelper;
=======
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
>>>>>>> New update
import ee.ivkhkdev.model.Book;

import java.util.List;

<<<<<<< HEAD
public class BookService implements Service<Book>{
=======
public class BookService implements Service<Book> {
>>>>>>> New update

    private final List<Book> books;
    private final AppHelper<Book> appHelperBook;


    public BookService(List<Book> books, AppHelper<Book> appHelperBook) {
        this.books = books;
        this.appHelperBook = appHelperBook;

    }

    @Override
    public boolean add() {
        try {
            Book book = appHelperBook.create();
            if(book == null) {return false;}
<<<<<<< HEAD
            books.add(book);
=======
            appHelperBook.getRepository().save(book);
>>>>>>> New update
            return true;
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean edit(Book book) {
        return false;
    }

    @Override
    public boolean remove(Book book) {
        return false;
    }

    @Override
    public void print() {
        appHelperBook.printList(this.list());
    }

    @Override
    public List<Book> list() {
<<<<<<< HEAD
        return books;
=======
        return appHelperBook.getRepository().load();
>>>>>>> New update

    }
}
