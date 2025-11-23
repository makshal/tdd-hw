import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, Integer> phoneBookMap = new HashMap<>();

    public PhoneBook() {
        phoneBookMap.put("Маша", 232_013);
        phoneBookMap.put("Влад", 232_021);
        phoneBookMap.put("Макс", 232_732);
    }

    public int addNumber(String name, int number) {

        if (!phoneBookMap.containsKey(name)) {
            phoneBookMap.put(name, number);
        }

        return phoneBookMap.size();

    }

}
