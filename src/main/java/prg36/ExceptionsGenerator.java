package prg36;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsGenerator {

    public void throwError() throws Error {
        throw new Error("Ошибка на уровне JVM. Не обрабатываем");
    }

    public void throwRuntimeException() throws RuntimeException {
        throw new RuntimeException("Ошибка в коде!");
    }

    public void throwIoException() throws IOException {
        throw new FileNotFoundException("Ошибка ввода или вывода!");
    }
}
