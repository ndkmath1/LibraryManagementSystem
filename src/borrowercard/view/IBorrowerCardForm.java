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
public interface IBorrowerCardForm {
    
    public void setButtonIssuedListener(ActionListener listener);
    
    public void setButtonBackListener(ActionListener listener);
    
    public void setVisibleForm(boolean isVisible);
    
    public void closeForm();
    
}
