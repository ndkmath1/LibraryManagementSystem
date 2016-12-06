package book.view;

import java.awt.event.ActionListener;


public interface ILibrarianMainForm {
    
    public void openLibrarianMainForm();
    
    public void hideLibrarianMainForm();
    
    public void setButtonBookManagementActionListener(ActionListener listener);
    
    public void setButtonBorrowReturnBookManagementActionListener(ActionListener listener);
    
    public void setButtonBorrowCardManagementActionListener(ActionListener listener);
    
    public void setButtonLogoutActionListener(ActionListener listener);
    
    public void closeLibrarianMainForm();
    
    
}
