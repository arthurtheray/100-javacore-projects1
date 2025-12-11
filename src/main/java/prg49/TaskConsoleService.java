package prg49;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskConsoleService {
    private static final String WELCOME_MESSAGE = """
            Сервис задач запущен.
            Для добавления новой задачи напишите текст задачи в формате:
            +[приоритет от 0 до 5] [текст задачи]
            Например, для добавления задачи "вынести мусор" с наивысшим приоритетом, отправьте:
            +0 Вынести мусор
            
            Для получения списка задач в порядке их приоритетности, введите команду "!список".
            Для завершения программы введите !выход
            """;
    private final TaskRepository taskRepository;
    private final Scanner scanner = new Scanner(System.in);

    public TaskConsoleService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void init() {
        String nextCommand = "";
        System.out.println(WELCOME_MESSAGE);
        while (!nextCommand.equalsIgnoreCase("!выход")) {
            nextCommand = scanner.nextLine();
            System.out.println(sendReply(nextCommand.trim()));
        }
    }

    private String sendReply(String command) {
        if (!isValidCommand(command)) {
            return "Неверный формат команды.\n" + WELCOME_MESSAGE;
        }

        if (command.charAt(0) == '+') {
            try {
                taskRepository.add(command.substring(2), Integer.parseInt(command.substring(1, 2)));
                return "задача добавлена";
            } catch (Exception e) {
                return "Ошибка при добавлении команды.\n" + e.getMessage();
            }
        }

        if (command.charAt(0) == '!') {
            if (command.substring(1).equals("список")) {
                StringBuilder reply = new StringBuilder();
                for (Task task : taskRepository) {
                    reply
                            .append("- ")
                            .append(task.getCaption())
                            .append("(приоритет: ").append(task.getPriority()).append(")\n");
                }
                return reply.toString();
            }
        }
        return ">";
    }

    private boolean isValidCommand(String command) {
        Pattern pattern = Pattern.compile("(\\+[0-5]\\s+.*)|(!список)|(!выход)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(command);
        return matcher.find();
    }
}
