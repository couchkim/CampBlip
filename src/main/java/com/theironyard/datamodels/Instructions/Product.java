package com.theironyard.datamodels.Instructions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String productId;
    private String productImage;
    private String productName;
    private String themeName;
    private int launchYear;
    private List<Build> buildingInstructions;

    public Product() {
    }

    public Product(String productId, String productImage, String productName, String themeName, int launchYear, List<Build> buildingInstructions) {
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.themeName = themeName;
        this.launchYear = launchYear;
        this.buildingInstructions = buildingInstructions;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public List<Build> getBuildingInstructions() {
        return buildingInstructions;
    }

    public void setBuildingInstructions(List<Build> buildingInstructions) {
        this.buildingInstructions = buildingInstructions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productName='" + productName + '\'' +
                ", themeName='" + themeName + '\'' +
                ", launchYear=" + launchYear +
                ", buildingInstructions=" + buildingInstructions +
                '}';
    }
}
