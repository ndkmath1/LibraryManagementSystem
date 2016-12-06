package model;

import java.util.Date;

public class Borrow {
    private int id;
    private int cardID;
    private Date lendDate;
    private Date expiredDate;

    public Borrow(int id, int cardID, Date lendDate, Date expiredDate) {
        this.id = id;
        this.cardID = cardID;
        this.lendDate = lendDate;
        this.expiredDate = expiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    
    
}
