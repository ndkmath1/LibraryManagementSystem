package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BorrowerCardHelper {

    public static final String BORROW_CARD_ID = "^0-9";

    public static final boolean validateCardID(String borrowCardID) {
        if (borrowCardID.length() < 1) {
            return false;
        }
        Pattern p = Pattern.compile(BORROW_CARD_ID, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(borrowCardID);
        boolean check = m.find();
        if (check) {
            return false;
        }
        return true;
    }

    private static final String STUDENT_ID_OR_IDENTIFICATION = "^0-9";

    public static final boolean validateId(String id) {
        if (id.length() < 1) {
            return false;
        }
        Pattern p = Pattern.compile(STUDENT_ID_OR_IDENTIFICATION, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(id);
        boolean check = m.find();
        if (check) {
            return false;
        }
        return true;
    }

    public static Date getReleaseDate() {
        return new Date();
    }

    public static Date getExpiredDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    public static String generateActivateCode() {
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < 10; ++i) {
            sb.append(String.valueOf(1 + rd.nextInt(9)));
        }
        return sb.toString();
    }

    public static int generateBorrowerCardId() {
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < 5; ++i) {
            sb.append(String.valueOf(1 + rd.nextInt(9)));
        }
        return Integer.parseInt(sb.toString());
    }
}
