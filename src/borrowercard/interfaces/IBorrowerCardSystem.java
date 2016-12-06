/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.interfaces;

import model.Account;

/**
 * Define responsibility of BorrowerCardSystem
 *
 * @author Khanh Nguyen
 */
public interface IBorrowerCardSystem {
    
    public boolean getStateAccount(int accountId);
    
    public String getInfoAccount(Account mAccount);
    
    public boolean checkInfoActivate(int accountId, String activateCode);
    
    public boolean setAccountActivated(int accountId);
    
    public boolean isAccountHasBorrowerCard(int accountId);

    public int checkBorrowCard(int borrowCardID);
   
}
