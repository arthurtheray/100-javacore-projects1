package prg50;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Undo/Redo на Deque
 * Суть: консольное приложение с командами do <op>, undo, redo; на вход — поток команд; на выход — состояние после каждой команды.
 * Ограничения: использовать ArrayDeque (две деки: undo/redo); не использовать Stack, GUI или БД.
 * Теория: Deque, команды как объекты, push/pop, понятие стеков операций.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Deque<String> undo = new ArrayDeque<>();
    private static final Deque<String> redo = new ArrayDeque<>();
    public static void main(String[] args) {
        String rawString = askForString();
        undo.push(rawString);
        while (true) {
            Command command = getUserInput();
            switch (command) {
                case UNDO -> {
                    if (undo.size() < 2) {
                        System.out.println("отменять нечего");
                        continue;
                    }
                    redo.push(undo.pop());
                }
                case REDO -> {
                    if (redo.isEmpty()) {
                        System.out.println("нечего повторять");
                        continue;
                    }
                    undo.push(redo.pop());
                }
                default -> {
                    redo.clear();
                    undo.push(command.getOperation().getOperation().apply(undo.peek()));
                }
            }
            System.out.println(undo.peek());
        }
    }

    private static String askForString() {
        System.out.println("Введите строку для преобразования");
        return scanner.nextLine();
    }

    private static Command getUserInput() {
        input:
        while (true) {
            System.out.println("""
                    Введите команду do <op>, undo или redo.
                    Доступные <op>: snake, camel, kebab, pascal.
                    """);
            String userInput = scanner.nextLine().trim().toLowerCase();
            String[] tokens = userInput.split("\\s+", 2);
            for (Command command : Command.values()) {
                if (command.getCommandName().equals(tokens[0])) {
                    if (command.getCommandName().equals("do")) {
                        if (tokens.length < 2) {
                            System.out.println("Нужно выбрать операцию");
                            continue input;
                        }
                        for (Operation operation : Operation.values()) {
                            if (operation.getOperationName().equals(tokens[1])) {
                                return Command.getByOperation(operation);
                            }
                        }
                        continue input;
                    }
                    return command;
                }
            }
        }
    }
}

enum Operation {
    SNAKE_CASE("snake", string -> normalize(string).replaceAll("\\s+|-+|_+", "_")),
    CAMEL_CASE("camel", string -> {
        StringBuilder stringBuilder = new StringBuilder();
        String[] substrings = normalize(string).split("\\s+|-+|_+");
        for (int i = 0; i < substrings.length; i++) {
            char[] chars = substrings[i].toCharArray();
            if (i == 0) {
                chars[0] = Character.toLowerCase(chars[0]);
            } else {
                chars[0] = Character.toUpperCase(chars[0]);
            }
            substrings[i] = String.valueOf(chars);
            stringBuilder.append(substrings[i]);
        }
        return stringBuilder.toString();
    }),
    PASCAL_CASE("pascal", string -> {
        StringBuilder stringBuilder = new StringBuilder();
        String[] substrings = normalize(string).split("\\s+|-+|_+");
        for (int i = 0; i < substrings.length; i++) {
            char[] chars = substrings[i].toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            substrings[i] = String.valueOf(chars);
            stringBuilder.append(substrings[i]);
        }
        return stringBuilder.toString();
    }),
    KEBAB_CASE("kebab", string -> normalize(string).replaceAll("\\s+|-+|_+", "-"));

    private final Function<String, String> operation;
    private final String operationName;

    Operation(String operationName, Function<String, String> operation) {
        this.operation = operation;
        this.operationName = operationName;
    }

    public Function<String, String> getOperation() {
        return operation;
    }

    private static String normalize(String str) {
        Pattern pattern = Pattern.compile("([a-z][A-Z])|([A-Z][A-Z])");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll(mr -> mr.group().charAt(0) + " " + mr.group().substring(1)).trim().toLowerCase();
    }

    public String getOperationName() {
        return operationName;
    }
}

enum Command {
    UNDO("undo", null),
    REDO("redo", null),
    DO_SNAKE("do", Operation.SNAKE_CASE),
    DO_CAMEL("do", Operation.CAMEL_CASE),
    DO_KEBAB("do", Operation.KEBAB_CASE),
    DO_PASCAL("do", Operation.PASCAL_CASE);

    private final Operation operation;
    private final String commandName;

    Command(String commandName, Operation operation) {
        this.operation = operation;
        this.commandName = commandName;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Command getByOperation(Operation operation) {
        return switch (operation) {
            case CAMEL_CASE -> DO_CAMEL;
            case KEBAB_CASE -> DO_KEBAB;
            case SNAKE_CASE -> DO_SNAKE;
            case PASCAL_CASE -> DO_PASCAL;
        };
    }
}
