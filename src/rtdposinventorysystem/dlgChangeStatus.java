/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class dlgChangeStatus extends javax.swing.JDialog {

    pnlUserAccount main;

    /**
     * Creates new form dlgChangeStatus
     */
    public dlgChangeStatus(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setData(String username) {
        this.txtusername.setText(username);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        USERNAME = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtusername = new javax.swing.JTextField();
        updateStatus = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        RActive = new javax.swing.JRadioButton();
        RDeactive = new javax.swing.JRadioButton();
        RReset = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        USERNAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        USERNAME.setText("USERNAME:");
        jPanel5.add(USERNAME);

        PASSWORD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PASSWORD.setText("STATUS:");
        jPanel5.add(PASSWORD);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        txtusername.setEditable(false);
        txtusername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel6.add(txtusername);

        updateStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save 1.png"))); // NOI18N
        updateStatus.setText("SAVE");
        updateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        cancel.setText("CANCEL");

        RActive.setBackground(new java.awt.Color(204, 204, 204));
        group.add(RActive);
        RActive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RActive.setText("Active");
        RActive.setName("group"); // NOI18N
        RActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActiveActionPerformed(evt);
            }
        });

        RDeactive.setBackground(new java.awt.Color(204, 204, 204));
        group.add(RDeactive);
        RDeactive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RDeactive.setText("Deactive");
        RDeactive.setName("group"); // NOI18N
        RDeactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDeactiveActionPerformed(evt);
            }
        });

        RReset.setBackground(new java.awt.Color(204, 204, 204));
        group.add(RReset);
        RReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RReset.setText("Reset");
        RReset.setName("RReset"); // NOI18N
        RReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RReset)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(RActive)
                                        .addGap(18, 18, 18)
                                        .addComponent(RDeactive)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RActive)
                            .addComponent(RDeactive)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHANGE STATUS");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusActionPerformed
        String selectStatus = "";
        String username = txtusername.getText();
        DBQueries database4 = new DBQueries();
        if (RActive.isSelected()) {
            selectStatus = RActive.getText();
        } else if (RDeactive.isSelected()) {
            selectStatus = RDeactive.getText();
        } else if (RReset.isSelected()) {
            selectStatus = RReset.getText();
        }
        try {
            database4.ConnectToDatabase();
            database4.UpdateUserStatusActive(username, selectStatus);
//           main.refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Updated Successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

        }
        this.dispose();
    }//GEN-LAST:event_updateStatusActionPerformed

    private void RActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RActiveActionPerformed
        RActive.setSelected(true);
        RDeactive.setSelected(false);
        RReset.setSelected(false);
    }//GEN-LAST:event_RActiveActionPerformed

    private void RDeactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDeactiveActionPerformed
        // TODO add your handling code here:
        RActive.setSelected(false);
        RDeactive.setSelected(true);
        RReset.setSelected(false);
    }//GEN-LAST:event_RDeactiveActionPerformed

    private void RResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RResetActionPerformed
        // TODO add your handling code here:
        RActive.setSelected(false);
        RDeactive.setSelected(false);
        RReset.setSelected(true);
    }//GEN-LAST:event_RResetActionPerformed

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
            java.util.logging.Logger.getLogger(dlgChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgChangeStatus dialog = new dlgChangeStatus(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JRadioButton RActive;
    private javax.swing.JRadioButton RDeactive;
    private javax.swing.JRadioButton RReset;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JButton cancel;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtusername;
    private javax.swing.JButton updateStatus;
    // End of variables declaration//GEN-END:variables
}
