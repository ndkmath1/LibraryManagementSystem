
package book.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class MyPopUpMenuBookCopy extends JPopupMenu{
    private JMenuItem anItem;
    private int currentPosition;
    private String currentBookCopyNumber;
    private IBookManagementForm bookManagementForm;
    
    public MyPopUpMenuBookCopy(IBookManagementForm bookManagementForm){
        this.bookManagementForm=bookManagementForm;
        anItem = new JMenuItem("Sửa thông tin bản sao");
        add(anItem);
    }
    
    public void setActionForItemMenu(ActionListener listener){
        anItem.addActionListener(listener);
    }
    
    public void setPosition(int currentPosition){
        this.currentPosition=currentPosition;
    }
    
    public int getCurrentPosition(){
        return currentPosition;
    }
    
    public void setCurrentBookCopyNumber(String currentBookCopyNumber){
        this.currentBookCopyNumber=currentBookCopyNumber;
    }
    
    public String getCurrentBookCopyNumber(){
        return this.currentBookCopyNumber;
    }
}
