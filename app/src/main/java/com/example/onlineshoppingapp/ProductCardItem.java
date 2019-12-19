package com.example.onlineshoppingapp;

public class ProductCardItem {
    private String productTitle;
    private int image;
    private String price;
    private String Catid;

    public ProductCardItem(String productTitle, int image, String price, String catid) {
        this.productTitle = productTitle;
        this.image = image;
        this.price = price;
        Catid = catid;
    }

    public ProductCardItem() {
    }

    public ProductCardItem(String productTitle, String price, String catid) {
        this.productTitle = productTitle;
        this.price = price;
        Catid = catid;
    }

    public ProductCardItem(String productTitle, int image, String price) {
        this.productTitle = productTitle;
        this.image = image;
        this.price = price;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCatid() {
        return Catid;
    }

    public void setCatid(String catid) {
        Catid = catid;
    }
}
