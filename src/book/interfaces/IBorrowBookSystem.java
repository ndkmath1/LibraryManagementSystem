package book.interfaces;

import java.util.ArrayList;
import model.Borrow;

public interface IBorrowBookSystem {
    public int saveNewBorrowedBook(int cardID);
    
    public void saveNewBorrowBookCopy(int borrowID, ArrayList<Integer> listBookCopyID);
    
}
