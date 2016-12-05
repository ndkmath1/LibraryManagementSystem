package utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.CatetoryBook;

public class BookHelper {
    private static final String BOOK_NAME_CHARACTER = "[^A-Za-z0-9 ]";
    private static final String BOOK_CHARACTER = "[^A-Za-z0-9]";
    private static final String NUM_OF_BOOK_CHARACTER= "[^0-9]";
    private static final String PRINCE_OF_BOOK_CHARACTER="[^0-9]";
    private static final String AUTHOR_CHARACTER="[^A-Za-z ]";
    private static final String PUBLISHER_CHARACTER="[^A-Za-z0-9 ]";
    private static final String IBNS_CHARACTER="[^A-Z0-9]";
    
    public static final boolean validateBookNumber(String bookNumber){
        if(bookNumber.length()!=6) return false;
        if(!Character.isLetter(bookNumber.charAt(0))) return false;
        if(!Character.isLetter(bookNumber.charAt(1))) return false;
        for(int i=2;i<6;i++) 
            if(!Character.isDigit(bookNumber.charAt(i))) return false;
        Pattern p = Pattern.compile(BOOK_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(bookNumber);
        boolean check = m.find();
        if (check) return false;
        return true;
    }
    
    public static final boolean validateNumOfBook(String numOfBook){
        if(numOfBook.length()<1) return false;
        Pattern p = Pattern.compile(NUM_OF_BOOK_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(numOfBook);
        boolean check = m.find();
        if (check) return false;
        return true;
    }
    
    public static final boolean validateNumOfCopy(String numOfCopy){
        if(numOfCopy.length()<=0) return false;
        Pattern p = Pattern.compile(NUM_OF_BOOK_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(numOfCopy);
        boolean check = m.find();
        if (check) return false;
        return true;
    }
    
    public static final boolean validatePrinceOfCopy(String prince){
        if(prince.length()<=0) return false;
        Pattern p = Pattern.compile(PRINCE_OF_BOOK_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(prince);
        boolean check = m.find();
        if (check) return false;
        return true;
    }
    
    public static final boolean validateAuthor(String author){
        if(author.length()<6) return false;
//        Pattern p = Pattern.compile(AUTHOR_CHARACTER, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(author);
//        boolean check = m.find();
//        if (check) return false;
        return true;
    }
    
    public static final boolean validatePublisher(String publisher){
        if(publisher.length()<6) return false;
//        Pattern p = Pattern.compile(PUBLISHER_CHARACTER, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(publisher);
//        boolean check = m.find();
//        if (check) return false;
        return true;
    }
    
    public static final boolean validateIBNS(String ibns){
        if(ibns.length()<6) return false;
        Pattern p = Pattern.compile(IBNS_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(ibns);
        boolean check = m.find();
        if (check) return false;
        return true;
    }
    
      public static final boolean validateBookName(String name){
        if(name.length()<6) return false;
//        Pattern p = Pattern.compile(BOOK_NAME_CHARACTER, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(name);
//        boolean check = m.find();
//        if (check) return false;
        return true;
    }
      
    public static String formatOfBookNumber(String cateID, int numOfBook){
        if(numOfBook<10) 
            return cateID+"000"+numOfBook;
        else if(numOfBook<100&& numOfBook>9) 
            return cateID+"00"+numOfBook;
        else if(numOfBook>99 && numOfBook<1000) 
            return cateID+"0"+numOfBook;
        else if(numOfBook>999&&numOfBook<10000) 
            return cateID+numOfBook;
        else return cateID+"ERROR";
    }
    
    public static String deFormatOfBookNumber(String bookNumber){
        System.out.println("data="+bookNumber.substring(0, 2)+Integer.valueOf(bookNumber.substring(2,6)));
        return bookNumber.substring(0, 2)+Integer.valueOf(bookNumber.substring(2,6));
    }
    
    public static String getCateCode(int iD, ArrayList<CatetoryBook> listCatetoryBooks){
        for(CatetoryBook c:listCatetoryBooks){
            if(c.getId()==iD) return c.getCateID();
        }
        return "";
    } 
}
