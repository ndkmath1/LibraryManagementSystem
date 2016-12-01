/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasehelper;

/**
 * 
 * @author Khanh Nguyen
 */
public final class AccountSQLStatement {
    
    public final class AccountTable {
        public static final String TABLE_NAME = "account";
        public static final String ACCOUNT_ID_COL = "account_id";
        public static final String USERNAME_COL = "username";
        public static final String EMAIL_COL = "email";
        public static final String PASSWORD_COL = "password";
    }
    
    public final class OtherTableHaveRelationshipWithAccountTable {
        public static final String TABLE_NAME = "othername";
    }
    
    public static final String QUERY_GET_ALL_ACCOUNT = "SELECT * FROM " + AccountTable.TABLE_NAME;
    
    public static final String QUERY_GET_ACCOUNT = "SELECT * FROM " + AccountTable.TABLE_NAME + " WHERE " + AccountTable.ACCOUNT_ID_COL + " = ?";
    
    
    
}
