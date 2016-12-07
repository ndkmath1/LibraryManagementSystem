package account.view;

import java.awt.event.ActionListener;

public interface IUserMainForm {

    public void setVisibleForm(boolean isVisible);
    
    public void openUserMainForm();

    public void closeUserMainForm();
    
    public void setMenuItemActivateAccountListener(ActionListener listener);
    
    public void nontifiesAccountIsActivated();
    
    public void nontifiesNotYetBorrowerCard();
    
    public void setMenuItemLogOutListener(ActionListener listener);
    
}
