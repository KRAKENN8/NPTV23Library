package ee.ivkhkdev.nptv23libraryjpa.services;

import ee.ivkhkdev.nptv23libraryjpa.entity.Author;
import ee.ivkhkdev.nptv23libraryjpa.entity.Book;
import ee.ivkhkdev.nptv23libraryjpa.helpers.AuthorHelperImple;
import ee.ivkhkdev.nptv23libraryjpa.interfaces.AppHelper;
import ee.ivkhkdev.nptv23libraryjpa.interfaces.BookService;
import ee.ivkhkdev.nptv23libraryjpa.repository.AuthorRepository;
import ee.ivkhkdev.nptv23libraryjpa.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImple implements BookService {

    @Autowired private AppHelper<Book> bookHelper;
    @Autowired private AuthorHelperImple authorHelperImple;
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;

    @Transactional
    @Override
    public boolean add() {
        Optional<Book> optionalBook = bookHelper.create();
        if(optionalBook.isEmpty()) {
            return false;
        }
        Book book = optionalBook.get();
        List<Long> listIdBooks = authorHelperImple.listAuthorsId((List<Author>) authorRepository.findAll());
        List<Author> bookAuthors = new ArrayList<>();
        for(Long id : listIdBooks) {
            Optional<Author> optionalAuthor = authorRepository.findById(id);
            if(optionalAuthor.isEmpty()) {return false;}
            Author author = optionalAuthor.get();
            author.getBooks().add(book);
            bookAuthors.add(author);
        }
        book.setAuthors(bookAuthors);

        Book savedBook = bookRepository.save(book);
//        for(Author author : bookAuthors) {
//            author.getBooks().add(savedBook);
//        }
//        authorRepository.saveAll(bookAuthors);
        return true;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean changeAvailability() {
        Long bookId = bookHelper.findIdEntityForChangeAvailability(bookRepository.findAll());
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()) {
            return false;
        }
        Book book = optionalBook.get();
        book.setAvailable(false);
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean print() {
        return bookHelper.printList(bookRepository.findAll());
    }
}
