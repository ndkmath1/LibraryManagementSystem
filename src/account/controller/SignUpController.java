package account.controller;

import account.factory.AccountSystemFactory;
import account.interfaces.IAccountSystem;
import account.view.ILogInForm;
import account.view.ISignUpForm;
import account.view.SignUpForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import model.Account;
import model.User;
import utils.AccountHelper;
import utils.UserInfoHelper;

public class SignUpController {

    private ILogInForm loginForm;
    private ISignUpForm signUpForm;
    private IAccountSystem accountSystem;
    
    public SignUpController(ILogInForm loginForm) {
        this.loginForm = loginForm;
        loginForm.setVisibleForm(false);
        signUpForm = new SignUpForm();
        signUpForm.setVisibleForm(true);
        accountSystem=AccountSystemFactory.getAccountSystem();
        signUpForm.setButtonBackActionListener(new BackButtonActionListener());
        signUpForm.setRadioButtonNormalActionListener(new RadioButtonNormalActionListener());
        signUpForm.setRadioButtonStudentActionListener(new RadioButtonStudentActionListener());
        signUpForm.setButtonRegisterActionListener(new RegisterButtonActionListener());
    }
    
    
    /////////////////////////////////////////////////////////////////////
    private class RegisterButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(signUpForm.getTypeOfRegisterOnSingupForm()){ 
            //username
            String username=signUpForm.getUsernameOnSingupForm();
            if(!AccountHelper.validateUsername(username)){ 
                signUpForm.noticeError("Tài khoản không đúng!","Sai cú pháp nhập");
                return;
            }
            //password
            String password=signUpForm.getPasswordOnSingupForm();
            if(!AccountHelper.validatePassword(password)){
                signUpForm.noticeError("Mật khẩu không đúng!","Sai cú pháp nhập");
                return;
            }
            //name
            String name=signUpForm.getNameOnSingupForm();
            if(!UserInfoHelper.validateName(name)) {
                signUpForm.noticeError("Tên không đúng!","Sai cú pháp nhập");
                return;
            }        
            //birthday
            Date birthDay=signUpForm.getComboboxBirthdayonSignForm();
            //gender
            boolean gender=signUpForm.getGenderOnSingupForm();
            //national id
            String nationalID=signUpForm.getNationalOnSignupForm();
            if(!UserInfoHelper.validateNationalID(nationalID)){
                signUpForm.noticeError("CMND không đúng!","Sai cú pháp nhập");
                return;
            }
            if(!UserInfoHelper.validateName(name)) {
                signUpForm.noticeError("Tên không đúng!","Sai cú pháp nhập");
                return;
            }     
            //phone
            String phone=signUpForm.getPhoneOnSingupForm();
            if((!phone.equals(""))||phone!=null){
                if(!UserInfoHelper.validatePhone(phone)){
                    signUpForm.noticeError("Số điện thoại không đúng!","Sai cú pháp nhập");
                    return;
                }
            }
            //email
            String email=signUpForm.getEmailOnSingupForm();
//            if(email!=null||(!email.equals(""))){
//                if(!AccountHelper.validateEmail(email)){
//                    signUpForm.noticeError("Email không đúng!","Sai cú pháp nhập");
//                    return;
//                }
//            }
            //address
            String address=signUpForm.getAddressOnSingupForm();
//            if(address!=null||(!address.equals(""))){
//                if(!UserInfoHelper.validateAddress(address)){
//                    signUpForm.noticeError("Email không đúng!","Sai cú pháp nhập");
//                    return;
//                }
//            }
            if(accountSystem.isAccountExisted(username)) {
                signUpForm.noticeError("Lỗi đăng ký", "Tài khoản đã tồn tại");
                return;
            }
            Account account=new Account(username, email, password);
            User user=new User(name, address, gender, phone, birthDay, nationalID);
            accountSystem.saveNewAccount(account, user);
            signUpForm.noticeSuccessfully("Thành công", "Đăng ký thành công!");
        }
            else{
                 //student id
                 String studentIDNumber=signUpForm.getStudentIDOnSingupForm();
                 if(!UserInfoHelper.validateStudentID(studentIDNumber)){
                     signUpForm.noticeError("Mã số sinh viên không đúng!","Sai cú pháp nhập");
                     return;
                 }
                 //username
                 String username= signUpForm.getUsernameOnSingupForm();
                 if(!AccountHelper.validateUsername(username)){ 
                     signUpForm.noticeError("Tài khoản không đúng!","Sai cú pháp nhập");
                     return;
                 }
                 //password
                 String password=signUpForm.getPasswordOnSingupForm();
                 if(!AccountHelper.validatePassword(password)){
                     signUpForm.noticeError("Mật khẩu không đúng!","Sai cú pháp nhập");
                     return;
                 }

                 int studentID=accountSystem.isStudentIDExisted(studentIDNumber);
                 if(studentID==0){
                     signUpForm.noticeError("Mã số sinh viên không đúng", "Lỗi đăng ký");
                     return;
                 }
                 else{
                     if(accountSystem.isAccountExisted(username)){
                         signUpForm.noticeError("Lỗi đăng ký", "Tài khoản đã tồn tại");
                         return;
                     }
                     else {
                         if(accountSystem.isStudentHasAccount(studentIDNumber)){
                             signUpForm.noticeError("Lỗi đăng ký", "Sinh viên đã có tài khoản");
                             return;
                         }
                         Account account=new Account(username, username, password);
                         accountSystem.saveNewStudenAccount(account, studentID);
                         signUpForm.noticeSuccessfully("Thành công", "Đăng ký thành công");
                     }
                 }
            }
        }
        
    }
    
    private class BackButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginForm.setVisibleForm(true);
            signUpForm.closeForm();
        }
    }
    
    private class RadioButtonNormalActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            signUpForm.hideStudentInfoFields();
        }
        
    }
    
    private class RadioButtonStudentActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            signUpForm.showStudentInfoFriends();
        }
        
    }
}
