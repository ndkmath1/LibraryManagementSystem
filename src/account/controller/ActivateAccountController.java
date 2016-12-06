/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.controller;

import account.view.ActivateAccountForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import account.view.IActivateAccountForm;
import account.view.IUserMainForm;
import borrowercard.factory.BorrowerCardSystemFactory;
import borrowercard.interfaces.IBorrowerCardSystem;
import model.Account;

/**
 *
 * @author Khanh Nguyen
 */
public class ActivateAccountController {

    private IActivateAccountForm activateAccount;
    private IUserMainForm userMainForm;
    private IBorrowerCardSystem bCardSystem = BorrowerCardSystemFactory.getBorrowerCardSystem();

    public ActivateAccountController(IUserMainForm userMainForm, Account mAccount) {

        //get state of account
        if (bCardSystem.getStateAccount(mAccount.getAccounrID())) {
            userMainForm.nontifiesAccountIsActivated();
        } else {
            this.userMainForm = userMainForm;
            activateAccount = new ActivateAccountForm();
            activateAccount.setVisibleForm(true);
            activateAccount.setButtonActivateListener(new ButtonActivateActionListener());
        }
    }

    private class ButtonActivateActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button activate is clicked");
        }
    }
}
