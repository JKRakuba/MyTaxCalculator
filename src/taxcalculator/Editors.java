/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author NaeemFranks
 * Used to edit Information
 */
public class Editors {
     
    /**
    * Method formats the decimals of a number passed into 2 decimal places.
    *  Numbers  are divided by a comma (,) after every 3 digits.
     * @param n
     * @return String
    */
    public static String format(Number n) {
        NumberFormat format = DecimalFormat.getInstance();
        format.setRoundingMode(RoundingMode.FLOOR);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(3);
        return format.format(n);
    }
    
    /**
    * a String that is passed to this method will be converted into upper-camel casing and returned
    * e.g naeem franks will be returned as Naeem Franks
     * @param word
     * @return String
    */
    public static String toCamelCase(String word){
        String toUc = "";
        int len = word.length();
        String[] splitWords = word.split(" ");
        
            for(int x = 0; x < splitWords.length; ++x){
                for(int y = 0; y < splitWords[x].length(); ++y){
                    if(y == 0)
                        toUc += splitWords[x].toUpperCase().charAt(y);
                    else
                        toUc += splitWords[x].toLowerCase().charAt(y);

                }
                if(x < splitWords.length - 1)
                toUc += " ";
            }

        return toUc;
        
    }
}
