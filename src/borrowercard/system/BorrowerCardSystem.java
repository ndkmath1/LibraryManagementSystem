/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.system;

import account.system.AccountSystem;
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
import utils.BorrowerCardHelper;
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

    @Override
    public boolean checkInfoActivate(int accountId, String activateCode) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_INFO_ACTIVATE)) {
            stmt.setInt(1, accountId);
            stmt.setString(2, activateCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("true");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean setAccountActivated(int accountId) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.SET_ACCOUNT_IS_ACTIVATED)) {
            stmt.setInt(1, accountId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public static void main(String[] args) {
//        BorrowerCardSystem bCardSystem = new BorrowerCardSystem();
//        Account mAccount = new Account();
//        mAccount.setAccounrID(9);
//        mAccount.setUserName("huynh");
//        mAccount.setEmail("huynh@mail.com");
//        mAccount.setStudentID(1);
//        String b = bCardSystem.getInfoAccount(mAccount);
//        System.out.println(b);
//    }
    @Override
    public boolean isAccountHasBorrowerCard(int accountId) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_ACCOUNT_HAS_BORROWER_CARD)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

   @Override
    public int checkBorrowCard(int borrowCardID) {
        System.out.println("cardid="+borrowCardID);
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_BORROW_CARD_EXISTED)) {
            stmt.setInt(1, borrowCardID);
            ResultSet res= stmt.executeQuery();
            if(res.next()) {
                Date expiredDay=res.getDate(5);
                Date toDay=new Date();
                if(expiredDay.compareTo(toDay)<0) return 0;
                else return 1;
            }
            return -1;
        } catch (SQLException ex) {
            System.out.println("exppppppp="+ex);
        }
        return -1;
    }

    @Override
    public String getInfoUser(String id) {
        String result = "";
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GET_USER_BY_ID)) {
            stmt.setString(1, id);
            System.out.println("user: " + stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result += "Tên: " + rs.getString(2) + "\n";
                result += "Địa chỉ: " + rs.getString(3) + "\nGiới tính: ";
                if (rs.getBoolean(4)) {
                    result += "Nam";
                } else {
                    result += "Nữ";
                }
                result += "\nNgày sinh: " + DateTimeHelper.formatDate(rs.getDate(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GET_STUDENT_BY_ID)) {
            stmt.setString(1, id);
            System.out.println("student: " + stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result += "MSSV: " + rs.getInt(1) + "\n";
                result += "Tên: " + rs.getString(2) + "\n";
                result += "Niên khóa: " + DateTimeHelper.formatDate(rs.getDate(3)) + " - " + DateTimeHelper.formatDate(rs.getDate(4)) + "\n";
                result += "Địa chỉ: " + rs.getString(5) + "\nGiới tính: ";
                if (rs.getBoolean(6)) {
                    result += "Nam";
                } else {
                    result += "Nữ";
                }
                result += "\nNgày sinh: " + DateTimeHelper.formatDate(rs.getDate(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int checkStateBorrowerCard(String id) {
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_HAS_BORROWERCARD_IDENTIFICATION)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return -1;//Non BorrowerCard
            } else {
                PreparedStatement st1 = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GET_USER_INFO_BY_IDEN);
                st1.setString(1, id);
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) {
                    return rs1.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.CHECK_HAS_BORROWERCARD_STUDENT_ID)) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return -1;//Non borrower card
            } else {
                PreparedStatement st1 = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GET_ACCOUNT_ID_BY_ST_ID);
                st1.setInt(1, Integer.parseInt(id));
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) {
                    return rs1.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;//
    }

    @Override
    public String issuedBorrowerCard(int accountId) {
        String result = "";
        try (PreparedStatement stmt = ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.GEN_BORROWER_CARD)) {
            int bCardId = BorrowerCardHelper.generateBorrowerCardId();
            stmt.setInt(1, bCardId);
            stmt.setInt(2, accountId);
            String activateCode = BorrowerCardHelper.generateActivateCode();
            stmt.setString(3, activateCode);
            String releaseDate = DateTimeHelper.formatDateSQL(BorrowerCardHelper.getReleaseDate());
            stmt.setString(4, releaseDate);
            String expiredDate = DateTimeHelper.formatDateSQL(BorrowerCardHelper.getExpiredDate());
            stmt.setString(5, expiredDate);
            System.out.println("bCard: " + stmt.toString());
            int n = stmt.executeUpdate();
            if (n >= 1) {
                result = "Mã thẻ mượn: " + bCardId;
                result += "\nMã kích hoạt: " + activateCode;
                result += "\nNgày phát hày: " + releaseDate;
                result += "\nHạn sử dụng: " + expiredDate;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCardSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
