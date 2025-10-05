package prg4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            String userInput = getUserInput();
            List<String> parsedInput = parseUserInput(userInput);
            if (parsedInput.isEmpty()) {
                System.out.println("Упс");
            } else {
                System.out.println(calc(parsedInput));
                break;
            }
        }
    }

    public static double calc(List<String> expression) throws NumberFormatException, NullPointerException {
        double c;
        double a = Double.parseDouble(expression.get(0));
        double b = Double.parseDouble(expression.get(2));
        switch (expression.get(1)) {
            case "+" -> c = a + b;
            case "-" -> c = a - b;
            case "*" -> c = a * b;
            case "/" -> c = a / b;
            default -> c = 0;
        }
        return c;
    }

    public static String getUserInput() {
        System.out.println("введите выражение (например 1+1)");
        return scanner.nextLine();
    }

    public static List<String> parseUserInput(String userInput) {
        List<String> parsedInput = new ArrayList<>();
        for (Operations operation:Operations.values()) {
            int index = userInput.indexOf(operation.getOperation());
            if (index > 0 & index != userInput.length() - 1) {
                parsedInput.add(0, userInput.substring(0, index));
                parsedInput.add(1, operation.getOperation());
                parsedInput.add(2, userInput.substring(index + 1));
                break;
            }
        }
        return parsedInput;
    }
}

enum Operations {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DEVIDE("/");

    private final String operation;
    Operations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
