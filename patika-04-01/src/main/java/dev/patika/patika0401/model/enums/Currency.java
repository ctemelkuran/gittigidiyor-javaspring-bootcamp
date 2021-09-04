package dev.patika.patika0401.model.enums;

public enum Currency {
    TRY("Türk Lirası", "₺"),
    USD("Amerikan Doları","$"),
    EUR("Euro","€"),
    GBP("İngiliz Pound","£");


    private String currencyName;
    private String currencySign;

    Currency(String currencyName, String currencySign) {
        this.currencyName = currencyName;
        this.currencySign = currencySign;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySign() {
        return currencySign;
    }
}
