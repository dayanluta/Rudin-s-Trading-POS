/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACC
 */
public class pnlUserAccount extends javax.swing.JPanel {
    private frmMain main;
    frmMain updateUser;
    frmMain UpdatePassword;
    /**
     * Creates new form pnlUserAccount
     */
    public pnlUserAccount() {
        initComponents();
    }

    pnlUserAccount(frmMain parent) {
         initComponents();
         this.main = parent;
         
         viewUser();
    }

//   public void refresh(){
//       DBQueries database5 = new DBQueries();
//       DefaultTableModel model=(DefaultTableModel) user_table.getModel(); //*cast to the table*//
//     try{
//            database5.ConnectToDatabase();
//            database5.ListOfUserAccount();
//                /*displaying the data from database to the table in customer.java*/
//                model.setRowCount(0);
//                while(database5.rs.next()){ //*the result set to addrow*//
//                    model.addRow(new Object[]{
//                        false,
//                        rs.getInt("cus_id"),
//                        rs.getString("cus_lname"),
//                        rs.getString("cus_fname"),
//                        rs.getString("cus_mname"),
//                        rs.getString("cus_address"),
//                        rs.getString("cus_email"),
//                        rs.getString("cus_contact"),
//                    });
//                }
//                rs.close();
//                st.execute(sql);
//                st.close();
//                con.close();
//               
//                
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,e.getMessage());
//        }
// }
    
    
   void viewUser(){
        DBQueries database1= new DBQueries();
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();
        int i=1;
        try{
            database1.ConnectToDatabase();
            database1.viewUser();
            model.setRowCount(0);
            while(database1.rs.next()){
                model.addRow(new Object[]{
                    i,
                    database1.rs.getString(1),
                    database1.rs.getString(3),
                    database1.rs.getString(4),
                    database1.rs.getString(6),
                    database1.rs.getString(5)
                    
                    
                    
                });
                i++;
               
            }
            database1.closeConnection();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        ADDUSER = new javax.swing.JButton();
        EDITACCOUNT = new javax.swing.JButton();
        CHANGE_PASSWORD = new javax.swing.JButton();
        changeStatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Username", "Fullname", "Role", "Date Created", "Status"
            }
        ));
        user_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(user_table);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(4, 0, 0, 2));

        ADDUSER.setText("ADD USER");
        ADDUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDUSERActionPerformed(evt);
            }
        });
        jPanel1.add(ADDUSER);

        EDITACCOUNT.setText("EDIT ACCOUNT");
        EDITACCOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITACCOUNTActionPerformed(evt);
            }
        });
        jPanel1.add(EDITACCOUNT);

        CHANGE_PASSWORD.setText("CHANGE PASSWORD");
        CHANGE_PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGE_PASSWORDActionPerformed(evt);
            }
        });
        jPanel1.add(CHANGE_PASSWORD);

        changeStatus.setText("CHANGE STATUS");
        changeStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeStatusActionPerformed(evt);
            }
        });
        jPanel1.add(changeStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ADDUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDUSERActionPerformed
        // TODO add your handling code here:
       dlgUserAccountAdd add = new dlgUserAccountAdd(main, true);
       add.setVisible(true);
      
    }//GEN-LAST:event_ADDUSERActionPerformed

    private void CHANGE_PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGE_PASSWORDActionPerformed
        // TODO add your handling code here:
        dlgChangePassword changePass = new dlgChangePassword(UpdatePassword,true);
        int i = user_table.getSelectedRow();
        
        try{
            changePass.setData(user_table.getValueAt(i, 1).toString());
            changePass.setVisible(true);   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Select a Row");
        }
        
        
    }//GEN-LAST:event_CHANGE_PASSWORDActionPerformed

    private void EDITACCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITACCOUNTActionPerformed
        dlgEditUserAccount edit=new dlgEditUserAccount(updateUser,false); //*calling dialog FEditcustomer*//
        
        int i=user_table.getSelectedRow();
        try{
            edit.setData(user_table.getValueAt(i,1).toString(),user_table.getValueAt(i, 2).toString(),
               user_table.getValueAt(i,3).toString());
            edit.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Select a row");
        }
        
    }//GEN-LAST:event_EDITACCOUNTActionPerformed

    private void changeStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStatusActionPerformed
        // TODO add your handling code here:
        dlgChangeStatus updateStatus = new dlgChangeStatus(main,false);
        
        int i = user_table.getSelectedRow();
        try{
            updateStatus.setData(user_table.getValueAt(i,1).toString());
            updateStatus.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Select row");
        }
        
//        updateStatus.setVisible(true);
    }//GEN-LAST:event_changeStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDUSER;
    private javax.swing.JButton CHANGE_PASSWORD;
    private javax.swing.JButton EDITACCOUNT;
    private javax.swing.JButton changeStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
