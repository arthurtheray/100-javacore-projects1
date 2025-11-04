package prg35;

public class Car {
    private Engine engine = new DieselEngine();

    public void drive() {
        engine.start();
        System.out.println("Двигатель запущен. Поехали!\n Текущая частота двигателя: " + engine.getRpm() + "\n"
        + "Крутящий момент: " + engine.getTorque());
    }

    public void stopDriving() {
        if (engine.getRpm() == 0) {
            throw new IllegalStateException("Не могу остановить двигатель. Мы и так стоим!");
        }
        engine.stop();
        System.out.println("Двигатель остановлен. Приехали!");
    }

    public void changeEngine(Engine newEngine) {
        engine = newEngine;
        System.out.println("Ого! Мы заменили двигатель на ходу");
        System.out.println("Текущая частота двигателя: " + engine.getRpm() + "\n"
                + "Крутящий момент: " + engine.getTorque());
        if (engine.getRpm() == 0) {
            System.out.println("Мы заглохли!");
        } else System.out.println("Продолжаем ехать!");
    }
}
