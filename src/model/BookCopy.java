package model;

public class BookCopy {
    private int bookCopyID;
    private int bookID;
    private int sequenceNumber;
    private boolean typeOfCopy;
    private long prince;
    
    public BookCopy(){
        
    }

    public BookCopy(int bookID, int sequenceNumber, boolean typeOfCopy, long prince) {
        this.bookID = bookID;
        this.sequenceNumber = sequenceNumber;
        this.typeOfCopy = typeOfCopy;
        this.prince = prince;
    }

    public int getBookCopyID() {
        return bookCopyID;
    }

    public void setBookCopyID(int bookCopyID) {
        this.bookCopyID = bookCopyID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public boolean isTypeOfCopy() {
        return typeOfCopy;
    }

    public void setTypeOfCopy(boolean typeOfCopy) {
        this.typeOfCopy = typeOfCopy;
    }

    public long getPrince() {
        return prince;
    }

    public void setPrince(long prince) {
        this.prince = prince;
    }
    
    
    
}
