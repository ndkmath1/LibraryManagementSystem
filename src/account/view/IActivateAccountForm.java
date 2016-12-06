/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;

import java.awt.event.ActionListener;

/**
 *
 * @author Khanh Nguyen
 */
public interface IActivateAccountForm {
    
    public void setButtonActivateListener(ActionListener listener);
    
    public String getActivateCode();
    
    public void setTextForLabelInfo(String info);
    
    public void setVisibleForm(boolean isVisible);
    
    public void closeForm();
    
    public void nontifiesActivateCodeWrong();
    
    public void nontifiesActivateSuccessful();
    
}
