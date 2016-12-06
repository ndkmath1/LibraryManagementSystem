package book.system;

import book.factory.BookSystemFactory;
import book.interfaces.IBookManagementSystem;
import book.interfaces.IBorrowBookSystem;
import book.interfaces.IReturnBookSystem;
import book.view.IBookManagementForm;
import databasehelper.BookSQLStatement;
import databasehelper.ConnectDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import model.BookCopy;
import model.CatetoryBook;

public class BookSystem implements IBookManagementSystem, IBorrowBookSystem, IReturnBookSystem{

    @Override
    public ArrayList<CatetoryBook> getListCategory() {
        try {
            ResultSet res=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_GET_ALL_CATEGORY).executeQuery();
            ArrayList<CatetoryBook> listCategoryBook=new ArrayList<>();
            while(res.next()){
                listCategoryBook.add(new CatetoryBook(res.getInt(1), res.getString(2), res.getString(3)));
            }
            return listCategoryBook;
        } catch (SQLException ex) {
            System.out.println("ex book1"+ex);
        }
        return null;
    }

    @Override
    public void saveNewBook(Book book) {
        int num=book.getNumOfBook();
         //if librarian use auto increment num of book
        if(book.getNumOfBook()==0){
            //get num of book which has the same category with that book
            int numOfBook=getNumOfBookWithCategory(book.getCateID());
            numOfBook++;
            if(checkBookNumber(book.getCateID(), numOfBook)>0) numOfBook++;
            num=numOfBook;
        }
        PreparedStatement preparedStmt;
            try {
                preparedStmt = ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_SAVE_NEW_BOOK);
                preparedStmt.setString(1, book.getAuthor());
                preparedStmt.setString(3, book.getPublisher());
                preparedStmt.setString(4, book.getIbns());
                preparedStmt.setString(2, book.getTitle());
                preparedStmt.setInt(5, book.getCateID());
                preparedStmt.setInt(6, num);
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.out.println("ex2= "+ex);
            }       
    }

    @Override
    public boolean saveNewCopyBook(BookCopy bookCopy) {
        PreparedStatement preparedStmt;
        try {
            preparedStmt = ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_SAVE_NEW_BOOK_COPY);
            preparedStmt.setInt(1, bookCopy.getBookID());
            preparedStmt.setInt(2, bookCopy.getSequenceNumber());
            preparedStmt.setBoolean(3, bookCopy.isTypeOfCopy());
            preparedStmt.setLong(4, bookCopy.getPrince());
            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("ex2= "+ex);
            return false;
        }
    }

    @Override
    public int getNumOfBook(int category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isBookExisted(String title, String publisher, String author) {
        
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_IS_BOOK_EXISTED);
            ps.setString(1, title);
            ps.setString(2, publisher);
            ps.setString(3, author);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) return true;
        } catch (SQLException ex) {
            System.out.println("ex5= "+ex);
        }
        return false;
    }

    @Override
    public int checkBookNumber(int cateID, int numOfBook) {
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_CHECK_BOOK_NUMBER);
            ps.setInt(1, cateID);
            ps.setInt(2, numOfBook);
            ResultSet res=ps.executeQuery();
            if(res.next()) return res.getInt(1);
            return 0;
        } catch (SQLException ex) {
            System.out.println("ex6= "+ex);
            return -1;
        }
    }

    @Override
    public ArrayList<Book> getBooksByID(String bookNumber) {
        ArrayList<Book> listBookResult=new ArrayList<>();
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_SEARCH_BOOK_BY_ID);
            ps.setString(1, bookNumber+"%");
            System.out.println("search="+ps.toString());
            ResultSet res=ps.executeQuery();
            while(res.next()){
                int iD=res.getInt(1);
                String title=res.getString(3);
                String author=res.getString(2);
                String publisher=res.getString(4);
                String ibns=res.getString(5);
                int cateID=res.getInt(6);
                int numOfBook=res.getInt(7);
                listBookResult.add(new Book(iD, cateID, numOfBook, title, author, publisher, ibns));
            }
        } catch (SQLException ex) {
            System.out.println("ex7= "+ex);
        }
        System.out.println("size= "+listBookResult.size());
        return listBookResult;
    }

    @Override
    public ArrayList<Book> getBooksByName(String name) {
        ArrayList<Book> listBookResult=new ArrayList<>();
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_SEARCH_BOOK_BY_NAME);
            ps.setString(1, name+"%");
            System.out.println("sql="+ps.toString());
            ResultSet res=ps.executeQuery();
            while(res.next()){
                int iD=res.getInt(1);
                String title=res.getString(3);
                String author=res.getString(2);
                String publisher=res.getString(4);
                String ibns=res.getString(5);
                int cateID=res.getInt(6);
                int numOfBook=res.getInt(7);
                listBookResult.add(new Book(iD, cateID, numOfBook, title, author, publisher, ibns));
            }
        } catch (SQLException ex) {
            System.out.println("ex7= "+ex);
        }
        System.out.println("list size="+listBookResult.size());
        return listBookResult;    
    }

    @Override
    public ArrayList<Book> getBooksByAuthor(String authorname) {
        ArrayList<Book> listBookResult=new ArrayList<>();     
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_SEARCH_BOOK_BY_AUTHOR);
            ps.setString(1, authorname+"%");
            ResultSet res=ps.executeQuery();
            while(res.next()){
                int iD=res.getInt(1);
                String title=res.getString(3);
                String author=res.getString(2);
                String publisher=res.getString(4);
                String ibns=res.getString(5);
                int cateID=res.getInt(6);
                int numOfBook=res.getInt(7);
                listBookResult.add(new Book(iD, cateID, numOfBook, title, author, publisher, ibns));
            }
        } catch (SQLException ex) {
            System.out.println("ex7= "+ex);
        }
        return listBookResult;    
    }

    @Override
    public ArrayList<Book> getBooksByPublisher(String publishername) {
        ArrayList<Book> listBookResult=new ArrayList<>();
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_SEARCH_BOOK_BY_PUBLISHER);
            ps.setString(1, publishername+"%");
            ResultSet res=ps.executeQuery();
            while(res.next()){
                int iD=res.getInt(1);
                String title=res.getString(3);
                String author=res.getString(2);
                String publisher=res.getString(4);
                String ibns=res.getString(5);
                int cateID=res.getInt(6);
                int numOfBook=res.getInt(7);
                listBookResult.add(new Book(iD, cateID, numOfBook, title, author, publisher, ibns));
            }
        } catch (SQLException ex) {
            System.out.println("ex7= "+ex);
        }
        return listBookResult;    
    }

    @Override
    public int getNumOfBookCopy(int bookID) {
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_GET_NUM_OF_COPY_BOOK);
            ps.setInt(1, bookID);
            ResultSet res=ps.executeQuery();
            if(res.next())
                return res.getInt(1);
            else return 0;
        } catch (SQLException ex) {
            System.out.println("ex4= "+ex);
            return -1;
        }
    }

    @Override
    public ArrayList<BookCopy> getCopyBooks(int bookID) {
        ArrayList<BookCopy> listBookCopy=new ArrayList();
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareCall(BookSQLStatement.QUERY_GET_BOOK_COPY);
            ps.setInt(1, bookID);
            System.out.println("da="+ps.toString());
            ResultSet res=ps.executeQuery();
            while(res.next()){
                BookCopy bookCopy=new BookCopy();
                bookCopy.setBookCopyID(res.getInt(1));
                bookCopy.setBookID(bookID);
                bookCopy.setSequenceNumber(res.getInt(3));
                bookCopy.setTypeOfCopy(res.getBoolean(4));
                bookCopy.setPrince(res.getLong(5));
                listBookCopy.add(bookCopy);
            }
            System.out.println("size1="+listBookCopy.size());
            return listBookCopy;
        } catch (SQLException ex) {
            System.out.println("ex4= "+ex);
            return null;
        }
    }

    @Override
    public void updateBookInfo(Book bookInfo) {
        
        PreparedStatement ps;
        try {
            ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_UPDATE_BOOK_INFO);
            ps.setString(1, bookInfo.getTitle());
            ps.setString(2, bookInfo.getAuthor());
            ps.setString(3, bookInfo.getPublisher());
            ps.setString(4, bookInfo.getIbns());
            ps.setInt(5, bookInfo.getBookID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("111111111111111");
        }
    }

    @Override
    public BookCopy getBookCopyInfo(String bookNumber, int bookCopyNumber) {
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_GET_BOOK_COPY_INFO);
            ps.setString(1, bookNumber);
            ps.setInt(2, bookCopyNumber);
            ResultSet res=ps.executeQuery();
            if(res.next()){
                BookCopy bookCopy=new BookCopy();
                bookCopy.setBookCopyID(res.getInt(1));
                bookCopy.setBookID(res.getInt(2));
                bookCopy.setSequenceNumber(res.getInt(3));
                bookCopy.setTypeOfCopy(res.getBoolean(4));
                bookCopy.setPrince(res.getLong(5));
                bookCopy.setReady(res.getBoolean(6));
                return bookCopy;
            }
            else return null;
        } catch (SQLException ex) {
            System.out.println("errrrrrrr="+ex);
        }
        return null;
    }

    @Override
    public void updateBookCopyInfo(BookCopy bookCopy) {
         
        PreparedStatement ps;
        try {
            ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_UPDATE_BOOK_COPY_INFO);
            ps.setBoolean(1, bookCopy.isTypeOfCopy());
            ps.setLong(2, bookCopy.getPrince());
            ps.setInt(3, bookCopy.getBookCopyID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("2222222222" +ex);
        }
    }
    
    private int getNumOfBookWithCategory(int cateID){
        try {
            PreparedStatement ps=ConnectDatabase.getConnection().prepareStatement(BookSQLStatement.QUERY_GET_NUM_OF_BOOK_WITH_CATEGORY);
            ps.setInt(1, cateID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) return rs.getInt(1);
            else return 0;
        } catch (SQLException ex) {
            System.out.println("book ex2="+ex);
        }
        return 0;
    }
}
