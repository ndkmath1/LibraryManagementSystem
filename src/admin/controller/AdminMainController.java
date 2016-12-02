package admin.controller;

import account.view.ILogInForm;
import admin.view.AdminMainForm;
import admin.view.IAdminMainForm;

public class AdminMainController {
    private IAdminMainForm adminMainForm;
    
    public AdminMainController(ILogInForm logInForm){
        adminMainForm=new AdminMainForm();
        logInForm.closeForm();
        adminMainForm.openAdminMainForm();
    }
}
