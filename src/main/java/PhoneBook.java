import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {

    private Map<String, Integer> nameToNumber = new HashMap<>();
    private Map<Integer, String> numberToName = new HashMap<>();

    public PhoneBook() {

        nameToNumber.put("Маша", 232_013);
        nameToNumber.put("Влад", 232_021);
        nameToNumber.put("Макс", 232_732);

        numberToName.put(232_013, "Маша");
        numberToName.put(232_021, "Влад");
        numberToName.put(232_732, "Макс");

    }

    public int addNumber(String name, int number) {

        if (!nameToNumber.containsKey(name)) {
            nameToNumber.put(name, number);
            numberToName.put(number, name);
        }

        return nameToNumber.size();

    }

    public String findByNumber(int number) {

        if (!numberToName.containsKey(number)) {
            throw new IllegalArgumentException("Контакт с номером " + number + " не найден");
        }

        return numberToName.get(number);

    }

    public int findByName(String name) {

        if (!nameToNumber.containsKey(name)) {
            throw new IllegalArgumentException("Контакт с именем " + name + " не найден");
        }

        return nameToNumber.get(name);

    }

    public void printAllNames() {

        TreeSet<String> sortedNames = new TreeSet<>(nameToNumber.keySet());
        sortedNames.forEach(System.out::println);

    }

}