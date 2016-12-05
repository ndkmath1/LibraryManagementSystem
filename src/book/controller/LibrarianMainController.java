package book.controller;

import account.view.ILogInForm;
import book.view.ILibrarianMainForm;
import book.view.LibrarianMainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianMainController {
    private ILibrarianMainForm librarianMainForm;
    private ILogInForm logInForm;
    
    public LibrarianMainController(ILogInForm logInForm){
        librarianMainForm=new LibrarianMainForm();
        this.logInForm=logInForm;
        logInForm.closeForm();
        librarianMainForm.openLibrarianMainForm();
        
        librarianMainForm.setButtonBookManagementActionListener(new ButtonBookManagementListener());
        librarianMainForm.setButtonBorrowReturnBookManagementActionListener(new ButtonBorrowReturnManagementListener());
        librarianMainForm.setButtonBorrowCardManagementActionListener(new ButtonBorrowCardManagementListener());
        librarianMainForm.setButtonLogoutActionListener(new ButtonLogoutListener());
    }
    
    public void openLibrarianMainForm() {
        librarianMainForm.openLibrarianMainForm();
    }

    
    public void closeLibrarianMainForm() {
        librarianMainForm.hideLibrarianMainForm();
    }
    
    private class ButtonBookManagementListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new BookManagementController(librarianMainForm);
        }
        
    }
    
    private class ButtonBorrowReturnManagementListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    }
     
    private class ButtonBorrowCardManagementListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    }
      
    private class ButtonLogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            logInForm.setVisibleForm(true);
            librarianMainForm.closeLibrarianMainForm();
        }
        
    }
}
