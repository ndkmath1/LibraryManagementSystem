package book.controller;

import book.view.BorrowReturnBookManagementForm;
import book.view.IBorrowReturnBookManagementForm;
import book.view.ILibrarianMainForm;
import borrowercard.factory.BorrowerCardSystemFactory;
import borrowercard.interfaces.IBorrowerCardSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.BorrowerCardHelper;

public class BorrowReturnBookManagementController{
    private IBorrowReturnBookManagementForm borrowReturnBookManagementForm;
    private ILibrarianMainForm librarianMainForm;
    private IBorrowerCardSystem borrowerCardSystem;
    
    public BorrowReturnBookManagementController(ILibrarianMainForm librarianMainForm){
        borrowReturnBookManagementForm=new BorrowReturnBookManagementForm();
        this.librarianMainForm=librarianMainForm;
        librarianMainForm.hideLibrarianMainForm();
        borrowerCardSystem=BorrowerCardSystemFactory.getBorrowerCardSystem();
        this.borrowReturnBookManagementForm=new BorrowReturnBookManagementForm();
        borrowReturnBookManagementForm.openBorrowReturnMainForm();
        borrowReturnBookManagementForm.setButtonBackActionListener(new ButtonBackActionListener());
        borrowReturnBookManagementForm.setButtonCheckBorrowCardIDActionListener(new ButtonCheckBorrowCardIDListener());
        borrowReturnBookManagementForm.setButtonAddBookCopyIDActionListener(new ButtonAddBookCopyListener());
        borrowReturnBookManagementForm.setButtonAcceptToBorrowActionListener(new ButtonAcceptBorrowBookListener());
    }
    
    private class ButtonBackActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            librarianMainForm.openLibrarianMainForm();
            borrowReturnBookManagementForm.closeBorrowReturnMainForm();
        }
        
    }
    
    private class ButtonCheckBorrowCardIDListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String cardID=borrowReturnBookManagementForm.getTextFieldBorrowCardID();
            if(!BorrowerCardHelper.validateCardID(cardID)){
                borrowReturnBookManagementForm.noticeError("Lỗi nhập dữ liệu", "Mã số thẻ không đúng");
                return;
            }
            int borrowCardID=Integer.valueOf(cardID);
//            if(borrowerCardSystem.isBorrowCardExisted(borrowCardID)){
//                borrowReturnBookManagementForm.showFieldsToAddBookCopy();
//            }
        }
        
    }
    
    private class ButtonAddBookCopyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    private class ButtonAcceptBorrowBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
        
    }
}
