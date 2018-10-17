/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import Classes.DBSetting;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Acer
 */
public class frmPOS extends javax.swing.JFrame {

    int total_items = 0;
    double subtotal = 0;
//    double officialAmount = 0;
    frmPOS main;

    public frmPOS() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmPOS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmPOS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmPOS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmPOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        JTableHeader header = new DefaultTableRenderer();
        input_proCode.requestFocus();
        transactionNO1.setText(TransactionNo());

    }

    boolean exist1 = false;
    int existnum1 = 0;
    boolean duplicate = false;
    int loop;

    boolean alreadyExist(String name) {
        int i = purchase_table.getSelectedRow();
        try {
            loop = 0;
            while (loop < purchase_table.getRowCount()) {
                if (purchase_table.getValueAt(loop, 1).equals(name)) {
                    duplicate = true;
                    existnum1 = loop;
                    break;
                } else {
                    duplicate = false;
                    loop++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return exist1;
    }

    String TransactionNo() {
        String str = "";
        DBQueries dbSales = new DBQueries();
        try {
            dbSales.ConnectToDatabase();
            dbSales.TransactionNo();
            if (dbSales.rs.next()) {
                str = "" + (dbSales.rs.getInt(1) + 1);
            }
            dbSales.con.close();
            dbSales.rs.close();
            dbSales.st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    public void salesTable() {
        boolean flag = false;
        double x = 0;
        int i = 0;
        String prodcode = input_proCode.getText();
        DBQueries dbSALES = new DBQueries();

        try {
//            Class.forName(DBSetting.db_driver);
//            Connection con = DriverManager.getConnection(DBSetting.db_url, DBSetting.db_user, DBSetting.db_paswd);
//            Statement st = con.createStatement();
//            String sql = "Select prod_name,prod_description,unit_name,retail_price FROM PRODUCT.product_table A, PRODUCT.unit_table B where A.unit_code = B.unit_code AND  A.prod_code = '"+input_proCode+"'";
//            ResultSet check = st.executeQuery(sql);
            dbSALES.ConnectToDatabase();
            dbSALES.salesProcess(prodcode);
            DefaultTableModel model = (DefaultTableModel) purchase_table.getModel();

            while (dbSALES.rs.next()) {
                if (input_proCode.getText().equals(dbSALES.rs.getString(1))) {
//                    System.out.println("hello");
                    if (purchase_table.getRowCount() == 0) {
                        model.addRow(new Object[]{
                            dbSALES.rs.getString("prod_code"),
                            dbSALES.rs.getString("prod_description"),
                            dbSALES.rs.getString("unit_name"),
                            dbSALES.rs.getDouble("retail_price"),
                            1, dbSALES.rs.getDouble("retail_price")

                        });

                        flag = true;
                    } else {
                        alreadyExist(dbSALES.rs.getString(2));
                        if (duplicate) {
                            i = (int) purchase_table.getValueAt(loop, 4) + 1;
                            x = (double) purchase_table.getValueAt(loop, 5);
                            purchase_table.setValueAt(i, loop, 4);
                            purchase_table.setValueAt(dbSALES.rs.getDouble("retail_price") * i, loop, 5);

                            flag = true;
                        } else {

                            model.addRow(new Object[]{
                                dbSALES.rs.getString("prod_code"),
                                dbSALES.rs.getString("prod_description"),
                                dbSALES.rs.getString("unit_name"),
                                dbSALES.rs.getDouble("retail_price"),
                                1, dbSALES.rs.getDouble("retail_price")
                            });
                            flag = true;

                        }
                    }
                }
                if (flag) {

                    System.out.println("ok");
                    input_proCode.setText("");
                    input_proCode.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Product not found!");
                }
                total_items = 0;
                total_items = total_items + (int) purchase_table.getValueAt(loop, 4);
                ITEMNO.setText("" + total_items);
//                ITEMNO.setText(""+purchase_table.getRowCount());
                subtotal = subtotal + (double) purchase_table.getValueAt(loop, 5);
                subtotalResult.setText("" + (double) purchase_table.getValueAt(loop, 5));
                NumberFormat formatter = new DecimalFormat("#0.00");
                double vat12 = subtotal * (0.12);
                subtotalResult.setText("" + (double) purchase_table.getValueAt(loop, 5));
                txtVat.setText("" + formatter.format(vat12));
                double amount = vat12 + subtotal;
                result.setText("" + amount);
//                AMOUNTDUE.setText("" + formatter.format(subtotal + vat12));
//            totalITEMS1.setText(total_items+"");
//                dbSALES.con.close();
//                dbSALES.st.close();
//                dbSALES.rs.close();
//                dbSALES.rs.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            dbSALES.closeConnection();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        txtVat = new javax.swing.JLabel();
        PRODUCTCODE = new javax.swing.JLabel();
        input_proCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        transactionNO1 = new javax.swing.JLabel();
        transactionNO2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        total_ITEMS = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        timeDay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchase_table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ITEMNO = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        subtotal1 = new javax.swing.JLabel();
        subtotalResult = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Enter = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(910, 100));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel23.setBackground(new java.awt.Color(0, 204, 204));
        jPanel23.setPreferredSize(new java.awt.Dimension(910, 30));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVat.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        txtVat.setForeground(new java.awt.Color(255, 255, 255));
        txtVat.setText("0");
        jPanel23.add(txtVat, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 110, 30));

        PRODUCTCODE.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        PRODUCTCODE.setForeground(new java.awt.Color(255, 255, 255));
        PRODUCTCODE.setText("SCAN BARCODE:");
        jPanel23.add(PRODUCTCODE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        input_proCode.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        input_proCode.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        input_proCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_proCodeActionPerformed(evt);
            }
        });
        input_proCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                input_proCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_proCodeKeyReleased(evt);
            }
        });
        jPanel23.add(input_proCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 310, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Transaction No:");
        jPanel23.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, 30));

        transactionNO1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        transactionNO1.setForeground(new java.awt.Color(255, 255, 255));
        transactionNO1.setText("0");
        jPanel23.add(transactionNO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 70, 30));

        transactionNO2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        transactionNO2.setForeground(new java.awt.Color(255, 255, 255));
        transactionNO2.setText("Vat:");
        jPanel23.add(transactionNO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 50, 30));

        jPanel8.add(jPanel23, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 100));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel24.setBackground(new java.awt.Color(0, 204, 204));
        jPanel24.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ITEMS:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setPreferredSize(new java.awt.Dimension(163, 47));
        jPanel24.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        total_ITEMS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total_ITEMS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_ITEMS.setMinimumSize(new java.awt.Dimension(40, 40));
        total_ITEMS.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel24.add(total_ITEMS, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel24, java.awt.BorderLayout.LINE_START);

        jPanel25.setBackground(new java.awt.Color(0, 204, 204));

        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("January 29, 2095");
        date.setMinimumSize(new java.awt.Dimension(40, 40));
        date.setPreferredSize(new java.awt.Dimension(40, 30));

        timeDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timeDay.setForeground(new java.awt.Color(255, 255, 255));
        timeDay.setText("     Thursday - 10:25:18");
        timeDay.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        timeDay.setPreferredSize(new java.awt.Dimension(163, 47));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeDay, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(timeDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel25, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(new java.awt.GridLayout());

        purchase_table.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        purchase_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Description", "Unit", "Price", "Quantity", "Sub-total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchase_table.setGridColor(new java.awt.Color(0, 0, 0));
        purchase_table.setRowHeight(20);
        purchase_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(purchase_table);
        if (purchase_table.getColumnModel().getColumnCount() > 0) {
            purchase_table.getColumnModel().getColumn(0).setMinWidth(150);
            purchase_table.getColumnModel().getColumn(0).setPreferredWidth(150);
            purchase_table.getColumnModel().getColumn(0).setMaxWidth(150);
            purchase_table.getColumnModel().getColumn(1).setMinWidth(500);
            purchase_table.getColumnModel().getColumn(1).setPreferredWidth(500);
            purchase_table.getColumnModel().getColumn(1).setMaxWidth(500);
            purchase_table.getColumnModel().getColumn(2).setMinWidth(150);
            purchase_table.getColumnModel().getColumn(2).setPreferredWidth(150);
            purchase_table.getColumnModel().getColumn(2).setMaxWidth(150);
            purchase_table.getColumnModel().getColumn(3).setMinWidth(150);
            purchase_table.getColumnModel().getColumn(3).setPreferredWidth(150);
            purchase_table.getColumnModel().getColumn(3).setMaxWidth(150);
            purchase_table.getColumnModel().getColumn(4).setMinWidth(150);
            purchase_table.getColumnModel().getColumn(4).setPreferredWidth(150);
            purchase_table.getColumnModel().getColumn(4).setMaxWidth(150);
            purchase_table.getColumnModel().getColumn(5).setMinWidth(100);
            purchase_table.getColumnModel().getColumn(5).setPreferredWidth(100);
            purchase_table.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jPanel4.add(jScrollPane1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(700, 240));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setForeground(new java.awt.Color(255, 0, 51));
        jPanel11.setPreferredSize(new java.awt.Dimension(455, 120));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setPreferredSize(new java.awt.Dimension(455, 75));
        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        jPanel26.setLayout(new java.awt.BorderLayout());

        jPanel27.setBackground(new java.awt.Color(204, 204, 204));
        jPanel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel27.setPreferredSize(new java.awt.Dimension(375, 120));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("AMOUNT DUE:");
        jLabel8.setMinimumSize(new java.awt.Dimension(130, 10));
        jLabel8.setPreferredSize(new java.awt.Dimension(34, 10));
        jPanel27.add(jLabel8, java.awt.BorderLayout.CENTER);

        result.setFont(new java.awt.Font("Digital-7 Italic", 1, 70)); // NOI18N
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setText("0.00");
        result.setPreferredSize(new java.awt.Dimension(108, 90));
        jPanel27.add(result, java.awt.BorderLayout.PAGE_END);

        jPanel26.add(jPanel27, java.awt.BorderLayout.CENTER);

        jPanel28.setBackground(new java.awt.Color(0, 153, 153));
        jPanel28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel28.setPreferredSize(new java.awt.Dimension(150, 120));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("   ITEMS:");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setPreferredSize(new java.awt.Dimension(163, 20));
        jPanel28.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        ITEMNO.setFont(new java.awt.Font("Digital-7 Mono", 1, 70)); // NOI18N
        ITEMNO.setForeground(new java.awt.Color(255, 255, 255));
        ITEMNO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITEMNO.setText("0");
        jPanel28.add(ITEMNO, java.awt.BorderLayout.CENTER);
        jPanel28.add(jLabel9, java.awt.BorderLayout.PAGE_END);

        jPanel26.add(jPanel28, java.awt.BorderLayout.LINE_START);

        jPanel22.add(jPanel26);

        jPanel11.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 120));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setPreferredSize(new java.awt.Dimension(455, 75));
        jPanel13.setLayout(new java.awt.GridLayout(1, 2));

        jPanel33.setBackground(new java.awt.Color(0, 153, 153));
        jPanel33.setLayout(new java.awt.GridLayout(1, 2));

        jPanel37.setBackground(new java.awt.Color(0, 153, 153));
        jPanel37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel37.setLayout(new java.awt.BorderLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 204, 153));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("F8");
        jLabel35.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel35.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel37.add(jLabel35, java.awt.BorderLayout.PAGE_START);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("SALES ");
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel37.add(jLabel36, java.awt.BorderLayout.CENTER);

        jPanel33.add(jPanel37);

        jPanel36.setBackground(new java.awt.Color(0, 153, 153));
        jPanel36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel33.add(jPanel36);

        jPanel13.add(jPanel33);

        jPanel32.setBackground(new java.awt.Color(255, 204, 153));
        jPanel32.setToolTipText("");
        jPanel32.setLayout(new java.awt.BorderLayout());

        subtotal1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subtotal1.setText("SUBTOTAL:");
        jPanel32.add(subtotal1, java.awt.BorderLayout.PAGE_START);

        subtotalResult.setFont(new java.awt.Font("Digital-7", 1, 70)); // NOI18N
        subtotalResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtotalResult.setText("0.00");
        jPanel32.add(subtotalResult, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel32);

        jPanel10.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel9.setBackground(new java.awt.Color(0, 255, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(500, 235));
        jPanel9.setLayout(new java.awt.GridLayout(2, 4));

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PAYMENTS");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel14.add(jLabel5, java.awt.BorderLayout.CENTER);

        Enter.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Enter.setForeground(new java.awt.Color(255, 204, 153));
        Enter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Enter.setText("F1");
        Enter.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Enter.setPreferredSize(new java.awt.Dimension(34, 75));
        Enter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Enter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterKeyPressed(evt);
            }
        });
        jPanel14.add(Enter, java.awt.BorderLayout.PAGE_START);

        jPanel9.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("F2");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel21.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel15.add(jLabel21, java.awt.BorderLayout.PAGE_START);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("REMOVE ITEMS");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel15.add(jLabel22, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(0, 153, 153));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 204, 153));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("F3");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel23.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel16.add(jLabel23, java.awt.BorderLayout.PAGE_START);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DISCOUNT");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel16.add(jLabel24, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(0, 153, 153));
        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 204, 153));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("F4");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel25.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel17.add(jLabel25, java.awt.BorderLayout.PAGE_START);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("<html><center>NEW<br>TRANSACTION</center></html>");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel17.add(jLabel26, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(0, 153, 153));
        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 204, 153));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("F5");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel27.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel18.add(jLabel27, java.awt.BorderLayout.PAGE_START);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("REPRINT RECEIPT");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel18.add(jLabel28, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(0, 153, 153));
        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 204, 153));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("F6");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel29.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel19.add(jLabel29, java.awt.BorderLayout.PAGE_START);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("CANCEL");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel19.add(jLabel30, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(0, 153, 153));
        jPanel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 204, 153));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("ESC");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel31.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel31.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel20.add(jLabel31, java.awt.BorderLayout.PAGE_START);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("LOGOUT");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel20.add(jLabel32, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(0, 153, 153));
        jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 204, 153));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("F7");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel33.setPreferredSize(new java.awt.Dimension(34, 75));
        jLabel33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel21.add(jLabel33, java.awt.BorderLayout.PAGE_START);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("DESCRIPTION");
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel21.add(jLabel34, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel21);

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel29.setBackground(new java.awt.Color(0, 153, 153));
        jPanel29.setPreferredSize(new java.awt.Dimension(1402, 30));
        jPanel29.setLayout(new java.awt.GridLayout(1, 0));

        jPanel30.setBackground(new java.awt.Color(0, 153, 153));
        jPanel30.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Copyright 2017 @ SoftTech Philippines");
        jPanel30.add(jLabel10);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Cashier: Dayan M. Luta");
        jPanel30.add(jLabel12);

        jPanel29.add(jPanel30);

        jPanel31.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel29.add(jPanel31);

        jPanel1.add(jPanel29, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_proCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_proCodeActionPerformed
        // TODO add your handling code here:
        salesTable();
//        System.out.println(evt.getKeyCode());

    }//GEN-LAST:event_input_proCodeActionPerformed
    public double amountTender,amountChange;
    private void input_proCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_proCodeKeyPressed
        // TODO add your handling code here:

//        salesTable();
        int code = evt.getKeyCode();
//        System.out.println(evt.getKeyCode());
        if (code == KeyEvent.VK_F1) {
            dlgPayment payment = new dlgPayment(this, true, Double.parseDouble(result.getText()));
            payment.setVisible(true);
            /*object for the amount jdialog*/
            payment.setVisible(true);
            amountTender = payment.amountTender;
            amountChange = payment.amountChange;

            if (payment.print) {

            }

        } else if (code == KeyEvent.VK_F3) {
            dlgDiscount discount = new dlgDiscount(this, true);
            discount.setVisible(true);
        }
//       


    }//GEN-LAST:event_input_proCodeKeyPressed

    boolean f = false;

    public void autoPrint(boolean f) {
        this.f = f;

        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            PageFormat format = job.defaultPage();
            Paper paper = new Paper();
            double margin = 8;
            paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
            paper.setSize(3, 4);
            format.setPaper(paper);
            job.defaultPage(format);
            job.setPrintable(new PrintObject(), format);

            job.print();
            /*boolean printerexists=job.printDialog();
             if (printerexists){
             try{
             job.print();
             }catch (Exception a){}
            
            
             }*/
        } catch (PrinterException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public class PrintObject implements Printable {

        public int print(Graphics g, PageFormat f, int pageIndex) {
            if (pageIndex == 0) {
                PrintArea(g);
            }
            return pageIndex;
        }
    }

    void PrintArea(Graphics g) {
//       

        int x = 150, y = 150;
        int i = 0;
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Arial", Font.BOLD, 7));
        g2.drawString("WELCOME TO RUDIN'S TRADING", 30, 31);
        g2.drawString("****        GROUP5       ****", 27, 40);
        g2.setFont(new Font("Arial", Font.PLAIN, 6));
        g2.drawString("CLAN CORPORATION", 51, 49);
        g2.drawString("ABUYOG LEYTE", 51, 58);
        g2.drawString("09123456789", 51, 67);
        g2.drawString("-----------------------------------------------------------------------", 10, 72);
        int x2 = 73, y2 = 55, count = 0;
        int y3 = 130;

        i++;
        y2 = y2 + 15;
        y3 = y3 + 15; /*y3 for the product height*/

//        g2.setFont(new Font("Arial", Font.BOLD, 6));
//        g2.drawString("CHECK_IN ID: ", 25, y2 + 10);
//        g2.drawString("" + checkid.getText(), 80, y2 + 10);
//        g2.drawString("OR NO: ", 25, y2 + 20);
//        g2.drawString("" + orno.getText(), 80, y2 + 20);
//        g2.drawString("NIGHTS: ", 25, y2 + 30);
//        g2.drawString("" + night.getText(), 80, y2 + 30);
//        g2.drawString("NO. OF HEADS: ", 25, y2 + 40);
//        g2.drawString("" + heads.getText(), 80, y2 + 40);
//        g2.drawString("ARRIVAL DATE:", 25, y2 + 50);
//        g2.drawString("" + arrdate.getText(), 80, y2 + 50);
//        g2.drawString("ARRIVAL TIME:", 25, y2 + 60);
//        g2.drawString("" + arrtime.getText(), 80, y2 + 60);
//        g2.drawString("----------------------------------------------------------------------", 10, y2 + 65);
//        g2.drawString("ROOM NO::", 25, y2 + 72);
//        g2.drawString("" + roomnumber1.getText(), 80, y2 + 72);
//        g2.drawString("ROOM TYPE", 25, y2 + 82);
//        g2.drawString("" + roomtype1.getText(), 80, y2 + 82);
//        g2.drawString("ROOM PRICE", 25, y2 + 92);
//        g2.drawString("" + roomprice1.getText(), 80, y2 + 92);
//        g2.drawString("----------------------------------------------------------------------", 10, y2 + 102);
//        g2.drawString("SUBTOTAL:", 25, y2 + 110);
//        g2.drawString("" + subtotal.getText(), 90, y2 + 110);
//        g2.drawString("TAX:", 25, y2 + 122);
//        g2.drawString("" + tax.getText(), 90, y2 + 122);
//        g2.drawString("PAYMENT TYPE:", 25, y2 + 132);
//        g2.drawString("" + paymenttype.getSelectedItem(), 90, y2 + 132);
//        g2.drawString("TOTAL:", 25, y2 + 142);
//        g2.drawString("" + total.getText(), 90, y2 + 142);
//        g2.drawString("DOWNPAYMENT:", 25, y2 + 152);
//        g2.drawString("" + downpayment.getText(), 90, y2 + 152);
//        g2.drawString("AMOUNT BAL:", 25, y2 + 162);
//        g2.drawString("" + balance.getText(), 90, y2 + 162);
//        g2.drawString("AMOUNT RECEIVE:", 25, y2 + 172);
//        g2.drawString("" + amountreceive.getText(), 90, y2 + 172);
//        g2.drawString("AMOUNT CHANGE:", 25, y2 + 182);
//        g2.drawString("" + change.getText(), 90, y2 + 182);

        g2.setFont(new Font("Arial", Font.BOLD, 6));
        g2.drawString("***THANK YOU FOR COMING***", 35, y2 + 202);
        g2.drawString("WE HOPE YOU ENJOY SHOPPING", 35, y2 + 212);
        g2.drawString(" GOD TO BE GLORY", 45, y2 + 222);
        g2.setFont(new Font("Arial", Font.PLAIN, 6));
        g2.drawString("THIS SERVES AS YOUR OFFICIAL RECEIPT", 25, y2 + 232);
        g2.drawString("TEL# (900) 345-3555", 50, y2 + 242);

        f = false;

    }

    
    private void EnterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnterKeyPressed
        // TODO add your handling code here:

//        System.out.println(evt.getKeyCode());
//        if(evt.getKeyCode() == 10){
//            dlgPayment payment = new dlgPayment(this, true);
//            payment.setVisible(true);
//        }   

    }//GEN-LAST:event_EnterKeyPressed

    private void input_proCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_proCodeKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_input_proCodeKeyReleased

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
            java.util.logging.Logger.getLogger(frmPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Enter;
    private javax.swing.JLabel ITEMNO;
    private javax.swing.JLabel PRODUCTCODE;
    private javax.swing.JLabel date;
    private javax.swing.JTextField input_proCode;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchase_table;
    private javax.swing.JLabel result;
    private javax.swing.JLabel subtotal1;
    private javax.swing.JLabel subtotalResult;
    private javax.swing.JLabel timeDay;
    private javax.swing.JLabel total_ITEMS;
    private javax.swing.JLabel transactionNO1;
    private javax.swing.JLabel transactionNO2;
    private javax.swing.JLabel txtVat;
    // End of variables declaration//GEN-END:variables
}
