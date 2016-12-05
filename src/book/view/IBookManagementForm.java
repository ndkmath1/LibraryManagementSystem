package book.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface IBookManagementForm {
    
    public void openBookManageForm();
    
    public void hideBookManagementForm();
          
    public void setButtonBackAction(ActionListener listener);
    
    public void setButtonSaveNewBookAction(ActionListener listener);
    
    public void setButtonCansaveNewBookAction(ActionListener listener);
    
    public void setButtonSearchBookAction(ActionListener listener);
    
    public void setTextFieldSearchBookKeyAction(KeyListener listener);
    
    public void setCheckBoxTypeEnterBookActionListener(ActionListener listener);
    
    public void enableEnterBookNumber();
    
    public void disableEnterBookNumber();
    
    public boolean getCheckBoxSelectTypeEnter();
    
    public String getTextFieldBookNumberOnSaveBook();
    
    public String getTextFieldBookTitleOnSaveBook();
    
    public String getTextFieldBookAuthorOnSaveBook();
    
    public String getTextFieldBookPublisherOnSaveBook();
    
    public String getTextFieldBookIBNSOnSaveBook();
    
    public void showListCategoryBook(MyComboboxModel data);
    
    public int getComboBoxCategoryBookOnSaveBook();
    
    public void noticeError(String title, String message);
    
    public void noticeSuccessfully(String title, String message);
    
    public void setButonSaveNewBookCopyActionListener(ActionListener listener);
    
    public void setButtonRefreshSaveBookCopyActionListener(ActionListener listener);
    
    public String getTextFieldBookNumberOfNewBookCopy();
    
    public String getTextFieldNumOfCopyBook();
    
    public String getTextFieldBookCopyPrince();
    
    public int getComboBoxBoxTypeOfCopy();
    
    public int getComboBoxTypeOfSearchBook();
    
    public String getTextFieldDataSearch();
    
    public void displayBookResult(BookTableModel bookTableModel);
    
    public void setTextFieldDataSearchKeyAction(KeyListener listener);
    
    public void doClickButtonSearchBook();
    
    public void setTableShowBookResultMouseAction(MouseListener listener);
    
    public void setTextFieldShowBookNumber(String bookNumber);
    
    public void setTextFieldShowBookName(String bookNumber);
    
    public void setTextFieldShowBookAuthor(String author);
    
    public void setTextFieldShowBookPublisher(String publisher);
    
    public void setTextFieldShowIBNS(String ibns);
    
    public void showTableListBookCopyInfo(BookCopyTableModel bookCopyTableModel);
    
    public int getTableListBookResultRowSelected(MouseEvent e);
    
    public void setTableShowBookCopyMouseAction(MouseListener listener);
    
    public void setTableBookCopySelectRow(int row);
    
    public int getTableListBookCopyResultRowSelected(MouseEvent e);
    
    public void showBookInfoToEdit(String bookNumber, String bookName, String bookAuthor, String BookPublisher, String ibns);
    
    public void setTableShowListBookSelected(int row);
    
    public void showBookCopyInfoToEdit(int currentPosition);
}
