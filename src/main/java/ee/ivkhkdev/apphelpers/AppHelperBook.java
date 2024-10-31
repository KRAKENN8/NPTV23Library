package ee.ivkhkdev.apphelpers;

<<<<<<< HEAD
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.services.Service;

import java.util.ArrayList;
import java.util.List;

public class AppHelperBook implements AppHelper<Book> {
    private final Input input;
    private final Service<Author> authorService;

    public AppHelperBook(Input input, Service<Author> authorService) {
        this.input = input;
        this.authorService = authorService;
=======
import ee.ivkhkdev.interfaces.FileRepository;
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.interfaces.Service;

import java.util.List;

public class AppHelperBook implements AppHelper<Book>, Input {
    private final Input input; // добавляем поле для Input
    private final Service<Author> authorService;
    private final FileRepository<Book> bookRepository;

    public AppHelperBook(Input input, Service<Author> authorService, FileRepository<Book> bookRepository) {
        this.input = input; // инициализация Input
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    @Override
    public FileRepository<Book> getRepository() {
        return bookRepository;
>>>>>>> New update
    }

    @Override
    public Book create() {
        Book book = new Book();
        System.out.print("Название книги: ");
<<<<<<< HEAD
        book.setTitle(input.getString());
        authorService.print();
        System.out.println("Добавить нового автора (y/n): ");
        String answer = input.getString();
        if(answer.equalsIgnoreCase("y")) {return null;}
        System.out.print("Укажите количество авторов книги: ");
        int countAuthors = Integer.parseInt(input.getString());

        for (int i = 0; i < countAuthors; i++) {
            System.out.printf("Выбери номер автора из списка (%d из %d): ", i + 1, countAuthors);
            int numberAuthor = Integer.parseInt(input.getString());
            book.getAuthors().add(authorService.list().get(numberAuthor-1));
        }

        System.out.print("Год издания книги: ");
        book.setPublishedYear(Integer.parseInt(input.getString()));
=======
        book.setTitle(getString());
        authorService.print();
        System.out.println("Добавить нового автора (y/n): ");
        String answer = getString();
        if (answer.equalsIgnoreCase("y")) {
            return null;
        }
        System.out.print("Укажите количество авторов книги: ");
        int countAuthors = Integer.parseInt(getString());

        for (int i = 0; i < countAuthors; i++) {
            System.out.printf("Выбери номер автора из списка (%d из %d): ", i + 1, countAuthors);
            int numberAuthor = Integer.parseInt(getString());
            book.getAuthors().add(authorService.list().get(numberAuthor - 1));
        }

        System.out.print("Год издания книги: ");
        book.setPublishedYear(Integer.parseInt(getString()));
>>>>>>> New update
        return book;
    }

    @Override
    public void printList(List<Book> books) {
        StringBuilder sbBooks = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
<<<<<<< HEAD
            if(book == null) {continue;}
            StringBuilder sbAuthorsBook = new StringBuilder();
            for (Author author : book.getAuthors()) {
                if (author != null) {
                    sbAuthorsBook.append(author.getAuthorName()).append(" ").append(author.getAuthorSurname());
                }
            }
            sbBooks.append(String.format("%d. %s. %s. %d%n",
                                i + 1,
                                book.getTitle(),
                                sbAuthorsBook.toString(),
                                book.getPublishedYear()
                        )
            );
            System.out.println(sbBooks.toString());

        }
    }
=======
            if (book == null) continue;
            StringBuilder sbAuthorsBook = new StringBuilder();
            for (Author author : book.getAuthors()) {
                if (author != null) {
                    sbAuthorsBook.append(author.getAuthorName()).append(" ").append(author.getAuthorSurname()).append(", ");
                }
            }
            sbBooks.append(String.format("%d. %s. %s. %d%n",
                    i + 1,
                    book.getTitle(),
                    sbAuthorsBook.toString(),
                    book.getPublishedYear()
            ));
            System.out.println(sbBooks.toString());
        }
    }

    @Override
    public String getString() {
        return input.getString(); // Используем input для получения строки
    }
>>>>>>> New update
}
