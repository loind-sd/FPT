/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ADMIN
 * @Getter
 * @Setter
 */
public class Customer {
    private int cusid;
    private String name;
    private String phone;
    private String address;
    private String user;
    private String pass;

    public Customer() {
    }

    public Customer(int cusid, String name, String phone, String address) {
        this.cusid = cusid;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Customer(int cusid, String name, String phone, String address, String user, String pass) {
        this.cusid = cusid;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.user = user;
        this.pass = pass;
    }
    
    

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    
}
