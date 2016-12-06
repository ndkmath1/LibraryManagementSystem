package databasehelper;

import account.system.AccountSystem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountManager;

public final class AccountSQLStatement {

    public final class AccountTable {

        public static final String TABLE_NAME = "account";
        public static final String ACCOUNT_ID_COL = "id";
        public static final String USERNAME_COL = "username";
        public static final String EMAIL_COL = "email";
        public static final String STATE_COL = "status";
        public static final String PASSWORD_COL = "password";
        public static final String STUDENT_ID_COL = "student_id";
        public static final String USER_ID_COL = "user_id";
    }

    public final class AccountManagerTable {

        public static final String TABLE_NAME = "manager_account";
        public static final String ACCOUNT_ID_COL = "account_id";
        public static final String USERNAME_COL = "username";
        public static final String PASSWORD_COL = "password";
    }

    public final class UserTable {

        public static final String TABLE_NAME = "user";
        public static final String USER_ID_COL = "user_id";
        public static final String NAME_COL = "name";
        public static final String ADDRESS_COL = "address";
        public static final String GENDER_COL = "gender";
        public static final String PHONE_COL = "phone_number";
        public static final String BIRTHDAY_COL = "birthday";
        public static final String NATIONAL_COL = "identification";
    }

    public final class StudentTable {

        public static final String TABLE_NAME = "student";
        public static final String STUDENT_ID_COL = "student_id";
        public static final String NAME_COL = "name";
        public static final String BEGIN_DATE_COL = "begin_date";
        public static final String END_DATE_COL = "end_date";
        public static final String ADRESS_COL = "address";
        public static final String GENDER_COL = "gender";
        public static final String BIRTH_DAY_COL = "birthday";
        public static final String ORDER_COL = "order";
    }

    public final class BorrowerCardTable {

        public static final String TABLE_NAME = "borrower_card";
        public static final String BORROWER_CARD_ID_COL = "card_id";
        public static final String ACCOUNT_ID_COL = "account_id";
        public static final String ACTIVATE_CODE_COL = "activate_code";
        public static final String RELEASE_DATE_COL = "release_date";
        public static final String EXPIRED_DATE_COL = "expired_date";
    }

    public static final String QUERY_GET_ALL_ACCOUNT = "SELECT * FROM " + AccountTable.TABLE_NAME;

    public static final String QUERY_GET_ACCOUNT = "SELECT * FROM " + AccountTable.TABLE_NAME + " WHERE "
            + AccountTable.ACCOUNT_ID_COL + " = ?";

    public static final String QUERY_GET_ACCOUNT_FROM_USERNAME_OR_EMAIL = "SELECT * FROM " + AccountTable.TABLE_NAME
            + " WHERE (" + AccountTable.USERNAME_COL + "=? OR " + AccountTable.EMAIL_COL + "=?) AND "
            + AccountTable.PASSWORD_COL + "=?";

    public static final String QUERY_CHECK_MANAGER_LOGIN = "SELECT * FROM " + AccountManagerTable.TABLE_NAME
            + " WHERE " + AccountManagerTable.USERNAME_COL + "=? AND " + AccountManagerTable.PASSWORD_COL + "=?";

    public static final String QUERY_REGISTER_NEW_STUDENT_ACCOUNT = "INSERT INTO "
            + AccountTable.TABLE_NAME + " VALUES(null, ?, ?, ?, 0, null, ?)";

    public static final String QUERY_REGISTER_NEW_USER = "INSERT INTO "
            + UserTable.TABLE_NAME + " VALUES(null,?, ?, ?, ?, ?, ?);";

    public static final String QUERY_REGISTER_NEW_ACCOUNT = "INSERT INTO "
            + AccountTable.TABLE_NAME + " VALUES(null, ?, ?, ?, 0, (SELECT MAX(" + UserTable.USER_ID_COL + ") FROM "
            + UserTable.TABLE_NAME + "), null)";

    public static final String QUERY_CHECK_ACCOUNT_EXISTED = "SELECT * FROM "
            + AccountTable.TABLE_NAME + " WHERE " + AccountTable.USERNAME_COL + "=?";

    public static final String QUERY_CHECK_STUDENTID_EXISTED = "SELECT " + StudentTable.STUDENT_ID_COL + " FROM "
            + StudentTable.TABLE_NAME + " WHERE YEAR(" + StudentTable.BEGIN_DATE_COL + ")=? AND `"
            + StudentTable.ORDER_COL + "`=?";

    public static final String QUERY_CHECK_STUDENT_HAS_ACCOUNT = "SELECT "
            + StudentTable.TABLE_NAME + "." + StudentTable.STUDENT_ID_COL + " FROM " + StudentTable.TABLE_NAME + ", " + AccountTable.TABLE_NAME + " WHERE "
            + StudentTable.TABLE_NAME + "." + StudentTable.STUDENT_ID_COL + "=" + AccountTable.TABLE_NAME + "." + AccountTable.STUDENT_ID_COL
            + " AND YEAR(begin_date)=? AND `order`=?";

    
    public static final String QUERY_GET_ALL_BORROWER_CARD = "SELECT * FROM " + BorrowerCardTable.TABLE_NAME;

    public static final String QUERY_GET_BORROWER_CARD_BY_ID = "SELECT * FROM " + BorrowerCardTable.TABLE_NAME + " WHERE " + BorrowerCardTable.BORROWER_CARD_ID_COL + " = ?";
    
    public static final String QUERY_GET_STATE_OF_ACCOUNT = "SELECT " + AccountTable.STATE_COL + " FROM  " + AccountTable.TABLE_NAME + " WHERE  " + AccountTable.ACCOUNT_ID_COL + " = ?";
    
    public static final String SET_ACCOUNT_IS_ACTIVATED = "UPDATE " + AccountTable.TABLE_NAME + " SET " + AccountTable.STATE_COL + " = 1 WHERE " + AccountTable.ACCOUNT_ID_COL + " = ?";
    
    public static final String GET_INFO_BY_USER_ID = "SELECT * FROM " + UserTable.TABLE_NAME + " WHERE " + UserTable.USER_ID_COL + " = ?";
    
    public static final String GET_INFO_BY_STUDENT_ID = "SELECT * FROM " + StudentTable.TABLE_NAME + " WHERE " + StudentTable.STUDENT_ID_COL + " = ?";
    
    public static final String CHECK_INFO_ACTIVATE = "SELECT * FROM " + BorrowerCardTable.TABLE_NAME + " WHERE " + BorrowerCardTable.ACCOUNT_ID_COL + " = ? AND " + BorrowerCardTable.ACTIVATE_CODE_COL + " '?' ";
    
}
