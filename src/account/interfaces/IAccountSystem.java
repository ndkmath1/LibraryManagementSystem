/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.interfaces;

import model.Account;
import model.AccountManager;
import model.Student;
import model.User;

/**
 * Define responsibility of AccountSystem
 *
 * @author Khanh Nguyen
 */
public interface IAccountSystem {
    public Account checkLogin(String email, String password);
    
    public AccountManager checkManageLogin(String username, String password);
    
    public void saveNewAccount(Account account, User user);
    
    public void saveNewStudenAccount(Account account, int studentID);
    
    public boolean isAccountExisted(String username);
    
    public int isStudentIDExisted(String studentIDNumber);
    
    public boolean isStudentHasAccount(String studentIDNumber);
    
}
