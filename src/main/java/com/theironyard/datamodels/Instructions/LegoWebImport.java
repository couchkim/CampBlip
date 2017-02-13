package com.theironyard.datamodels.Instructions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegoWebImport {
    private int count;
    private List<Product> products;

    public LegoWebImport() {
    }

    public LegoWebImport(int count, List<Product> products) {
        this.count = count;
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "LegoWebImport{" +
                "count=" + count +
                ", products=" + products +
                '}';
    }
}