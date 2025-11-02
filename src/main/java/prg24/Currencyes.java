package prg24;

import java.math.BigDecimal;

public enum Currencyes {
    RUB("0.0"),
    USD("82"),
    EUR("90");

    private final String exchangeRate;

    Currencyes(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return new BigDecimal(exchangeRate);
    }
}
