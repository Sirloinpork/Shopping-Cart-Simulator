package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Brand;
import model.Cart;
import model.Category;
import model.Product;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import static ui.LoadingManager.*;

public class Store extends Application {

    Label welcome;
    Label instructions;
    Label brandInstructions;
    Label brandNames;
    Label productInstructions;
    Label productNames;
    Label productInfo;
    Label cartInfo;
    Label total;
    Label removeCartInfo;

    TextField nameInput;
    TextField brandnameinput;
    TextField productnameinput;
    TextField removeinput;

    Button button;
    Button brandButton;
    Button productButton;
    Button returnButton = new Button("Return");
    Button addToCartButton = new Button("Add to cart");
    Button checkoutButton = new Button("Checkout");
    Button removeButton = new Button("Remove a product");
    Button removeinputbutton = new Button("Enter");

    Scene scene1;
    Scene scene2;
    Scene scene3;
    Scene scene4;
    Scene scene5;
    Scene scene6;

    VBox layout1;
    VBox layout2;
    VBox layout3;
    VBox layout4;
    VBox layout5;
    VBox layout6;

    Cart cart = new Cart();
    Input input = new Input();

    static InfoManager info;

    public static void main(String[] args) {
        musicBackground();
        loadClothingProducts();
        loadTechProducts();
        loadFurnitureProducts();
        loadMakeUpProducts();
        loadCategories();
        loadBrands();
        launch(args);
        welcome();
        info = new InfoManager();
        info.handleUserInput();
    }

    public static void welcome() {
        System.out.println("Welcome to TheSimpleMall. Choose a category for the product you are searching for.");
    }

    @Override
    public void start(Stage primaryStage) {
        createScene1(primaryStage);
        primaryStage.setScene(scene1);
        primaryStage.show();
        iconCreator(primaryStage);
        checkoutButton.setOnAction(e -> manageCheckout(primaryStage));
        returnButton.setOnAction(e -> start(primaryStage));
        button.setOnAction(e -> selectingCategory(primaryStage));
    }

    public void createScene1(Stage primaryStage) {
        welcome = new Label("Welcome to TheSimpleMall. Choose a category for the product you are searching for.");
        instructions = new Label("Enter 'clothing' for Clothing, 'tech' for Technology, 'furniture' for Furniture,"
                + " and 'make-up'" + "\n" + "for Make-up.");
        primaryStage.setTitle("Store Application");
        nameInput = new TextField();
        button = new Button("Enter");

        layout1 = new VBox(10);
        layout1.setPadding(new Insets(20, 20, 20, 20));
        layout1.getChildren().addAll(welcome, instructions, nameInput, button, checkoutButton);
        scene1 = new Scene(layout1, 650, 400);
        backgroundCreator(layout1);
    }

    public static void musicBackground() {
        try {
            Media musicFile = new Media(Paths.get("MaplestoryFreeMarket.wav").toUri().toString());
            MediaPlayer mediaplayer = new MediaPlayer(musicFile);
            mediaplayer.setAutoPlay(true);
            mediaplayer.setVolume(0.5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void iconCreator(Stage primaryStage) {
        try {
            FileInputStream imageInput = new FileInputStream("images/icons/shopping-cart.png");
            Image applicationIcon = new Image(imageInput);
            primaryStage.getIcons().add(applicationIcon);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void backgroundCreator(VBox vbox) {
        try {
            FileInputStream fileInputStream = new FileInputStream("images/ShoppingCartBackground.jpg");
            Image image = new Image(fileInputStream);
            BackgroundImage bi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background background = new Background(bi);
            vbox.setBackground(background);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectingCategory(Stage primaryStage) {
        brandButton = new Button("Enter");
        for (Category c : categoryList) {
            if (c.getName().equals(input.makePrettyString(nameInput.getText()))) {
                createScene2(primaryStage, c);
                brandButton.setOnAction(e -> selectingBrands(c.returnBrandList(), primaryStage, c));
                return;
            }
        }
        System.out.println("That is not a Category. Please try again.");
    }

    public void selectingBrands(List<Brand> brands, Stage primaryStage, Category c) {
        productButton = new Button("Enter");
        for (Brand b : brands) {
            if (b.getName().equals(input.makePrettyString(brandnameinput.getText()))) {
                createScene3(primaryStage, b);
                productButton.setOnAction(e -> selectingProducts(b.returnProductList(), primaryStage, b));
                return;
            }
        }
        System.out.println("That is not a brand. Please try again.");
    }

    public void createScene2(Stage primaryStage, Category c) {
        brandnameinput = new TextField();
        layout2 = new VBox(10);
        layout2.setPadding(new Insets(20, 20, 20, 20));
        brandInstructions = new Label("Select a brand by entering the brand name." + "\n");
        brandNames = new Label(printBrands(c));
        layout2.getChildren().addAll(brandInstructions, brandNames, brandnameinput, brandButton, checkoutButton,
                returnButton);


        scene2 = new Scene(layout2, 650, 400);
        primaryStage.setScene(scene2);
        backgroundCreator(layout2);
    }

    public String printBrands(Category c) {
        String acc = new String("");
        for (Brand b : c.returnBrandList()) {
            acc += "-" + b.getdisplayName() + "\n";
        }
        return acc;
    }

    public void selectingProducts(List<Product> products, Stage primaryStage, Brand b) {
        for (Product p : products) {
            if (p.getName().equals(input.makePrettyString(productnameinput.getText()))) {
                displayProductInfo(p, primaryStage);
                return;
            }
        }
        System.out.println("That is not a product. Please try again.");
    }

    public void createScene3(Stage primaryStage, Brand b) {
        productnameinput = new TextField();
        layout3 = new VBox(10);
        layout3.setPadding(new Insets(20, 20, 20, 20));
        productInstructions = new Label("Select a product by entering the brand name." + "\n");
        productNames = new Label(printProducts(b));
        layout3.getChildren().addAll(productInstructions, productNames, productnameinput, productButton, checkoutButton,
                returnButton);

        scene3 = new Scene(layout3, 650, 400);
        primaryStage.setScene(scene3);
        backgroundCreator(layout3);
    }

    public String printProducts(Brand b) {
        String acc = new String("");
        for (Product p : b.returnProductList()) {
            acc += "-" + p.getDisplayName() + "\n";
        }
        return acc;
    }

    public String getInfo(Product p) {
        String acc = new String("Product name: " + p.getDisplayName() + "\n"
                + "Price: " + p.getPrice()) + "\n"
                + "Description: " + p.getDescription() + "\n"
                + "Rating: " + p.getRating() + "\n";
        return acc;
    }

    public void displayProductInfo(Product p, Stage primaryStage) {
        layout4 = new VBox(10);
        layout4.setPadding(new Insets(20, 20, 20, 20));
        productInfo = new Label(getInfo(p));
        layout4.getChildren().addAll(productInfo, addToCartButton, checkoutButton, returnButton);

        scene4 = new Scene(layout4, 650, 400);
        primaryStage.setScene(scene4);
        addToCartButton.setOnAction(e -> manageAddToCart(primaryStage, p));
        backgroundCreator(layout4);
    }

    public void manageAddToCart(Stage primaryStage, Product p) {
        if (cart.returnHashMap().keySet().contains(p)) {
            System.out.println("Product has already been added to cart.");
            return;
        } else {
            cart.addProductToCart(p);
            System.out.println("Product has been added to cart.");
        }
    }

    public void manageCheckout(Stage primaryStage) {
        checkoutInfo(primaryStage);

    }

    public void checkoutInfo(Stage primaryStage) {
        Double sum = 0.00;
        if (!cart.returnHashMap().isEmpty()) {
            cart.returnHashMap().forEach((product, aDouble) -> {
                cartInfo = new Label("Name: " + product.getDisplayName() + "\n" + "Price: " + aDouble + "\n \n");
            });
            for (Double d : cart.returnHashMap().values()) {
                sum += d;
            }
            total = new Label("Total = " + sum);
            createCheckOutScene(primaryStage, cartInfo, total);
        } else {
            System.out.println("Your cart is empty.");
        }
    }

    public void createCheckOutScene(Stage primaryStage, Label cartInfo, Label total) {
        layout5 = new VBox(10);
        layout5.setPadding(new Insets(20, 20, 20, 20));
        layout5.getChildren().addAll(cartInfo, total, removeButton, returnButton);

        scene5 = new Scene(layout5, 650, 400);
        primaryStage.setScene(scene5);
        removeButton.setOnAction(e -> manageRemove(primaryStage));
        backgroundCreator(layout5);
    }

    public void manageRemove(Stage primaryStage) {
        createRemoveScene(primaryStage);
        removeinputbutton.setOnAction(e -> iterateRemove());
    }

    public void createRemoveScene(Stage primaryStage) {
        removeinput = new TextField();
        Label removeInstructions = new Label("Enter the product that you would like to remove from the cart.");
        cart.returnHashMap().forEach((product, aDouble) -> {
            removeCartInfo = new Label("Name: " + product.getDisplayName() + "\n" + "Price: " + aDouble + "\n \n");
        });
        layout6 = new VBox(10);
        layout6.setPadding(new Insets(20, 20, 20, 20));
        layout6.getChildren().addAll(removeInstructions, removeCartInfo, removeinput, removeinputbutton, returnButton);

        scene6 = new Scene(layout6, 650, 400);
        primaryStage.setScene(scene6);
        backgroundCreator(layout6);
    }

    public void iterateRemove() {
        Iterator<Product> it = cart.returnHashMap().keySet().iterator();
        while (it.hasNext()) {
            Product key = it.next();
            if (replaceSymbolWithSpace(key.getName()).equals(input.makePrettyString(removeinput.getText()))) {
                it.remove();
                System.out.println("Product has been removed. ");
            } else {
                System.out.println("The product does not exist in your cart.");
            }
        }
    }

    public String replaceSymbolWithSpace(String s) {
        String str = s.replaceAll("_", " ");
        return str;
    }
}
