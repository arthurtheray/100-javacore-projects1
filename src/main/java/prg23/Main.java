package prg23;

/**
 * Статический счётчик экземпляров.
 *    1. Требования: `static` поле; потокобезопасность не нужна.
 *    2. Теория: члены класса vs экземпляра, статические инициализаторы, область жизни.
 */
public class Main {
    public static void main(String[] args) {
        CountingService countingService = new CountingService();
        CountingService countingService2 = new CountingService();
        countingService2.resetCount();
        CountingService countingService3 = new CountingService();
    }
}
