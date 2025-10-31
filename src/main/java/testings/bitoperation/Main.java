package testings.bitoperation;

public class Main {
    public static void main(String[] args) {
        byte a = 0b1111110;
        byte b = (byte) (~ a);
        System.out.println(a);
        System.out.println(b);

        int x = 111;
        int y = x >> 1;
        System.out.println(y);
    }
}
