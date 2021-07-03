/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.DBContext;

/**
 *
 * @author ADMIN
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Digital getNewDigital() {
        String query = "select top 1 * from Digital order by [DateCreate] desc";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Digital(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        sdf.format(rs.getDate(6)),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("getNewDigital: " + e.getMessage());
        }
        return null;
    }

    public List<Digital> getTop5Digital() {
        String query = "select top 5 * from Digital order by [DateCreate] desc";
        List<Digital> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Digital(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        sdf.format(rs.getDate(6)),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("gettop5Digital: " + e.getMessage());
        }
        return list;
    }
    
    public Digital getMostRecentNews() {
        String query = "select top 1 * from Digital order by [DateCreate] desc";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Digital(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        sdf.format(rs.getDate(6)),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("getMostRecentNews: " + e.getMessage());
        }
        return null;
    }

    public Digital getDigitalById(String id) {
        String query = "select * from Digital where id = '" + id + "'";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Digital(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        sdf.format(rs.getDate(6)),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("getDigitalByID: " + e.getMessage());
        }
        return null;
    }

    public List<Digital> searchDigital(String s, int index, int pageSize) {
        String query = "with x as (\n"
                + "select ROW_NUMBER() OVER(order by id) as r, * from Digital "
                + "where tittle like ?)\n"
                + "select * from x where r between ? and ?";
        List<Digital> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + s + "%");
            ps.setInt(2, pageSize * (index - 1) + 1);
            ps.setInt(3, pageSize * index);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Digital(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        sdf.format(rs.getDate(7)),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println("searchDigital: " + e.getMessage());
        }
        return list;
    }

    public int getNumberDigitalByTitle(String s) {
        String query = "select count(*) FROM dbo.Digital\n"
                + " WHERE \n"
                + "tittle like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + s + "%");
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumberDigitalByTitle: " + e.getMessage());
        }
        return 0;
    }

    public int getAllDi() {
        String query = "select count(*) FROM dbo.Digital";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumberDigitalByTitle: " + e.getMessage());
        }
        return 0;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getNumberDigitalByTitle("a"));
    }
}
