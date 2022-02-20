package main.java;

import main.java.products.Cheese;
import main.java.products.Chips;
import main.java.products.Product;
import main.java.products.Wine;

import java.time.LocalDate;

public class ProductFactory {

    public Product createProduct(String productType, String name, double basicPrice, LocalDate expiryDate) {
        return switch (productType) {
            case "Käse", "Kaese" -> new Cheese(name, basicPrice, expiryDate);
            case "Wein" -> new Wine(name, basicPrice, expiryDate);
            case "Chips" -> new Chips(name, basicPrice, expiryDate);
            default -> null;
        };
    }
}
