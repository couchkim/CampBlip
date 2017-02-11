package com.theironyard.datamodels.Instructions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegoWebImport {
    private Product products;

    public LegoWebImport() {
    }

    public LegoWebImport(Product products) {
        this.products = products;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "LegoWebImport{" +
                "products=" + products +
                '}';
    }
}
