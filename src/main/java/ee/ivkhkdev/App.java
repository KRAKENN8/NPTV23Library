package ee.ivkhkdev;

<<<<<<< HEAD

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.services.Service;

public class App {

    private final Service<Book> bookService;
    private final Input input;
    private final Service<Author> authorService;

    public App(
            Input input,
            Service<Book> bookService,
            Service<Author> authorService) {

        this.input = input;
        this.bookService = bookService;
        this.authorService = authorService;

=======
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;

import java.util.Scanner;

public class App implements Input {

    private final Service<Book> bookService;
    private final Service<Author> authorService;
    private final Scanner scanner = new Scanner(System.in); // Инициализация Scanner как поля класса

    public App(Service<Book> bookService, Service<Author> authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
>>>>>>> New update
    }

    public void run() {
        System.out.println("------ Библиотека группы NPTV23 ------");
        System.out.println("--------------------------------------");
<<<<<<< HEAD
        boolean repeat=true;
        do{
=======
        boolean repeat = true;
        do {
>>>>>>> New update
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Список книг");
<<<<<<< HEAD

            System.out.println("3. Добавить автора");

            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(input.getString());
=======
            System.out.println("3. Добавить автора");

            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(getString());
>>>>>>> New update
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("----- Добавление книги -----");
<<<<<<< HEAD

=======
>>>>>>> New update
                    if (bookService.add()) {
                        System.out.println("Книга добавлена");
                    } else {
                        System.out.println("Книгу добавить не удалось");
                    }
<<<<<<< HEAD
                    ;
=======
>>>>>>> New update
                    break;
                case 2:
                    System.out.println("----- Список книг -----");
                    bookService.print();
                    break;
                case 3:
                    System.out.println("----- Добавление автора -----");
                    if (authorService.add()) {
                        System.out.println("Автор добавлен");
                    } else {
                        System.out.println("Автора добавить не удалось");
                    }
<<<<<<< HEAD

=======
>>>>>>> New update
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");
            }
            System.out.println("--------------------------------------");
<<<<<<< HEAD
        }while(repeat);
        System.out.println("До свидания :)");
    }


=======
        } while (repeat);
        System.out.println("До свидания :)");
    }

    @Override
    public String getString() {
        return scanner.nextLine(); // Используем scanner для получения строки
    }
>>>>>>> New update
}
