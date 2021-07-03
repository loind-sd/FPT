/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
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

    public List<TimeTable> getAllTimeTable() {
        String query = "select a.[Date], a.slot, d.[Time], b.classname, e.teacherName, c.roomname\n"
                + "                from TimeTable a join [Class] b on a.classID = b.classID\n"
                + "                join Room c on a.roomid = c.roomid \n"
                + "                join Time d on a.slot = d.slot\n"
                + "		   join Teacher e on a.teacherid = e.teacherid "
                + "                 order by a.[Date]";
        List<TimeTable> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeTable(
                        sdf.format(rs.getDate(1, Calendar.getInstance())),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("getAllTimeTable: " + e.getMessage());
        }
        return list;
    }

    public List<TimeTable> searchTimeTable(String from, String to) {
        String query = "SET DATEFORMAT dmy \n"
                + "select a.[Date], a.slot, d.[Time], b.classname, e.teacherName, c.roomname\n"
                + "                                 from TimeTable a join [Class] b on a.classID = b.classID\n"
                + "                             join Room c on a.roomid = c.roomid \n"
                + "                            join Time d on a.slot = d.slot\n"
                + "                join Teacher e on a.teacherid = e.teacherid\n"
                + "                where a.[Date] between ? and ? "
                + "                 order by a.[Date]";
        List<TimeTable> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, from);
            ps.setString(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeTable(
                        sdf.format(rs.getDate(1, Calendar.getInstance())),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("searchTimeTable: " + e.getMessage());
        }
        return list;
    }

    public List<Time> loadAllSlot() {
        List<Time> list = new ArrayList<>();
        String query = "select * from Time";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Time(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("loadAllSlot: " + e.getMessage());
        }
        return list;
    }

    public List<Room> loadAllRoom() {
        List<Room> list = new ArrayList<>();
        String query = "select * from Room";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("loadAllRoom: " + e.getMessage());
        }
        return list;
    }

    public List<Class> loadAllClass() {
        List<Class> list = new ArrayList<>();
        String query = "select * from Class";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("loadAllClass: " + e.getMessage());
        }
        return list;
    }

    public int checkTeacherExist(String teacher) {
        String query = "Select * from Teacher where TeacherName = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, teacher);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("checkTeacherExist: " + e.getMessage());
        }
        return -1;
    }

    public boolean checkRoomExist(String date, int slot, int roomID) {
        String query = "SET DATEFORMAT dmy \n"
                + " select * from TimeTable \n"
                + "where [date] = ? and slot = ? and roomid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, slot);
            ps.setInt(3, roomID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkRoomExist: " + e.getMessage());
        }
        return false;
    }

    public boolean checkTeacherHaveClass(String date, int slot, int teacherID) {
        String query = "SET DATEFORMAT dmy \n"
                + " select * from TimeTable \n"
                + "where [date] = ? and slot = ? and teacherid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, slot);
            ps.setInt(3, teacherID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkTeacherHaveClass: " + e.getMessage());
        }
        return false;
    }

    public int addTimeTable(int classId, String date, int slot, int roomId, int teacherId) {
        String query = "SET DATEFORMAT dmy \n"
                + "insert into TimeTable values(?,?,?,?,?)";
        int n = 0;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, classId);
            ps.setString(2, date);
            ps.setInt(3, slot);
            ps.setInt(4, roomId);
            ps.setInt(5, teacherId);

            n = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("addTimeTable: " + e.getMessage());
        }
        return n;
    }

    public void test() {
        String query = "select [Date]\n"
                + "                from TimeTable\n";
        
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getDate(1));
                Date d = rs.getDate(1);
                System.out.println("| " + d);
                
            }
        } catch (Exception e) {
            System.out.println("getAllTimeTable: " + e.getMessage());
        }
       
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.test();
    }
}
