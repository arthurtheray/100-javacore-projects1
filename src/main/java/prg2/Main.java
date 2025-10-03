package prg2;

public class Main {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        double c = (double) a / b;

        System.out.println(b == 0 ? "На ноль делить нельзя" : c);
    }
}
