package main.view;

import book.view.BookCopyTableModel;
import book.view.BookTableModel;
import book.view.MyComboboxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import javax.swing.table.TableModel;

public interface IMainForm {
    
    public void closeForm();
    
    public void setVisibleForm(boolean isVisible);
    
    public void setLogInButtonActionListener(ActionListener listener);
    
    public void setButtonExitActionListener(WindowListener listener);
    
    public MainForm getMainFormInstance();
    
    public void setButtonRegisterActionListener(ActionListener listener);
    
    public void displayNewBook(BookTableModel bookTableModel);
    
    public void showListCategoryBook(MyComboboxModel myComboboxModel);
    
    public void setComboBoxCategoryBookActionListener(ActionListener listener);
    
    public int getComboBoxCategoryBookSelectedIndex();
    
    public void setTaleShowBookMouseListener(MouseListener listener);
    
    public int getTableListBookResultRowSelected(MouseEvent e);
    
    public void setDataBookToShow(String bookNumber, String name, String author, String publisher, String ibns, BookCopyTableModel bookCopyTableModel);
    
    public void setButtonSearchBookActionListener(ActionListener listener);
    
    public String getTextFieldSearchBook();
    
    public void setTextFieldSearchBookKeyListener(KeyListener listener);
    
    public void doButtonSearchBookClick();
}
