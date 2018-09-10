/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACC
 */
public class DBQueries {

    public Statement st, st2, st3, st4;
    public ResultSet rs, rs2, rs3, rs4;
    public Connection con, con2, con3, con4;

    public void ConnectToDatabase() {
        try {
            Class.forName(DBSetting.db_driver);
            con = DriverManager.getConnection(DBSetting.db_url, DBSetting.db_user, DBSetting.db_paswd);
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (ClassNotFoundException | SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage() + " \n\nPlease contact the System Administrator for assisstance!", "ERROR", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, "The System will exit!", "ERROR", JOptionPane.ERROR_MESSAGE);
            // System.exit(0);//exit the system
        }
    }

    public Connection con() {
        try {
            return DriverManager.getConnection(DBSetting.db_url, DBSetting.db_user, DBSetting.db_paswd);
        } catch (SQLException ex) {
            Logger.getLogger(DBQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void closeConnection() {
        try {
            con.close();
            st.close();
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void ConnectToDatabase2() {
        try {
            Class.forName(DBSetting.db_driver);
            con2 = DriverManager.getConnection(DBSetting.db_url, DBSetting.db_user, DBSetting.db_paswd);
            st2 = con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (ClassNotFoundException | SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage() + " \n\nPlease contact the System Administrator for assisstance!", "ERROR", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, "The System will exit!", "ERROR", JOptionPane.ERROR_MESSAGE);
            // System.exit(0);//exit the system
        }
    }

    public void closeConnection2() {
        try {
            con2.close();
            st2.close();
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }
}
