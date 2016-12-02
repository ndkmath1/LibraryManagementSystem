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

/**
 *
 * @author Khanh Nguyen
 */
public class LogInController {
    private ILogInForm loginForm;
    //example for using subsystem
    IAccountSystem s = AccountSystemFactory.getAccountSystem();
    
    public LogInController () {
        loginForm = new LogInForm();
        loginForm.setVisibleForm(true);
        loginForm.setLoginButtonActionListener(new LogInButtonActionListener());
    }
    
    private class LogInButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
}
