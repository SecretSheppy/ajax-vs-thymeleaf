package com.secretsheppy.ajax_vs_thymleaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {

    private static final ArrayList<Product> products = new ArrayList<> (
            Arrays.asList(new Product(1, "a", "a is good", 20.0),
                          new Product(2, "b", "b is good", 20.0),
                          new Product(3, "c", "c is good", 20.0),
                          new Product(4, "d", "d is good", 20.0)));

    public static List<Product> getProducts() {
        return products.stream().toList();
    }

    public static int getNextProductId() {
        return products.get(products.size() - 1).getId() + 1;
    }

    public static void addProducts(Product product) {
        products.add(product);
    }

}
