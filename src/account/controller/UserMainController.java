package account.controller;

import account.view.ILogInForm;
import account.view.IUserMainForm;
import account.view.UserMainForm;

public class UserMainController {
    private IUserMainForm userMainForm;
    
    public UserMainController(ILogInForm logInForm){
        userMainForm=new UserMainForm();
        userMainForm.openUserMainForm();
        logInForm.closeForm();
    }
}
