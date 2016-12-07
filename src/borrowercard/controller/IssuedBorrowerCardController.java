/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.controller;

import borrowercard.factory.BorrowerCardSystemFactory;
import borrowercard.interfaces.IBorrowerCardSystem;
import borrowercard.view.IBorrowerCardForm;
import borrowercard.view.IIssuedBorrowerCardForm;
import borrowercard.view.IssuedBorrowerCardForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.BorrowerCardHelper;

/**
 *
 * @author Khanh Nguyen
 */
public class IssuedBorrowerCardController {

    private IIssuedBorrowerCardForm issuedBCF;
    private IBorrowerCardForm bCardForm;
    private IBorrowerCardSystem bCardSystem = BorrowerCardSystemFactory.getBorrowerCardSystem();

    public IssuedBorrowerCardController(IBorrowerCardForm bCardForm) {
        this.bCardForm = bCardForm;
        issuedBCF = new IssuedBorrowerCardForm();
        issuedBCF.setVisibleForm(true);
        issuedBCF.setButtonSearchActionListener(new SearchButtonListener());
        issuedBCF.setButtonIssuedActionListener(new IssuedButtonListener());
        issuedBCF.setButtonBackActionListener(new BackButtonListener());
    }

    private class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            checkInfo();
        }

    }

    private class IssuedButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!BorrowerCardHelper.validateId(issuedBCF.getId())) {
                issuedBCF.nontifiesInfoWrong();
            } else {
                String str = bCardSystem.getInfoUser(issuedBCF.getId());
                if (str.length() == 0) {
                    issuedBCF.nontifiesInfoWrong();
                } else {
                    int b = bCardSystem.checkStateBorrowerCard(issuedBCF.getId());
                    if (b < 0) {
                        str += "\nTrạng thái: Đã có thẻ mượn";
                        issuedBCF.setButtonIssuedEnable(false);
                    } else {
                        str += "\nTrạng thái: Chưa có thẻ mượn";
                    }
                    issuedBCF.setTextAreaInfo(str);
                    String iss = bCardSystem.issuedBorrowerCard(b);
                    issuedBCF.nontifiesSuccessful(str + "\n" + iss);
                }
            }

        }

    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            bCardForm.setVisibleForm(true);
            issuedBCF.setVisibleForm(false);
        }

    }

    private void checkInfo() {
        if (!BorrowerCardHelper.validateId(issuedBCF.getId())) {
            issuedBCF.nontifiesInfoWrong();
        } else {
            String str = bCardSystem.getInfoUser(issuedBCF.getId());
            if (str.length() == 0) {
                issuedBCF.nontifiesInfoWrong();
            } else {
                int b = bCardSystem.checkStateBorrowerCard(issuedBCF.getId());
                if (b < 0) {
                    str += "\nTrạng thái: Đã có thẻ mượn";
                    issuedBCF.setButtonIssuedEnable(false);
                } else {
                    str += "\nTrạng thái: Chưa có thẻ mượn";
                }
                issuedBCF.setTextAreaInfo(str);
            }
        }
    }

}
