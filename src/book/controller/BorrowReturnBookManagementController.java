package book.controller;

import book.view.BorrowReturnBookManagementForm;
import book.view.IBorrowReturnBookManagementForm;
import book.view.ILibrarianMainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowReturnBookManagementController{
    private IBorrowReturnBookManagementForm borrowReturnBookManagementForm;
    private ILibrarianMainForm librarianMainForm;
    
    public BorrowReturnBookManagementController(ILibrarianMainForm librarianMainForm){
        borrowReturnBookManagementForm=new BorrowReturnBookManagementForm();
        this.librarianMainForm=librarianMainForm;
        librarianMainForm.hideLibrarianMainForm();
        this.borrowReturnBookManagementForm=new BorrowReturnBookManagementForm();
        borrowReturnBookManagementForm.openBorrowReturnMainForm();
        borrowReturnBookManagementForm.setButtonBackActionListener(new ButtonBackActionListener());
    }
    
    private class ButtonBackActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            librarianMainForm.openLibrarianMainForm();
            borrowReturnBookManagementForm.closeBorrowReturnMainForm();
        }
        
    }
}
