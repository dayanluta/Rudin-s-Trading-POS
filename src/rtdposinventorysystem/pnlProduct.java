/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;


import Classes.DBQueries;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACC
 */
public class pnlProduct extends javax.swing.JPanel {

    frmMain main;
    public pnlProduct() {
        initComponents();
        DisplayProductstoPRODUC_TABLE();
        
    }

    public void DisplayProductstoPRODUC_TABLE(){
        DBQueries databasePRODUCT = new DBQueries();
        
        try{
            databasePRODUCT.ConnectToDatabase();
            databasePRODUCT.viewPRODUCTS();
            DefaultTableModel model = (DefaultTableModel) product_table.getModel();
            
            model.setRowCount(0);
            while(databasePRODUCT.rs.next()){
                model.addRow(new Object []{
                    databasePRODUCT.rs.getString("prod_code"),
                    databasePRODUCT.rs.getString("category_name"),
                    databasePRODUCT.rs.getString("brand_name"),
                    databasePRODUCT.rs.getString("prod_description"),
                    databasePRODUCT.rs.getString("color_name"),
                    databasePRODUCT.rs.getDouble("cost_price"),
                    databasePRODUCT.rs.getDouble("retail_price"),
                    databasePRODUCT.rs.getDouble("discount"),
                    databasePRODUCT.rs.getInt("warn_level")
                });
            }
            
        }catch(Exception e){
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
        addProdct2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        addProdct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        addProdct1.setText("GENERATES BARCODE");
        addProdct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdct1ActionPerformed(evt);
            }
        });

        addProdct2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addProdct2.setText("UPDATE");
        addProdct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdct2ActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));

        product_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT ID", "CATEGORY", "BRAND NAME", "DESCRIPTION", "COLOR", "COST PRICE", "RETAIL PRICE", "DISCOUNT", "WARN LEVEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

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
            product_table.getColumnModel().getColumn(0).setMinWidth(120);
            product_table.getColumnModel().getColumn(0).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(0).setMaxWidth(120);
            product_table.getColumnModel().getColumn(1).setMinWidth(120);
            product_table.getColumnModel().getColumn(1).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(1).setMaxWidth(120);
            product_table.getColumnModel().getColumn(2).setMinWidth(120);
            product_table.getColumnModel().getColumn(2).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(2).setMaxWidth(120);
            product_table.getColumnModel().getColumn(3).setMinWidth(150);
            product_table.getColumnModel().getColumn(3).setPreferredWidth(150);
            product_table.getColumnModel().getColumn(3).setMaxWidth(150);
            product_table.getColumnModel().getColumn(4).setMinWidth(120);
            product_table.getColumnModel().getColumn(4).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(4).setMaxWidth(120);
            product_table.getColumnModel().getColumn(5).setMinWidth(120);
            product_table.getColumnModel().getColumn(5).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(5).setMaxWidth(120);
            product_table.getColumnModel().getColumn(6).setMinWidth(120);
            product_table.getColumnModel().getColumn(6).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(6).setMaxWidth(120);
            product_table.getColumnModel().getColumn(7).setMinWidth(100);
            product_table.getColumnModel().getColumn(7).setPreferredWidth(100);
            product_table.getColumnModel().getColumn(7).setMaxWidth(100);
            product_table.getColumnModel().getColumn(8).setMinWidth(120);
            product_table.getColumnModel().getColumn(8).setPreferredWidth(120);
            product_table.getColumnModel().getColumn(8).setMaxWidth(120);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(addProdct, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addProdct2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(addProdct1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProdct, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProdct1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProdct2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addProdctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdctActionPerformed
        // TODO add your handling code here:
        dlgAddProduct addProd = new dlgAddProduct(main,true);
        addProd.setVisible(true);
        
    }//GEN-LAST:event_addProdctActionPerformed

    private void addProdct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdct1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProdct1ActionPerformed

    private void addProdct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdct2ActionPerformed
        // TODO add your handling code here:
         dlgUpdateProduct updateProd = new dlgUpdateProduct(main,true);
        updateProd.setVisible(true);
    }//GEN-LAST:event_addProdct2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProdct;
    private javax.swing.JButton addProdct1;
    private javax.swing.JButton addProdct2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable product_table;
    // End of variables declaration//GEN-END:variables
}
