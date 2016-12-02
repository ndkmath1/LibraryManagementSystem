/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.controller;

import account.factory.AccountSystemFactory;
import account.interfaces.IAccountSystem;
import account.view.LogInForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import account.view.ILogInForm;
import admin.controller.AdminMainController;
import admin.view.AdminMainForm;
import constants.LoginConstants;
import librarian.controller.LibrarianMainController;
import model.Account;
import model.AccountManager;
import user.controller.UserMainController;
import utils.AccountHelper;

public class LoginController {
    private ILogInForm loginForm;
    private IAccountSystem accountSystem = AccountSystemFactory.getAccountSystem();
    
    public LoginController () {
        loginForm = new LogInForm();
        loginForm.setLoginButtonActionListener(new LoginActionListener());
        
    }
    public void initLoginForm(){
        loginForm = new LogInForm();
        loginForm.setLoginButtonActionListener(new LoginActionListener());
    }
    
    private class LoginActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String username=loginForm.getUserNameEmailOnLoginForm();
            if(!AccountHelper.validateUsername(username)){
                loginForm.noticeError(LoginConstants.ERROR_FORMAT_TITLE, LoginConstants.ERROR_USERNAME_MESSAGE);
                return;
            }
            else if(!AccountHelper.validateEmail(username)){
                loginForm.noticeError(LoginConstants.ERROR_FORMAT_TITLE, LoginConstants.ERROR_EMAIL_MESSAGE);
                return;
            }
            String password=loginForm.getPasswordOnLoginForm();
            if(!AccountHelper.validatePassword(password)){
                loginForm.noticeError(LoginConstants.ERROR_FORMAT_TITLE, LoginConstants.ERROR_PASSWORD_MESSAGE);
                return;
            }
            if(loginForm.getComboboxSelectedOnLoginForm()==0){
                Account account=accountSystem.checkLogin(username, password);
                if(account==null){
                    loginForm.noticeError(LoginConstants.ERROR_ACCOUNT_NOT_FOUND_TITLE, LoginConstants.ERROR_ACCONT_NOT_FOUND);
                }
                else{
                    new UserMainController(loginForm);
                }
            }
            else{
                AccountManager accountManager=accountSystem.checkManageLogin(username, password);
                if(accountManager==null){
                    loginForm.noticeError(LoginConstants.ERROR_ACCOUNT_NOT_FOUND_TITLE, LoginConstants.ERROR_ACCONT_NOT_FOUND);
                }
                else{
                    if(!accountManager.getTypeManager()) {
                        new LibrarianMainController(loginForm);
                    }
                    else new AdminMainController(loginForm);
                }
            }
        }
        
    }
}
