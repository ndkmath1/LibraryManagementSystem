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
public final class BorrowerCardSQLStatement {
    
    public final class BorrowerCardTable {
        public static final String TABLE_NAME = "borrower_card";
        public static final String BORROWER_CARD_ID_COL = "borrowercard_id";
        public static final String ACCOUNT_ID_COL = "account_id";
    }
    
    public static final String QUERY_GET_ALL_BORROWER_CARD = "SELECT * FROM " + BorrowerCardTable.TABLE_NAME;
    
}
