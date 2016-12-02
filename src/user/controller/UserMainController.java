package user.controller;

import account.view.ILogInForm;
import user.view.IUserMainForm;
import user.view.UserMainForm;

public class UserMainController {
    private IUserMainForm userMainForm;
    
    public UserMainController(ILogInForm logInForm){
        userMainForm=new UserMainForm();
        userMainForm.openUserMainForm();
        logInForm.closeForm();
    }
}
