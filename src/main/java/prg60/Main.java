package prg60;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * 60. Локализованное форматирование чисел/денег
 * Суть: на вход число и код локали/валюты; на выход — строка с форматированием.
 * Ограничения: NumberFormat, Locale, Currency; без ручной вставки разделителей.
 * Теория: локализация, валютные форматы, группировка.
 */
public class Main {
    public static void main(String[] args) {
        double number = 123456.78901;
        System.out.println("raw: " + number);

        NumberFormat defaultFormat = NumberFormat.getNumberInstance();
        System.out.println(defaultFormat.toString() + defaultFormat.format(number)
                + " " + defaultFormat.getCurrency().getDisplayName() + defaultFormat.getCurrency().getSymbol());

        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        System.out.println(usFormat.toString() + usFormat.format(number) + usFormat.getCurrency());

        Currency currency = Currency.getInstance(Locale.US);
        System.out.println(currency.toString() + usFormat.format(number)+currency.getCurrencyCode());
    }
}
