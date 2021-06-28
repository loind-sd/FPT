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
public class Bil {
    private int bid;
    private String date;
    private String total;
    private String recNAme;
    private String recAddress;
    private String recPhone;
    private int cid;
    private int status;
    private String cName;

    public Bil() {
    }

    public Bil(int bid, String date, String total, String recNAme, String recAddress, String recPhone, int cid, int status) {
        this.bid = bid;
        this.date = date;
        this.total = total;
        this.recNAme = recNAme;
        this.recAddress = recAddress;
        this.recPhone = recPhone;
        this.cid = cid;
        this.status = status;
    }

    public Bil(int bid, String date, String total, String recNAme, String recAddress, String recPhone, int cid, int status, String cName) {
        this.bid = bid;
        this.date = date;
        this.total = total;
        this.recNAme = recNAme;
        this.recAddress = recAddress;
        this.recPhone = recPhone;
        this.cid = cid;
        this.status = status;
        this.cName = cName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
    
    

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRecNAme() {
        return recNAme;
    }

    public void setRecNAme(String recNAme) {
        this.recNAme = recNAme;
    }

    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
