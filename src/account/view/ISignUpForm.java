package account.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Date;

public interface ISignUpForm {

    public void closeForm();
    
    public void setVisibleForm(boolean isVisible);

    public String getStudentIDOnSingupForm();

    public boolean getTypeOfRegisterOnSingupForm();

    public String getUsernameOnSingupForm();

    public String getPasswordOnSingupForm();

    public String getNameOnSingupForm();

    public String getEmailOnSingupForm();

    public String getPhoneOnSingupForm();
    
    public String getNationalOnSignupForm();

    public boolean getGenderOnSingupForm();

    public String getAddressOnSingupForm();

    public void hidePanelEnterStudentInfo();

    public void showPanelEnterStudentInfo();

    public void setButtonRegisterActionListener(ActionListener listener);

    public void setButtonRefreshActionListener(ActionListener listener);

    public void setButtonBackActionListener(ActionListener listener);

    public void setRadioButtonNormalActionListener(ActionListener listener);
    
    public void setRadioButtonStudentActionListener(ActionListener listener);
    
    public Date getComboboxBirthdayonSignForm();
    
    public void hideStudentInfoFields();
    
    public void showStudentInfoFriends();
    
    public void noticeError(String title, String message);
    
    public void noticeSuccessfully(String title, String message);
    
    
}
