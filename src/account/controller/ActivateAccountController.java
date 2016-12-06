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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.Account;

/**
 *
 * @author Khanh Nguyen
 */
public class ActivateAccountController {

    private IActivateAccountForm activateAccount;
    private IUserMainForm userMainForm;
    private IBorrowerCardSystem bCardSystem = BorrowerCardSystemFactory.getBorrowerCardSystem();
    private Account mAccount;

    public ActivateAccountController(IUserMainForm userMainForm, Account mAccount) {
        this.mAccount = mAccount;
        if (!bCardSystem.isAccountHasBorrowerCard(mAccount.getAccounrID())) {
            userMainForm.nontifiesNotYetBorrowerCard();
        } else if (bCardSystem.getStateAccount(mAccount.getAccounrID())) {
            userMainForm.nontifiesAccountIsActivated();
        } else {
            this.userMainForm = userMainForm;
            activateAccount = new ActivateAccountForm();
            activateAccount.setVisibleForm(true);
            activateAccount.setTextForLabelInfo(bCardSystem.getInfoAccount(mAccount));
            activateAccount.setButtonActivateListener(new ButtonActivateActionListener());
            activateAccount.setWindowsListenerForFom(new CloseWindowsListener());
        }
    }

    private class ButtonActivateActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //check activate code
            if (bCardSystem.checkInfoActivate(mAccount.getAccounrID(), activateAccount.getActivateCode())) {
                if (bCardSystem.setAccountActivated(mAccount.getAccounrID())) {
                    activateAccount.nontifiesActivateSuccessful();
                    activateAccount.setActivateCodeEditable(false);
                }
            } else {
                activateAccount.nontifiesActivateCodeWrong();
            }
        }
    }
    
    private class CloseWindowsListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            activateAccount.closeForm();
            userMainForm.setVisibleForm(true);
        }
        
    }
}
