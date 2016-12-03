package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {
     public static Date getDateFromString(String date){
        DateFormat df=new SimpleDateFormat("dd - MM - yyyy");
        try {
            return df.parse(date);
        } catch (Exception e) {
            System.out.println("e_date="+e);
            return null;
        }
    }
}
