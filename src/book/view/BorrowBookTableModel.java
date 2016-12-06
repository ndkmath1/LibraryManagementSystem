package book.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Book;
import model.CatetoryBook;
import utils.BookHelper;

public class BorrowBookTableModel extends AbstractTableModel {
    private ArrayList<DataShow> listData;
    private static final String[] columnNames = {"Mã sách", "Tên sách", "Tác giả", "NXB", "IBNS","Trạng thái","Giá tiền"};
 
    public BorrowBookTableModel() {
       listData=new ArrayList<>();
    }

    public void notificationDataHasChanged() {
        fireTableRowsInserted(listData.size()-1, listData.size()-1);
    }    

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    } 
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return listData.get(rowIndex).getBookCopyNumber();
            case 1: return listData.get(rowIndex).getName();
            case 2: return listData.get(rowIndex).getAuthor();
            case 3: return listData.get(rowIndex).getPublisher();
            case 4: return listData.get(rowIndex).getIbns();
            case 5: return listData.get(rowIndex).getStatus();
            case 6: return listData.get(rowIndex).getPrince();
        }
        return null;
    }
    
    private boolean isBookNumberExisted(String bookCopyNumber){
       for(DataShow dt:listData){
           if(dt.bookCopyNumber.equals(bookCopyNumber)) return true;
       }
       return false;
    }
    
    public boolean addData(String bookCopyNumber, String name, String author, String publisher, String ibns, String status, long price){
        if(listData.size()>5) return false;
        if(!isBookNumberExisted(bookCopyNumber)){
            listData.add(new DataShow(bookCopyNumber, name, author, publisher, ibns, status, price));
            return true;
        }
        return false;
    }
    private class DataShow{
        private String bookCopyNumber;
        private String name;
        private String author;
        private String publisher;
        private String ibns;
        private String status;
        private long price;
        public DataShow(String bookCopyNumber, String name, String author, String publisher, String ibns, String status, long price) {
            this.bookCopyNumber = bookCopyNumber;
            this.name = name;
            this.author = author;
            this.publisher = publisher;
            this.ibns = ibns;
            this.status = status;
            this.price=price;
        }

        public String getBookCopyNumber() {
            return bookCopyNumber;
        }

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getIbns() {
            return ibns;
        }

        public String getStatus() {
            return status;
        }
        
        public long getPrince(){
            return this.price;
        }
    }

}
