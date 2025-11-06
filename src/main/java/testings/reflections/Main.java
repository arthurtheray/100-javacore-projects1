package testings.reflections;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Container<String> container = new Container<>(String.class);
        String a = container.newInstance();
        a = "hello";
        System.out.println(a);
    }
}
