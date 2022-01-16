package com.thbs.jewellery.jewel.model;

import javax.persistence.*;

@Entity
public class Jewels {
    @Id
    private String name;
    private int price;
    private int grams;
    private String productType;

    @ManyToOne
    @JoinColumn(name = "product")
    Category category;

    public Jewels() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jewels{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", grams=").append(grams);
        sb.append(", productType='").append(productType).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
