package testings.heappolution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String>[] a = (List<String>[]) new List<?>[2];
        Object[] b = a;

        b[0] = Arrays.asList("one");
        b[1] = Arrays.asList(Map.of());

        String str = a[0].get(0);
        System.out.println(str);
    }
}
