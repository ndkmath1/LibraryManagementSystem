/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Khanh Nguyen
 */
public class DateTimeHelper {
     public static Date getDateFromString(String day, String month, String year){
        String s_date=day+"/"+month+"/"+year;
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = df.parse(s_date);
            return date;
        } catch (Exception e) {
            System.out.println("e_date="+e);
            return null;
        }
    }
}
