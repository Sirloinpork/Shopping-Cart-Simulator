package tests;

import model.Brand;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    private Product macbook;
    private Brand Apple;

    @BeforeEach
    void beforeEachTest(){
        macbook = new Product("macbook pro","Macbook Pro", 1699.00,"The 2019 model", 4.5);
        Apple = new Brand("apple", "Apple");
    }

    @Test
    void getNameTest(){
        assertTrue(macbook.getName() == "macbook pro");
    }

    @Test
    void getDisplayNameTest() {
        assertEquals(macbook.getDisplayName(), "Macbook Pro");
    }

    @Test
    void getPriceTest(){
        assertTrue(macbook.getPrice().equals(1699.00));
    }

    @Test
    void getDescriptionTest(){
        assertTrue(macbook.getDescription() == "The 2019 model");
    }

    @Test
    void getRatingTest(){
        assertTrue(macbook.getRating().equals(4.5));
    }

    @Test
    void setBrandTest() {
        macbook.setBrand(Apple);
        assertEquals(macbook.returnBrand(), Apple);
        Apple.returnProductList().contains(macbook);
    }
}
