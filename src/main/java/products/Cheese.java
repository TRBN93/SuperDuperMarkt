package main.java.products;

import java.time.LocalDate;

public class Cheese extends Product {

    public Cheese(String name, double basicPrice, LocalDate expiryDate) {
        super(name, basicPrice, expiryDate);
    }

    @Override
    public double getPrice() {
        return basicPrice + 0.1 * getQuality();
    }

    @Override
    public void checkQuality() {
        if (this.quality < 30) {
            this.spoiled = true;
        }
    }
}
