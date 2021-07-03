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
import java.util.Calendar;
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

    public Account login(String user, String pass) {
        try {
            String query = "select * from Account where username = ? and password = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("login: " + e.getMessage());
        }
        return null;
    }

    public List<Request> getCountRequestDepartmentToday() {
        List<Request> list = new ArrayList<>();
        try {
            String today = sdf.format(Calendar.getInstance().getTime());

            String query = "SET DATEFORMAT dmy\n"
                    + "SELECT a.requestTo, b.[name], COUNT(a.id) \n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "WHERE a.dateCreated = ?\n"
                    + "GROUP BY a.requestTo, b.[name]";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, today);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Request(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            System.out.println("getCountRequestDepartmentToday: " + e.getMessage());
        }
        return list;
    }

    public List<Request> getCountRequestDepartmentPast() {
        List<Request> list = new ArrayList<>();
        try {
            String today = sdf.format(Calendar.getInstance().getTime());

            String query = "SET DATEFORMAT dmy\n"
                    + "SELECT a.requestTo, b.[name], COUNT(a.id) \n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "WHERE a.dateCreated <> ?\n"
                    + "GROUP BY a.requestTo, b.[name]";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, today);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Request(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            System.out.println("getCountRequestDepartmentPast: " + e.getMessage());
        }
        return list;
    }

    public List<Request> getViewRequestDepartmentPast(int to) {
        List<Request> list = new ArrayList<>();
        try {
            String today = sdf.format(Calendar.getInstance().getTime());
            String query = "SET DATEFORMAT dmy\n"
                    + "SELECT *\n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "WHERE a.dateCreated <> ? AND a.requestTo = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, today);
            ps.setInt(2, to);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Request(rs.getInt(1), rs.getString(13), sdf.format(rs.getDate(4, Calendar.getInstance())), rs.getString(8), rs.getString(5), rs.getInt(7)));
            }

        } catch (Exception e) {
            System.out.println("getViewRequestDepartmentPast: " + e.getMessage());
        }
        return list;
    }

    public List<Request> getViewRequestDepartmentToday(int to) {
        List<Request> list = new ArrayList<>();
        try {
            String today = sdf.format(Calendar.getInstance().getTime());

            String query = "SET DATEFORMAT dmy\n"
                    + "SELECT *\n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "WHERE a.dateCreated = ? AND a.requestTo = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, today);
            ps.setInt(2, to);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Request(rs.getInt(1), rs.getString(13), sdf.format(rs.getDate(4, Calendar.getInstance())), rs.getString(8), rs.getString(5), rs.getInt(7)));
            }

        } catch (Exception e) {
            System.out.println("getViewRequestDepartmentToday: " + e.getMessage());
        }
        return list;
    }

    public List<Department> getAllDepartment() {
        List<Department> list = new ArrayList<>();
        try {

            String query = "select * from Department";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Department(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("getAllDepartment:" + e.getMessage());
        }
        return list;
    }

    public Request getRequestByID(String id) {
        try {
            String query = "SELECT *\n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "JOIN dbo.Student c ON c.id = a.studentID\n"
                    + "WHERE a.id = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Request(rs.getInt(1),
                        rs.getString(13),
                        rs.getString(3),
                        rs.getString(15),
                        sdf.format(rs.getDate(4, Calendar.getInstance())),
                        sdf.format(Calendar.getInstance().getTime()),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10));
            }

        } catch (Exception e) {
            System.out.println("getRequestByID: " + e.getMessage());
        }
        return null;
    }
    
    public Request getRequestByIDAfterSolve(String id) {
        try {
            String query = "SELECT *\n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "JOIN dbo.Student c ON c.id = a.studentID\n"
                    + "WHERE a.id = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Request(rs.getInt(1),
                        rs.getString(13),
                        rs.getString(3),
                        rs.getString(15),
                        sdf.format(rs.getDate(4, Calendar.getInstance())),
                        sdf.format(Calendar.getInstance().getTime()),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(10),
                        rs.getString(11));
            }

        } catch (Exception e) {
            System.out.println("getRequestByID: " + e.getMessage());
        }
        return null;
    }

    public List<Request> getRequestByDepartment(String id) {
        List<Request> list = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "WHERE a.requestTo = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Request(rs.getInt(1), rs.getString(13), sdf.format(rs.getDate(4, Calendar.getInstance())),
                        rs.getString(8), rs.getString(5), rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("getRequestByDepartment: " + e.getMessage());
        }
        return list;
    }

    public List<Request> getRequestByTitle(String title) {
        List<Request> list = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM dbo.Request a JOIN dbo.Department b ON b.id = a.requestTo\n"
                    + "WHERE a.title LIKE ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Request(
                        rs.getInt(1),
                        rs.getString(13),
                        sdf.format(rs.getDate(4, Calendar.getInstance())),
                        rs.getString(8),
                        rs.getString(5),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("getRequestByTitle: " + e.getMessage());
        }
        return list;
    }

    public void solveRequest(String id, int status, String solveBy, String solution) {
        String query = "UPDATE dbo.Request\n"
                + "SET status = ?, clodeDate = GETDATE(), solvedBy = ?, solution = ?\n"
                + "WHERE id = ?";
        
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, status);
            ps.setString(2, solveBy);
            ps.setString(3, solution);
            ps.setString(4, id);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("solveRequest: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Request> l = dao.getCountRequestDepartmentPast();
        Request r = dao.getRequestByIDAfterSolve("1");
        System.out.println(r.getAttach());
        
    }

}
