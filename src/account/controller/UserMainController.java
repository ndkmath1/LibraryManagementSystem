package account.controller;

import account.view.ILogInForm;
import account.view.IUserMainForm;
import account.view.UserMainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Account;

public class UserMainController {

    private IUserMainForm userMainForm;
    private Account mAccount;
    private ILogInForm  loginForm;

    public UserMainController(ILogInForm logInForm, Account mAccount) {
        this.loginForm = logInForm;
        this.mAccount = mAccount;
        userMainForm = new UserMainForm();
        userMainForm.openUserMainForm();
        logInForm.setVisibleForm(false);
        userMainForm.setMenuItemActivateAccountListener(new ActivateAccountListener());
        userMainForm.setMenuItemLogOutListener(new LogOutActionListener());
    }
    
    private class ActivateAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new ActivateAccountController(userMainForm, mAccount);
        }
        
    }
    
    private class LogOutActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginForm.setVisibleForm(true);
            userMainForm.setVisibleForm(false);
        }
        
    }
}
