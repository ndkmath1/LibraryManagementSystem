/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controller;

import account.controller.LogInController;
import account.controller.SignUpController;
import account.view.ILogInForm;
import account.view.LogInForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
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
        mainForm.setButtonExitActionListener(new ExitButtonActionListener());
        mainForm.setButtonRegisterActionListener(new ButtonRegisterListener());
    }
    
    private class LoginButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainForm.setVisibleForm(false);
            new LogInController(mainForm);
        }
    
    }
    
    private class ExitButtonActionListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            if (JOptionPane.showConfirmDialog(mainForm.getMainFormInstance(), "Bạn có chắc chắn muốn thoát?", "Kết thúc", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
    }
    
    private class ButtonRegisterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new SignUpController(mainForm);
        }
        
    }
    
    
}
