package model;

public class BorrowBookCopy {
    private int id;
    private int borrow_id;
    private int bookcopy_id;
    private boolean status;

    public BorrowBookCopy(int id, int borrow_id, int bookcopy_id, boolean status) {
        this.id = id;
        this.borrow_id = borrow_id;
        this.bookcopy_id = bookcopy_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getBookcopy_id() {
        return bookcopy_id;
    }

    public void setBookcopy_id(int bookcopy_id) {
        this.bookcopy_id = bookcopy_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
