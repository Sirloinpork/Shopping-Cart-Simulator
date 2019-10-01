package ui;

import model.Brand;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class LoadingManager {
    public static final List<Category> categoryList = new ArrayList();
    public static final Category clothing = new Category("clothing");
    public static final Category tech = new Category("tech");
    public static final Category furniture = new Category("furniture");
    public static final Category makeup = new Category("make-up");

    public static final Brand uniqlo = new Brand("uniqlo", "Uniqlo");
    public static final Brand bananarepublic = new Brand("banana republic","Banana Republic");
    public static final Brand apple = new Brand("apple","Apple");
    public static final Brand google = new Brand("google","Google");
    public static final Brand stanley = new Brand("stanley","Stanley");
    public static final Brand basset = new Brand("basset","Basset");
    public static final Brand mac = new Brand("mac","Mac");
    public static final Brand urbandecay = new Brand("urban decay","Urban Decay");

    public static Product peanuts_shirt = new Product("peanuts shirt", "Peanuts Shirt", 14.90,
            "100% cotton T-Shirt, pink", 4.5);
    public static Product wide_straight_pants = new Product("wide straight pants","Wide Straight Pants", 39.90,
            "High waisted, wide-leg straight cut showcases the drape of the fabric", 4.0);
    public static Product chino_pants = new Product("chino pants","Chino Pants", 29.90,
            "High-density chino material with a brushed surface for a premium feel", 3.5);


    public static Product floral_ruffled_dress = new Product("floral ruffled dress","Floral Ruffled Dress", 195.00,
            "Delicately ruffled accents at the shoulders and neckline add a feminine flourish",
            4.0);
    public static Product luxespun_hoodie = new Product("luxespun hoodie","Luxespun Hoodie", 75.00,
            "Made with our cozy-knit, Luxespun fabric that's sweater-soft for maximum comfort",
            4.7);
    public static Product luxury_touch_polo = new Product("luxury touch polo","Luxury Touch Polo", 55.00,
            "Silky soft and smooth to the touch, our customer-favorite Luxury Touch fabric offers superior comfort",
            4.9);


    public static Product macbook_pro = new Product("macbook pro","Macbook Pro", 1569.00,
            "MacBook Pro elevates the notebook to a whole new level of performance and portability", 4.9);
    public static Product iphone_xs = new Product("iphone xs","iPhone Xs", 1379.00,
            "iPhone XS is everything you love about iPhone. Taken to the extreme", 4.9);
    public static Product imac = new Product("imac","iMac", 1329.00,
            "iMac is packed with the latest processors, faster memory and phenomenal graphics", 4.9);


    public static Product pixel_3a = new Product("pixel 3a","Pixel 3a", 549.00,
            "Premium. For less.", 4.8);
    public static Product google_home = new Product("google home","Google Home", 99.00,
            "Help is here. Meet Google Home.", 4.0);
    public static Product pixelbook = new Product("pixelbook","PixelBook", 1299.00,
            "Google Pixelbook, the high performance Chromebook.", 3.9);


    public static Product latitude_dresser = new Product("latitude dresser","Latitude Dresser", 499.00,
            "Refined top drawers lifted above the floor by delicate feet",
            3.5);
    public static Product horizon_panel_bed = new Product("horizon panel bed","Horizon Panel Bed", 1000.00,
            "With metal inlays featured on its headboard and footbard and a hand mottled, metal base, "
                    +
                    "the Horizon Panel Bed is the perfect centerpiece for a contemporary bedroom", 4.0);
    public static Product latitude_writing_desk = new Product("latitude writing desk","Latitude Writing Desk", 299.00,
            "The Latitude Writing Desk is uniquely styled to float in a room to provide maximum flexibility", 4.5);


    public static Product savoy_upholstered_bed = new Product("savoy upholstered bed","Savoy Upholstered Bed", 1179.00,
            "It is light and airy in form and finish", 4.5);
    public static Product verona_dining_table = new Product("verona dining table","Verona Dining Table", 2449.00,
            "The Dover White finish is applied in multiple layers to recreate that rustic farmhouse look",
            4.5);
    public static Product alexander_sofa = new Product("alexander sofa","Alexander Sofa", 999.00,
            "The design is pure classic: sock-styled arms, loose cushions, and welted cushion seams",
            3.9);


    public static Product matte_lipstick = new Product("matte lipstick","Matte Lipstick", 23.00,
            "his creamy rich formula features high colour payoff in a no-shine matte finish", 4.5);
    public static Product dazzleshadow = new Product("dazzleshadow","DazzleShadow", 24.00,
            "The rich pigments adhere to the lid, imparting eyes with a beautiful sheen",
            4.0);
    public static Product ooverage_foundation = new Product("coverage foundation","Coverage Foundation", 43.00,
            "Can cover most scars, blemishes and birthmarks", 4.9);


    public static Product eyeshadow_primer = new Product("eyeshadow primer","Eyeshadow Primer", 28.50,
            "The legendary primer looks gorgeous and applies with versatility",
            3.5);
    public static Product vice_lipstick = new Product("vice lipstick","Vice Lipstick", 23.00,
            "This product is guaranteed to make your lips looking flawless",
            5.0);
    public static Product beached_bronzer = new Product("beached bronzer","Beached Bronzer", 37.00,
            "Our finely mill formula applies smoothly, doesn’t streak, and creates a radiant glow",
            4.7);

    public static void loadCategories() {

        categoryList.add(clothing);
        categoryList.add(tech);
        categoryList.add(furniture);
        categoryList.add(makeup);
    }

    public List<Category> returnCategoryList() {
        return categoryList;
    }

    public static void loadBrands() {
        clothing.addBrand(uniqlo);
        clothing.addBrand(bananarepublic);

        tech.addBrand(apple);
        tech.addBrand(google);

        furniture.addBrand(stanley);
        furniture.addBrand(basset);

        makeup.addBrand(mac);
        makeup.addBrand(urbandecay);
    }

    public static void loadClothingProducts() {
        uniqlo.addProduct(peanuts_shirt);
        uniqlo.addProduct(wide_straight_pants);
        uniqlo.addProduct(chino_pants);

        bananarepublic.addProduct(floral_ruffled_dress);
        bananarepublic.addProduct(luxespun_hoodie);
        bananarepublic.addProduct(luxury_touch_polo);
    }

    public static void loadTechProducts() {

        apple.addProduct(macbook_pro);
        apple.addProduct(iphone_xs);
        apple.addProduct(imac);

        google.addProduct(pixel_3a);
        google.addProduct(google_home);
        google.addProduct(pixelbook);
    }

    public static void loadFurnitureProducts() {
        stanley.addProduct(latitude_dresser);
        stanley.addProduct(horizon_panel_bed);
        stanley.addProduct(latitude_writing_desk);

        basset.addProduct(savoy_upholstered_bed);
        basset.addProduct(verona_dining_table);
        basset.addProduct(alexander_sofa);
    }

    public static void loadMakeUpProducts() {
        mac.addProduct(matte_lipstick);
        mac.addProduct(dazzleshadow);
        mac.addProduct(ooverage_foundation);

        urbandecay.addProduct(eyeshadow_primer);
        urbandecay.addProduct(vice_lipstick);
        urbandecay.addProduct(beached_bronzer);
    }
}
