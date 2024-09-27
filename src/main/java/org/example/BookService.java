package org.example;

public class BookService {
    public Book createBook() {
        Book book = new Book();
        Author author = new Author("Лев", "Толстой");

        book.setTitle("Война и Мир");
        book.setPublishedYear(2000);
        Author[] authors = new Author[1];
        authors[0] = author;

        book.setAuthors(authors);

        return book;
    }
}
