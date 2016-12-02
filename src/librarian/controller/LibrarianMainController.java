package librarian.controller;

import account.view.ILogInForm;
import librarian.view.ILibrarianMainForm;
import librarian.view.LibrarianMainForm;

public class LibrarianMainController {
    private ILibrarianMainForm librarianMainForm;
    private ILogInForm logInForm;
    
    public LibrarianMainController(ILogInForm logInForm){
        librarianMainForm=new LibrarianMainForm();
        this.logInForm=logInForm;
        logInForm.closeForm();
        librarianMainForm.openLibrarianMainForm();
    }
    
    public void openLibrarianMainForm() {
        librarianMainForm.openLibrarianMainForm();
    }

    
    public void closeLibrarianMainForm() {
        librarianMainForm.closeLibrarianMainForm();
    }
    
    
}
