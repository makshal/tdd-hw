import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    private PhoneBook phoneBook;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // "Виртуальная консоль" сюда записываем весь вывод
    private final PrintStream originalOut = System.out; // Сохраняем ссылку на настоящию консоль

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
        System.setOut(new PrintStream(outputStream)); // Теперь всё, что должно было печататься в консоль, идет в outputStream
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); // Возвращаем настоящую консоль на место
    }

    @Test()
    @DisplayName("Если имя отличается, номер добавляется")
    void addNumberTestOne() {

        int result = phoneBook.addNumber("Олег", 232_032);

        assertEquals(4, result, "3 + 1 должно быть 4");

    }

    @Test
    @DisplayName("Если имя присутствует, номер не добавляется")
    void addNumberTestTwo() {

        int result = phoneBook.addNumber("Макс", 232_032);

        assertEquals(3, result, "Имена повторяются, ответ 3");

    }

    @Test
    void findByNumberTestOne() {

        String result = phoneBook.findByNumber(232_021);

        assertEquals("Влад", result, "Такой номер есть");

    }


    @Test
    void findByNumberTestTwo() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findByNumber(232_232);
        });

        assertEquals("Контакт с номером 232232 не найден", exception.getMessage());

    }

    @Test
    void findByNameTestOne() {

        int result = phoneBook.findByName("Макс");

        assertEquals(232_732, result, "Контакт с таким именем есть");

    }


    @Test
    void findByNameTestTwo() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findByName("Евгений");
        });

        assertEquals("Контакт с именем Евгений не найден", exception.getMessage());

    }

    @Test
    void TestPrintAllNames() {

        phoneBook.addNumber("Рафаэль", 232_256);
        phoneBook.addNumber("Марсель", 232_266);

        phoneBook.printAllNames();

        String output = outputStream.toString().trim();
        String[] lines = output.split("\r?\n");

        assertTrue(isAlphabeticallySorted(lines),
                "Имена должны быть в алфавитном порядке. Фактический вывод: " + Arrays.toString(lines));

    }

    private boolean isAlphabeticallySorted(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}
