/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controller;

import account.controller.LogInController;
import account.view.ILogInForm;
import account.view.LogInForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.view.IMainForm;
import main.view.MainForm;

/**
 *
 * @author Khanh Nguyen
 */
public class MainController {
    private IMainForm mainForm;
    private ILogInForm loginForm;
    
    public MainController() {
        mainForm = new MainForm();
        mainForm.setVisibleForm(true);
        mainForm.setLogInButtonActionListener(new LoginButtonActionListener());
        mainForm.setExitButtonActionListener(new ExitButtonActionListener());
    }
    
    private class LoginButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new LogInController();
        }
    
    }
    
    private class ExitButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //nontifies before
            mainForm.nontifiesUserExitApp();
        }
        
    }
    
    
}
