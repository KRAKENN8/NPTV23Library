package ee.ivkhkdev.apphelpers;

<<<<<<< HEAD
import ee.ivkhkdev.input.Input;
=======
import ee.ivkhkdev.interfaces.FileRepository;
>>>>>>> New update
import ee.ivkhkdev.model.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperAuthorTest {
    Input inputMock;
    PrintStream outDefault;
    ByteArrayOutputStream outMock;
    AppHelperAuthor appHelperAuthor;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(Input.class);
        outDefault = System.out;
        outMock = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outMock));
        appHelperAuthor = new AppHelperAuthor(inputMock);
=======

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class AppHelperAuthorTest {

    private FileRepository<Author> authorRepositoryMock;
    private AppHelperAuthor appHelperAuthor;
    private final InputStream originalIn = System.in; // Сохраняем стандартный System.in
    private final PrintStream originalOut = System.out; // Сохраняем стандартный System.out

    @BeforeEach
    void setUp() {
        // Создаем mock для FileRepository и экземпляр AppHelperAuthor с ByteArrayInputStream
        authorRepositoryMock = mock(FileRepository.class);
>>>>>>> New update
    }

    @AfterEach
    void tearDown() {
<<<<<<< HEAD
        inputMock = null;
        System.setOut(outDefault);
        outMock= null;
    }

    @Test
    void create() {
        when(inputMock.getString()).thenReturn("Lev","Tolstoy");
        Author actual = appHelperAuthor.create();
        Author expected = new Author("Lev","Tolstoy");
        assertEquals(expected.getAuthorName(), actual.getAuthorName());
        assertEquals(expected.getAuthorSurname(), actual.getAuthorSurname());
    }

    @Test
    void printList() {
        Author author = new Author("Lev","Tolstoy");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        appHelperAuthor.printList(authors);
        String actual = outMock.toString();
        String expected = "1. Lev Tolstoy";
        assertTrue(actual.contains(expected));

    }
}
=======
        // Сбрасываем System.in и System.out после теста
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testCreateAuthor() {
        // Подготавливаем ввод через ByteArrayInputStream
        String input = "Иван\nПетров\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        // Создаем AppHelperAuthor с mock-репозиторием и симулированным вводом
        appHelperAuthor = new AppHelperAuthor(authorRepositoryMock, in);

        // Вызываем метод create и проверяем результат
        Author author = appHelperAuthor.create();

        // Проверка, что author создан с ожидаемыми значениями
        assertEquals("Иван", author.getAuthorName(), "Имя автора должно быть 'Иван'");
        assertEquals("Петров", author.getAuthorSurname(), "Фамилия автора должна быть 'Петров'");
    }

    @Test
    void testPrintList() {
        // Подготавливаем поток для захвата вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Перенаправляем System.out

        // Создаем список авторов для теста
        List<Author> authors = Arrays.asList(
                new Author("Иван", "Петров"),
                new Author("Алексей", "Сидоров")
        );


        appHelperAuthor = new AppHelperAuthor(authorRepositoryMock, System.in);

        // Вызываем метод printList
        appHelperAuthor.printList(authors);

        // Захватываем фактический вывод и удаляем лишние пробелы и переносы строк
        String actualOutput = outputStream.toString().trim();

        // Ожидаемый результат
        String expectedOutput = "---------- Список авторов --------\n" +
                "1. Иван Петров\n" +
                "2. Алексей Сидоров";

        // Сравниваем строки построчно
        String[] expectedLines = expectedOutput.split("\\n");
        String[] actualLines = actualOutput.split("\\n");

        assertEquals(expectedLines.length, actualLines.length, "Количество строк в выводе не совпадает");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i].trim(), actualLines[i].trim(), "Различие в строке " + (i + 1));
        }
    }
}
>>>>>>> New update
