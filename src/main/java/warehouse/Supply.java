package warehouse;

import java.util.Objects;

public class Supply{

    private String user;
    private int units;
    private Double price;

    public Supply(String user, int units, Double price){
        this.user = Objects.requireNonNull(user);
        this.units = Objects.requireNonNull(units);
        this.price = Objects.requireNonNull(price);
    }

    public String getUser() {
        return user;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Double getPrice() {
        return price;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("\n| User: %s, units: %s, price: %s", user, units, price);
    }
}
