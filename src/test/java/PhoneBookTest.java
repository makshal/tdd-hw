import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    void addNumberTestOne() {

        Map<String, Integer> number = Map.of("Маша", 232_013,
                "Влад", 232_021,
                "Макс", 232_732);

        int result = phoneBook.addNumber("Олег", 232_032);

        assertEquals(4, result, "3 + 1 должно быть 4");

    }

    @Test
    void addNumberTestTwo() {

        Map<String, Integer> number = Map.of("Маша", 232_013,
                "Влад", 232_021,
                "Макс", 232_732);

        int result = phoneBook.addNumber("Макс", 232_032);

        assertEquals(3, result, "Имена повторяются, ответ 3");

    }

}
