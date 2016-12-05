
package book.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class MyPopUpMenuBookCopy extends JPopupMenu{
    private JMenuItem anItem;
    private int currentPosition;
    private JTabbedPane tab;
    private IBookManagementForm bookManagementForm;
    
    public MyPopUpMenuBookCopy(IBookManagementForm bookManagementForm){
        this.bookManagementForm=bookManagementForm;
        this.tab=tab;
        anItem = new JMenuItem("Sửa thông tin bản sao");
        add(anItem);
        anItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookManagementForm.showBookCopyInfoToEdit(currentPosition);
            }
        });
    }
    
    public void setPosition(int currentPosition){
        this.currentPosition=currentPosition;
    }
    
}
