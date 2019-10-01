package tests;

import model.Brand;
import model.Category;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.LoadingManager.*;

public class BrandTest {

    private static Brand Herschel;
    private static Category clothing;

    @BeforeEach
    void beforeEachTest() {
        Herschel = new Brand("herschel", "Herschel");
        clothing = new Category("Food");
        loadClothingProducts();
        loadTechProducts();
        loadFurnitureProducts();
        loadMakeUpProducts();
        loadCategories();
        loadBrands();
    }

    @Test
    void testGetName() {
        assertEquals (Herschel.getName(), "herschel");
        assertEquals(uniqlo.getName(), "uniqlo");
        assertEquals(basset.getName(), "basset");
    }

    @Test
    void testGetDisplayName() {
        assertEquals(Herschel.getdisplayName(),"Herschel");
    }

    @Test
    void testaddProduct() {
        Product bag = new Product("bag","Bag", 20.00, "A bag", 4.5);
        Product jacket = new Product("jacket","Jacket", 55.99, "A jacket", 4.0);
        Product luggage = new Product("luggage","Luggage", 199.99, "A luggage", 3.9);
        assertTrue(Herschel.returnProductList().isEmpty());
        Herschel.addProduct(bag);
        assertTrue(!Herschel.returnProductList().isEmpty());
        assertTrue(Herschel.returnProductList().contains(bag));
        assertEquals(bag.returnBrand(), Herschel);
        Herschel.addProduct(jacket);
        assertEquals(jacket.returnBrand(), Herschel);

    }

    @Test
    void testreturnProductsList() {
        assertTrue(!uniqlo.returnProductList().isEmpty());
        assertTrue(uniqlo.returnProductList().contains(peanuts_shirt));
        assertTrue(uniqlo.returnProductList().contains(wide_straight_pants));
        assertTrue(uniqlo.returnProductList().contains(chino_pants));
        assertEquals(uniqlo.returnProductList().size(), 3);

        assertTrue(Herschel.returnProductList().isEmpty());
        assertTrue(!apple.returnProductList().isEmpty());
        assertTrue(apple.returnProductList().contains(macbook_pro));
        assertTrue(apple.returnProductList().contains(iphone_xs));
        assertTrue(apple.returnProductList().contains(imac));
        assertEquals(apple.returnProductList().size(), 3);
    }

    @Test
    void testsetCategory() {
        Herschel.setCategory(clothing);
        assertEquals(Herschel.returnCategory(), clothing);
        clothing.returnBrandList().contains(Herschel);


    }


}




