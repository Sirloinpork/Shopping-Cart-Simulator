package ui;

import model.Brand;
import model.Category;
import model.Product;

import java.util.List;

public class PrintManager {

    private static final String RETURN_COMMAND = "r";
    private static final String QUIT_COMMAND = "quit";

    //EFFECTS: prints a list of available clothing brands
    public static String printBrands(Category category) {
        String acc = "";
        for (Brand c : category.returnBrandList()) {
            acc += ("-" + c.getName());
        }
        return acc;
    }

    public static void printBrandInstructions(List<Brand> b) {
        System.out.println("Select a brand by typing the brand name exactly how its shown below");
        System.out.println("Enter '" + RETURN_COMMAND + "' to return to the main menu");
        for (Brand brands : b) {
            System.out.println("-" + brands.getdisplayName());
        }

    }

    //EFFECTS: prints a list of available Uniqlo products
    public static void printProductInstructions(List<Product> p) {
        System.out.println("Select a product by typing the product name exactly how its shown below");
        System.out.println("To return to the main menu, enter '" + RETURN_COMMAND + "'.");
        for (Product products : p) {
            System.out.println("-" + products.getDisplayName());
        }
    }
}
