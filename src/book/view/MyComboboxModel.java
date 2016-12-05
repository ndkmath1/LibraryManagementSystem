package book.view;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import model.CatetoryBook;

public class MyComboboxModel extends AbstractListModel implements ComboBoxModel {
    private ArrayList<CatetoryBook> listCategoryBooks;
    private String selected;
    public MyComboboxModel(ArrayList<CatetoryBook> listCategoryBooks){
        this.listCategoryBooks=listCategoryBooks;
    }


    public Object getElementAt(int index) {
      return listCategoryBooks.get(index).getCateID()+":    "+listCategoryBooks.get(index).getCateName();
    }

    public int getSize() {
      return listCategoryBooks.size();
    }

    public void setSelectedItem(Object anItem) {
        selected=(String)anItem;
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    public Object getSelectedItem() {
        return selected;
    }
}