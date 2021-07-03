/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Gallery> getTop3Gallery() {
        String select = "select top 3 * from Gallery";
        List<Gallery> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println("getTop3Gallery: " + e.getMessage());
        }
        return list;
    }

    public Gallery getGalleryByID(int id) {
        String select = "select * from Gallery where GalleryID = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Gallery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("getGalleryByID: " + e.getMessage());
        }
        return null;
    }

    public List<String> getAllImageByID(int id) {
        String select = "SELECT i.image FROM dbo.Image i \n"
                + "JOIN dbo.Gallery g ON g.GalleryID = i.GalleryID\n"
                + "WHERE g.GalleryID = ?";
        List<String> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("getAllImageByID: " + e.getMessage());
        }
        return list;
    }
    
    public Contact getContact() {
        String query = "select * from Contact";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Contact(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("getContact: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getGalleryByID(1));
    }
}
