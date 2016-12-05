package model;

public class Book {
    private int bookID;
    private int cateID;
    private int numOfBook;
    private String title;
    private String author;
    private String publisher;
    private String ibns;

    public Book(){
        
    }
    
    public Book(int cateID, int numOfBook, String title, String author, String publisher, String ibns) {
        this.cateID = cateID;
        this.numOfBook = numOfBook;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ibns = ibns;
    }

    public Book(int cateID, String title, String author, String publisher, String ibns) {
        this.cateID = cateID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ibns = ibns;
    }

    public Book(int bookID, int cateID, int numOfBook, String title, String author, String publisher, String ibns) {
        this.bookID = bookID;
        this.cateID = cateID;
        this.numOfBook = numOfBook;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ibns = ibns;
    }

    
    
    
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getNumOfBook() {
        return numOfBook;
    }

    public void setNumOfBook(int numOfBook) {
        this.numOfBook = numOfBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIbns() {
        return ibns;
    }

    public void setIbns(String ibns) {
        this.ibns = ibns;
    }
    
    
    
}
