package main.java.products;

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

    public void drawInfo() {
        System.out.format("%20s %15.2f %10d %15s", this.getName(), this.getPrice(), this.getQuality(), this.getExpiryDate());
        System.out.println();
    }

    public void drawInfoFuture(LocalDate date) {
        quality = (int) ChronoUnit.DAYS.between(date, expiryDate);
        if (!spoiled) {
            System.out.format("%20s %15.2f %10d", this.getName(), this.getPrice(), this.getQuality());
            System.out.println();
        } else {
            System.out.format("%20s %15.2f %10d %15s", this.getName(), this.getPrice(), this.getQuality(), "X");
            System.out.println();
        }
    }
}
