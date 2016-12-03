package account.system;

import account.interfaces.IAccountSystem;
import databasehelper.AccountSQLStatement;
import databasehelper.ConnectDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.AccountManager;
import model.Student;
import model.User;

public class AccountSystem implements IAccountSystem {

    @Override
    public Account checkLogin(String username, String password) {
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_GET_ACCOUNT_FROM_USERNAME_OR_EMAIL);            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            ResultSet result= preparedStatement.executeQuery();
            if(result.next()){
                Account account=new Account();
                account.setUserName(result.getString(1));
                account.setPassword(result.getString(2));
                account.setPassword(result.getString(3));
                return account;
            }
            else return null;
        } catch (SQLException ex) {
            System.out.println("ex account1"+ex);
        }
        return null;
    }

    @Override
    public AccountManager checkManageLogin(String username, String password) {
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_CHECK_MANAGER_LOGIN);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result= preparedStatement.executeQuery();
            if(result.next()){
                AccountManager accountManager=new AccountManager();
                accountManager.setUsername(username);
                accountManager.setPassword(password);
                accountManager.setTypeManager(result.getBoolean(9));
                return accountManager;
            }
            else return null;
        } catch (SQLException ex) {
            System.out.println("ex account2"+ex);
        }
        return null;
    }

    @Override
    public void saveNewAccount(Account account, User user) {
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_REGISTER_NEW_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());;
            preparedStatement.setBoolean(3, user.getGender());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setDate(5, new java.sql.Date(user.getBirthDay().getTime()));
            preparedStatement.setString(6, user.getNationalID());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ex account5= "+ex);
        }
        
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_REGISTER_NEW_ACCOUNT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ex account5= "+ex);
        }

    }

    @Override
    public void saveNewStudenAccount(Account account, int studentID) {
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_REGISTER_NEW_STUDENT_ACCOUNT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setInt(4, studentID);
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("ex account6"+ex);
        }
    }

    @Override
    public boolean isAccountExisted(String username) {
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_CHECK_ACCOUNT_EXISTED);
            preparedStatement.setString(1, username);
            ResultSet result= preparedStatement.executeQuery();
            if(result.next()) return true;
            else return false;
        } catch (SQLException ex) {
             System.out.println("ex account3="+ex);
        }
        return false;
    }

    @Override
    public int isStudentIDExisted(String studentIDNumber) {
        StudentID studentID=new StudentID(studentIDNumber);
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_CHECK_STUDENTID_EXISTED);
            preparedStatement.setInt(1, studentID.getYear());         
            preparedStatement.setInt(2, studentID.getOrder());
            ResultSet result= preparedStatement.executeQuery();
            if(result.next()) return result.getInt(1);
            else return 0;
        } catch (SQLException ex) {
             System.out.println("ex account4="+ex);
        }
        return 0;
    }

    @Override
    public boolean isStudentHasAccount(String studentIDNumber) {
        StudentID studentID=new StudentID(studentIDNumber);
        try {
            PreparedStatement preparedStatement= ConnectDatabase.getConnection().prepareStatement(AccountSQLStatement.QUERY_CHECK_STUDENT_HAS_ACCOUNT);
            preparedStatement.setInt(1, studentID.getYear());
            preparedStatement.setInt(2, studentID.getOrder());
            ResultSet result= preparedStatement.executeQuery();
            if(result.next()) return true;
            else return false;
        } catch (SQLException ex) {
             System.out.println("ex account4="+ex);
        }
        return false;
    }
    
}
