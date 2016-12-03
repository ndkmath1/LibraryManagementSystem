package model;


public class Account {
    
    private String username;
    private String email;
    private String password;
    private boolean status;
    private int accounrID;
    private int userID;
    
    public Account () {}
    
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status=false;
        this.accounrID=0;
        this.userID=0;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAccounrID() {
        return accounrID;
    }

    public void setAccounrID(int accounrID) {
        this.accounrID = accounrID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    
}
