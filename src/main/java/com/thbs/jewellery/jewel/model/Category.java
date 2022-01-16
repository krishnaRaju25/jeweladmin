package com.thbs.jewellery.jewel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private String product;

    public Category() {
    }

    public Category(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" +
                "product='" + product + '\'' +
                '}';
    }
}
