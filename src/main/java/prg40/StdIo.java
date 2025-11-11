package prg40;

import java.util.Scanner;

public enum StdIo {
    INSTANCE;

    private final Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String read() {
        return scanner.nextLine().trim();
    }
}
