package book.controller;

import book.factory.BookSystemFactory;
import book.interfaces.IBookManagementSystem;
import book.view.BookCopyTableModel;
import book.view.BookManagementForm;
import book.view.BookTableModel;
import book.view.IBookManagementForm;
import book.view.ILibrarianMainForm;
import book.view.MyComboboxModel;
import book.view.MyPopUpMenu;
import book.view.MyPopUpMenuBookCopy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import model.Book;
import model.BookCopy;
import model.CatetoryBook;
import utils.BookHelper;

public class BookManagementController{
    private IBookManagementForm bookManagementForm;
    private ILibrarianMainForm librarianMainForm;
    private ArrayList<CatetoryBook> listCategoryBook;
    private IBookManagementSystem bookManagementSystem;
    private ArrayList<Book> listResultBook;
    private MyPopUpMenu myPopUpMenu;
    private MyPopUpMenuBookCopy myPopUpMenuBookCopy;

    public BookManagementController(ILibrarianMainForm librarianMainForm){
        this.librarianMainForm=librarianMainForm;
        bookManagementSystem=BookSystemFactory.getBookManagementSystem();
        bookManagementForm=new BookManagementForm();
        bookManagementForm.openBookManageForm();
        librarianMainForm.hideLibrarianMainForm();
        bookManagementForm.setButtonBackAction(new ButtonBackActionListener());
        bookManagementForm.setCheckBoxTypeEnterBookActionListener(new CheckBoxEnterBookNumberListener());
        bookManagementForm.setButtonSaveNewBookAction(new ButtonSaveNewBookListener());
        bookManagementForm.setButtonCansaveNewBookAction(new ButtonRefreshSaveNewBookListener());
        bookManagementForm.setButonSaveNewBookCopyActionListener(new ButtonSaveBookCopyListener());
        bookManagementForm.setButtonSearchBookAction(new ButtonSearchBookListener());
        bookManagementForm.setTextFieldDataSearchKeyAction(new TextFieldSearchBookListener());
        bookManagementForm.setTableShowBookResultMouseAction(new TableShowBookResultMouseListener());
        bookManagementForm.setTableShowBookCopyMouseAction(new TableShowBookCopyResultMouseListener());
        loadListCategoryBook();
        myPopUpMenu=new MyPopUpMenu(bookManagementForm);
        myPopUpMenu.setMenuAction(new PopupMenuActionListener());
    }
    
    public void loadListCategoryBook(){
        listCategoryBook=bookManagementSystem.getListCategory();
        bookManagementForm.showListCategoryBook(new MyComboboxModel(listCategoryBook));
    }
    private class ButtonBackActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            librarianMainForm.openLibrarianMainForm();
            bookManagementForm.hideBookManagementForm();
        }
        
    }
    
    private class CheckBoxEnterBookNumberListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(bookManagementForm.getCheckBoxSelectTypeEnter())
                bookManagementForm.enableEnterBookNumber();
            else bookManagementForm.disableEnterBookNumber();
        }
        
    }
    
    private class ButtonSaveNewBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             //get data to save new book
            int catePosition=bookManagementForm.getComboBoxCategoryBookOnSaveBook(); 
            int cateID=listCategoryBook.get(catePosition).getId();

            String bookTitle=bookManagementForm.getTextFieldBookTitleOnSaveBook();
            if(!BookHelper.validateBookName(bookTitle)){
                bookManagementForm.noticeError("Nỗi cú pháp nhập", "Tên sách nhập không đúng");
                return;
            }

            String publisher=bookManagementForm.getTextFieldBookPublisherOnSaveBook();
            if(!BookHelper.validatePublisher(publisher)){
                bookManagementForm.noticeError( "Nỗi cú pháp nhập", "Ten nhà xuất bản không đúng");
                return;
            }
            String author=bookManagementForm.getTextFieldBookAuthorOnSaveBook();
            if(!BookHelper.validateAuthor(author)){
                bookManagementForm.noticeError("Nỗi cú pháp nhập","Ten tác giả không đúng");
                return;
            }

            String ibns=bookManagementForm.getTextFieldBookIBNSOnSaveBook();
            if(!ibns.equals("")){
                if(!BookHelper.validateIBNS(ibns)){
                    bookManagementForm.noticeError( "Nỗi cú pháp nhập","Mã IBNS không đúng!");
                    return;
                }
            }
            int numOfBook=0;
            if(bookManagementForm.getCheckBoxSelectTypeEnter()){
                String number=bookManagementForm.getTextFieldBookNumberOnSaveBook();
                if(BookHelper.validateNumOfBook(number)){
                    bookManagementForm.noticeError( "Nỗi cú pháp nhập","Số sách không đúng!");
                    return;
                } 
                else numOfBook=Integer.valueOf(number);
            }
            Book book=new Book(cateID, numOfBook ,bookTitle, author, publisher, ibns);         
            //check if book is existed!
            if(bookManagementSystem.isBookExisted(book.getTitle(),book.getPublisher(), book.getAuthor())){ 
                bookManagementForm.noticeError("Lỗi thêm mới sách", "Sách đã tồn tại");
                return;
            }

            if(numOfBook>0){
                if(bookManagementSystem.checkBookNumber(book.getCateID(), book.getNumOfBook())>0){
                    bookManagementForm.noticeError("Lỗi thêm mới sách", "Số sách đã tồn tại");
                    return;
                }
            }

            bookManagementSystem.saveNewBook(book);    
            bookManagementForm.noticeSuccessfully("Thành công", "Thêm mới sách thành công");
        }
    }
    
    private class ButtonRefreshSaveNewBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
        
    }
    
    private class ButtonSaveBookCopyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String bookNumber=bookManagementForm.getTextFieldBookNumberOfNewBookCopy();
            if(!BookHelper.validateBookNumber(bookNumber)){
                bookManagementForm.noticeError("Lỗi cú pháp", "Mã số sách không đúng");
                return;
            }
            String category=bookNumber.substring(0, 2);
            int cateID=0;
            for(int i=0;i<listCategoryBook.size();i++){
                if(listCategoryBook.get(i).getCateID().equals(category)) 
                    cateID=listCategoryBook.get(i).getId();
            }
            if(cateID==0) {
                bookManagementForm.noticeError("Lỗi thêm sách", "Không tìm thấy phân loại sách!");
                return;
            }
            System.out.println("boo="+bookNumber.substring(2, 6));
            int num=Integer.valueOf(bookNumber.substring(2, 6));
            

            String sNumOfCopy=bookManagementForm.getTextFieldNumOfCopyBook();
            if(!BookHelper.validateNumOfBook(sNumOfCopy)){
                System.out.println("s="+sNumOfCopy);
                bookManagementForm.noticeError("Số sách nhập vào không đúng!", "Lỗi cú pháp nhập");
                return;
            }
            int numOfCopy=Integer.valueOf(sNumOfCopy);
            
            String sPrince=bookManagementForm.getTextFieldBookCopyPrince();
            if(!BookHelper.validatePrinceOfCopy(sPrince)){
                bookManagementForm.noticeError("Giá sách nhập vào không đúng!", "Lỗi cú pháp nhập");
                return;
            }
            long prince=Long.valueOf(sPrince);
            
            boolean typeOfCopy=false;
            if(bookManagementForm.getComboBoxBoxTypeOfCopy()==0) typeOfCopy=true; 
            
            int bookID= bookManagementSystem.checkBookNumber(cateID, num);
            if(bookID==0) {
                bookManagementForm.noticeError("Lỗi thêm sách", "Không tìm thấy mã sách này");
                return;
            }
      
            int numOfCopyAdded=bookManagementSystem.getNumOfBookCopy(bookID);
            for(int i=0;i<numOfCopy;i++){
                BookCopy bookCopy=new BookCopy();
                bookCopy.setBookID(bookID);
                bookCopy.setSequenceNumber(++numOfCopyAdded);
                bookCopy.setPrince(prince);
                bookCopy.setTypeOfCopy(typeOfCopy);
                bookManagementSystem.saveNewCopyBook(bookCopy);
            }
            bookManagementForm.noticeSuccessfully("Thành công", "Thêm mới sách bản sao thành công!");
        }
        
    }
    
    private class ButtonSearchBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int typeSearch=bookManagementForm.getComboBoxTypeOfSearchBook()+1;
            String dataSearch=bookManagementForm.getTextFieldDataSearch();
            switch (typeSearch) {
                case 1:
                    if(dataSearch.equals("")) listResultBook= bookManagementSystem.getBooksByID("");
                    else{
                        if(!BookHelper.validateBookNumber(dataSearch)){
                        bookManagementForm.noticeError("Lỗi cú pháp", "Mã số sách không đúng");
                        return;
                        }
                        listResultBook=bookManagementSystem.getBooksByID(BookHelper.deFormatOfBookNumber(dataSearch));
                    }
                break;
                
                case 2:
                    if(!BookHelper.validateBookName(dataSearch)){
                        bookManagementForm.noticeError("Lỗi cú pháp", "Tên sách không đúng");
                        return;
                    }
                    listResultBook=bookManagementSystem.getBooksByName(dataSearch);
                break;
                
                case 3:
                    if(!BookHelper.validateAuthor(dataSearch)){
                        bookManagementForm.noticeError("Lỗi cú pháp", "Tên tác giả không đúng");
                        return;
                    }
                    listResultBook=bookManagementSystem.getBooksByAuthor(dataSearch);
                break;
                
                case 4:
                    if(!BookHelper.validatePublisher(dataSearch)){
                        bookManagementForm.noticeError("Lỗi cú pháp", "Tên NXB không đúng");
                        return;
                    }
                    listResultBook=bookManagementSystem.getBooksByPublisher(dataSearch);
                break;
            }
            if(listResultBook.size()==0) bookManagementForm.noticeError("Lỗi tìm kiếm", "Không tìm thấy quyển sách nào");
            else {
                bookManagementForm.displayBookResult(new BookTableModel(listResultBook, listCategoryBook));
            }
        }              
    }
    
    private class TextFieldSearchBookListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
                bookManagementForm.doClickButtonSearchBook();
        }
    }
    
    private class TableShowBookResultMouseListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = bookManagementForm.getTableListBookResultRowSelected(e);
            if(row>-1){
                Book book=listResultBook.get(row);
                bookManagementForm.setTextFieldShowBookNumber(BookHelper.getCateCode(row, listCategoryBook)+book.getNumOfBook());
                bookManagementForm.setTextFieldShowBookName(book.getTitle());
                bookManagementForm.setTextFieldShowBookAuthor(book.getAuthor());
                bookManagementForm.setTextFieldShowBookPublisher(book.getPublisher());
                bookManagementForm.setTextFieldShowIBNS(book.getIbns());
                bookManagementForm.showTableListBookCopyInfo(new BookCopyTableModel(BookHelper.formatOfBookNumber(BookHelper.getCateCode(book.getCateID(), listCategoryBook),book.getNumOfBook()), bookManagementSystem.getCopyBooks(book.getBookID())));
            }       
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                int row = bookManagementForm.getTableListBookResultRowSelected(e);
                bookManagementForm.setTableShowListBookSelected(row);
                if(row>-1){
                    myPopUpMenu.show(e.getComponent(), e.getX(), e.getY());
                    myPopUpMenu.setPosition(row);
                }            
            }
        }
        
        
    }
    
    private class TableShowBookCopyResultMouseListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)){
                int row = bookManagementForm.getTableListBookCopyResultRowSelected(e);
                bookManagementForm.setTableBookCopySelectRow(row);
                if(row>-1){
                    myPopUpMenuBookCopy.show(e.getComponent(), e.getX(), e.getY());
                    myPopUpMenuBookCopy.setPosition(row);
                }
            }
        }
        
    }
    
    private class PopupMenuActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//        anItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                bookManagementForm.showBookInfoToEdit(currentPosition);
//               // tab.setSelectedIndex(3);
//            }
//        });
        
        }
        
    }
}
