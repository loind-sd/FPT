/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ADMIN
 */
public class BillDetail {
    private int bid;
    private int pid;
    private String price;
    private int quantity;
    private String subTotal;
    private String pName;

    public BillDetail() {
    }

    public BillDetail(int bid, int pid, String price, int quantity) {
        this.bid = bid;
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    public BillDetail(int bid, int pid, String price, int quantity, String pName) {
        this.bid = bid;
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
        this.pName = pName;
    }

    public BillDetail(int bid, int pid, String price, int quantity, String subTotal, String pName) {
        this.bid = bid;
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.pName = pName;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }
    
    

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    
    
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
