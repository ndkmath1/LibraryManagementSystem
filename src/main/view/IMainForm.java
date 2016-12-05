/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 *
 * @author Khanh Nguyen
 */
public interface IMainForm {
    
    public void closeForm();
    
    public void setVisibleForm(boolean isVisible);
    
    public void setLogInButtonActionListener(ActionListener listener);
    
    public void setButtonExitActionListener(WindowListener listener);
    
    public MainForm getMainFormInstance();
    
    public void setButtonRegisterActionListener(ActionListener listener);
    
}
