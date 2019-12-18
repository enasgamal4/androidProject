package com.example.onlineshoppingapp.Model;

public class Category {
    private String name;
    private String image;


    public Category() {

    }

    public Category(String title, String image) {
        this.name = title;
        this.image = image;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
