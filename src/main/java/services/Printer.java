package main.java.services;

import main.java.controller.MenuController;
import main.java.products.Product;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Printer {

    // Print all products
    public static void printAllProducts(ArrayList<Product> productsList) throws FileNotFoundException {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%20s %15s %10s %15s", "Bezeichnung", "Preis in \u20AC", "Qualität", "Verfallsdatum");
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        for (Product product : productsList) {
            product.checkQuality();
            product.drawInfo();
        }
        System.out.println("------------------------------------------------------------------");
        MenuController.returnToMenu(productsList);
    }

    // print all products for the following x days
    public static void printInfoFuture(ArrayList<Product> productsList, int days) throws FileNotFoundException {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%20s %15s %10s %15s", "Bezeichnung", "Preis in \u20AC", "Qualität", "Abgelaufen");
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < days; i++) {
            System.out.println("--------------------------- " + LocalDate.now().plusDays(i) + " ---------------------------");
            for (Product product : productsList) {
                product.drawInfoFuture(LocalDate.now().plusDays(i));
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------");
        MenuController.returnToMenu(productsList);
    }
}
