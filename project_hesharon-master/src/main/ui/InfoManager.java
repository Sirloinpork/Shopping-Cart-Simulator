package ui;

import model.Brand;
import model.Cart;
import model.Category;
import model.Product;

import java.util.Iterator;
import java.util.List;

public class InfoManager {

    private static final String CLOTHING_COMMAND = "clothing";
    private static final String TECH_COMMAND = "tech";
    private static final String FURNITURE_COMMAND = "furniture";
    private static final String MAKEUP_COMMAND = "make-up";
    private static final String RETURN_COMMAND = "r";
    private static final String CHECKOUT_COMMAND = "checkout";
    private static final String REMOVE_COMMAND = "remove";

    private Cart cart = new Cart();


    private Input input;
    private LoadingManager loadingManager;
    private boolean runProgram;
    private PrintManager printManager;

    public InfoManager() {
        loadingManager = new LoadingManager();
        printManager = new PrintManager();
        input = new Input();
        runProgram = true;
    }


    //EFFECTS: prints instructions to navigate the store
    public void printInstructions() {
        System.out.println("\nHere are the list of categories you can choose from:\n");
        System.out.println("Enter '" + CLOTHING_COMMAND + "' for the clothing department");
        System.out.println("Enter '" + TECH_COMMAND + "' for the technology department");
        System.out.println("Enter '" + FURNITURE_COMMAND + "' for the furniture department");
        System.out.println("Enter '" + MAKEUP_COMMAND + "' for the make-up department");
        System.out.println("To checkout, enter " + "'" + CHECKOUT_COMMAND + "'.");
        System.out.println("To return to the main menu, enter '" + RETURN_COMMAND + "'.");
    }

    public void selectCategory() {
        String choice = input.getUserInputString();
        for (Category c : loadingManager.returnCategoryList()) {
            if (c.getName().equals(choice)) {
                selectBrands(c.returnBrandList());
                return;
            }
        }
        if (CHECKOUT_COMMAND.equals(choice)) {
            checkout();
            return;
        }
        System.out.println("That is not a category. Please try again");
        selectCategory();
    }

    public void selectBrands(List<Brand> b) {
        printManager.printBrandInstructions(b);
        String choice = input.getUserInputString();
        for (Brand brands : b) {
            if (brands.getName().equals(choice)) {
                selectProducts(brands.returnProductList());
                return;
            }
        }
        if (CHECKOUT_COMMAND.equals(choice)) {
            checkout();
            return;
        }
        if (RETURN_COMMAND.equals(choice)) {
            handleUserInput();
            return;
        }
        invalidBrand(b);
    }

    public void selectProducts(List<Product> p) {
        printManager.printProductInstructions(p);
        String choice = input.getUserInputString();
        for (Product products : p) {
            if (products.getName().equals(choice)) {
                getProductInfo(products);
                return;
            }
        }
        if (CHECKOUT_COMMAND.equals(choice)) {
            checkout();
            return;
        }
        if (RETURN_COMMAND.equals(choice)) {
            handleUserInput();
            return;
        }
        invalidProduct(p);
    }

    public void invalidBrand(List<Brand> b) {
        System.out.println("That is not a brand. Please try again");
        selectBrands(b);
    }

    public void invalidProduct(List<Product> p) {
        System.out.println("That is not a product. Please try again");
        selectProducts(p);
    }

    public void getProductInfo(Product product) {
        System.out.println("Product name: " + product.getDisplayName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Description: " + product.getDescription());
        System.out.println(("Rating: " + product.getRating()));
        System.out.println("Add to cart? Type 'yes' to add to cart. Type 'r' to return.");
        addToCartManager(product);
    }

    public void addToCartManager(Product product) {
        String choice = input.getUserInputString();
        if ("yes".equals(choice)) {
            addToCart(product);
        }
        if (REMOVE_COMMAND.equals(choice)) {
            handleUserInput();
        }
        if (RETURN_COMMAND.equals(choice)) {
            handleUserInput();
            return;
        } else {
            System.out.println("That is not a command. Please try again.");
        }
    }

    //EFFECTS: parses user input until user quits
    public void handleUserInput() {
        printInstructions();

        while (runProgram) {
            selectCategory();
        }
    }

    public void addToCart(Product p) {
        if (cart.returnHashMap().keySet().contains(p)) {
            System.out.println("Product has already been added to cart");
            return;
        }
        cart.addProductToCart(p);
        System.out.println("Product has been added to cart. You will be redirected to the main menu.");
        handleUserInput();
    }

    private void checkout() {
        checkoutInfo();
        System.out.println("To remove a product from your cart, enter '" + REMOVE_COMMAND + "'.");
        String choice = input.getUserInputString();
        if (REMOVE_COMMAND.equals(choice)) {
            removetheProduct();
        }
        if (RETURN_COMMAND.equals(choice)) {
            handleUserInput();
            return;
        } else {
            System.out.println("That is not a command. Please try again.");
            checkout();
        }

    }

    private void checkoutInfo() {
        Double sum = 0.00;
        if (!cart.returnHashMap().isEmpty()) {
            cart.returnHashMap().forEach((product, aDouble) -> {
                System.out.println("Name: " + product.getDisplayName() + "\n");
                System.out.println("Price: " + aDouble + "\n \n");
            });
            for (Double d : cart.returnHashMap().values()) {
                sum += d;
            }
            System.out.println("Total = " + sum);
        } else {
            System.out.println("Your cart is empty. You will be redirected to the main menu");
            handleUserInput();
        }
    }

    private String replaceSymbolWithSpace(String s) {
        String str = s.replaceAll("_", " ");
        return str;
    }


    private void removetheProduct() {
        System.out.println("Enter the product that you would like to remove from the cart.");
        cart.returnHashMap().forEach((product, aDouble) -> {
            System.out.println("Name: " + product.getDisplayName() + "\n");
            System.out.println("Price: " + aDouble + "\n \n");
        });
        String choice = input.getUserInputString();
        iterateProducts(choice);
        if (RETURN_COMMAND.equals(choice)) {
            handleUserInput();
            return;
        }
        System.out.println("The product does not exist in your cart.");
        removetheProduct();
    }

    private void iterateProducts(String choice) {
        Iterator<Product> it = cart.returnHashMap().keySet().iterator();
        while (it.hasNext()) {
            Product key = it.next();
            if (replaceSymbolWithSpace(key.getName()).equals(choice)) {
                it.remove();
                System.out.println("Product has been removed. You will be redirected to the main menu.");
                handleUserInput();
            }
        }
    }
}

