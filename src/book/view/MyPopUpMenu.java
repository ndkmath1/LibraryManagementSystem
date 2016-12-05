package book.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class MyPopUpMenu extends JPopupMenu{
    private JMenuItem anItem;
    private int currentPosition;
    private IBookManagementForm bookManagementForm;
    
    public MyPopUpMenu(IBookManagementForm bookManagementForm){
        this.bookManagementForm=bookManagementForm;
        anItem = new JMenuItem("Sửa thông tin sách");
    }
    
    public void setPosition(int currentPosition){
        this.currentPosition=currentPosition;
    }
    
    public void setMenuAction(ActionListener listener){
        anItem.addActionListener(listener);
    }
    
    
    
}
