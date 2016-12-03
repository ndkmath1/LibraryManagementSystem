/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.controller;

import borrowercard.view.IIssuedBorrowerCardForm;
import borrowercard.view.IssuedBorrowerCardForm;

/**
 *
 * @author Khanh Nguyen
 */
public class IssuedBorrowerCardController {

    private IIssuedBorrowerCardForm issuedBCF;

    public IssuedBorrowerCardController() {
        issuedBCF = new IssuedBorrowerCardForm();
    }

}
