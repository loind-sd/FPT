/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work;

import JDBC.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tu Duc
 */
public class FrProduct extends javax.swing.JFrame implements DocumentListener {

    Connection cnn;// ket noi toi db
    Statement stm;  // thuc thi cac cau lenh sql
    ResultSet rs;

    /**
     * Creates new form FrProduct
     */
    public FrProduct() {
        initComponents();
        connect();
        txtId.getDocument().addDocumentListener(this);
        txtName.getDocument().addDocumentListener(this);
        txtPrice.getDocument().addDocumentListener(this);
        txtAmount.getDocument().addDocumentListener(this);
        this.pack();
    }

    public FrProduct(String language, String country) {
        initComponents();
        connect();
        String s = null;
        this.setContentPane(new PnLogin(language, country, s));
        this.pack();
        loadProduct(language, country);
        loadOrder(language, country);
        Locale lvn = new Locale(language, country);
        ResourceBundle rbVn = ResourceBundle.getBundle("MessageBundle", lvn);

        jTabbedPane1.setTitleAt(0, rbVn.getString("Order-Product"));
        jTabbedPane1.setTitleAt(1, rbVn.getString("All-Order"));
        jLabel9.setText(rbVn.getString("Product"));
        jLabel1.setText(rbVn.getString("ProductId"));
        jLabel2.setText(rbVn.getString("ProductName"));
        jLabel4.setText(rbVn.getString("Amount"));
        jLabel10.setText(rbVn.getString("Price"));
        btnAdd.setText(rbVn.getString("Add"));
        btnUpdate.setText(rbVn.getString("Update"));
        btnDelete.setText(rbVn.getString("Delete"));
        btnReset.setText(rbVn.getString("Reset"));
        jLabel3.setText(rbVn.getString("AllO"));
        jButton4.setText(rbVn.getString("CalAll"));
        if (language.equals("en")) {
            btnBack.setText("EXIT");
            btnBAck1.setText("EXIT");
        } else {
            btnBack.setText("THOÁT");
            btnBAck1.setText("THOÁT");
        }

        txtId.getDocument().addDocumentListener(this);
        txtName.getDocument().addDocumentListener(this);
        txtPrice.getDocument().addDocumentListener(this);
        txtAmount.getDocument().addDocumentListener(this);
        this.setResizable(true);
    }

    public void connect() {
        try {
            cnn = (new DBContext()).getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Connect success");

        } catch (Exception e) {
            System.out.println("Connect fail:" + e.getMessage());
        }

    }

    public JTabbedPane panel() {
        return jTabbedPane1;
    }

    public void loadOrder2(String language, String country) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbOrder2.getModel();
        dtm.setRowCount(0);
        try {
            String a1 = null, b = null, c = null;
            Locale lvn = new Locale(language, country);
            ResourceBundle rbVn = ResourceBundle.getBundle("MessageBundle", lvn);
            Enumeration read = rbVn.getKeys();
            while (read.hasMoreElements()) {
                String key = (String) read.nextElement();
                String value = (String) rbVn.getObject(key);
                if (key.equalsIgnoreCase("ProductName")) {
                    a1 = value;
                }
                if (key.equalsIgnoreCase("Price")) {
                    b = value;
                }
                if (key.equalsIgnoreCase("Amount")) {
                    c = value;
                }

                dtm.setColumnIdentifiers(new Object[]{
                    a1, b, c
                });
            }

            String a = tbOrder3.getValueAt(tbOrder3.getSelectedRow(), 0).toString();
            String strSelect = "select * from tblOrderDetail where orderId= '" + a + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String name = rs.getString(2);
                String total = String.valueOf(rs.getInt(3));
                String amount = String.valueOf(rs.getInt(4));
                dtm.insertRow(dtm.getRowCount(), new Object[]{
                    name, total, amount
                });
            }

        } catch (Exception e) {
            System.out.println("Fail load Order2 " + e.getMessage());
        }
    }

    public void loadOrder(String language, String country) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbOrder3.getModel();
        dtm.setRowCount(0);
        try {
            Locale lvn = new Locale(language, country);
            ResourceBundle rbVn = ResourceBundle.getBundle("MessageBundle", lvn);

            String a = rbVn.getString("OrderID"), b = rbVn.getString("Totalmoney");
            dtm.setColumnIdentifiers(new Object[]{
                a, b
            });

            String strSelect = "select * from tblOrder";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String total = String.valueOf(rs.getInt(2));
                dtm.insertRow(dtm.getRowCount(), new Object[]{
                    id, total
                });
            }

        } catch (Exception e) {
            System.out.println("Fail load Order " + e.getMessage());
        }
    }

    public void loadProduct(String language, String country) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbProduct.getModel();
        dtm.setRowCount(0);

        try {
            String a = null, b = null, c = null, d = null;
            Locale lvn = new Locale(language, country);
            ResourceBundle rbVn = ResourceBundle.getBundle("MessageBundle", lvn);
            Enumeration read = rbVn.getKeys();
            while (read.hasMoreElements()) {
                String key = (String) read.nextElement();
                String value = (String) rbVn.getObject(key);
                if (key.equalsIgnoreCase("ProductId")) {
                    a = value;
                }
                if (key.equalsIgnoreCase("ProductName")) {
                    b = value;
                }
                if (key.equalsIgnoreCase("Price")) {
                    c = value;
                }
                if (key.equalsIgnoreCase("Amount")) {
                    d = value;
                }
                dtm.setColumnIdentifiers(new Object[]{
                    a, b, c, d
                });
            }

            String strSelect = "select * from tblProduct";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String price = String.valueOf(rs.getInt(3));
                String amount = String.valueOf(rs.getInt(4));
                dtm.insertRow(dtm.getRowCount(), new Object[]{
                    code, name, price, amount
                });

            }

        } catch (Exception e) {
            System.out.println("Fail load Product " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtAmount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        cboType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbOrder2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbOrder3 = new javax.swing.JTable();
        btnBAck1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel10.setBackground(new java.awt.Color(255, 255, 51));

        jLabel2.setText("Product Name");

        jPanel5.setBackground(new java.awt.Color(153, 255, 51));

        jLabel9.setBackground(new java.awt.Color(204, 255, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Product");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbProduct.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Price", "Amount"
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
        tbProduct.setRowHeight(20);
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        jLabel4.setText("Amount");

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel10.setText("Price");

        btnAdd.setText("Add");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setText("Product Id");

        btnBack.setText("Exit");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C:\\Img\\ipX.PNG", "C:\\Img\\ipXPro.PNG", "C:\\Img\\ipXProMax.PNG", "C:\\Img\\ip11.PNG", "C:\\Img\\ip11Pro.PNG", "C:\\Img\\ip11ProMax.PNG", "C:\\Img\\ip12mini.PNG", "C:\\Img\\ip12.PNG", "C:\\Img\\ip12Pro.PNG", "C:\\Img\\ip12ProMax.PNG", "C:\\Img\\ip12.PNG", "C:\\Img\\ip12Pro.PNG", "C:\\Img\\ip12ProMax.PNG" }));
        cboType.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtId))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(56, 56, 56)
                                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(53, 53, 53)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Order-Product", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));

        jButton4.setText("Calculate All Money");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(153, 255, 51));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("ALL ORDER");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tbOrder2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbOrder2);

        tbOrder3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Total Money"
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
        tbOrder3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrder3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbOrder3);

        btnBAck1.setText("Exit");
        btnBAck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBAck1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBAck1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBAck1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("AllOrder", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String language = null, country = null, e1 = null, e2 = null,e3="",e4="";
        if (jLabel9.getText().equalsIgnoreCase("Product")) {
            language = "en";
            country = "US";
            e1 = "Fail. Please Check Your ID !";
            e3 = "Fail. Please Check Your AMount !";
            e4 = "Fail. Please Check Your Price !";
            e2 = "Successfull";
        } else {
            language = "vn";
            country = "VN";
            e1 = "Lỗi. Vui Lòng Kiểm Tra Lại ID !";
            e3 = "Lỗi. Vui Lòng Kiểm Tra Lại Amount !";
            e4 = "Lỗi. Vui Lòng Kiểm Tra Lại Price !";
            e2 = "Thành Công!";
        }
        
        
        
        if (txtAmount.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, e3);
            return;
        }
        try {
            int a = Integer.parseInt(txtAmount.getText());
            if (a <= 0) {
                JOptionPane.showMessageDialog(null, e3);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e3);
            return;
        }
        if (txtPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, e4);
            return;
        }
        try {
            int a = Integer.parseInt(txtPrice.getText());
            if (a <= 0) {
                JOptionPane.showMessageDialog(null, e4);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e4);
            return;
        }

        try {
            String strSelect = "select * from tblProduct where ProductID='" + txtId.getText() + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (!rs.next()) {
                JOptionPane.showMessageDialog(null, e1);
                return;
            }
            String update = "update tblProduct set ProductID='" + txtId.getText()
                    + "',ProductName='" + txtName.getText() + "',Price='" + txtPrice.getText() + "'"
                    + ",ImgUrl='" + cboType.getSelectedItem().toString() + "',Amount ='" + txtAmount.getText() + "'where ProductID='" + txtId.getText() + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(update);
            JOptionPane.showMessageDialog(null, txtId.getText() + e2);
            loadProduct(language, country);

        } catch (Exception e) {
            System.out.println("Fail update:" + e.getMessage());
            JOptionPane.showMessageDialog(null, e1);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cboType.setSelectedIndex(-1);
        txtId.setText("");
        txtAmount.setText("");
        txtName.setText("");
        txtPrice.setText("");

        btnAdd.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String language = null, country = null, e1 = null, e2 = null,e3=null,e4=null,e5=null;
        if (jLabel9.getText().equalsIgnoreCase("Product")) {
            language = "en";
            country = "US";
            e1 = "Fail. Please Check Your ID !";
            e3 = "Fail. Please Check Your Name !";
            e4 = "Fail. Please Check Your Amount !";
            e5 = "Fail. Please Check Your Price !";
            e2 = "Successfull";
        } else {
            language = "vn";
            country = "VN";
            e1 = "Lỗi. Vui Lòng Kiểm Tra Lại ID !";
            e2 = "Thành Công!";
            e3 = "Lỗi. Vui Lòng Kiểm Tra Lại Name !";
            e4 = "Lỗi. Vui Lòng Kiểm Tra Lại Amount !";
            e5 = "Lỗi. Vui Lòng Kiểm Tra Lại Price !";
            
            
        }

        if (checkDuplicate(txtId.getText())) {
            JOptionPane.showMessageDialog(null, e1);
            return;
        }
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, e1);
            return;
        }
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, e3);
            return;
        }
        if (txtAmount.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, e4);
            return;
        }
        try {
            int a = Integer.parseInt(txtAmount.getText());
            if (a <= 0) {
                JOptionPane.showMessageDialog(null, e4);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e4);
            return;
        }
        if (txtPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, e5);
            return;
        }
        try {
            int a = Integer.parseInt(txtPrice.getText());
            if (a <= 0) {
                JOptionPane.showMessageDialog(null, e5);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e5);
            return;
        }
        if (cboType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, e5);
            return;
        }

        try {
            int d = Integer.parseInt(txtAmount.getText());
            int d1 = Integer.parseInt(txtPrice.getText());
            String add = "insert into tblProduct values('" + txtId.getText() + "','" + txtName.getText() + "','" + d1 + "','" + d + "' ,'" + cboType.getSelectedItem().toString() + "')";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(add);
            JOptionPane.showMessageDialog(null, txtId.getText() + e2);
            loadProduct(language, country);

        } catch (Exception e) {
            System.out.println("Fail add:" + e.getMessage());
            JOptionPane.showMessageDialog(null, e1);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        txtId.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString());
        txtName.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 1).toString());
        txtAmount.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 3).toString());
        txtPrice.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 2).toString());

        String url = null;
        try {
            String strSelect = "select ImgUrl from tblProduct where ProductName='" + txtName.getText() + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                url = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Fail load Product " + e.getMessage());
        }
        cboType.setSelectedItem(url);

        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String language = null, country = null, e1 = null, e2 = null;
        if (jLabel9.getText().equalsIgnoreCase("Product")) {
            language = "en";
            country = "US";
            e1 = "Fail. Please Check Your Infomation !";
            e2 = "Successfull";
        } else {
            language = "vn";
            country = "VN";
            e1 = "Lỗi. Vui Lòng Kiểm Tra Lại Thông Tin !";
            e2 = "Thành Công!";
        }
        try {
            String del = "delete from tblProduct where ProductID='" + txtId.getText() + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(del);
            JOptionPane.showMessageDialog(null, txtId.getText() + e2);
            loadProduct(language, country);
            txtId.setText("");
            txtAmount.setText("");
            txtName.setText("");
            txtPrice.setText("");
            cboType.setSelectedIndex(-1);

        } catch (Exception e) {
            System.out.println("Fail dele:" + e.getMessage());
            JOptionPane.showMessageDialog(null, e1);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        String s = "", n = "";
        if (jLabel3.getText().equalsIgnoreCase("ALL ORDER")) {
            s = "Are you sure to exit?";
            n = "Alert";
        } else {
            s = "Bạn muốn thoát?";
            n = "Thông báo";
        }
        if (JOptionPane.showConfirmDialog(null, s, n, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    DefaultTableModel dtm;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String s = "";
        if (jLabel3.getText().equalsIgnoreCase("ALL ORDER")) {
            s = "Sum of all Money is: ";
        } else {
            s = "Tổng tiền tất cả đơn hàng: ";
        }
        dtm = (DefaultTableModel) tbOrder3.getModel();
        int size = dtm.getRowCount();
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += Integer.parseInt(tbOrder3.getValueAt(i, 1).toString());
        }

        JOptionPane.showMessageDialog(null, s + total);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbOrder3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrder3MouseClicked

        String language = null, country = "null";
        if (jLabel3.getText().equalsIgnoreCase("all order")) {
            language = "en";
            country = "US";
        } else {
            language = "vn";
            country = "VN";
        }

        loadOrder2(language, country);

        // TODO add your handling code here:
    }//GEN-LAST:event_tbOrder3MouseClicked

    private void btnBAck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBAck1ActionPerformed
        String s = "", n = "";
        if (jLabel3.getText().equalsIgnoreCase("ALL ORDER")) {
            s = "Are you sure to exit?";
            n = "Alert";
        } else {
            s = "Bạn muốn thoát?";
            n = "Thông báo";
        }
        if (JOptionPane.showConfirmDialog(null, s, n, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnBAck1ActionPerformed
    private boolean checkDuplicate(String text) {

        try {
            String srtSelect = "select * from tblProduct where ProductID ='" + text.trim() + "'";
            rs = stm.executeQuery(srtSelect);
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("loi:" + e.getMessage());
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FrProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBAck1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbOrder2;
    private javax.swing.JTable tbOrder3;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (txtId.getText().trim().isEmpty() || txtName.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty() || txtAmount.getText().trim().isEmpty()) {
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(false);
        } else {
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (txtId.getText().trim().isEmpty() || txtName.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty() || txtAmount.getText().trim().isEmpty()) {
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(false);
        } else {
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
