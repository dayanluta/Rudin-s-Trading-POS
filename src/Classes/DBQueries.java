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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    public void StockID() {
        try {
            String sql = "Select count(stock_id) as count FROM STOCK.stock_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    
    }

    public void TransactionNo() {
        try {
            String sql = "Select count(sales_id) as count FROM SALES.sales_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int insertNewUserAccount(String username, String password, String fullname, String role) {
        //public int to convert database.insertNewUserAccount(Username, Password, fullname,role);
        try {
            String sql = "INSERT INTO USER_TB.user_table VALUES('" + username + "',md5('" + password + "'),'" + fullname + "','" + role + "','Active',now())";

            return st.executeUpdate(sql);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }

    public int CustomerDiscount(String disType, Double percentage) {
        try {
            String sql = "INSERT INTO CUSTOMER.discount_table VALUES('" + disType + "','" + percentage + "')";
            return st.executeUpdate(sql);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void insertUserAccount(String username) {
        try {
            String sql = "INSERT INTO USER_TB.user_table VALUES('" + username + "')";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Inserted Successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Insert Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void checkUsername(String username) {
        try {
            String sql = "SELECT * FROM USER_TB.user_table where username='" + username + "'";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewUser() {
        try {
            String sql = "SELECT * FROM USER_TB.user_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewNewColor() {
        try {
            String sql = "SELECT * FROM PRODUCT.color_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewCategoryName() {
        try {
            String sql = "Select * from PRODUCT.category_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//    public void getCategoryProductforUpdate(String category_name){
//        try{
//            String sql = "SELECT category_id from PRODUCT.category_table where category_name ='"+category_name+"'";
//        }catch(Exception e){
//             JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    public void viewSupplierName() {
        try {
            String sql = "Select * from SUPPLIER.supplier_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    public void viewBrandName() {
        try {
            String sql = "Select * from PRODUCT.brand_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewUnitName() {
        try {
            String sql = "Select * from PRODUCT.unit_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewPRODUCTS() {
        try {
//            String sql = "Select a.prod_code,a.prod_description,a.cost_price,a.retail_price, a.discount,a.warn_level,b.category_id, c.brand_code,"
//                    + "d.color_code from PRODUCT.product_table a, PRODUCT.category_table b, PRODUCT.brand_table c, PRODUCT.color_table d where ";
            String sql = "SELECT prod_code,category_name,brand_name,unit_name,prod_description,color_name,cost_price,retail_price,discount,warn_level from PRODUCT.product_table A,"
                    + "PRODUCT.category_table B,PRODUCT.brand_table C, PRODUCT.color_table D, PRODUCT.unit_table E WHERE A.category_id = B.category_id and A.brand_code = C.brand_code and A.color_code = D.color_code and A.unit_code = E.unit_code";

            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int updateUserStatusActive(String username) {
        try {
            String sql = "UPDATE user_tb SET status=Active WHERE username='" + username + "' ";

            return st.executeUpdate(sql);

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int updateUserAccount(String username, String fullname, String role) {
        try {
            String sql = "UPDATE USER_TB.user_table SET username='" + username + "', fullname='" + fullname + "', role='" + role + "' WHERE username='" + username + "' ";

            return st.executeUpdate(sql);

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

//    public int SalesProcess(String input_procode){
//        try{
//            String sql = "Select prod_name,prod_description,unit_name,retail_price FROM PRODUCT.product_table A, PRODUCT.unit_table B where A.unit_code = B.unit_code and prod_code = '"+input_procode+"'";
//        
//            rs = st.executeQuery(sql);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//            return 0;
//        }
//       
//    }
    public int updateUserPassword(String username, String confirm_pwrd) {
        try {
            String sql = "UPDATE USER_TB.user_table SET password=md5('" + confirm_pwrd + "') WHERE username='" + username + "' ";

            return st.executeUpdate(sql);

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int UpdateUserStatusActive(String username, String Active) {
        try {
            String sql = "UPDATE USER_TB.user_table SET Status='" + Active + "' WHERE username='" + username + "' ";

            return st.executeUpdate(sql);

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int UpdateUserStatusDeactive(String username, String Deactive) {
        try {
            String sql = "UPDATE USER_TB.user_table SET Status='" + Deactive + "' WHERE username = '" + username + "'";
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int UpdateProduct(String prodCode, String category, String brand, String description, String unit, double cost_price,
            double retail_price, double discount, int warnlevel) {
        try {
            String sql = "UPDATE PRODUCT.product_table SET prod_code='" + prodCode + "' , prod_description = '" + description + "', retail_price = '" + retail_price + "',"
                    + "cost_price='" + cost_price + "',discount = '"+discount+"' ,category_id =(Select category_id from PRODUCT.category_table where category_name ='" + category + "'),"
                    + "brand_code = (Select brand_code from PRODUCT.brand_table where brand_name = '" + brand + "'),"
                    + "unit_code = (Select unit_code from PRODUCT.unit_table where unit_name = '"+unit+"'), warn_level = '"+warnlevel+"' WHERE prod_code = '" + prodCode + "'";
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }
    
     public int UpdateBrand(String brandcode, String brandname) {
        try {
             String sql = "UPDATE PRODUCT.brand_table SET brand_code='" + brandcode + "',brand_name='"+ brandname+"' WHERE brand_code = '" + brandcode + "'";
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
     }
        
      public int UpdateColor(String colorcode, String colorname) {
        try {
             String sql = "UPDATE PRODUCT.color_table SET color_code='" + colorcode + "',color_name='"+ colorname+"' WHERE color_code = '" + colorcode + "'";
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
     }
    public int UpdateUnit(String unitcode, String unitname) {
        try {
             String sql = "UPDATE PRODUCT.unit_table SET unit_code='" + unitcode + "',unit_name='"+ unitname+"' WHERE unit_code = '" + unitcode + "'";
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
     
      public int UpdateNewSupplier(String suppliercode, String suppliername, String Address, String Email, String Contact) {
        try {
       String sql = "UPDATE SUPPLIER.supplier_table SET sup_id='" + suppliercode + "', sup_name='"+ suppliername+"', sup_address='"+ Address +"',sup_email='"+ Email +"', sup_contact='"+ Contact +"' WHERE sup_id = '" + suppliercode + "'";
//                String sql = "UPDATE SUPPLIER.supplier_table SET sup_id='" + suppliercode + "'"
            return st.executeUpdate(sql);
            
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
      }


    public void checkProduct_code(String prod_code) {
        try {
            String sql = "SELECT * FROM PRODUCT.product_table where prod_code='" + prod_code + "'";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setCategoryName() {
        try {
            String sql = "SELECT category_name FROM PRODUCT.category_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setNewColor() {
        try {
            String sql = "SELECT color_name FROM PRODUCT.color_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setBrandName() {
        try {
            String sql = "SELECT brand_name FROM PRODUCT.brand_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setNewUnitName() {
        try {
            String sql = "SELECT unit_name FROM PRODUCT.unit_table";
            rs = st.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setSupplierName() {
        try {
            String sql = "SELECT sup_name FROM SUPPLIER.supplier_table";
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int insertNewCategory(String categorycode, String categoryname) {
        try {
            String sql = "Insert into PRODUCT.category_table VALUES ('" + categorycode + "','" + categoryname + "')";
            return st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

//      public void categorycodecount(String categorycode){
//          try{
//              String sql = "Select count(category_id = '"+categorycode+"') as count from PRODUCT.category_table";
////              return st.executeUpdate(sql);
//          }catch(Exception e){
//              JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
////              return 0;
//          }
//      }
    public int insertNewBrand(String brandcode, String brandname) {
        try {
            String sql = "Insert into PRODUCT.brand_table VALUES ('" + brandcode + "','" + brandname + "')";
            return st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int insertNewSupplierName(String suppliercode, String suppliername, String Address, String email, String contact) {
        try {
            String sql = "Insert into SUPPLIER.supplier_table VALUES ('" + suppliercode + "', '" + suppliername + "', '" + Address + "', '" + email + "','" + contact + "','now()')";
            return st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int insertNewUnitName(String unitcode, String unitname) {
        try {
            String sql = "Insert into PRODUCT.unit_table VALUES ('" + unitcode + "', '" + unitname + "')";
            return st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int insertNewColor(String colorcode, String colorname) {
        try {
            String sql = "Insert into PRODUCT.color_table VALUES('" + colorcode + "','" + colorname + "')";
            return st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void searchProductForStocks(String product_code) {
        try {
            String sql = "SELECT prod_code,category_name,brand_name,color_name,prod_description,color_name,cost_price,retail_price,invoicenumber,prod_quantity,date_purchase,expirationdate,unit_name,sup_name from PRODUCT.product_table A,"
                    + "PRODUCT.category_table B,PRODUCT.brand_table C, PRODUCT.color_table D , PRODUCT.unit_table E ,SUPPLIER.supplier_table F "
                    + "WHERE A.category_id = B.category_id and A.brand_code = C.brand_code and  A.color_code = D.color_code and A.unit_code = E.unit_code and A.sup_id = F.sup_id and A.prod_code='" + product_code + "'";
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void salesProcess(String procode) {
        try {
            String sql = "Select prod_code,prod_description,unit_name,retail_price FROM PRODUCT.product_table A, PRODUCT.unit_table B WHERE A.unit_code = B.unit_code and A.prod_code = '" + procode + "'";
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

}
