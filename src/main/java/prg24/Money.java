package prg24;

import java.math.BigDecimal;

public final class Money {
    private final Currencyes currency;
    private final BigDecimal amount;

    public Money(Currencyes currency, String amount) throws NumberFormatException {
        this.amount = new BigDecimal(amount);
        if (this.amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NumberFormatException("Amount must be > 0");
        }
        this.currency = currency;
    }

    public BigDecimal getSumInRub() {
        if (currency == Currencyes.RUB) {
            return amount;
        }

        return amount.multiply(currency.getExchangeRate());
    }
}

