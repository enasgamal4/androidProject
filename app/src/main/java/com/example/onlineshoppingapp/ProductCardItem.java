package com.example.onlineshoppingapp;

public class ProductCardItem {
    private String title;
    private int image;
    private String price;


    public ProductCardItem(String title, int image, String price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public ProductCardItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
