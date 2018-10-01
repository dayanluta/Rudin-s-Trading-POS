/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import Classes.DBQueries;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACC
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        mnBar.setVisible(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblError.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        pnlLoginForm = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnClear = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        ckbShowPassword = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        lblCapsLock = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlAdmin = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlCenterDisplay = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlTop = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        USERS = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        HISTORY = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        CATEGORY = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        BRAND = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        supplier = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        unit = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        color = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        refresh = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        pnlStatusBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlLeftMenu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        PRODUCT = new javax.swing.JButton();
        INVENTORY = new javax.swing.JButton();
        SALES = new javax.swing.JButton();
        STOCKS = new javax.swing.JButton();
        REPORTS = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mnBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        userAccount = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setLayout(new java.awt.CardLayout());

        pnlLogin.setLayout(new javax.swing.OverlayLayout(pnlLogin));

        pnlLoginForm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 192, 61), 5, true));
        pnlLoginForm.setMaximumSize(new java.awt.Dimension(450, 250));
        pnlLoginForm.setPreferredSize(new java.awt.Dimension(600, 450));
        pnlLoginForm.setRequestFocusEnabled(false);
        pnlLoginForm.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Password:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear_icon.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/check_icon.png"))); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        ckbShowPassword.setText("Show password");
        ckbShowPassword.setOpaque(false);
        ckbShowPassword.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbShowPasswordItemStateChanged(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/change_password1.png"))); // NOI18N

        lblCapsLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/warning.png"))); // NOI18N
        lblCapsLock.setText("Caps Lock is on");

        lblError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/error.png"))); // NOI18N
        lblError.setText("Incorrect Username/Password!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCapsLock)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ckbShowPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(txtPassword))
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbShowPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCapsLock, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlLoginForm.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(303, 35));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        lblTitle.setBackground(new java.awt.Color(0, 204, 204));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<<USER LOGIN>>");
        lblTitle.setOpaque(true);
        jPanel4.add(lblTitle);

        pnlLoginForm.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        pnlLogin.add(pnlLoginForm);

        pnlMain.add(pnlLogin, "card3");

        pnlAdmin.setLayout(new java.awt.BorderLayout());

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlCenterDisplay.setOpaque(false);
        pnlCenterDisplay.setLayout(new java.awt.CardLayout());
        pnlCenter.add(pnlCenterDisplay, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(715, 35));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText(" WELCOME");
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6);

        pnlCenter.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pnlAdmin.add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlTop.setPreferredSize(new java.awt.Dimension(865, 50));
        pnlTop.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar1.setRollover(true);

        USERS.setText("USERS");
        USERS.setFocusable(false);
        USERS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        USERS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        USERS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERSActionPerformed(evt);
            }
        });
        jToolBar1.add(USERS);
        jToolBar1.add(jSeparator1);

        HISTORY.setText("HISTORY");
        HISTORY.setFocusable(false);
        HISTORY.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HISTORY.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(HISTORY);
        jToolBar1.add(jSeparator2);

        CATEGORY.setText("CATEGORY");
        CATEGORY.setFocusable(false);
        CATEGORY.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CATEGORY.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CATEGORY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CATEGORYActionPerformed(evt);
            }
        });
        jToolBar1.add(CATEGORY);
        jToolBar1.add(jSeparator3);

        BRAND.setText("BRAND");
        BRAND.setFocusable(false);
        BRAND.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BRAND.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BRAND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRANDActionPerformed(evt);
            }
        });
        jToolBar1.add(BRAND);
        jToolBar1.add(jSeparator4);

        supplier.setText("SUPPLIER");
        supplier.setFocusable(false);
        supplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        supplier.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierActionPerformed(evt);
            }
        });
        jToolBar1.add(supplier);
        jToolBar1.add(jSeparator5);

        unit.setText("UNIT");
        unit.setFocusable(false);
        unit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        unit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitActionPerformed(evt);
            }
        });
        jToolBar1.add(unit);
        jToolBar1.add(jSeparator6);

        color.setText("COLOR");
        color.setFocusable(false);
        color.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        color.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });
        jToolBar1.add(color);
        jToolBar1.add(jSeparator7);

        refresh.setText("REFRESH");
        refresh.setFocusable(false);
        refresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(refresh);
        jToolBar1.add(jSeparator8);

        pnlTop.add(jToolBar1);

        pnlAdmin.add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlStatusBar.setPreferredSize(new java.awt.Dimension(865, 35));
        pnlStatusBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel1.setText(" Copyright 2018 by Thesis");
        pnlStatusBar.add(jLabel1);

        pnlAdmin.add(pnlStatusBar, java.awt.BorderLayout.PAGE_END);

        pnlLeftMenu.setPreferredSize(new java.awt.Dimension(150, 466));
        pnlLeftMenu.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        PRODUCT.setText("PRODUCTS");
        PRODUCT.setMaximumSize(new java.awt.Dimension(150, 35));
        PRODUCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRODUCTActionPerformed(evt);
            }
        });
        jPanel5.add(PRODUCT);

        INVENTORY.setText("INVENTORY");
        INVENTORY.setMaximumSize(new java.awt.Dimension(150, 35));
        jPanel5.add(INVENTORY);

        SALES.setText("SALES");
        SALES.setMaximumSize(new java.awt.Dimension(150, 35));
        jPanel5.add(SALES);

        STOCKS.setText("STOCKS");
        STOCKS.setMaximumSize(new java.awt.Dimension(150, 35));
        jPanel5.add(STOCKS);

        REPORTS.setText("REPORTS");
        REPORTS.setMaximumSize(new java.awt.Dimension(150, 35));
        jPanel5.add(REPORTS);

        pnlLeftMenu.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(150, 35));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHOOSE A MENU:");
        jPanel6.add(jLabel2);

        pnlLeftMenu.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        pnlAdmin.add(pnlLeftMenu, java.awt.BorderLayout.LINE_START);

        pnlMain.add(pnlAdmin, "card2");

        jMenu1.setText("Admin");

        userAccount.setText("User Account");
        userAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccountActionPerformed(evt);
            }
        });
        jMenu1.add(userAccount);

        mnBar.add(jMenu1);

        jMenu2.setText("Edit");
        mnBar.add(jMenu2);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // CommonGUISettingsMethod.CapsLock(lblCapsLock, new javax.swing.ImageIcon(getClass().getResource("/images/warning.png")));
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        /*
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         SystemLogin();
         } //else if (evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
         CommonGUISettingsMethod.CapsLock(lblCapsLock, new javax.swing.ImageIcon(getClass().getResource("/images/warning.png")));
         */
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        //CommonGUISettingsMethod.CapsLock(lblCapsLock, new javax.swing.ImageIcon(getClass().getResource("/images/warning.png")));
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        /*
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         SystemLogin();
         } //else if (evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
         CommonGUISettingsMethod.CapsLock(lblCapsLock, new javax.swing.ImageIcon(getClass().getResource("/images/warning.png")));
         */
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtUsername.setText("");
        txtPassword.setText("");
        lblError.setVisible(false);
        txtUsername.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //SystemLogin();
        //successLogin
        pnlMain.removeAll();
        pnlMain.add(pnlAdmin);
        pnlMain.repaint();
        pnlMain.revalidate();
        mnBar.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void ckbShowPasswordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbShowPasswordItemStateChanged
        if (ckbShowPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_ckbShowPasswordItemStateChanged

    private void userAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccountActionPerformed
        pnlUserAccount account = new pnlUserAccount(this);
        pnlCenterDisplay.removeAll();
        pnlCenterDisplay.add(account);
        pnlCenterDisplay.repaint();
        pnlCenterDisplay.revalidate();
        

    }//GEN-LAST:event_userAccountActionPerformed

    private void PRODUCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODUCTActionPerformed
        pnlProduct product = new pnlProduct();
        pnlCenterDisplay.removeAll();
        pnlCenterDisplay.add(product);
        pnlCenterDisplay.repaint();
        pnlCenterDisplay.revalidate();
    }//GEN-LAST:event_PRODUCTActionPerformed

    private void USERSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USERSActionPerformed

    private void CATEGORYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CATEGORYActionPerformed
        // TODO add your handling code here:
        dlgNewcategory newcategory = new dlgNewcategory(this, true);
        newcategory.setVisible(true);

    }//GEN-LAST:event_CATEGORYActionPerformed

    private void BRANDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRANDActionPerformed
        // TODO add your handling code here:
        dlgNewBrand newbrand = new dlgNewBrand(this, true);
        newbrand.setVisible(true);
    }//GEN-LAST:event_BRANDActionPerformed

    private void supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierActionPerformed
        // TODO add your handling code here:
        dlgNewSupplier newsupplier = new dlgNewSupplier(this, true);
        newsupplier.setVisible(true);
    }//GEN-LAST:event_supplierActionPerformed

    private void unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitActionPerformed
        // TODO add your handling code here:
        dlgNewUnit newunit = new dlgNewUnit(this, true);
        newunit.setVisible(true);
    }//GEN-LAST:event_unitActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
        dlgNewColor newcolor = new dlgNewColor(this, true);
        newcolor.setVisible(true);
    }//GEN-LAST:event_colorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
         try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BRAND;
    private javax.swing.JButton CATEGORY;
    private javax.swing.JButton HISTORY;
    private javax.swing.JButton INVENTORY;
    private javax.swing.JButton PRODUCT;
    private javax.swing.JButton REPORTS;
    private javax.swing.JButton SALES;
    private javax.swing.JButton STOCKS;
    private javax.swing.JButton USERS;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox ckbShowPassword;
    private javax.swing.JButton color;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCapsLock;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JPanel pnlAdmin;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlCenterDisplay;
    private javax.swing.JPanel pnlLeftMenu;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlLoginForm;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlStatusBar;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JButton refresh;
    private javax.swing.JButton supplier;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JButton unit;
    private javax.swing.JMenuItem userAccount;
    // End of variables declaration//GEN-END:variables

}
