package prg36;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Иерархия исключений.
 *    1. Требования: checked исключения; перехват в `main`.
 *    2. Теория: `Throwable`→`Exception`/`RuntimeException`, checked vs unchecked, `throws`.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ExceptionsGenerator exceptionsGenerator = new ExceptionsGenerator();
        try {
            exceptionsGenerator.throwRuntimeException();
            exceptionsGenerator.throwIoException();
        } catch (Exception e) {
            System.out.println("Поймал: " + e.getMessage() + "\n" + e.getClass());
            throw e;
        }
    }
}
