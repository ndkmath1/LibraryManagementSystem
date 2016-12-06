package book.view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public interface IBorrowReturnBookManagementForm {
    
    public void setButtonCheckBorrowCardIDActionListener(ActionListener listener);
    
    public void setButtonAddBookCopyIDActionListener(ActionListener listener);
    
    public void setButtonAcceptToBorrowActionListener(ActionListener listener);
    
    public void setButtonBackActionListener(ActionListener listener);
    
    public String getTextFieldBorrowCardID();
    
    public String getTextFieldBookCopyID();
    
    public void openBorrowReturnMainForm();
    
    public void closeBorrowReturnMainForm();
    
    public void noticeError(String title, String message);

    public void noticeSuccessfully(String title, String message);
    
    public void showFieldsToAddBookCopy();
    
    public void disableFieldsToAddBookCopy();
}
