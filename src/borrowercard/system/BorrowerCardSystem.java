/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.system;

import borrowercard.interfaces.IBorrowerCardSystem;
import databasehelper.AccountSQLStatement;
import databasehelper.ConnectDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import utils.DateTimeHelper;

/**
 *
 * @author Khanh Nguyen
 */
public class BorrowerCardSystem implements IBorrowerCardSystem {

    @Override
    public boolean getStateAccount(int accountId) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_GET_STATE_OF_ACCOUNT)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (!rs.getBoolean(1)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public String getInfoAccount(Account mAccount) {
        //get info: student info or user info
        String result = "Username: " + mAccount.getUsername() + "\nEmail: " + mAccount.getEmail() + "\n";
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GET_INFO_BY_USER_ID)) {
            stmt.setInt(1, mAccount.getUserID());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result += "Tên: " + rs.getString(2) + "\n";
                result += "Địa chỉ: " + rs.getString(3) + "\nGiới tính: ";
                if (rs.getBoolean(4)) {
                    result += "Nam";
                } else {
                    result += "Nữ";
                }
                result += "\nSố điện thoại: " + rs.getString(5);
                result += "\nNgày sinh: " + DateTimeHelper.formatDate(rs.getDate(6));
                result += "\nSố CMND: " + rs.getString(7);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GET_INFO_BY_STUDENT_ID)) {
            stmt.setInt(1, mAccount.getStudentID());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result += "MSSV: " + rs.getInt(1) + "\n";
                result += "Tên: " + rs.getString(2) + "\n";
                result += "Ngày bắt đầu: " + DateTimeHelper.formatDate(rs.getDate(3)) + "\n";
                result += "Ngày kết thúc: " + DateTimeHelper.formatDate(rs.getDate(4)) + "\n";
                result += "Địa chỉ: " + rs.getString(5)
                        + "\nGiới tính: ";
                if (rs.getBoolean(6)) {
                    result += "Nam";
                } else {
                    result += "Nữ";
                }
                result += "\nNgày sinh: " + DateTimeHelper.formatDate(rs.getDate(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean checkInfoActivate(int accountId, String activateCode) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_INFO_ACTIVATE)) {
            
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String setAccountActivated() {
        return null;
    }
    
    public static void main(String[] args) {
        BorrowerCardSystem bCardSystem = new BorrowerCardSystem();
        Account mAccount = new Account();
        mAccount.setAccounrID(9);
        mAccount.setUserName("huynh");
        mAccount.setEmail("huynh@mail.com");
        mAccount.setStudentID(1);
        String b = bCardSystem.getInfoAccount(mAccount);
        System.out.println(b);
    }

    @Override
    public int checkBorrowCard(int borrowCardID) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_BORROW_CARD_EXISTED)) {
            stmt.setInt(1, borrowCardID);
            ResultSet res= stmt.executeQuery();
            if(res.next()) {
                Date expiredDay=res.getDate(5);
               // Date toDay=S
            }
        } catch (SQLException ex) {
            System.out.println("exppppppp="+ex);
        }
        return 0;
    }
    
}
