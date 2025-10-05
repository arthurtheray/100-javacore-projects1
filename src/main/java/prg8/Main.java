package prg8;

public class Main {
    public static void main(String[] args) {
        int a = generateRnd();
        int b = generateRnd();
        int c = generateRnd();
        System.out.printf("Меньшее число из %s %s и %s это: \n", a, b, c);
        System.out.println(findMinOfThree(a, b, c));

    }

    private static int generateRnd() {
        return (int) (100 * Math.random());
    }

    public static int findMinOfThree(int a, int b, int c) {
        int min;
        if (a <= b) {
            min = a;
        } else if (b <= c) {
            min = b;
        } else {
            min = c;
        }
        return min;
    }
}
