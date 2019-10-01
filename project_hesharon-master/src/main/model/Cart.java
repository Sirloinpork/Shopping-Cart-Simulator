package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    public Map<Product, Double> products;

    //MODIFIES: this
    //EFFECTS: Constructs an empty cart (no products)
    public Cart() {
        products = new HashMap<>();
    }

    //MODIFIES: this
    //EFFECTS: Adds the chosen product to the cart
    public void addProductToCart(Product product) {
        products.put(product, product.getPrice());
    }

    //EFFECTS: Returns the hashmap of the cart
    public Map<Product, Double> returnHashMap() {
        return products;
    }
}
