/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * The Account class contain information of a account
 * @author Khanh Nguyen
 */
public class Account {
    
    private String username;
    private String email;
    private String password;
    
    public Account () {}
    
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
