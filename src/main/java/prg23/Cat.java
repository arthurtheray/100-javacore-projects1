package prg23;

public class Cat {
    private final String name;
    private final int age;
    private static int count;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public int getCount() {
        return count;
    }

    public static int getCountStatic() {
        return count;
    }

    static {
        count = 0;
        System.out.println(Cat.class.getName() + " initialized");
    }
}
