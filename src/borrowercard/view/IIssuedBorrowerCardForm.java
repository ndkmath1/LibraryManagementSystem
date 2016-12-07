/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.view;

import java.awt.event.ActionListener;

/**
 *
 * @author Khanh Nguyen
 */
public interface IIssuedBorrowerCardForm {
    
    public void setVisibleForm(boolean isVisible);
    
    public void closeForm();
    
    public void setButtonSearchActionListener(ActionListener listener);
    
    public void setButtonIssuedActionListener(ActionListener listener);
    
    public void setButtonBackActionListener(ActionListener listener);
    
    public String getId();
    
    public void setTextAreaInfo(String info);
    
    public void nontifiesInfoWrong();
    
    public void nontifiesSuccessful(String info);
    
    public void setButtonIssuedEnable(boolean b);
    
}
