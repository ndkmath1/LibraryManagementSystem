package book.view;

import model.Book;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.CatetoryBook;
import utils.BookHelper;

public class BookTableModel extends AbstractTableModel {
    private ArrayList<Book> listBooksResult;
    private ArrayList<CatetoryBook> listCatetoryBooks;
    private static final String[] columnNames = {"Mã sách", "Tên sách", "Tác giả", "NXB", "IBNS"};
 
    public BookTableModel(ArrayList<Book> listBooksResult, ArrayList<CatetoryBook> listCatetoryBooks) {
        this.listCatetoryBooks=listCatetoryBooks;
        this.listBooksResult=listBooksResult;
    }

    public void notificationDataHasChanged() {
        fireTableRowsInserted(listBooksResult.size()-1, listBooksResult.size()-1);
    }    

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listBooksResult.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    } 
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return BookHelper.formatOfBookNumber(BookHelper.getCateCode(listBooksResult.get(rowIndex).getCateID(), listCatetoryBooks),listBooksResult.get(rowIndex).getNumOfBook());
            case 1: return listBooksResult.get(rowIndex).getTitle();
            case 2: return listBooksResult.get(rowIndex).getAuthor();
            case 3: return listBooksResult.get(rowIndex).getPublisher();
            case 4: return listBooksResult.get(rowIndex).getIbns();
        }
        return null;
    }
}
