import Products.Cheese;
import Products.Product;
import Products.Wine;

import java.time.LocalDate;

public class ProductFactory {

    public Product createProduct(String productType, String name, double basicPrice, LocalDate expiryDate) {
        return switch (productType) {
            case "Käse", "Kaese" -> new Cheese(name, basicPrice, expiryDate);
            case "Wein" -> new Wine(name, basicPrice, expiryDate);
            default -> null;
        };
    }
}
