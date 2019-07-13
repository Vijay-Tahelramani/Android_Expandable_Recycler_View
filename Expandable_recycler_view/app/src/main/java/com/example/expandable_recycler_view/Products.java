package com.example.expandable_recycler_view;

public class Products {

    private String productName,productType;
    private Float productRating;
    private boolean expanded;

    public Products(String productName, String productType, Float productRating) {
        this.productName = productName;
        this.productType = productType;
        this.productRating = productRating;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public Float getProductRating() {
        return productRating;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
