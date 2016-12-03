/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

import databasehelper.ConnectDatabase;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khanh Nguyen
 */
public final class AppConstants {

    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "123456";
    public static final String DB_NAME = "lms";
    public static final String SERVER_NAME = "localhost";
    public static final int PORT_NUMBER = 3306;
    public static final String DBMS = "mysql";
    public static final String URL_CONNECTION = "jdbc:" + DBMS + "://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME;

    public static void main(String[] args) {
        try {
            ConnectDatabase.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AppConstants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
