package databasehelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountManager;

public final class AccountSQLStatement {
    
    public final class AccountTable {
        public static final String TABLE_NAME = "account";
        public static final String ACCOUNT_ID_COL = "account_id";
        public static final String USERNAME_COL = "username";
        public static final String EMAIL_COL = "email";
        public static final String PASSWORD_COL = "password";
    }
    
    public final class AccountManagerTable{
        public static final String TABLE_NAME = "manager_account";
        public static final String ACCOUNT_ID_COL = "account_id";
        public static final String USERNAME_COL = "username";
        public static final String PASSWORD_COL = "password";
    }
    
    public final class OtherTableHaveRelationshipWithAccountTable {
        public static final String TABLE_NAME = "othername";
    }
    
    public static final String QUERY_GET_ALL_ACCOUNT = "SELECT * FROM " + AccountTable.TABLE_NAME;
    
    public static final String QUERY_GET_ACCOUNT = "SELECT * FROM " + AccountTable.TABLE_NAME + " WHERE " + AccountTable.ACCOUNT_ID_COL + " = ?";
    
    public static final String QUERY_GET_ACCOUNT_FROM_USERNAME_OR_EMAIL="SELECT * FROM "+AccountTable.TABLE_NAME
            +" WHERE ("+AccountTable.USERNAME_COL+"=? OR "+AccountTable.EMAIL_COL+"=?) AND "+AccountTable.PASSWORD_COL+"=?";
    
    public static final String QUERY_CHECK_MANAGER_LOGIN="SELECT * FROM "+AccountManagerTable.TABLE_NAME
            +" WHERE "+AccountManagerTable.USERNAME_COL+"=? AND "+AccountManagerTable.PASSWORD_COL+"=?";
    
    public static final String QUERY_REGISTER_NEW_STUDENT_ACCOUNT="INSERT INTO account VALUES(null, ?, ?, ?, 0, null, ?)";
    
    public static final String QUERY_REGISTER_NEW_USER="INSERT INTO user VALUES(null,?, ?, ?, ?, ?, ?);";
    public static final String QUERY_REGISTER_NEW_ACCOUNT="INSERT INTO account VALUES(null, ?, ?, ?, 0, (SELECT MAX(user_id) FROM user), null)";
    
    public static final String GET_USER_MAX_ID = "SELECT * FROM user WHERE user.user_id >= ALL(SELECT user_id FROM user);";
    
    public static final String QUERY_INSERT_NEW_USER="";
    
    public static final String QUERY_CHECK_ACCOUNT_EXISTED="SELECT * FROM account WHERE username = ?";
    
    public static final String QUERY_CHECK_STUDENTID_EXISTED="SELECT student_id FROM student WHERE YEAR(begin_date)=? AND `order`=?";
    
    public static final String QUERY_CHECK_STUDENT_HAS_ACCOUNT="SELECT student.student_id FROM student, account WHERE student.student_id=account.student_id"
            + " AND YEAR(begin_date)=? AND `order`=?";

}
