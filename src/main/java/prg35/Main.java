package prg35;

/**
 * Композиция vs наследование. `Car` с `Engine`.
 *    1. Требования: не наследоваться от `Engine`; `toString`.
 *    2. Теория: композиция против наследования, делегирование.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        Engine gasolineEngine = new GasolineEngine();
        gasolineEngine.start();
        car.changeEngine(gasolineEngine);
        car.stopDriving();
    }
}
