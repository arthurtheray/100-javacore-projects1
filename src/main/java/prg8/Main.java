package prg8;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 0, 0, 0, min3(0, 0, 0));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 1, 2, 3, min3(1, 2, 3));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 3, 3, 3, min3(3, 3, 3));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 3, 2, 1, min3(3, 2, 1));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 3, 1, 2, min3(3, 1, 2));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 2, 1, 3, min3(2, 1, 3));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n", 2, 3, 1, min3(2, 3, 1));
        System.out.printf("Меньшее число из %s %s и %s это: %s\n",
                Integer.MIN_VALUE, 0, Integer.MAX_VALUE, min3(Integer.MIN_VALUE, 0, Integer.MAX_VALUE));
    }

    public static int min3(int a, int b, int c) {
        int min = a;
        if (b <= min) {
            min = b;
        }
        if (c <= min) {
            min = c;
        }
        return min;
    }
}
