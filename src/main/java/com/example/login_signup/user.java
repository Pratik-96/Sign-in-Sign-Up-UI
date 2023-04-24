package com.example.login_signup;

public class user {

    private String name;
    private String email;
    private String Pass;
    private String phone;

    public user( String name, String email, String pass, String phone) {

        this.name = name;
        this.email = email;
        Pass = pass;
        this.phone = phone;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
