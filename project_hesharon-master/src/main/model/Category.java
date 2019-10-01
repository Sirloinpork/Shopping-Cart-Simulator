package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Brand> brands;

    //MODIFIES: this
    //EFFECTS: Constructs a category with a name and a list of brands
    public Category(String name) {
        brands = new ArrayList<>();
        this.name = name;
    }

    //EFFECTS: returns the name of the category
    public String getName() {
        return name;
    }


    public void addBrand(Brand b) {
        if (!brands.contains(b)) {
            brands.add(b);
            b.setCategory(this);
        }
    }

    public  List<Brand> returnBrandList() {
        return brands;
    }
}
