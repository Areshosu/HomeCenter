/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author sphal
 */
public class SharedHelper {
    private static final String datePattern = "dd/MM/yyyy, h:mma";
    
    public static <T> int indexOf(T[] arr, T val) {
        return Arrays.asList(arr).indexOf(val);
    }
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    
    public static LocalDateTime isValidDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        
        try {
            return LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String dateToString(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);

        try {
            return dateTime.format(formatter);
        } catch (Exception ex) {
            return null;
        }
    }
}
