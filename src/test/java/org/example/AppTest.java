package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void testRunExit() {
        String input = "0\n"; // Ввод: 0 - завершение программы
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App app = new App();
        app.run();

        String output = outContent.toString();
        assertTrue(output.contains("До свидания :)"));
    }

    @Test
    public void testRunInvalidTask() {
        String input = "2\n0\n"; // Ввод: 2 - неправильная задача, 0 - завершение программы
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App app = new App();
        app.run();

        String output = outContent.toString();
        assertTrue(output.contains("Выберите задачу из списка!"));
        assertTrue(output.contains("До свидания :)"));
    }

    @Test
    public void testRunValidTask() {
        String input = "1\n0\n"; // Ввод: 1 - добавление книги, 0 - завершение программы
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App app = new App();
        app.run();

        String output = outContent.toString();
        assertTrue(output.contains("------ Добавление книги ------"));
        assertTrue(output.contains("До свидания :)"));
    }
}
