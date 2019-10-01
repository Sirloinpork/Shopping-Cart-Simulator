package model;

public class Product {

    private String name;
    private String displayName;
    private Double price;
    private String description;
    private Double rating;
    private Brand bra;

    //MODIFIES: this
    //EFFECTS: Constructs a product with a name, price, product description,
    //         and a rating
    public Product(String name, String displayName, Double price, String description, Double rating) {
        this.name = name;
        this.displayName = displayName;
        this.price = price;
        this.description = description;
        this.rating = rating;
    }

    //EFFECTS: returns the name of the product
    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    //EFFECTS: returns the price of the product
    public Double getPrice() {
        return price;
    }


    //EFFECTS: returns description of the product
    public String getDescription() {
        return description;
    }

    //EFFECTS: returns the rating of the product
    public Double getRating() {
        return rating;
    }

    public void setBrand(Brand brand) {
        if (bra != brand) {
            bra = brand;
            bra.addProduct(this);
        }
    }

    public Brand returnBrand() {
        return bra;
    }
}
