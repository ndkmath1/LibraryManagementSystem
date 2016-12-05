package model;

public class CatetoryBook {
    private int id;// mã phân loại dạng XY
    private String cateID;// tên phân loại
    private String cateName;
    
    public CatetoryBook(){
        
    }

    public CatetoryBook(int id, String cateID, String cateName) {
        this.id = id;
        this.cateID = cateID;
        this.cateName = cateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    
    
}
