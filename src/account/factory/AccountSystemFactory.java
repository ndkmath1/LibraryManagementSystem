/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.factory;

import account.interfaces.IAccountSystem;
import account.system.AccountSystem;

/**
 *
 * @author Khanh Nguyen
 */
public class AccountSystemFactory {

    private static IAccountSystem accountSystem;

    public static IAccountSystem getAccountSystem() {
        if (accountSystem == null) {
            accountSystem = new AccountSystem();
        }
        return accountSystem;
    }

}
