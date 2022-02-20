package main.java.controller;

import main.java.products.Product;
import main.java.services.FileImport;
import main.java.services.Printer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {

    // Show main menu
    public static void mainMenu(ArrayList<Product> productsList) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println(" 1 - Für die Ausgabe aller Produkte");
        System.out.println(" 2 - Um neue Produkte hinzu zufügen");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                printProductsMenu(productsList);
                break;
            case 2:
                addProductsMenu(productsList);
                break;
            default:
                System.out.println("Die Eingabe war ungültig.");
                mainMenu(productsList);
        }
    }

    // show the menu to print the products
    static void printProductsMenu(ArrayList<Product> productsList) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println(" 1 - Für die Ausgabe aller Produkte");
        System.out.println(" 2 - Für die Ausgabe aller Produkte mit der Angabe, ob das Produkt entsort werden muss.");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                Printer.printAllProducts(productsList);
                break;
            case 2:
                System.out.println("Für wie viele Tage soll die Liste erstellt werden? ");
                Printer.printInfoFuture(productsList,scanner.nextInt());
                break;
            default:
                System.out.println("Die Eingabe war ungültig.");
                mainMenu(productsList);
        }
    }

    // Show the menu to add products
    static void addProductsMenu(ArrayList<Product> productsList) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println("1 - Für den Import einer .csv Datei");
        System.out.println("2 - Für den Import aus einer online Datenbank");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                FileImport.csvImport(productsList);
                break;
            case 2:
                // TODO SQL
                break;
            default:
                break;
        }
    }

    // Show the menu to return to the main menu
    static void returnToMenu(ArrayList<Product> productsList) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Wählen Sie eine der Folgenden Optionen");
        System.out.println(" 1 - Zurück zum Menü");
        System.out.println(" jede andere Taste - Programm beenden");
        int caseNr = scanner.nextInt();
        switch (caseNr) {
            case 1:
                mainMenu(productsList);
                break;
            default:
                break;
        }
    }
}
