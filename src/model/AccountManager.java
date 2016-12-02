package model;

public class AccountManager {
    private String username;
    private String password;
    private boolean typeManager;
    
    public AccountManager(){
        
    }

    public AccountManager(String username, String password,boolean typeManager) {
        this.username = username;
        this.password = password;
        this.typeManager=typeManager;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeManager(boolean typeManager) {
        this.typeManager = typeManager;
    }
    
    public boolean getTypeManager(){
        return this.typeManager;
    }
    
}
