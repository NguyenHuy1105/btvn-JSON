package com.example.baitapvenha;

public class IteamModel {
    private int id;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String company;
    private String address;

    public IteamModel(int id, String username,String name, String email, String phone, String company, String address ) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone= phone;
        this.address= address;
        this.company=company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
