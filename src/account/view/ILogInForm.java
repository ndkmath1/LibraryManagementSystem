/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * The ILogInForm list methods for LoginForm
 *
 * @author Khanh Nguyen
 */
public interface ILogInForm {

    public void setLoginButtonActionListener(ActionListener listener);

    public String getUserNameEmailOnLoginForm();

    public String getPasswordOnLoginForm();

    public void setBackButtonActionListener(ActionListener listener);

    public void setRegisterButtonActionListener(ActionListener listener);

    public void closeForm();

    public void setVisibleForm(boolean isVisible);

    public void noticeError(String title, String message);

    public void noticeSuccessfully(String title, String message);

    public int getComboboxSelectedOnLoginForm();
    
    public void setTextFieldUserNameKeyAction(KeyListener keyListener);
    
    public void setTextFieldPassWordKeyAction(KeyListener keyListener);
    
    public void doClickButtonLogin();

}
