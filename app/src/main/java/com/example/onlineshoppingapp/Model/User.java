package com.example.onlineshoppingapp.Model;

public class User {
    public String FullName;
//    public String UserName;
    public String password;
//    public String Gender;
//    public String Job;
    public String email;
//    public String Birthdate;
    public String phone;


    public User() {

    }

    public User(String fullName, String phone , String password, String email)
    {
        this.FullName = fullName;
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

//    public User(String fullname, String username)
}
