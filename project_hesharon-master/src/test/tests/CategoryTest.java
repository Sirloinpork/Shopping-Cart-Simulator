package tests;

import model.Brand;
import model.Cart;
import model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.LoadingManager.*;

public class CategoryTest {
    private Cart cart;
    private Category clothing;
    private Category food;
    private Brand noname;
    private Brand Muji;

    @BeforeEach
    void beforeEachTest() {
        cart = new Cart();
        clothing = new Category("Clothing");
        food = new Category("Food");
        noname = new Brand("noname", "Noname");
        Muji = new Brand("muji","Muji");
        loadClothingProducts();
        loadTechProducts();
        loadFurnitureProducts();
        loadMakeUpProducts();
        loadCategories();
        loadBrands();
    }

    @Test
    void testgetName() {
        assertEquals(clothing.getName(), "Clothing");
        assertEquals(food.getName(),"Food");
    }

    @Test
    void testaddBrand() {
        assertTrue(clothing.returnBrandList().isEmpty());
        clothing.addBrand(noname);
        assertTrue(!clothing.returnBrandList().isEmpty());
        assertTrue(clothing.returnBrandList().contains(noname));
        assertEquals(noname.returnCategory(), clothing);
        clothing.addBrand(Muji);
        assertEquals(Muji.returnCategory(), clothing);
    }

    @Test
    void testreturnBrandList() {
        assertTrue(clothing.returnBrandList().isEmpty());
        clothing.addBrand(noname);
        clothing.addBrand(Muji);
        assertTrue(clothing.returnBrandList().contains(noname));
        assertTrue(clothing.returnBrandList().contains(Muji));
    }
}
