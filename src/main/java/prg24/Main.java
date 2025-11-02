package prg24;

/**
 * Иммутабельный класс `Money`. Валюта + сумма.
 *    1. Требования: `final` поля, без сеттеров; проверка инвариантов в конструкторе.
 *    2. Теория: иммутабельность, защитные копии, `BigDecimal` для денег (намёк).
 */
public class Main {
    public static void main(String[] args) {

        Money usdMoney = new Money(Currencyes.USD, "100.0000003");
        Money eurMoney = new Money(Currencyes.EUR, "50");
        Money rubMoney = new Money(Currencyes.RUB, "1000E+100");
        System.out.println("Sum of all my money in RUB: "
                + usdMoney.getSumInRub()
                .add(eurMoney.getSumInRub()
                        .add(rubMoney.getSumInRub())));
    }
}
