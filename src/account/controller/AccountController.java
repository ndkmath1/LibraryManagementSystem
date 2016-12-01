/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.controller;

import account.factory.AccountSystemFactory;
import account.interfaces.IAccountSystem;

/**
 *
 * @author Khanh Nguyen
 */
public class AccountController {
    
    public static void main(String[] args) {
        IAccountSystem s = AccountSystemFactory.getAccountSystem();
    }
    
}
