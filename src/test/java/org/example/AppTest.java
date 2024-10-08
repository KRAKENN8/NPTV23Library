package org.example;

import org.example.handlers.BookHandler;
import org.example.interfaces.BookProvider;
import org.example.interfaces.InputProvider;
import org.example.model.Author;
import org.example.model.Book; // Assuming you have a Book class
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class AppTest {
    ByteArrayOutputStream outDefault;
    ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outDefault = new ByteArrayOutputStream();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(new PrintStream(outDefault));
    }

    @Test
    void testAppRunExit() {
        InputProvider inputMock = Mockito.mock(InputProvider.class);
        when(inputMock.getInput()).thenReturn("0");

        BookProvider bookProviderMock = Mockito.mock(BookProvider.class);
        Author[] authors = new Author[1];
        Author author = new Author("Lev", "Tolstoy");
        authors[0] = author;

        when(bookProviderMock.createBook(inputMock)).thenReturn(new Book("Voina i mir", authors, "2000"));

        BookHandler bookHandler = new BookHandler(inputMock, bookProviderMock);
        App app = new App(bookHandler, inputMock);

        app.run();

        String outputContent = outContent.toString();
        assertTrue(outputContent.contains("До свидания!"));
    }
}
