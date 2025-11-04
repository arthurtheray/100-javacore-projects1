package prg38;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Анонимный класс слушателя. Таймер «тик».
 *    1. Требования: `Timer` + анонимный `TimerTask`; без лямбд.
 *    2. Теория: анонимные классы, классы-обёртки задач, планирование `Timer`.
 */
public class Main {
    /**
     * Длина бара (количество тиков для полного заполнения бара)
     */
    private static final int BAR_LENGTH = 10;

    public static void main(String[] args) {
        drawProgressBar(3000, 3);
    }

    /**
     * Рисует заполняющийся за указанное время прогресс бар
     * @param barTime время для полного заполнения бара в миллисекундах
     * @param repeats количество повторений прохождения бара
     */
    private static void drawProgressBar(long barTime, int repeats) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            private int count = 0;
            @Override
            public void run() {
                if (count == repeats * BAR_LENGTH) {
                    cancel();
                    timer.cancel();
                    return;
                }
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b");
                redraw(count);
                count++;}
        }, 0, barTime / BAR_LENGTH);
    }

    private static void redraw(int count) {
        char[] barChars = new char[BAR_LENGTH];
        int normalizedCount = count % barChars.length;
        for (int i = 0; i < barChars.length; i++) {
            if (i <= normalizedCount) {
                barChars[i] = '#';
            } else {
                barChars[i] = '_';
            }
        }
        String bar = "[" + String.valueOf(barChars) + "]";
        System.out.print(bar);
    }
}
