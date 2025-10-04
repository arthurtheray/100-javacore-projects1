package prg3;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            try {
                double celsiumInput = askForCelsiumValue();
                System.out.printf("%.2f градусов цельсия это %.2f фаренгейт",
                        celsiumInput, convertCelsiumToFahrenheit(celsiumInput));
                break;
            } catch (IOException e) {
                System.out.println("Не удалось обработать ввод. Введи еще раз");
            }
        }
    }

    public static double askForCelsiumValue() throws IOException {
        System.out.println("Введите число в цельсиях:");
        Scanner scanner = new Scanner(System.in);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            throw new IOException("Input not parsable to double ", e.getCause());
        }
    }

    public static double convertCelsiumToFahrenheit(double celsiumValue) {
        return Math.round(celsiumValue * 1.8 + 32);
    }
}
