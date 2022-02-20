package main.java.services;

import main.java.ProductFactory;
import main.java.controller.MenuController;
import main.java.products.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileImport {

    static ProductFactory factory = new ProductFactory();

    // Import file from .csv
    public static void csvImport(ArrayList<Product> productsList) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String[] line;
        System.out.println("Die zu importierende Datei muss das Format Produkttyp, Produktbezeichnung, Preis, " +
                "Verfallsdatum haben.");
        System.out.println("Bitte geben sie den absoluten Pfad der .csv Datei an.");
        String path = scanner.nextLine();
        File csvFile = new File(path);
        Scanner csvScanner = new Scanner(csvFile);
        while (csvScanner.hasNextLine()) {
            line = csvScanner.nextLine().split(";");
            productsList.add(factory.createProduct(line[0], line[1],
                    Double.parseDouble(line[2]), LocalDate.parse(line[3])));
        }
        MenuController.mainMenu(productsList);
    }

    // Import from SQL
    static void sqlImport(){
        Scanner scanner = new Scanner(System.in);
        String url, database, user, password;
        System.out.println("Bitte geben Sie die ");
    }
}
