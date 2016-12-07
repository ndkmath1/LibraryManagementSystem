/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowercard.controller;

import book.view.ILibrarianMainForm;
import borrowercard.view.BorrowerCardForm;
import borrowercard.view.IBorrowerCardForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Khanh Nguyen
 */
public class BorrowerCardController {
    private ILibrarianMainForm libForm;
    private IBorrowerCardForm bCardForm;
    
    public BorrowerCardController(ILibrarianMainForm libForm) {
        this.libForm = libForm;
        bCardForm = new BorrowerCardForm();
        bCardForm.setVisibleForm(true);
        bCardForm.setButtonIssuedListener(new IssuedButtonActionListener());
        bCardForm.setButtonBackListener(new BackButtonActionListener());
    }
    
    private class IssuedButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            bCardForm.setVisibleForm(false);
            new IssuedBorrowerCardController(bCardForm);
        }
        
    }
    
    private class BackButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            bCardForm.setVisibleForm(false);
            libForm.setVisibleForm(true);
        }
        
    }
}
