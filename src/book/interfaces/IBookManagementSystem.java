package book.interfaces;

import java.util.ArrayList;
import model.Book;
import model.BookCopy;
import model.CatetoryBook;

public interface IBookManagementSystem {
    
    public ArrayList<CatetoryBook> getListCategory();
    
    public void saveNewBook(Book book);
    
    public boolean saveNewCopyBook(BookCopy bookCopy);
    
    public int getNumOfBook(int category);

    public boolean isBookExisted(String title, String publisher, String author);
    
    public int checkBookNumber(int cateID, int numOfBook);
 
    public ArrayList<Book> getBooksByID(String bookNumber);
    
    public ArrayList<Book> getBooksByName(String name);
    
    public ArrayList<Book> getBooksByAuthor(String author);
   
    public ArrayList<Book> getBooksByPublisher(String publisher);
  
    public int getNumOfBookCopy(int bookID);
    
    public ArrayList<BookCopy> getCopyBooks(int bookID);
  
    public void updateBookInfo(Book bookInfo);
    
    public BookCopy getBookCopyInfo(String bookNumber, int bookCopyNumber);
    
    public void updateBookCopyInfo(BookCopy bookCopy);
    
    public CatetoryBook getCatetoryBookByID(int id);
}
