package testings.negative_double_casting;

public class Main {
    public static void main(String[] args) {
        double a = 2.5;
        double b = 3.6;
        int c = (int) (10 * (a - b));
        System.out.println(c);
    }
}
