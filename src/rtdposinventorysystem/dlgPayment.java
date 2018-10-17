/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtdposinventorysystem;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class dlgPayment extends javax.swing.JDialog {

    public double amountval, amountTender, amountChange;
    public boolean print = false;
    frmPOS pos;

    public dlgPayment(frmPOS parent, boolean modal, double value) {
        super(parent, modal);
        pos = parent;
        initComponents();
        DUE.setText("" + value); /*DOUBLE QUOTE MEANS THE STRING VALUE CONTINATE NUMBER AND STRING*/

        amountval = value; /*encapsulation the local value to global value "EXTENDS word means inheritance*/

        TENDERED.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainP = new javax.swing.JPanel();
        paymentTitle = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        closeButton = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        MainPayment = new javax.swing.JPanel();
        PaymentInformation = new javax.swing.JPanel();
        Card1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        TotalDue = new javax.swing.JLabel();
        Tendered = new javax.swing.JLabel();
        Less = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        DUE = new javax.swing.JTextField();
        TENDERED = new javax.swing.JTextField();
        txtSales1 = new javax.swing.JTextField();
        CHANGE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Card2 = new javax.swing.JPanel();
        Loading = new javax.swing.JLabel();
        Loading1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        toClose = new javax.swing.JLabel();
        toSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        MainP.setBackground(new java.awt.Color(255, 255, 255));
        MainP.setLayout(new java.awt.BorderLayout());

        paymentTitle.setBackground(new java.awt.Color(0, 153, 153));
        paymentTitle.setLayout(new java.awt.BorderLayout());

        payment.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 0));
        payment.setText("PAYMENT");
        payment.setToolTipText("");
        paymentTitle.add(payment, java.awt.BorderLayout.CENTER);

        closeButton.setBackground(new java.awt.Color(0, 153, 153));

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setText("X");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        closeButton.add(cancel);

        paymentTitle.add(closeButton, java.awt.BorderLayout.EAST);

        MainP.add(paymentTitle, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());

        MainPayment.setBackground(new java.awt.Color(204, 204, 204));
        MainPayment.setLayout(new java.awt.BorderLayout());

        PaymentInformation.setBackground(new java.awt.Color(204, 204, 204));
        PaymentInformation.setLayout(new java.awt.CardLayout());

        Card1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.GridLayout(4, 0));

        TotalDue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalDue.setText("TOTAL DUE:");
        jPanel1.add(TotalDue);

        Tendered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tendered.setText("TENDERED:");
        jPanel1.add(Tendered);

        Less.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Less.setText("LESS:");
        jPanel1.add(Less);

        change.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        change.setText("CHANGE:");
        jPanel1.add(change);

        jPanel4.setLayout(new java.awt.GridLayout(4, 0));

        DUE.setBackground(new java.awt.Color(0, 204, 204));
        DUE.setFont(new java.awt.Font("Digital-7 Mono", 1, 24)); // NOI18N
        DUE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DUE.setText("0.00");
        jPanel4.add(DUE);

        TENDERED.setFont(new java.awt.Font("Digital-7 Mono", 1, 24)); // NOI18N
        TENDERED.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TENDERED.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TENDEREDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TENDEREDKeyReleased(evt);
            }
        });
        jPanel4.add(TENDERED);

        txtSales1.setBackground(new java.awt.Color(0, 204, 204));
        txtSales1.setFont(new java.awt.Font("Digital-7 Mono", 1, 24)); // NOI18N
        txtSales1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSales1.setText("0.00");
        jPanel4.add(txtSales1);

        CHANGE.setBackground(new java.awt.Color(0, 204, 204));
        CHANGE.setFont(new java.awt.Font("Digital-7 Mono", 1, 24)); // NOI18N
        CHANGE.setForeground(new java.awt.Color(255, 0, 0));
        CHANGE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CHANGE.setText("0.00");
        CHANGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEActionPerformed(evt);
            }
        });
        jPanel4.add(CHANGE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Card1Layout = new javax.swing.GroupLayout(Card1);
        Card1.setLayout(Card1Layout);
        Card1Layout.setHorizontalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        Card1Layout.setVerticalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PaymentInformation.add(Card1, "card3");

        Card2.setBackground(new java.awt.Color(204, 204, 204));
        Card2.setLayout(new java.awt.GridLayout(2, 0));

        Loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Loading.setText("Loading");
        Card2.add(Loading);

        Loading1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Loading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Loading1.setText("Saving Transaction.....");
        Card2.add(Loading1);

        PaymentInformation.add(Card2, "card2");

        MainPayment.add(PaymentInformation, java.awt.BorderLayout.CENTER);

        jPanel2.add(MainPayment, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        toClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toClose.setText("ESC (CLOSE)");
        toClose.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(toClose);

        toSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toSave.setText("ENTER (SAVE)");
        toSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(toSave);

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        MainP.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainP);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void TENDEREDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TENDEREDKeyPressed
        // TODO add your handling code here:
//        boolean print = true;
//        autoPrint(print);

    }//GEN-LAST:event_TENDEREDKeyPressed

    private void TENDEREDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TENDEREDKeyReleased
        // TODO add your handling code here:
//         boolean print = true;
//        autoPrint(print);
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10) {
            double amt = Double.parseDouble(TENDERED.getText()) - amountval;
            NumberFormat formatter = new DecimalFormat("#0.00");
            CHANGE.setText("" +formatter.format(amt) );
            amountTender = Double.parseDouble(TENDERED.getText());
            amountChange = amt;

            if (amountTender >= amountval) {

                print = true;
                pos.amountChange = amountChange;
                pos.amountTender = amountTender;
//                pos.autoPrint(true);
//                pos.setClear();

            } else if (amountTender < amountval) {
                JOptionPane.showMessageDialog(null, "AMOUNT IS INSUFFICIENT");
            }
        }
    }//GEN-LAST:event_TENDEREDKeyReleased

    private void CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CHANGEActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CHANGE;
    private javax.swing.JPanel Card1;
    private javax.swing.JPanel Card2;
    private javax.swing.JTextField DUE;
    private javax.swing.JLabel Less;
    private javax.swing.JLabel Loading;
    private javax.swing.JLabel Loading1;
    private javax.swing.JPanel MainP;
    private javax.swing.JPanel MainPayment;
    private javax.swing.JPanel PaymentInformation;
    private javax.swing.JTextField TENDERED;
    private javax.swing.JLabel Tendered;
    private javax.swing.JLabel TotalDue;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel change;
    private javax.swing.JPanel closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel payment;
    private javax.swing.JPanel paymentTitle;
    private javax.swing.JLabel toClose;
    private javax.swing.JLabel toSave;
    private javax.swing.JTextField txtSales1;
    // End of variables declaration//GEN-END:variables
}