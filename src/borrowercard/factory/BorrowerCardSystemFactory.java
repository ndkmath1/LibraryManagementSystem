/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.factory;

import borrowercard.interfaces.IBorrowerCardSystem;
import borrowercard.system.BorrowerCardSystem;

/**
 *
 * @author Khanh Nguyen
 */
public class BorrowerCardSystemFactory {
    private static IBorrowerCardSystem bCardSystem;
    
    public static IBorrowerCardSystem getBorrowerCardSystem () {
        if (bCardSystem == null) {
            bCardSystem = new BorrowerCardSystem();
        }
        return bCardSystem;
    }
}
