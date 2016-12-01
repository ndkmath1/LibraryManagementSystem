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
public class LoginController {
    private ILogInForm loginForm;
    //example for using subsystem
    IAccountSystem s = AccountSystemFactory.getAccountSystem();
    
    public LoginController () {
        loginForm = new LogInForm();
        loginForm.setLoginButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
}
