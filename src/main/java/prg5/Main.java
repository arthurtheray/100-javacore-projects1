package prg5;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            try {
                int userInput = askForIntegerInput();
                String output = (userInput % 2 == 0 ? "четное" : "нечетное") +
                        "\n" +
                        (userInput >= 0 ? "положительное" : "отрицательное");
                System.out.println(output);
            } catch (IOException e) {
                System.out.println("Нужно вводить целое число");
            }
        }
    }

    public static int askForIntegerInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IOException("Ошибка ввода");
        }
    }
}
