/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    NumberFormat df = new DecimalFormat("#,###");

    public List<Category> getAllCAtegory() {
        List<Category> list = new ArrayList<>();
        String select = "Select * from Category";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Fail getAllCategory: " + e.getMessage());
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String select = "Select * from Product";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        df.format(rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("getAllProduct:  " + e.getMessage());
        }
        return list;
    }

    public List<Product> getAllProductUntil6(int index, int pageSize) {
        List<Product> list = new ArrayList<>();
        String select = "with x as (select ROW_NUMBER() over (order by pid) as r, * "
                + "from Product)\n"
                + "select * from x where r between ? and ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);

            ps.setInt(1, index * pageSize - (pageSize - 1));
            ps.setInt(2, index * pageSize);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        df.format(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("getAllProduct:  " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductByBrand(String s) {
        List<Product> list = new ArrayList<>();
        String select = "SELECT * \n"
                + "FROM dbo.Product a JOIN dbo.Category b ON b.cId = a.cId\n"
                + " WHERE \n"
                + "a.cId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, s);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        df.format(rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("getAllProduct:  " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductByBrandUntil6(String s, int index, int pageSize) {
        List<Product> list = new ArrayList<>();
        String select
                = "with x as (select ROW_NUMBER() over (order by a.pid) as r, * "
                + "FROM dbo.Product a"
                + " WHERE a.cId = ?)\n"
                + "select * from x where r between ? and ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, s);
            ps.setInt(2, index * pageSize - (pageSize - 1));
            ps.setInt(3, index * pageSize);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        df.format(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("getAllProductBYBrandUptil6:  " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductByName(String s) {
        List<Product> list = new ArrayList<>();
        String select = "SELECT * \n"
                + "FROM dbo.Product\n"
                + " WHERE \n"
                + "name like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, "%" + s + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        df.format(rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("getAllProductByName:  " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductByNameUntil6(String s, int index, int pageSize) {
        List<Product> list = new ArrayList<>();
        String select
                = "with x as (select ROW_NUMBER() over (order by a.pid) as r, * "
                + "FROM dbo.Product a"
                + " WHERE a.name like ?)\n"
                + "select * from x where r between ? and ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, "%" + s + "%");
            ps.setInt(2, index * pageSize - (pageSize - 1));
            ps.setInt(3, index * pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        df.format(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("getAllProductByName:  " + e.getMessage());
        }
        return list;
    }

    public Product getProductById(int s) {
        Product p = null;
        String select = "SELECT * \n"
                + "FROM dbo.Product\n"
                + " WHERE \n"
                + "pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setInt(1, s);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        df.format(rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("getAllProductByName:  " + e.getMessage());
        }
        return p;
    }

    public Product getProductMaxPrice() {
        Product list = null;
        String select = "select * from Product\n"
                + "where price = \n"
                + "(select max(price) from Product)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        df.format(rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("getAllProductMax:  " + e.getMessage());
        }
        return list;
    }

    public Product getProduct(String id) {
        String select = "select * from Product where pid = '" + id + "'";
        Product p = null;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        df.format(rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }

        return p;
    }

    public Customer getCustomer(String user, String pass) {
        Customer c = null;
        String select = "Select * from Customer where username = '" + user + "' and password = '" + pass + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), user, pass);
            }
        } catch (Exception e) {
            System.out.println("getCustomer: " + e.getMessage());
        }

        return c;
    }
    
    public Customer getCustomerByUser(String user) {
        Customer c = null;
        String select = "Select * from Customer where username = '" + user + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), user, "");
            }
        } catch (Exception e) {
            System.out.println("getCustomer: " + e.getMessage());
        }

        return c;
    }

    public Admin getAdmin(String user, String pass) {
        Admin a = null;
        String select = "select * from admin where username = ? and password = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                a = new Admin(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("getAdmin: " + e.getMessage());
        }
        return a;
    }

    public void addCustomer(Customer c) {
        String inert = "insert into Customer(fullName,address,phone,username,password) values(?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(inert);
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getUser());
            ps.setString(5, c.getPass());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addCus: " + e.getMessage());
        }
    }

    public void addProduct(Product p) {
        String insert = "insert into Product(name, quantity, price, image, description, cid) values (?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQuantity());
            ps.setString(3, p.getPrice());
            ps.setString(4, p.getImage());
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getCid());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addProduct: " + e.getMessage());
        }
    }

    public void updateProduct(Product p) {
        String insert = "update Product set name = ?, quantity = ?, price = ?, "
                + "image = ?, description = ?, cid = ? where pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQuantity());
            ps.setString(3, p.getPrice());
            ps.setString(4, p.getImage());
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getCid());
            ps.setInt(7, p.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateProduct: " + e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        String delete = "delete from Product where pid = '" + id + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(delete);
            ps.execute();
        } catch (Exception e) {
            System.out.println("deleteProduct: " + e.getMessage());
        }
    }

    public int getQuantity(String id) {
        String select = "select quantity from Product where pid = '" + id + "'";
        int q = 0;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            if (rs.next()) {
                q = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getQuantity:" + e.getMessage());
        }
        return q;
    }

    public void addBill(Bil b) {
        String insert = "insert into Bill(date,total,recName,recPhone,recAddress,cid,status) values(?,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, b.getDate());
            ps.setString(2, b.getTotal());
            ps.setString(3, b.getRecNAme());
            ps.setString(4, b.getRecPhone());
            ps.setString(5, b.getRecAddress());
            ps.setInt(6, b.getCid());
            ps.setInt(7, 0);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addBill: " + e.getMessage());
        }
    }

    public void addBillDetail(BillDetail b) {
        String insert = "insert into BillDetail values(?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(insert);
            ps.setInt(1, b.getBid());
            ps.setInt(2, b.getPid());
            ps.setInt(4, b.getQuantity());
            ps.setString(3, b.getPrice());
            ps.setInt(5, b.getQuantity() * Integer.parseInt(b.getPrice()));

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addBillDetail: " + e.getMessage());
        }

    }

    public List<BillDetail> getBillDetailByBid(String id) {
        String select = "select * from BillDetail a join Product b on a.pid = b.pid where bid = '" + id + "'";
        List<BillDetail> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BillDetail(Integer.parseInt(id), rs.getInt(2), df.format(rs.getInt(3)), rs.getInt(4), df.format(rs.getInt(5)), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("getBillDetailByBid" + e.getMessage());
        }
        return list;
    }

    public int getFinalBillId() {
        String select = "select top 1 bid from Bill order by bid desc";
        int bid = 0;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            rs.next();
            bid = rs.getInt(1);
        } catch (Exception e) {
            System.out.println("getFinal: " + e.getMessage());
        }
        return bid;
    }

    public void updateProductAfterBill(Product p, int quantity) {
        String insert = "update Product set quantity = ? where pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(2, String.valueOf(p.getId()));
            ps.setInt(1, p.getQuantity() - quantity);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateProduct: " + e.getMessage());
        }
    }

    public void updateProductAfterClickWait(Product p, int quantity) {
        String insert = "update Product set quantity = ? where pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(2, String.valueOf(p.getId()));
            ps.setInt(1, p.getQuantity() + quantity);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateProduct: " + e.getMessage());
        }
    }

    public List<Bil> getAllBill() {
        List<Bil> list = new ArrayList<>();
        String select = "select * from Bill a join Customer b on a.cid = b.cusid";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bil(
                        rs.getInt(1),
                        rs.getString(2),
                        df.format(rs.getInt(3)),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(5),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            System.out.println("getAllBill: " + e.getMessage());
        }
        return list;
    }
    
    public List<Bil> getBillByStatus(int status) {
        List<Bil> list = new ArrayList<>();
        String select = "select * from Bill a join Customer b on a.cid = b.cusid where a.status = '"+status+"'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bil(
                        rs.getInt(1),
                        rs.getString(2),
                        df.format(rs.getInt(3)),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(5),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            System.out.println("getAllBill: " + e.getMessage());
        }
        return list;
    }

    public void checkDone(String id) {
        String update = "Update Bill set status = 2 where bid = '" + id + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(update);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("checkDone: " + e.getMessage());
        }
    }

    public void checkProcess(String id) {
        String update = "Update Bill set status = 1 where bid = '" + id + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(update);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("checkProcess: " + e.getMessage());
        }
    }

    public void checkWait(String id) {
        String update = "Update Bill set status = 0 where bid = '" + id + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(update);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("checkWait: " + e.getMessage());
        }
    }

    public List<Customer> getAllCus() {
        String select = "Select * from Customer";
        List<Customer> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("getAllCus: " + e.getMessage());
        }
        return list;
    }

    public void deletecus(String id) {
        String delete = "Delete from Customer where cusid = '" + id + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(delete);
            ps.execute();
        } catch (Exception e) {
            System.out.println("deleteCus: " + e.getMessage());
        }
    }

    public Customer getCusById(String id) {
        Customer c = null;
        String select = "Select * from Customer where cusid = '" + id + "'";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("getCusById: " + e.getMessage());
        }
        return c;
    }

    public void updateCusNoChangePass(Customer c) {
        String up = "update Customer set fullName = ?, address = ?, phone =? where cusid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(up);
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getPhone());
            ps.setInt(4, c.getCusid());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateCusNoChangePass: " + e.getMessage());
        }
    }

    public void updateCusWithChangePass(Customer c) {
        String up = "update Customer set fullName = ?, address = ?, phone =?, password = ? where cusid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(up);
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getPass());
            ps.setInt(5, c.getCusid());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateCuswithChangePass: " + e.getMessage());
        }
    }

    public int getNumberProduct() {
        String select = "select count(*) from Product";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumBerPro: " + e.getMessage());
        }
        return 0;
    }

    public int getNumberProductByBrand(String s) {
        String select = "select count(*) FROM dbo.Product a JOIN dbo.Category b ON b.cId = a.cId\n"
                + " WHERE \n"
                + "a.cId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, s);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumBerPro: " + e.getMessage());
        }
        return 0;
    }

    public int getNumberProductByName(String s) {
        String select = "select count(*) FROM dbo.Product\n"
                + " WHERE \n"
                + "name like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            ps.setString(1, "%" + s + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumBerPro: " + e.getMessage());
        }
        return 0;
    }

    public List<BillDetail> getAllPidByBid(int id) {
        String select = "Select * from BillDetail where bid = '" + id + "'";
        List<BillDetail> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BillDetail(id, rs.getInt(2), df.format(rs.getInt(3)), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("getAllPidByBid: " + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<BillDetail> p = dao.getBillDetailByBid("9");
//        System.out.println(dao.getFinalBillId());
        for (BillDetail o : p) {
            System.out.println(o.toString());
        }

        System.out.println(dao.getNumberProductByName("ip"));
    }
}
