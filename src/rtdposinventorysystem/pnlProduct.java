/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACC
 */
public class pnlProduct extends javax.swing.JPanel {

    frmMain main;
    frmMain updateprod;

    public pnlProduct() {
        initComponents();
        DisplayProductstoPRODUC_TABLE();

    }

    public void DisplayProductstoPRODUC_TABLE() {
        DBQueries databasePRODUCT = new DBQueries();
        DefaultTableModel model = (DefaultTableModel) product_table.getModel();
        int i = 1;
        try {
            databasePRODUCT.ConnectToDatabase();
            databasePRODUCT.viewPRODUCTS();

            model.setRowCount(0);
            while (databasePRODUCT.rs.next()) {
                model.addRow(new Object[]{
                    i,
                    databasePRODUCT.rs.getString("prod_code"),
                    databasePRODUCT.rs.getString("category_name"),
                    databasePRODUCT.rs.getString("brand_name"),
                    databasePRODUCT.rs.getString("prod_description"),
                    databasePRODUCT.rs.getString("unit_name"),
                    databasePRODUCT.rs.getString("color_name"),
                    databasePRODUCT.rs.getDouble("cost_price"),
                    databasePRODUCT.rs.getDouble("retail_price"),
                    databasePRODUCT.rs.getDouble("discount"),
                    databasePRODUCT.rs.getInt("warn_level")
                });
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addProdct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addProdct1 = new javax.swing.JButton();
        updateProduct = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        addProdct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addProdct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add 2.png"))); // NOI18N
        addProdct.setText("ADD");
        addProdct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdctActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Search by:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("(Press ENTER)");

        addProdct1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addProdct1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/barcode111.png"))); // NOI18N
        addProdct1.setText("GENERATES BARCODE");
        addProdct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdct1ActionPerformed(evt);
            }
        });

        updateProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        updateProduct.setText("UPDATE");
        updateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));

        product_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "PRODUCT ID", "CATEGORY", "BRAND NAME", "DESCRIPTION", "UNIT", "COLOR", "COST PRICE", "RETAIL PRICE", "DISCOUNT", "WARN LEVEL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        product_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        product_table.setMaximumSize(new java.awt.Dimension(32767, 32767));
        product_table.setMinimumSize(new java.awt.Dimension(32767, 32767));
        product_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(product_table);
        if (product_table.getColumnModel().getColumnCount() > 0) {
            product_table.getColumnModel().getColumn(0).setMinWidth(30);
            product_table.getColumnModel().getColumn(0).setPreferredWidth(30);
            product_table.getColumnModel().getColumn(0).setMaxWidth(30);
            product_table.getColumnModel().getColumn(1).setMinWidth(100);
            product_table.getColumnModel().getColumn(1).setPreferredWidth(100);
            product_table.getColumnModel().getColumn(1).setMaxWidth(100);
            product_table.getColumnModel().getColumn(2).setMinWidth(120);
            product_table.getColumnModel().getColumn(2).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(2).setMaxWidth(120);
            product_table.getColumnModel().getColumn(3).setMinWidth(120);
            product_table.getColumnModel().getColumn(3).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(3).setMaxWidth(120);
            product_table.getColumnModel().getColumn(4).setMinWidth(150);
            product_table.getColumnModel().getColumn(4).setPreferredWidth(150);
            product_table.getColumnModel().getColumn(4).setMaxWidth(150);
            product_table.getColumnModel().getColumn(6).setMinWidth(120);
            product_table.getColumnModel().getColumn(6).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(6).setMaxWidth(120);
            product_table.getColumnModel().getColumn(7).setMinWidth(120);
            product_table.getColumnModel().getColumn(7).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(7).setMaxWidth(120);
            product_table.getColumnModel().getColumn(8).setMinWidth(120);
            product_table.getColumnModel().getColumn(8).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(8).setMaxWidth(120);
            product_table.getColumnModel().getColumn(9).setMinWidth(100);
            product_table.getColumnModel().getColumn(9).setPreferredWidth(100);
            product_table.getColumnModel().getColumn(9).setMaxWidth(100);
            product_table.getColumnModel().getColumn(10).setMinWidth(120);
            product_table.getColumnModel().getColumn(10).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(10).setMaxWidth(120);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(addProdct, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(updateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(addProdct1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addProdct1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addProdct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addProdctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdctActionPerformed
        // TODO add your handling code here:
        dlgAddProduct addProd = new dlgAddProduct(main, true);
        addProd.setVisible(true);

    }//GEN-LAST:event_addProdctActionPerformed

    private void addProdct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdct1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProdct1ActionPerformed
//    dlgUpdateProduct updateProd = new dlgUpdateProduct(main,true);
    private void updateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductActionPerformed

        dlgUpdateProduct update = new dlgUpdateProduct(updateprod, false);
        
        int i = product_table.getSelectedRow();
        try {
//            String pro_code = product_table.getValueAt(i, i).toString();
//            String cat = product_table.getValueAt(i, 2).toString();
            
            update.setData(product_table.getValueAt(i,1).toString(),product_table.getValueAt(i,2).toString(),
                    product_table.getValueAt(i, 3).toString(), product_table.getValueAt(i, 4).toString(),
                    product_table.getValueAt(i, 5).toString(), product_table.getValueAt(i, 6).toString(),
                    Double.parseDouble(product_table.getValueAt(i, 7).toString()), Double.parseDouble(product_table.getValueAt(i, 8).toString()),
                    Double.parseDouble(product_table.getValueAt(i, 9).toString()), Integer.parseInt(product_table.getValueAt(i, 10).toString()));
            update.setVisible(true);
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select a row");
        }

    }//GEN-LAST:event_updateProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProdct;
    private javax.swing.JButton addProdct1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable product_table;
    private javax.swing.JButton updateProduct;
    // End of variables declaration//GEN-END:variables
}
