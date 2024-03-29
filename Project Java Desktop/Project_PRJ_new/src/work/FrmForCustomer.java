/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work;

import JDBC.DBContext;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FrmForCustomer extends javax.swing.JFrame {

    Color[] c = {Color.RED, Color.BLUE, Color.ORANGE, Color.CYAN, Color.PINK, Color.BLACK, Color.MAGENTA};
    Thread t1 = new Thread(new ThreadColor());

    public class ThreadColor implements Runnable {

        @Override
        public void run() {
            Color x = jLabel1.getForeground();
            int index = 0;

            while (true) {
                if (index == c.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
                try {
                    Thread.sleep(800);
                    jLabel1.setForeground(c[index]);
                } catch (InterruptedException e) {
                    System.out.println("Loi sleep: " + e.getMessage());
                }

            }

        }
    }

    ProductDetail p;
    int count = 0;
    Connection cnn;// ket noi toi db
    Statement stm;  // thuc thi cac cau lenh sql
    ResultSet rs;
    DefaultTableModel dtm;

    /**
     * Creates new form FrmForCustomer
     */
    public FrmForCustomer() {
        initComponents();
        String language = null, country = null;
        if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
            language = "en";
            country = "US";
        } else {
            language = "vn";
            country = "VN";
        }

        connect();
        loadProduct(language, country);
        loadnametbOrder(language, country);
        t1.start();

    }

    public FrmForCustomer(String language, String country) {
        initComponents();

        Locale lc = new Locale(language, country);
        ResourceBundle rB = ResourceBundle.getBundle("MessageBundle", lc);

        jLabel1.setText(rB.getString("WELCOME"));
        btnAdd.setText(rB.getString("AddtoOrder"));
        jLabel3.setText(rB.getString("ProductName"));
        jLabel4.setText(rB.getString("Amount"));
        jLabel2.setText(rB.getString("yourOrder"));
        btnPay.setText(rB.getString("Pay"));
        btnExit.setText(rB.getString("Exit"));

        if (language.equals("en")) {
            jLabel5.setText("Total Money");
            btnUpdate.setText("Update Amount");
            btnDelete.setText("Delete Product");
        }
        if (language.equals("vn")) {
            jLabel5.setText("Tổng Tiền");
            btnUpdate.setText("Cập Nhật Số Lượng");
            btnDelete.setText("Xóa Sản Phẩm");
        }

        connect();
        loadProduct(language, country);
        loadnametbOrder(language, country);
        t1.start();
    }

    public void loadnametbOrder(String language, String country) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbOrder.getModel();
        Locale lc = new Locale(language, country);
        ResourceBundle rB = ResourceBundle.getBundle("MessageBundle", lc);
        String a = rB.getString("ProductName"),
                b = rB.getString("Price"),
                c = rB.getString("Amount"),
                d = rB.getString("IntoMoney");

        dtm.setColumnIdentifiers(new Object[]{
            a, b, c, d
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbOrder = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME TO APPLE STORE");

        tbProduct.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProduct.setRowHeight(20);
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Your Order");

        tbOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Amount", "Into Money"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbOrder);

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnExit.setText("Exit Store");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnAdd.setText("Add to Order");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name:");

        jLabel4.setText("Amount:");

        txtName.setEditable(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update Amount");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Product");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Money: ");

        txtTotal.setEditable(false);
        txtTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay)
                    .addComponent(btnExit))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String s1 = "", s2 = "", s3 = "", s4 = "";

        if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
            s1 = "ProductName has exist!";
            s3 = "Enter a positive number!";
            s4 = "Enter Product Name";
        } else {
            s1 = "Tên Sản Phẩm Đã Tồn Tại!";
            s3 = "Nhập 1 số dương";
            s4 = "Nhập Tên Sản Phầm";
        }

        dtm = (DefaultTableModel) tbOrder.getModel();
        if (checkDuplicate(txtName.getText())) {
            JOptionPane.showMessageDialog(null, s1);
            return;
        }
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, s4);
            return;
        }
        try {
            int amount = Integer.parseInt(txtAmount.getText().trim());
            if (amount < 0) {
                throw new NumberFormatException();
            }
            int index = tbProduct.getSelectedRow();
            String name = tbProduct.getValueAt(index, 0).toString();
            String select = "Select Amount from tblProduct where ProductName = '" + name + "'";
            try {
                rs = stm.executeQuery(select);
                rs.next();
                int amountProduct = rs.getInt(1);
                if (amount > amountProduct) {
                    if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
                        s2 = "Our Store has only " + amountProduct + " units left";
                    } else {
                        s2 = "Cửa Hàng Chúng Tôi Chỉ Còn " + amountProduct + " chiếc";
                    }
                    JOptionPane.showMessageDialog(null, s2);
                    return;
                }
            } catch (SQLException ex) {
                System.out.println("Loi :" + ex.getMessage());
            }

//            int index = tbProduct.getSelectedRow();
            int price = Integer.parseInt(tbProduct.getValueAt(index, 1).toString());
            int intoMoney = price * amount;
            dtm.addRow(new Object[]{
                txtName.getText(), price, String.valueOf(amount), intoMoney
            });
            txtName.setText("");
            txtAmount.setText("");
            totalMoney();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, s3);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private boolean checkDuplicate(String text) {
        dtm = (DefaultTableModel) tbOrder.getModel();
        try {
            int size = dtm.getRowCount();
            for (int i = 0; i < size; i++) {
                String name = (String) tbOrder.getValueAt(i, 0);
                if (text.equals(name)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("loi:" + e.getMessage());
        }
        return false;
    }
    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        count++;
        if (count != 1) {
            p.setVisible(false);
        }
        txtName.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString());
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        String name = tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString();
        String price = tbProduct.getValueAt(tbProduct.getSelectedRow(), 1).toString();
        String Amount = null, url = null;
        String language = null, country = null;
        if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
            language = "en";
            country = "US";
        } else {
            language = "vn";
            country = "VN";
        }
        try {
            String strSelect = "select Amount,ImgUrl from tblProduct where ProductName='" + name + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                Amount = String.valueOf(rs.getInt(1));
                url = rs.getString(2);
                p = new ProductDetail(url, name, price, Amount, language, country);
                p.setVisible(true);

            }

        } catch (Exception e) {
            System.out.println("Fail load Product " + e.getMessage());
        }
//        System.out.println(url+ name+ price+ Amount);
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String s1 = "";
        String s = "";
        if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
            s = "Choice a Product";
        } else {
            s = "Chọn 1 Sản Phẩm";
        }
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, s);
            return;
        }
        try {
            int amount = Integer.parseInt(txtAmount.getText().trim());
            if (amount < 0) {
                throw new NumberFormatException();
            }
            int index = tbProduct.getSelectedRow();
            String name = tbProduct.getValueAt(index, 0).toString();
            String select = "Select Amount from tblProduct where ProductName = '" + name + "'";
            try {
                rs = stm.executeQuery(select);
                rs.next();
                int amountProduct = rs.getInt(1);
                if (amount > amountProduct) {
                    if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
                        s1 = "Our Store has only " + amountProduct + " units left";
                    } else {
                        s1 = "Cửa Hàng Chúng Tôi Chỉ Còn " + amountProduct + " chiếc";
                    }
                    JOptionPane.showMessageDialog(null, s1);
                    return;
                }
            } catch (SQLException ex) {
                System.out.println("Loi :" + ex.getMessage());
            }
            tbOrder.setValueAt(amount, tbOrder.getSelectedRow(), 2);
            tbOrder.setValueAt(amount * (int) tbOrder.getValueAt(tbOrder.getSelectedRow(), 1), tbOrder.getSelectedRow(), 3);

            totalMoney();
        } catch (NumberFormatException e) {
            String s3 = "";
            if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
                s3 = "Enter a positive number!";
            } else {
                s3 = "Nhập 1 số dương";
            }
            JOptionPane.showMessageDialog(null, s3);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrderMouseClicked
        txtName.setText(tbOrder.getValueAt(tbOrder.getSelectedRow(), 0).toString());
        txtAmount.setText(tbOrder.getValueAt(tbOrder.getSelectedRow(), 2).toString());

        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);

    }//GEN-LAST:event_tbOrderMouseClicked

    public void totalMoney() {
        int total = 0;
        dtm = (DefaultTableModel) tbOrder.getModel();
        int size = dtm.getRowCount();
        for (int i = 0; i < size; i++) {
            total += Integer.parseInt(tbOrder.getValueAt(i, 3).toString());
        }
        txtTotal.setText(String.valueOf(total));
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!txtName.getText().isEmpty()) {
            String s = "";
            if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
                s = "Do you want to delete this product in cart?";
            } else {
                s = "Bạn muốn xóa sản phẩm này trong giỏ hàng?";
            }

            if (JOptionPane.showConfirmDialog(null, s, "???", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                dtm = (DefaultTableModel) tbOrder.getModel();
                dtm.removeRow(tbOrder.getSelectedRow());
                totalMoney();
                txtName.setText("");
                txtAmount.setText("");
//                txtTotal.setText("0");
            }
        } else {
            btnDelete.setEnabled(false);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        if (Integer.parseInt(txtTotal.getText()) != 0) {
            try {
                String select = "select max(OrderId) from tblOrder";
                int orderId = 1;
                rs = stm.executeQuery(select);
                while (rs.next()) {
                    orderId = rs.getInt(1) + 1;
                }

                String insertOrder = "Insert into tblOrder values('" + orderId + "', '" + txtTotal.getText() + "')";
                stm.execute(insertOrder);

                dtm = (DefaultTableModel) tbOrder.getModel();
                int size = dtm.getRowCount();
                for (int i = 0; i < size; i++) {
                    String name = tbOrder.getValueAt(i, 0).toString();
                    String price = tbOrder.getValueAt(i, 1).toString();
                    String amount = tbOrder.getValueAt(i, 2).toString();
                    String money = tbOrder.getValueAt(i, 3).toString();
                    String insertOrderDetail = "Insert into tblOrderDetail values('" + orderId + "', '" + name + "', "
                            + "'" + price + "', '" + amount + "', '" + money + "')";

                    stm.execute(insertOrderDetail);

                    // Trừ số lượng trong TblProduct:
                    String select1 = "Select Amount from tblProduct where ProductName = '" + name + "'";
                    try {
                        rs = stm.executeQuery(select1);
                        rs.next();
                        int amountProduct = rs.getInt(1);
                        int amountAfter = amountProduct - Integer.parseInt(amount);
                        String update = "Update tblProduct set Amount = '" + amountAfter + "' where ProductName = '" + name + "'";
                        stm.execute(update);
                    } catch (NumberFormatException | SQLException e) {
                    }
                }
                dtm.setRowCount(0);

                // Thong bao tien cua khach hang:
                String s = "", s2 = "", s3 = "", s4 = "";

                if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
                    s = "Total money you need pay is: ";
                    s2 = "Thank you! Have a nice day";

                } else {
                    s = "Tổng số tiền bạn cần phải trả: ";
                    s2 = "Cảm ơn! Chúc bạn có một ngày tốt lành";
                }
                JOptionPane.showMessageDialog(null, s + txtTotal.getText());
                
                // Hiển thi form Home
          String s1 = "";
        if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
            s1 = "Do you want to continue?";
        } else {
            s1 = "Bạn muốn tiếp tục??";
        }
        if (JOptionPane.showConfirmDialog(null, s1, "???", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
              JOptionPane.showMessageDialog(null, s2);
            FrmHome f = new FrmHome();
                f.setVisible(true);
                this.setVisible(false);
                p.setVisible(false);
        }
        
                
             

            } catch (SQLException e) {
                System.out.println("Loi Pay: " + e.getMessage());
            }
        } else {
            if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
                JOptionPane.showMessageDialog(null, "Please Click ADD ORDER");
            } else {
                JOptionPane.showMessageDialog(null, "Hãy chọn THÊM VÀO");
            }
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        String s = "";
        if (jLabel1.getText().equalsIgnoreCase("WELCOME TO APPLE STORE")) {
            s = "Do you want to exit?";
        } else {
            s = "Bạn muốn thoát??";
        }
        if (JOptionPane.showConfirmDialog(null, s, "???", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public void connect() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect success");

        } catch (Exception e) {
            System.out.println("Connect fail:" + e.getMessage());
        }

    }

    public void loadProduct(String language, String country) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbProduct.getModel();
        dtm.setRowCount(0);
        try {
            String a = null, b = null;
            Locale lvn = new Locale(language, country);
            ResourceBundle rbVn = ResourceBundle.getBundle("MessageBundle", lvn);
            Enumeration read = rbVn.getKeys();
            while (read.hasMoreElements()) {
                String key = (String) read.nextElement();
                String value = (String) rbVn.getObject(key);
                if (key.equalsIgnoreCase("ProductName")) {
                    a = value;
                }
                if (key.equalsIgnoreCase("Price")) {
                    b = value;
                }
                dtm.setColumnIdentifiers(new Object[]{
                    a, b
                });
            }

            String strSelect = "select ProductName,price from tblProduct";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String code = rs.getString(1);
                String price = String.valueOf(rs.getInt(2));
                dtm.insertRow(dtm.getRowCount(), new Object[]{
                    code, price
                });
            }

        } catch (Exception e) {
            System.out.println("Fail load Product " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmForCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbOrder;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
