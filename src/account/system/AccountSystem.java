/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Khanh Nguyen
 */
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
                accountManager.setTypeManager(result.getBoolean(4));
                return accountManager;
            }
            else return null;
        } catch (SQLException ex) {
            System.out.println("ex account2"+ex);
        }
        return null;
    }
    
    
}
