package testings.mapTesting;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Integer> myMap = new HashMap<>();

    public static void main(String[] args) {
        myMap.put("One", 0);
        myMap.put("Two", 0);
        System.out.println(myMap);
        System.out.println(myMap.merge("One", 0, (oldValue, _) -> oldValue + 1));
        System.out.println(myMap);
        System.out.println(myMap.merge("One", 0, (oldValue, _) -> oldValue + 1));
        System.out.println(myMap);
        System.out.println(myMap.merge("Three", 0, (oldValue, _) -> oldValue + 1));
        System.out.println(myMap);
    }
}
