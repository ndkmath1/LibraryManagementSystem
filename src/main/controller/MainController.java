package main.controller;

import account.controller.LogInController;
import account.controller.SignUpController;
import account.view.ILogInForm;
import account.view.LogInForm;
import book.factory.BookSystemFactory;
import book.interfaces.IBookManagementSystem;
import book.view.BookCopyTableModel;
import book.view.BookTableModel;
import book.view.IBookManagementForm;
import book.view.MyComboboxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.view.IMainForm;
import main.view.MainForm;
import model.Book;
import model.CatetoryBook;
import utils.BookHelper;

public class MainController {
    private IMainForm mainForm;
    private ILogInForm loginForm;
    private BookTableModel bookTableModel;
    private ArrayList<Book> listBooks;
    private ArrayList<CatetoryBook> listCategoryBook;
    private IBookManagementSystem bookManagementSystem;
    private ArrayList<Book> listBookResult;
    private MyComboboxModel comboboxModel;
    
    public MainController() {
        mainForm = new MainForm();
        mainForm.setVisibleForm(true);
        mainForm.setLogInButtonActionListener(new LoginButtonActionListener());
        mainForm.setButtonExitActionListener(new ExitButtonActionListener());
        mainForm.setButtonRegisterActionListener(new ButtonRegisterListener());
        //get all book
        bookManagementSystem=BookSystemFactory.getBookManagementSystem();
        listBooks=bookManagementSystem.getBooksByID("");
        listBookResult=new ArrayList<>();
        for(Book book:listBooks) listBookResult.add(book);
        listCategoryBook=bookManagementSystem.getListCategory();
        listCategoryBook.add(0, new CatetoryBook(0, "AL", "Tất cả"));
        comboboxModel=new MyComboboxModel(listCategoryBook);
        mainForm.showListCategoryBook(comboboxModel);
        bookTableModel=new BookTableModel(listBookResult, listCategoryBook);
        mainForm.displayNewBook(bookTableModel);
        mainForm.setComboBoxCategoryBookActionListener(new ComboBoxCategoryBookListener());
        mainForm.setTaleShowBookMouseListener(new TableShowBookMouseListener());
        mainForm.setButtonSearchBookActionListener(new ButtonSearchBookListener());
        mainForm.setTextFieldSearchBookKeyListener(new TextFieldSearchBookKeyEvent());
    }
    
    private class LoginButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainForm.setVisibleForm(false);
            new LogInController(mainForm);
        }
    
    }
    
    private class ExitButtonActionListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            if (JOptionPane.showConfirmDialog(mainForm.getMainFormInstance(), "Bạn có chắc chắn muốn thoát?", "Kết thúc", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
    }
    
    private class ButtonRegisterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new SignUpController(mainForm);
        }
        
    }
    
    private class ComboBoxCategoryBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int postion=mainForm.getComboBoxCategoryBookSelectedIndex();
            if(postion>0){
                listBookResult.clear();
                for(Book book:listBooks) 
                    if(book.getCateID()==listCategoryBook.get(postion).getId()) listBookResult.add(book);
                bookTableModel.notificationDataHasChanged();
            }
            else  {
                listBookResult.clear();
                for(Book book:listBooks) listBookResult.add(book);
                bookTableModel.notificationDataHasChanged();
            }
        }
        
    }
    private class TableShowBookMouseListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
             int row = mainForm.getTableListBookResultRowSelected(e);
            if(row>-1){
                Book book=listBookResult.get(row);
                String bookNumber=BookHelper.formatOfBookNumber(BookHelper.getCateCode(book.getCateID(), listCategoryBook),book.getNumOfBook());
                String name=book.getTitle();
                String author=book.getAuthor();
                String publisher=book.getPublisher();
                String ibns=book.getIbns();
                BookCopyTableModel bookCopyTableModel= new BookCopyTableModel(bookNumber, bookManagementSystem.getCopyBooks(book.getBookID())) ;
                mainForm.setDataBookToShow(bookNumber, name, author, publisher,ibns, bookCopyTableModel);
            }       
        }        
    }
    
    private class ButtonSearchBookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String dataSearch=mainForm.getTextFieldSearchBook();
            int position=mainForm.getComboBoxCategoryBookSelectedIndex();
            listBookResult.clear();
            if(position>0){
                for(Book book:listBooks)
                    if(book.getCateID()==listCategoryBook.get(position).getId()){
                        String data=BookHelper.formatOfBookNumber(listCategoryBook.get(position).getCateID(),book.getNumOfBook())+book.getTitle()+book.getAuthor()+book.getPublisher()+book.getIbns();
                        if(data.contains(dataSearch)) listBookResult.add(book);
                    }
                bookTableModel.notificationDataHasChanged();
            }
            else {
                for(Book book:listBooks){
                   for(CatetoryBook cate:listCategoryBook){
                       if(cate.getId()==book.getCateID()){
                           String data=BookHelper.formatOfBookNumber(cate.getCateID(),book.getNumOfBook())+book.getTitle()+book.getAuthor()+book.getPublisher()+book.getIbns();
                           if(data.contains(dataSearch)) listBookResult.add(book);
                       }
                   } 
                }    
                bookTableModel.notificationDataHasChanged();
            }
        }
        
    }
    
    private class TextFieldSearchBookKeyEvent extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
                mainForm.doButtonSearchBookClick();
        }
        
    }
}
