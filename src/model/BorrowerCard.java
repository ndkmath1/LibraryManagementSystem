/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Khanh Nguyen
 */
public class BorrowerCard {
    private int cardId;
    private String activateCode;
    private String releaseDate;
    private String expiredDate;
    
    public BorrowerCard() {}
    
    public int getCardId() {
        return cardId;
    }
    
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    
    public String getActivateCode() {
        return activateCode;
    }
    
    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(String date) {
        this.releaseDate = date;
    }
    
    public String getExpiredDate() {
        return expiredDate;
    }
    
    public void setExpiredDate(String date) {
        this.expiredDate = date;
    }
}
