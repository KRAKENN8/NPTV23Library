package ee.ivkhkdev.apphelpers;

<<<<<<< HEAD
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.services.AuthorService;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.services.Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
=======
import ee.ivkhkdev.interfaces.FileRepository;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.interfaces.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

>>>>>>> New update
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
<<<<<<< HEAD
import static org.mockito.Mockito.when;

class AppHelperBookTest {
    Input inputMock;
    PrintStream outDefault;
    ByteArrayOutputStream outMock;
    Service<Author> authorServiceMock;
    AppHelper<Book> appHelperBook;
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(Input.class);
        outDefault = System.out;
        outMock = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outMock));
        authorServiceMock = Mockito.mock(AuthorService.class);
        appHelperBook = new AppHelperBook(inputMock,authorServiceMock);
    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        System.setOut(outDefault);
        outMock= null;
    }

    @Test
    void createWithAddAuthor() {
        when(inputMock.getString()).thenReturn("Voina i mir","y");
        Book actual = appHelperBook.create();
        assertTrue(actual == null);
    }
    @Test
    void createWithoutAddAuthor() {
        Author author = new Author("Lev","Tolstoy");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        when(authorServiceMock.list()).thenReturn(authors);
        when(inputMock.getString()).thenReturn("Voina i mir","n", "1", "1", "2000");
        Book actual = appHelperBook.create();
        Book expected = new Book("Voina i mir", authors,2000);
        assertEquals(actual.getTitle(), expected.getTitle());
        assertEquals(actual.getPublishedYear(), expected.getPublishedYear());
        assertEquals(actual.getAuthors().get(0).getAuthorName(), expected.getAuthors().get(0).getAuthorName());
        assertEquals(actual.getAuthors().get(0).getAuthorSurname(), expected.getAuthors().get(0).getAuthorSurname());
    }

    @Test
    void printList() {
        Author author = new Author("Lev","Tolstoy");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book("Voina i mir", authors,2000);
        List<Book> books = new ArrayList<>();
        books.add(book);
        appHelperBook.printList(books);
        String actual = outMock.toString();
//        System.setOut(outDefault);
//        System.out.println(actual);
        String expected = "1. Voina i mir. Lev Tolstoy. 2000";
        assertTrue(actual.contains(expected));

    }
=======
import static org.mockito.Mockito.*;

class AppHelperBookTest {
    @Mock
    private Input input;

    @Mock
    private Service<Author> authorService;

    @Mock
    private FileRepository<Book> bookRepository;

    @InjectMocks
    private AppHelperBook appHelperBook;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBookWithAuthors() {
        when(input.getString()).thenReturn("My Book", "n", "1", "1", "2023");

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setAuthorName("John");
        author.setAuthorSurname("Doe");
        authors.add(author);

        when(authorService.list()).thenReturn(authors);

        Book book = appHelperBook.create();

        assertNotNull(book);
        assertEquals("My Book", book.getTitle());
        assertEquals(1, book.getAuthors().size());
        assertEquals(author.getAuthorName(), book.getAuthors().get(0).getAuthorName());
        assertEquals(2023, book.getPublishedYear());

        verify(input, times(5)).getString();
        verify(authorService, times(1)).list();
    }

    @Test
    void testCreateBookWithNewAuthor() {
        when(input.getString()).thenReturn("My Book", "y");

        Book book = appHelperBook.create();

        assertNull(book);
        verify(input, times(2)).getString();
    }

    @Test
    void testPrintList() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle("My Book");

        Author author = new Author();
        author.setAuthorName("John");
        author.setAuthorSurname("Doe");
        book.getAuthors().add(author);
        book.setPublishedYear(2023);
        books.add(book);

        appHelperBook.printList(books);

        verify(input, never()).getString();
    }

>>>>>>> New update
}