package tests;

import model.Cart;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.LoadingManager.*;

public class CartTest {
    private Cart cart;
    private Product bag;
    private Product jacket;

    @BeforeEach
    void beforeEachTest() {
        cart = new Cart();
        bag = new Product("bag", "Bag", 10.00, "A bag", 4.0);
        jacket = new Product("jacket", "Jacket", 59.99, "A bag", 3.9);
        loadClothingProducts();
        loadTechProducts();
        loadFurnitureProducts();
        loadMakeUpProducts();
        loadCategories();
        loadBrands();
    }

    @Test
    void testaddProductToCart() {
        assertTrue(cart.returnHashMap().isEmpty());
        cart.addProductToCart(bag);
        assertTrue(cart.returnHashMap().containsKey(bag));
        assertTrue(cart.returnHashMap().containsValue(10.00));
        cart.addProductToCart(jacket);
        cart.returnHashMap().containsKey(jacket);
        cart.returnHashMap().containsValue(59.99);
    }
}
