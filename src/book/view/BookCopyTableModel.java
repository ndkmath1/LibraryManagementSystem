package book.view;

import model.Book;
import model.BookCopy;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BookCopyTableModel extends AbstractTableModel {
    private ArrayList<BookCopy> listBooksCopyResult;
    private static final String[] columnNames = {"Mã sách", "Loại", "Giá"};
    private String bookNumber;
 
    public BookCopyTableModel(String bookNumber, ArrayList<BookCopy> listBooksCopyResult) {
        this.bookNumber=bookNumber;
        this.listBooksCopyResult=listBooksCopyResult;
    }

    public void notificationDataHasChanged() {
        fireTableRowsInserted(listBooksCopyResult.size()-1, listBooksCopyResult.size()-1);
    }
    
    public void setData(ArrayList<BookCopy> listBooksResult){
        this.listBooksCopyResult=listBooksResult;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listBooksCopyResult.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    } 
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return bookNumber+listBooksCopyResult.get(rowIndex).getSequenceNumber();
            case 1: if(listBooksCopyResult.get(rowIndex).isTypeOfCopy()) return "Có thể mượn";
                    else return "Chỉ tham khảo";
            case 2: return listBooksCopyResult.get(rowIndex).getPrince()+"";
        }
        return null;
    }

}
