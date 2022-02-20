package main.java.products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wine extends Product {

    public Wine(String name, double basicPrice, LocalDate expiryDate) {
        super(name, basicPrice, expiryDate);
    }

    @Override
    public void checkQuality() {
        if (java.time.LocalDate.now().compareTo(expiryDate) % 10 == 0) {
            if (quality < 50) {
                quality++;
            }
        }
    }

    @Override
    public int getQuality() {
        quality = (int) ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        return quality;
    }
}
