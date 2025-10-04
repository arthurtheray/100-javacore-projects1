package prg4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            String userinput = getUserInput();
            ArrayList<String> parsedInput = parseUserInput(userinput);
            if (parsedInput == null) {
                System.out.println("Упс");
            } else {
                try {
                    calc(parsedInput);
                } catch (IOException e) {
                    System.out.println("Упс");
                    continue;
                }
                break;
            }
        }
    }

    public static void calc(ArrayList<String> expression) throws IOException {
        try {
            switch (expression.get(1)) {
                case "+" -> System.out.println(Double.parseDouble(expression.get(0)) + Double.parseDouble(expression.get(2)));
                case "-" -> System.out.println(Double.parseDouble(expression.get(0)) - Double.parseDouble(expression.get(2)));
                case "*" -> System.out.println(Double.parseDouble(expression.get(0)) * Double.parseDouble(expression.get(2)));
                case "/" -> System.out.println(Double.parseDouble(expression.get(0)) / Double.parseDouble(expression.get(2)));
                default -> System.out.println("ошибка");
            }
        } catch (NumberFormatException e) {
            throw new IOException("Не удалось спарсить");
        }

    }

    public static String getUserInput() {
        System.out.println("введите выражение (например 1+1)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static ArrayList<String> parseUserInput(String userinput) {
        ArrayList<String> parsedInput = new ArrayList<>();
        boolean isExpressionValid = false;
        for (Operations operation:Operations.values()) {
            int index = userinput.indexOf(operation.getOperation());
            if (index > 0 & index != userinput.length() - 1) {
                parsedInput.add(0, userinput.substring(0, index));
                parsedInput.add(1, operation.getOperation());
                parsedInput.add(2, userinput.substring(index + 1));
                isExpressionValid = true;
                break;
            }
        }
        return isExpressionValid ? parsedInput : null;
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
