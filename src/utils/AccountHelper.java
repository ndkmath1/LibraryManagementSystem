/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Khanh Nguyen
 */
public class AccountHelper {
    private static final String USER_CHARACTER="[^_A-Za-z0-9]";
    private static final String EMAIL_CHARACTER="[^@.A-Za-z0-9]";
    private static final String PASSWORD_CHARACTER="[^A-Za-z0-9]";
    
    public static boolean validateUsername(String username){
        if(username.length()<6 || username.length()>20) return false;
        Pattern p = Pattern.compile(USER_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(username);
        boolean check = m.find();
        if(check) return false;
        return true;
    }
    
    public static boolean validateEmail(String email) {
        if(email.length()<6 || email.length()>20) return false;
        if(!email.contains("@")) return false;
        if(!email.contains(".")) return false;
        Pattern p = Pattern.compile(EMAIL_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        boolean check = m.find();
        if(check) return false;
        return true;
    }
    
    public static boolean validatePassword(String password) {
        if(password.length()<6 || password.length()>20) return false;
        Pattern p = Pattern.compile(PASSWORD_CHARACTER, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean check = m.find();
        if(check) return false;
        return true;
    }
    
    public static String getMD5encrypt(String password){            
        StringBuffer sb = new StringBuffer();
        try{ 
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            for (int i = 0; i < thedigest.length; i++) {
              sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
            
        } catch (UnsupportedEncodingException ex) {
           
        }
        return sb.toString();
    }
    
   
}
