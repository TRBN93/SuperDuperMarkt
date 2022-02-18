package Products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Product {
    double basicPrice;
    int quality;
    String name;
    LocalDate expiryDate;
    boolean spoiled = false;

    public Product(String name, double basicPrice, LocalDate expiryDate) {
        this.name = name;
        this.basicPrice = basicPrice;
        this.quality = (int) ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return basicPrice;
    }

    public int getQuality() {
        return quality;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void checkQuality() {
        quality = (int) ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
    }

    void checkQuality(LocalDate date) {
        quality = (int) ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
    }

    public boolean isSpoiled() {
        return spoiled;
    }
}
