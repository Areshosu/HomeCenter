/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author sphal
 */
public class SharedHelper {
    public static <T> int indexOf(T[] arr, T val) {
        return Arrays.asList(arr).indexOf(val);
    }
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
