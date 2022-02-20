package main.java;

import main.java.products.Product;
import main.java.controller.MenuController;

import java.io.IOException;
import java.util.ArrayList;

public class SupertDuperMarkt {

    static ArrayList<Product> productsList = new ArrayList<>();

    public static void main(String[] arg) throws IOException {
        MenuController.mainMenu(productsList);
    }
}
