/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasehelper;

import constants.AppConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Create connection to database and close connection
 *
 * @author Khanh Nguyen
 */
public final class ConnectDatabase {

    private static Connection conn;

    /**
     * Create a connection object or get connection if exist
     *
     * @return a connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            Properties info = new Properties();
            info.put("user", AppConstants.DB_USERNAME);
            info.put("password", AppConstants.DB_PASSWORD);
            conn = DriverManager.getConnection(AppConstants.URL_CONNECTION, info);
        }
        return conn;
    }

    /**
     * Close connection
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
