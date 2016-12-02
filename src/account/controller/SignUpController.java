package account.controller;

import account.view.ISignUpForm;
import account.view.SignUpForm;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SignUpController {
    private ISignUpForm signUpForm;
    
    public SignUpController(){
        signUpForm=new SignUpForm();
       
    }
}
