package PojoDatas;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    String iso2;
    String name;
    String currency;
    String currency_name;
    String currency_symbol;

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    @Override
    public String toString() {
        return "Country{" +
                "iso2='" + iso2 + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", currency_name='" + currency_name + '\'' +
                ", currency_symbol='" + currency_symbol + '\'' +
                '}';
    }
}
