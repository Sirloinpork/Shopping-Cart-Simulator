package model;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private List<Product> products;
    private Category cat;

    private String name;
    private String displayName;

    //MODIFIES: this
    //EFFECTS: Constructs a brand setting its name to the string
    //         in the parameter
    public Brand(String name, String displayName) {
        this.products = new ArrayList<>();
        this.name = name;
        this.displayName = displayName;
    }

    //EFFECTS: returns the name of the brand
    public String getName() {
        return name;
    }

    public String getdisplayName() {
        return displayName;
    }

    public void addProduct(Product p) {
        if (!products.contains(p)) {
            products.add(p);
            p.setBrand(this);
        }
    }

    //EFFECTS: Returns the list of products
    public List<Product> returnProductList() {
        return products;
    }

    public Category returnCategory() {
        return cat;
    }

    public void setCategory(Category category) {
        if (cat != category) {
            cat = category;
            cat.addBrand(this);
        }
    }
}
