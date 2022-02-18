import Products.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SupertDuperMarkt {

    static ArrayList<Product> productsList = new ArrayList<>();

    static ProductFactory factory = new ProductFactory();

    public static void main(String[] arg) throws IOException {

        //chooseMenu();
        csvImport();
        printAllProducts();
    }

    // Ausgabe des Auswahlmenüs auf der Konsole
    static void chooseMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println(" 1 - Für die Ausgabe aller Produkte");
        System.out.println(" 2 - Um neue Produkte hinzu zufügen");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                printAllProducts();
                break;
            case 2:
                addProductsMenu();
                break;
            default:
                System.out.println("Die Eingabe war ungültig.");
                chooseMenu();
        }
    }

    // Ausgabe des Menüs um Produkte hinzu zufügen
    static void addProductsMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println("1 - Für den Import einer .csv Datei");
        System.out.println("2 - Für den Import aus einer online Datenbank");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                csvImport();
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    // Import file from .csv
    static void csvImport() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String[] line;
        System.out.println("Die zu importierende Datei muss das Format Produkttyp, Produktbezeichnung, Preis, " +
                "Verfallsdatum haben.");
        System.out.println("Bitte geben sie den absoluten Pfad der .csv Datei an, welche importiert werden soll:");
        String path = scanner.nextLine();
        File csvFile = new File(path);
        Scanner csvScanner = new Scanner(csvFile);
        while (csvScanner.hasNextLine()) {
            line = csvScanner.nextLine().split(";");
            productsList.add(factory.createProduct(line[0], line[1],
                    Double.parseDouble(line[2]), LocalDate.parse(line[3])));
        }
    }

    // Ausgabe um zurück zum Menü zu kommen, oder das Programm zu beenden
    static void returnToMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println(" 1 - Zurück zum Menü");
        System.out.println(" jede andere Taste - Programm beenden");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                chooseMenu();
                break;
            default:
                break;
        }
    }

    // Ausgabe aller Produkte auf der Konsole
    static void printAllProducts() throws FileNotFoundException {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%20s %15s %10s %15s", "Bezeichnung", "Preis in \u20AC", "Qualität", "Verfallsdatum");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        for (Product product : productsList) {
            product.checkQuality();
            if (!product.isSpoiled()) {
                System.out.format("%20s %15.2f %10d %15s", product.getName(), product.getPrice(), product.getQuality(), product.getExpiryDate());
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------------------------------");
        returnToMenu();
    }
}
