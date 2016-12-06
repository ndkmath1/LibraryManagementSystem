package book.view;

import java.awt.event.ActionListener;

public interface IBorrowReturnBookManagementForm {
    
    public void setButtonCheckBorrowCardIDActionListener(ActionListener listener);
    
    public void setButtonAddBookCopyIDActionListener(ActionListener listener);
    
    public void setButtonAcceptToBorrowActionListener(ActionListener listener);
    
    public void setButtonBackActionListener(ActionListener listener);
    
    public String getTextFieldBorrowCardID();
    
    public String getTextFieldBookCopyID();
    
    public void openBorrowReturnMainForm();
    
    public void closeBorrowReturnMainForm();
}
