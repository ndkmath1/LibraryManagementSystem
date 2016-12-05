/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.factory;

import book.interfaces.IBookManagementSystem;
import book.interfaces.IBorrowBookSystem;
import book.interfaces.IReturnBookSystem;
import book.system.BookSystem;

/**
 *
 * @author Khanh Nguyen
 */
public class BookSystemFactory {
    private static IBorrowBookSystem borrowSystem;
    private static IReturnBookSystem returnSystem;
    private static IBookManagementSystem bookManagementSystem;
    
    public static IBorrowBookSystem getBorrowBookSystem () {
        if (borrowSystem == null) {
            borrowSystem = new BookSystem();
        }
        return borrowSystem;
    }
    
    public static IReturnBookSystem getReturnBookSystem () {
        if (returnSystem == null) {
            returnSystem = new BookSystem();
        }
        return returnSystem;
    }
    
    public static IBookManagementSystem getBookManagementSystem () {
        if (bookManagementSystem == null) {
            bookManagementSystem = new BookSystem();
        }
        return bookManagementSystem;
    }
    
}
