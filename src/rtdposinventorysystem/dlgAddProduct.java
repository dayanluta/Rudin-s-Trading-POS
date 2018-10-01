/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import Classes.DBSetting;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Acer
 */
public class dlgAddProduct extends javax.swing.JDialog {
    frmMain dlgunit;
    frmMain dlgsupplier;
    frmMain dlgcategory1;
    frmMain dlgcolor;
    frmMain dlgbrand;
    private int markup = 15, vat = 0;
    private NumberFormat formatter = new DecimalFormat("#,##0.00");

    public dlgAddProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getCategoryName();
        getBrandName();
        getSupplierName();
        getUnitName();
        getNewColor();
    }

    private void saveProduct() {

        try {
            //int i = JOptionPane.showConfirmDialog(null, "Are you sure?", "CONFIRMATION", 2);
            //if (i == 0) {
            Class.forName(DBSetting.db_driver);
            Connection con = DriverManager.getConnection(DBSetting.db_url, DBSetting.db_user, DBSetting.db_paswd);
            Statement st = con.createStatement();

//            String sql = "insert into PRODUCT.product_table values(" + prod_id.getText() + ","
//                    + "'" + prod_dess.getText() + "','" + retail.getText() + "','" + datepurchase.getDate() + "'"
//                    + ",'" + Integer.parseInt(quantity.getText()) + "','" + Integer.parseInt(invoicenumber.getText().toString()) + "',"
//                    + "'" + Double.parseDouble(cost_price1.getText()) + "','" + warn.getText() + "','" + discount1.getText() + "','" + expirationdate.getDate() + "'"
//                    + "'" + Double.parseDouble(txtsubtotal.getText()) + "',(SELECT category_id from PRODUCT.category_table where category_name='" + combocategory.getSelectedItem() + "'),(SELECT brand_code FROM PRODUCT.brand_table where brand_name='" + combobrand.getSelectedItem() + "'),(SELECT unit_code FROM PRODUCT.unit_table where unit_name= '" + combounit.getSelectedItem() + "'),"
//                    + "(SELECT color_code FROM PRODUCT.color_table WHERE color_name='" + combocolor.getSelectedItem() + "'),(SELECT sup_id FROM SUPPLIER.supplier_table where sup_name='" + suppliercombo.getSelectedItem() + "'))";
//                String sql = "insert into PRODUCT.product_table values(" + prod_id.getText() + ","
//                        + "'" + prod_dess.getText() + "','" + retail.getText() + "','" + datepurchase.getDate() + "'"
//                        + ",'" + Integer.parseInt(quantity.getText()) + "','" + Integer.parseInt(invoicenumber.getText().toString()) + "',"
//                        + "'" + Double.parseDouble(cost_price1.getText()) + "','" + warn.getText() + "','" + discount1.getText() + "','" + expirationdate.getDate() + "',"
//                        + "'" + Double.parseDouble(txtsubtotal.getText()) + "',(SELECT category_id from PRODUCT.category_table where category_name='" + combocategory.getSelectedItem() + "'),(SELECT brand_code FROM PRODUCT.brand_table where brand_name='" + combobrand.getSelectedItem() + "'),(SELECT unit_code FROM PRODUCT.unit_table where unit_name= '" + combounit.getSelectedItem() + "'),"
//                        + "(SELECT color_code FROM PRODUCT.color_table WHERE color_name='" + combocolor.getSelectedItem() + "'),(SELECT sup_id FROM SUPPLIER.supplier_table where sup_name='" + suppliercombo.getSelectedItem() + "'))";
            String sql = "Insert into PRODUCT.product_table values('" +prod_id.getText()+ "', '" +prod_dess.getText() + "', '" +retail.getText() + "',"
                    + " '" + datepurchase.getDate()+ "', " +Integer.parseInt(quantity.getText().toString()) + ","+Double.parseDouble(cost_price1.getText().toString())+","
                    + ""+Double.parseDouble(discount1.getText().toString())+" ,"+Double.parseDouble(txtsubtotal.getText())+","
                    + "(SELECT category_id from PRODUCT.category_table where category_name='"+combocategory.getSelectedItem()+"'),(SELECT brand_code FROM PRODUCT.brand_table where brand_name = '"+combobrand.getSelectedItem()+"'),"
                    + "(SELECT unit_code FROM PRODUCT.unit_table where unit_name = '"+combounit.getSelectedItem()+"'), (SELECT color_code FROM PRODUCT.color_table where color_name = '"+combocolor.getSelectedItem()+"'),"
                    + "(SELECT sup_id FROM SUPPLIER.supplier_table where sup_name ='"+suppliercombo.getSelectedItem()+"'), '"+expirationdate.getDate()+"', "+Integer.parseInt(invoicenumber.getText().toString())+"," +Integer.parseInt(warn.getText().toString()) + ")";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "NEW PRODUCT ADDED !!");
            //}
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    void getCategoryName() {
        DBQueries database7 = new DBQueries();
        try {
            database7.ConnectToDatabase();
            database7.setCategoryName();
//            combocategory.removeAllItems();
            while (database7.rs.next()) {
                combocategory.addItem(database7.rs.getString(1));

            }
            combocategory.addItem("New CategoryName");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (database7.con != null) {
                database7.closeConnection();
            }
        }
    }
    

    void getUnitName() {
        DBQueries database22 = new DBQueries();
        try {
            database22.ConnectToDatabase();
            database22.setNewUnitName();
//            combounit.removeAllItems();
            while (database22.rs.next()) {
                combounit.addItem(database22.rs.getString(1));

            }
            combounit.addItem("New Unit Name");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (database22.con != null) {
                database22.closeConnection();
            }
        }
    }

    void getNewColor() {
        DBQueries database25 = new DBQueries();
        try {
            database25.ConnectToDatabase();
            database25.setNewColor();
//            combocolor.removeAllItems();
            while (database25.rs.next()) {
                combocolor.addItem(database25.rs.getString(1));

            }
            combocolor.addItem("New Color Name");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (database25.con != null) {
                database25.closeConnection();
            }
        }
    }

    void getBrandName() {
        DBQueries database16 = new DBQueries();
        try {
            database16.ConnectToDatabase();
            database16.setBrandName();
//            combobrand.removeAllItems();
            while (database16.rs.next()) {
                combobrand.addItem(database16.rs.getString(1));

            }
            combobrand.addItem("New Brand Name");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (database16.con != null) {
                database16.closeConnection();
            }
        }
    }

    void getSupplierName() {
        DBQueries database15 = new DBQueries();
        try {
            database15.ConnectToDatabase();
            database15.setSupplierName();
//            suppliercombo.removeAllItems();
            while (database15.rs.next()) {
                suppliercombo.addItem(database15.rs.getString(1));

            }
           suppliercombo.addItem("New Supplier Name");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (database15.con != null) {
                database15.closeConnection();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        productID = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        brand = new javax.swing.JLabel();
        prodDescription = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        unit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        prod_id = new javax.swing.JTextField();
        combocategory = new javax.swing.JComboBox();
        combobrand = new javax.swing.JComboBox();
        prod_dess = new javax.swing.JTextField();
        combocolor = new javax.swing.JComboBox();
        combounit = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        supplier = new javax.swing.JLabel();
        DatePurchase = new javax.swing.JLabel();
        invoice = new javax.swing.JLabel();
        expiration = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        suppliercombo = new javax.swing.JComboBox();
        datepurchase = new com.toedter.calendar.JDateChooser();
        invoicenumber = new javax.swing.JTextField();
        expirationdate = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        qty = new javax.swing.JLabel();
        costprice = new javax.swing.JLabel();
        retailprice = new javax.swing.JLabel();
        warnlevel = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        quantity = new javax.swing.JTextField();
        cost_price1 = new javax.swing.JTextField();
        retail = new javax.swing.JTextField();
        warn = new javax.swing.JTextField();
        discount1 = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        saveNewProduct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADDING NEW PRODUCT");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setLayout(new java.awt.GridLayout(6, 0));

        productID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        productID.setText("Product ID:");
        jPanel3.add(productID);

        category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category.setText("Category Name:");
        jPanel3.add(category);

        brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        brand.setText("Brand Name:");
        jPanel3.add(brand);

        prodDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prodDescription.setText("Product Description:");
        jPanel3.add(prodDescription);

        color.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        color.setText("Color:");
        jPanel3.add(color);

        unit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unit.setText("Unit:");
        jPanel3.add(unit);

        jPanel4.setLayout(new java.awt.GridLayout(6, 0));
        jPanel4.add(prod_id);

        combocategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combocategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        combocategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocategoryItemStateChanged(evt);
            }
        });
        combocategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoryActionPerformed(evt);
            }
        });
        jPanel4.add(combocategory);

        combobrand.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combobrand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        combobrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobrandActionPerformed(evt);
            }
        });
        jPanel4.add(combobrand);
        jPanel4.add(prod_dess);

        combocolor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combocolor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        combocolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocolorActionPerformed(evt);
            }
        });
        jPanel4.add(combocolor);

        combounit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combounit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        combounit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combounitActionPerformed(evt);
            }
        });
        jPanel4.add(combounit);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 390, 200));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel6.setLayout(new java.awt.GridLayout(4, 0));

        supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supplier.setText("Supplier Name:");
        jPanel6.add(supplier);

        DatePurchase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DatePurchase.setText("Date Purchased:");
        jPanel6.add(DatePurchase);

        invoice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invoice.setText("Invoice Number:");
        jPanel6.add(invoice);

        expiration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expiration.setText("Expiration Date:");
        jPanel6.add(expiration);

        jPanel7.setLayout(new java.awt.GridLayout(4, 0));

        suppliercombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        suppliercombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        suppliercombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliercomboActionPerformed(evt);
            }
        });
        jPanel7.add(suppliercombo);
        jPanel7.add(datepurchase);
        jPanel7.add(invoicenumber);
        jPanel7.add(expirationdate);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 390, 150));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Amount Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel9.setLayout(new java.awt.GridLayout(6, 0));

        qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qty.setText("Qty:");
        jPanel9.add(qty);

        costprice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        costprice.setText("Cost Price:");
        jPanel9.add(costprice);

        retailprice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        retailprice.setText("Retail Price:");
        jPanel9.add(retailprice);

        warnlevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        warnlevel.setText("Warn Level:");
        jPanel9.add(warnlevel);

        discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discount.setText("Discount:");
        jPanel9.add(discount);

        subtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subtotal.setText("Sub-total:");
        jPanel9.add(subtotal);

        jPanel10.setLayout(new java.awt.GridLayout(6, 0));

        quantity.setBackground(new java.awt.Color(240, 240, 240));
        quantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityFocusLost(evt);
            }
        });
        jPanel10.add(quantity);

        cost_price1.setBackground(new java.awt.Color(240, 240, 240));
        cost_price1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cost_price1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cost_price1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cost_price1KeyReleased(evt);
            }
        });
        jPanel10.add(cost_price1);

        retail.setBackground(new java.awt.Color(240, 240, 240));
        retail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        retail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(retail);

        warn.setBackground(new java.awt.Color(240, 240, 240));
        warn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        warn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(warn);

        discount1.setBackground(new java.awt.Color(240, 240, 240));
        discount1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        discount1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(discount1);

        txtsubtotal.setBackground(new java.awt.Color(240, 240, 240));
        txtsubtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsubtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsubtotalKeyReleased(evt);
            }
        });
        jPanel10.add(txtsubtotal);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 230, 180));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 120, 40));

        saveNewProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveNewProduct.setText("SAVE");
        saveNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNewProductActionPerformed(evt);
            }
        });
        getContentPane().add(saveNewProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 120, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void saveNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNewProductActionPerformed
        String prod_code = prod_id.getText();
        String category = combocategory.getSelectedItem().toString();
        String brand = combobrand.getSelectedItem().toString();
        String description = prod_dess.getText();
        String color = combocolor.getSelectedItem().toString();
        String unit_name = combounit.getSelectedItem().toString();
        String supplier = suppliercombo.getSelectedItem().toString();
        Date date_purchase = datepurchase.getDate();
        Date exp_date = expirationdate.getDate();
        int invoice_number = Integer.parseInt(invoicenumber.getText().toString());
        int qty = Integer.parseInt(quantity.getText().toString());
        double cost_price = Double.parseDouble(cost_price1.getText().toString());
        double retail_price = Double.parseDouble(retail.getText().toString());
        int warn_level = Integer.parseInt(warn.getText().toString());
        double discount = Double.parseDouble(discount1.getText().toString());
        double sub_total = Double.parseDouble(txtsubtotal.getText().toString());
        //VALIDATION
        if (prod_code.trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Product ID is empty. Please Enter/Scan PRODUCT ID!", "ERROR", JOptionPane.ERROR_MESSAGE);
            prod_id.requestFocus();
            return;
        }
        if (category.equals("-Select-")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please select Category Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            combocategory.requestFocus();
            return;
        }
        if (brand.equals("-Select-")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please select Brand Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            combobrand.requestFocus();
            return;
        }

        if (description.trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Product Description!", "ERROR", JOptionPane.ERROR_MESSAGE);
            prod_dess.requestFocus();
            return;
        }
        if (color.equals("-Select-")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please select category Color!", "ERROR", JOptionPane.ERROR_MESSAGE);
            combocolor.requestFocus();
            return;
        }

        if (supplier.equals("-Select-")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please select Supplier Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            suppliercombo.requestFocus();
            return;
        }
        if (datepurchase.isEnabled() && date_purchase == null) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Date Purchased!", "ERROR", JOptionPane.ERROR_MESSAGE);
            datepurchase.requestFocus();
            return;
        }
        if (datepurchase.getDate().after(new java.util.Date())) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Invalid Date of Purchased!", "ERROR", JOptionPane.ERROR_MESSAGE);
            datepurchase.requestFocus();
            return;
        }
        if (invoicenumber.getText().trim().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Invoice Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
            invoicenumber.selectAll();
            invoice.requestFocus();
            return;
        }
        if (expirationdate.isEnabled() && exp_date == null) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Select Expiration Date!", "ERROR", JOptionPane.ERROR_MESSAGE);
            expirationdate.requestFocus();
            return;
        }
        if (expirationdate.isEnabled() && !expirationdate.getDate().after(datepurchase.getDate())) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Invalid Expiration Date. Expiration date should be greater than purchased date!", "ERROR", JOptionPane.ERROR_MESSAGE);
            expirationdate.requestFocus();
            return;
        }
        if (expirationdate.isEnabled() && !expirationdate.getDate().after(new java.util.Date())) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Invalid Expiration Date. Expiration date should be lesser than current date!", "ERROR", JOptionPane.ERROR_MESSAGE);
            expirationdate.requestFocus();
            return;
        }
        if (quantity.getText().trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Quantity!", "ERROR", JOptionPane.ERROR_MESSAGE);
            quantity.selectAll();
            quantity.requestFocus();
            return;
        }
        if (cost_price1.getText().trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Cost Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
            cost_price1.selectAll();
            cost_price1.requestFocus();
            return;
        }
        if (retail.getText().trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Retail Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
            retail.selectAll();
            retail.requestFocus();
            return;
        }

        if (warn.getText().trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please fill up Re-order Level!", "ERROR", JOptionPane.ERROR_MESSAGE);
            warn.selectAll();
            warn.requestFocus();
            return;
        }
        if (discount1.getText().trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please enter discount to zero if none!", "ERROR", JOptionPane.ERROR_MESSAGE);
            discount1.requestFocus();
            discount1.requestFocus();
            return;
        }

        if (txtsubtotal.getText().trim().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please enter subtotal to zero if none!", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtsubtotal.requestFocus();
            txtsubtotal.requestFocus();
            return;
        }

        int CONFIRM = JOptionPane.showConfirmDialog(this, "Are all information Correct?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (CONFIRM == JOptionPane.YES_OPTION) {
            saveProduct();
        }


    }//GEN-LAST:event_saveNewProductActionPerformed

    private void quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusLost

    }//GEN-LAST:event_quantityFocusLost
   
    
    private void cost_price1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cost_price1KeyReleased
        // TODO add your handling code here:
        String cost_price = cost_price1.getText();
        String qty1= quantity.getText();
        
        if (!cost_price.equals("") && !cost_price.equals("0")) {
            double costprice1 = Double.parseDouble(cost_price);
            double mp = costprice1 / 100 * markup;
            double Vat = (((costprice1 / 1.12)) / 100) * vat;
            System.out.println(costprice1 + " " + markup + " " + vat);
            double totalRetailPrice = (costprice1 + markup + vat);
            retail.setText("" + formatter.format(totalRetailPrice));
            int qty = Integer.parseInt(qty1);
            double sub = costprice1 * qty;
            txtsubtotal.setText(""+formatter.format(sub));
          
            
            
        } else {
            retail.setText("0");
        }
    }//GEN-LAST:event_cost_price1KeyReleased

    private void combocategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocategoryItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_combocategoryItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsubtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsubtotalKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtsubtotalKeyReleased

    private void combocategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoryActionPerformed
        // TODO add your handling code here:
        if (combocategory.getSelectedItem().equals("New Category")) {
            dlgNewcategory newcat = new dlgNewcategory(dlgcategory1, true);
            newcat.setVisible(true);
        }
    }//GEN-LAST:event_combocategoryActionPerformed

    private void combobrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobrandActionPerformed
        // TODO add your handling code here:
        if(combobrand.getSelectedItem().equals("New Brand Name")){
            dlgNewBrand newb = new dlgNewBrand(dlgbrand,true);
            newb.setVisible(true);
        }
    }//GEN-LAST:event_combobrandActionPerformed

    private void combocolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocolorActionPerformed
        // TODO add your handling code here:
        if(combocolor.getSelectedItem().equals("New Color Name")){
            dlgNewColor newcolor = new dlgNewColor(dlgcolor,true);
            newcolor.setVisible(true);
        }
    }//GEN-LAST:event_combocolorActionPerformed

    private void combounitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combounitActionPerformed
        // TODO add your handling code here:
        if(combounit.getSelectedItem().equals("New Unit Name")){
            dlgNewUnit newunit = new dlgNewUnit(dlgunit,true);
            newunit.setVisible(true);
        }
    }//GEN-LAST:event_combounitActionPerformed

    private void suppliercomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliercomboActionPerformed
        // TODO add your handling code here:
        if(suppliercombo.getSelectedItem().equals("New Supplier Name")){
            dlgNewSupplier newsupplier = new dlgNewSupplier(dlgsupplier,true);
            newsupplier.setVisible(true);
        }
        
    }//GEN-LAST:event_suppliercomboActionPerformed

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
            java.util.logging.Logger.getLogger(dlgAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgAddProduct dialog = new dlgAddProduct(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DatePurchase;
    private javax.swing.JLabel brand;
    private javax.swing.JLabel category;
    private javax.swing.JLabel color;
    private javax.swing.JComboBox combobrand;
    private javax.swing.JComboBox combocategory;
    private javax.swing.JComboBox combocolor;
    private javax.swing.JComboBox combounit;
    private javax.swing.JTextField cost_price1;
    private javax.swing.JLabel costprice;
    private com.toedter.calendar.JDateChooser datepurchase;
    private javax.swing.JLabel discount;
    private javax.swing.JTextField discount1;
    private javax.swing.JLabel expiration;
    private com.toedter.calendar.JDateChooser expirationdate;
    private javax.swing.JLabel invoice;
    private javax.swing.JTextField invoicenumber;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel prodDescription;
    private javax.swing.JTextField prod_dess;
    private javax.swing.JTextField prod_id;
    private javax.swing.JLabel productID;
    private javax.swing.JLabel qty;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField retail;
    private javax.swing.JLabel retailprice;
    private javax.swing.JButton saveNewProduct;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel supplier;
    private javax.swing.JComboBox suppliercombo;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JLabel unit;
    private javax.swing.JTextField warn;
    private javax.swing.JLabel warnlevel;
    // End of variables declaration//GEN-END:variables
}
