
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BorrowerCardHelper {
    public static final String BORROW_CARD_ID="^0-9";
    public static final boolean validateCardID(String borrowCardID){
        if(borrowCardID.length()<1) return false;
        Pattern p = Pattern.compile(BORROW_CARD_ID, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(borrowCardID);
        boolean check = m.find();
        if (check) return false;
        return true;
    }
}
