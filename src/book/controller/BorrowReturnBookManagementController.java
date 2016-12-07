package book.controller;

import book.factory.BookSystemFactory;
import book.interfaces.IBookManagementSystem;
import book.interfaces.IBorrowBookSystem;
import book.view.BorrowBookTableModel;
import book.view.BorrowReturnBookManagementForm;
import book.view.IBorrowReturnBookManagementForm;
import book.view.ILibrarianMainForm;
import borrowercard.factory.BorrowerCardSystemFactory;
import borrowercard.interfaces.IBorrowerCardSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Book;
import model.BookCopy;
import utils.BookHelper;
import utils.BorrowerCardHelper;

public class BorrowReturnBookManagementController{
    private IBorrowReturnBookManagementForm borrowReturnBookManagementForm;
    private ILibrarianMainForm librarianMainForm;
    private IBorrowerCardSystem borrowerCardSystem;
    private IBookManagementSystem bookManagementSystem;
    private IBorrowBookSystem borrowSystem;
    private BorrowBookTableModel tableModel;
    private ArrayList<BookCopy> listCurrentBookCopy;
    
    public BorrowReturnBookManagementController(ILibrarianMainForm librarianMainForm){
        borrowReturnBookManagementForm=new BorrowReturnBookManagementForm();
        this.librarianMainForm=librarianMainForm;
        librarianMainForm.hideLibrarianMainForm();  
        borrowerCardSystem=BorrowerCardSystemFactory.getBorrowerCardSystem();
        bookManagementSystem=BookSystemFactory.getBookManagementSystem();
        borrowSystem=BookSystemFactory.getBorrowBookSystem();
        listCurrentBookCopy=new ArrayList<>();
        this.borrowReturnBookManagementForm=new BorrowReturnBookManagementForm();
        borrowReturnBookManagementForm.openBorrowReturnMainForm();
        tableModel=new BorrowBookTableModel();
        borrowReturnBookManagementForm.showTableBookCopy(tableModel);
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
            int status=borrowerCardSystem.checkBorrowCard(borrowCardID);
            if(status==-1){
                borrowReturnBookManagementForm.noticeError("Lỗi tìm kiếm", "Không tìm thấy thẻ mượn");
                borrowReturnBookManagementForm.disableFieldsToAddBookCopy();
                return;
            }
            else if(status==0){
                borrowReturnBookManagementForm.noticeError("Hết hạn", "Thẻ mượn đã hết hạn");
                borrowReturnBookManagementForm.disableFieldsToAddBookCopy();
                return;
            }
            borrowReturnBookManagementForm.showFieldsToAddBookCopy();
        }
        
    }
    
    private class ButtonAddBookCopyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String copy=borrowReturnBookManagementForm.getTextFieldBookCopyID();
            if(!BookHelper.validateBookCopyNumber(copy)){
                borrowReturnBookManagementForm.noticeError("Lỗi","Mã sách bản sao không đúng!");
                return;
            }
            String bookNumber=copy.substring(0,6);
            String copyNumber=copy.substring(6,copy.length());
            Book book=null;
            try{
                book=bookManagementSystem.getBooksByID(BookHelper.deFormatOfBookNumber(bookNumber)).get(0);
            }
            catch(Exception ex){
                System.out.println("eeeeeeeex="+ex);
            }
            if(book==null) {
                borrowReturnBookManagementForm.noticeError("Lỗi tìm kiếm", "Không thấy sách theo yêu cầu");
                return;
            }
            BookCopy bookCopy=bookManagementSystem.getBookCopyInfo(BookHelper.deFormatOfBookNumber(bookNumber), Integer.valueOf(copyNumber));
            if(bookCopy==null){
                borrowReturnBookManagementForm.noticeError("Lỗi", "Không tìm thấy quyển sách này");
                return;
            }
            if(!bookCopy.isReady()||!bookCopy.isTypeOfCopy()){
                borrowReturnBookManagementForm.noticeError("Lỗi", "Quyển sách này không được phép mượn");
                return;
            }
            
            if(tableModel.addData(copy, book.getTitle(), book.getAuthor(), book.getPublisher(), book.getIbns(), bookCopy.isReady()+"", bookCopy.getPrince())){
                
                listCurrentBookCopy.add(bookCopy);
                tableModel.notificationDataHasChanged();
            }
            
            else borrowReturnBookManagementForm.noticeError("Lỗi", "Có lỗi xảy ra");
        }
        
    }
    
    private class ButtonAcceptBorrowBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int cardID=Integer.valueOf(borrowReturnBookManagementForm.getTextFieldBorrowCardID());
            borrowSystem.saveNewBorrowedBook(cardID);
            ArrayList<Integer> listBookCopyID=new ArrayList<>();
            for(BookCopy bookCopy:listCurrentBookCopy){
                listBookCopyID.add(bookCopy.getBookCopyID());
            }
            borrowSystem.saveNewBorrowBookCopy(cardID, listBookCopyID);
            borrowReturnBookManagementForm.noticeError("Thành công", "Cho mượn sách thành công!");
        }
        
    }
}
