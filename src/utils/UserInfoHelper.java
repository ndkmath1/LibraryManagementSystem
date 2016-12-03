package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoHelper {
    public static final String NAME_CHARACTER="[^!@#$%^&*()-+,.?/'~`|]";
    public static final String PHONE_CHARACTER="[^0-9]";
    public static final String ADDRESS_CHARACTER="[^!@#$%^&*()+?/'~`|]";
    
    public static boolean validateName(String name){
        if(name.length()<6 || name.length()>40) return false;
        Pattern p = Pattern.compile(NAME_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        boolean check = m.find();
        if(check) return true;
        return false;
    }
    
    public static boolean validatePhone(String phone){
        if(phone.length()<8 || phone.length()>15) return false;
        Pattern p = Pattern.compile(PHONE_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(phone);
        boolean check = m.find();
        if(check) return false;
        return true;
    }
    
    public static boolean validateAddress(String address){
        if(address.length()<8 || address.length()>70) return false;
        Pattern p = Pattern.compile(ADDRESS_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(address);
        boolean check = m.find();
        if(check) return true;
        return false;
    }
    
    public static boolean validateNationalID(String nationalID){
        if(nationalID.length()<9 || nationalID.length() >12) return false;
        Pattern p = Pattern.compile(PHONE_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nationalID);
        boolean check = m.find();
        if(check) return false;
        return true;
    }
    
    public static boolean validateStudentID(String studentID){
        if(studentID.length()!=8) return false;
        Pattern p = Pattern.compile(PHONE_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(studentID);
        boolean check = m.find();
        if(check) return false;
        return true;
    }
}
