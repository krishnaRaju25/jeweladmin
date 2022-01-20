package com.thbs.jewellery.jewel.model;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="product")
    private String product; //earring,gold
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
