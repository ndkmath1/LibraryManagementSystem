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
import book.controller.LibrarianMainController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import main.view.IMainForm;
import model.Account;
import model.AccountManager;
import utils.AccountHelper;

public class LogInController {
    
    private ILogInForm loginForm;
    private IMainForm mainForm;
    private IAccountSystem accountSystem = AccountSystemFactory.getAccountSystem();

    public LogInController(IMainForm mainForm) {
        this.mainForm = mainForm;
        loginForm = new LogInForm();
        loginForm.setVisibleForm(true);
        loginForm.setLoginButtonActionListener(new LogInButtonActionListener());
        loginForm.setBackButtonActionListener(new BackButtonActionListener());
        loginForm.setRegisterButtonActionListener(new RegisterButtonActionListener());
        loginForm.setTextFieldUserNameKeyAction(new TextFieldUsernameKeyListener());
        loginForm.setTextFieldPassWordKeyAction(new TextFieldPasswordKeyListener());
    }

    private class LogInButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginForm.getUserNameEmailOnLoginForm();
            if ((!AccountHelper.validateEmail(username))&&(!AccountHelper.validateUsername(username))) {
                loginForm.noticeError(LoginConstants.ERROR_FORMAT_TITLE, LoginConstants.ERROR_EMAIL_MESSAGE);
                return;
            }
            String password = loginForm.getPasswordOnLoginForm();
            if (!AccountHelper.validatePassword(password)) {
                loginForm.noticeError(LoginConstants.ERROR_FORMAT_TITLE, LoginConstants.ERROR_PASSWORD_MESSAGE);
                return;
            }
            if (loginForm.getComboboxSelectedOnLoginForm() == 0) {
                Account account = accountSystem.checkLogin(username, AccountHelper.getMD5encrypt(password));
                if (account == null) {
                    loginForm.noticeError(LoginConstants.ERROR_ACCOUNT_NOT_FOUND_TITLE, LoginConstants.ERROR_ACCONT_NOT_FOUND);
                } else {
                    new UserMainController(loginForm, account);
                }
            } else {
                AccountManager accountManager = accountSystem.checkManageLogin(username, AccountHelper.getMD5encrypt(password));
                if (accountManager == null) {
                    loginForm.noticeError(LoginConstants.ERROR_ACCOUNT_NOT_FOUND_TITLE, LoginConstants.ERROR_ACCONT_NOT_FOUND);
                } else if (!accountManager.getTypeManager()) {
                    new LibrarianMainController(loginForm);
                } else {
                    new AdminMainController(loginForm);
                }
            }
        }

    }

    private class BackButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginForm.closeForm();
            mainForm.setVisibleForm(true);
        }

    }

    private class RegisterButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new SignUpController(loginForm);
        }

    }
    
    private class TextFieldUsernameKeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                JComponent component = (JComponent)e.getSource();
                component.transferFocus();
            } 
        }
        
    }
    
     private class TextFieldPasswordKeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                JComponent component = (JComponent)e.getSource();
                component.transferFocus();
                loginForm.doClickButtonLogin();
            } 
        }
        
    }

}
