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
public class Digital {
    private int id;
    private String title;
    private String des;
    private String image;
    private String author;
    private String date;
    private String shortDes;

    public Digital() {
    }

    public Digital(int id, String title, String des, String image, String author, String date, String shortDes) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.image = image;
        this.author = author;
        this.date = date;
        this.shortDes = shortDes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + des + " " + image + " " + author + " " + date + " " + shortDes;
    }
    
    
}
