/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class dlgDiscount extends javax.swing.JDialog {

    /**
     * Creates new form dlgDiscount
     */
    public dlgDiscount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel19 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        DISCOUNT1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        discountTYPE = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PERCENTAGE = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        DISCOUNT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, java.awt.BorderLayout.WEST);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9, java.awt.BorderLayout.EAST);

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));
        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        DISCOUNT1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DISCOUNT1.setText("DISCOUNT TYPE:");
        jPanel11.add(DISCOUNT1);

        jPanel7.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 51, 51));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        discountTYPE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        discountTYPE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Senior Citizen", "PWD" }));
        jPanel12.add(discountTYPE);

        jPanel7.add(jPanel12);

        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERCENTAGE:");
        jPanel14.add(jLabel1);

        PERCENTAGE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PERCENTAGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PERCENTAGEKeyPressed(evt);
            }
        });
        jPanel14.add(PERCENTAGE);

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("%");
        jPanel18.add(jLabel3);

        jPanel14.add(jPanel18);

        jPanel5.add(jPanel14);

        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel6);

        jPanel20.setBackground(new java.awt.Color(204, 204, 204));
        jPanel20.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("(PRESS ENTER TO SAVE)");
        jPanel20.add(jLabel2);

        jPanel13.add(jPanel20);

        jPanel5.add(jPanel13);

        jPanel3.add(jPanel5);

        jPanel2.add(jPanel3);

        jPanel19.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        DISCOUNT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DISCOUNT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DISCOUNT.setText("DISCOUNT");
        jPanel1.add(DISCOUNT);

        jPanel19.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel19);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayDiscount() {
        DBQueries db = new DBQueries();
        try {
            db.ConnectToDatabase();

            //show image
//            db.queryDiscount();
            discountTYPE.removeAllItems();
            while (db.rs.next()) {
                discountTYPE.addItem(db.rs.getString("dis_type"));
            }
            discountTYPE.addItem("OTHERS");
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (db.con != null) {
                db.closeConnection();
            }

        }
    }
    private void PERCENTAGEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PERCENTAGEKeyPressed
        // TODO add your handling code here:
        String discountType = discountTYPE.getSelectedItem().toString();
        double disPercentage = Double.parseDouble(PERCENTAGE.getText().toString());

        DBQueries dbDiscount = new DBQueries();
        try {
            dbDiscount.ConnectToDatabase();
//            dbDiscount.CustomerDiscount(discountType,disPercentage);
            if (dbDiscount.rs.next()) {
                int i = dbDiscount.CustomerDiscount(discountType, disPercentage);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Inserted Successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
//                    discountTYPE.setText("");
                    PERCENTAGE.setText("");
//                   main1.refresh();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Failed", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (dbDiscount.con != null) {
                dbDiscount.closeConnection();
            }

        }


    }//GEN-LAST:event_PERCENTAGEKeyPressed

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
            java.util.logging.Logger.getLogger(dlgDiscount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgDiscount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgDiscount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgDiscount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgDiscount dialog = new dlgDiscount(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel DISCOUNT;
    private javax.swing.JLabel DISCOUNT1;
    private javax.swing.JTextField PERCENTAGE;
    private javax.swing.JComboBox discountTYPE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
