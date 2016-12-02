package account.controller;

import account.view.ILogInForm;
import account.view.ISignUpForm;
import account.view.SignUpForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SignUpController {

    private ILogInForm loginForm;
    private ISignUpForm signUpForm;

    public SignUpController(ILogInForm loginForm) {
        this.loginForm = loginForm;
        loginForm.setVisibleForm(false);
        signUpForm = new SignUpForm();
        signUpForm.setVisibleForm(true);
        signUpForm.setButtonBackActionListener(new BackButtonActionListener());
    }

    private class BackButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginForm.setVisibleForm(true);
            signUpForm.closeForm();
        }

    }

}
