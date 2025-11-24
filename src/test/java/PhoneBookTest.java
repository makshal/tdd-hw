import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
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
    void findByNumberOne() {

        String result = phoneBook.findByNumber(232_021);

        assertEquals("Влад", result, "Такой номер есть");

    }


    @Test
    void findByNumberTwo() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findByNumber(232_232);
        });

        assertEquals("Контакт с номером 232232 не найден", exception.getMessage());

    }

    @Test
    void findByNameOne() {

        int result = phoneBook.findByName("Макс");

        assertEquals(232_732, result, "Контакт с таким именем есть");

    }


    @Test
    void findByNameTwo() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findByName("Евгений");
        });

        assertEquals("Контакт с именем Евгений не найден", exception.getMessage());

    }

}
