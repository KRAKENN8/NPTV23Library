package ee.ivkhkdev;

<<<<<<< HEAD

import ee.ivkhkdev.apphelpers.AppHelper;
import ee.ivkhkdev.apphelpers.AppHelperAuthor;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.input.ConsoleInput;
=======
import ee.ivkhkdev.apphelpers.AppHelperAuthor;
import ee.ivkhkdev.interfaces.FileRepository;
import ee.ivkhkdev.apphelpers.repository.Storage;
>>>>>>> New update
import ee.ivkhkdev.apphelpers.AppHelperBook;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.services.AuthorService;
import ee.ivkhkdev.services.BookService;
<<<<<<< HEAD
import ee.ivkhkdev.services.Service;
=======
import ee.ivkhkdev.interfaces.Service;
>>>>>>> New update

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD

=======
>>>>>>> New update
public class NPTV23Library {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
<<<<<<< HEAD
        Input input = new ConsoleInput();
        AppHelper<Author> appHelperAuthor = new AppHelperAuthor(input);
        Service<Author> authorService = new AuthorService(authors, appHelperAuthor);
        AppHelper<Book> appHelperBook = new AppHelperBook(input,authorService);
        Service<Book> bookService = new BookService(books,appHelperBook);
        App app = new App(input, bookService, authorService);
        app.run();
    }

}
=======

        // Создаем репозитории для хранения данных
        FileRepository<Book> bookRepository = new Storage<>("books.dat");
        FileRepository<Author> authorRepository = new Storage<>("authors.dat");

        // Создаем AppHelper для авторов и книг с учетом входных данных
        AppHelperAuthor appHelperAuthor = new AppHelperAuthor(authorRepository, System.in);
        Service<Author> authorService = new AuthorService(authors, appHelperAuthor);
        AppHelperBook appHelperBook = new AppHelperBook(appHelperAuthor, authorService, bookRepository); // передаем appHelperAuthor как Input
        Service<Book> bookService = new BookService(books, appHelperBook);

        // Запускаем приложение
        App app = new App(bookService, authorService);
        app.run();
    }
}
>>>>>>> New update
