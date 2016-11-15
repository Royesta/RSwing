/* REmailFormated.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.utility;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;

/**
 * Email Formated
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class REmailFormated extends JFormattedTextField.AbstractFormatter {

    Pattern regexp = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
 
    @Override
    public Object stringToValue(String string) throws ParseException {
        Matcher matcher = regexp.matcher(string);
        if(matcher.matches()){
            return string;
        }else{
           throw new ParseException("Masukan Email Yang Valid !!!", 1);
//            return "Masukan Email Yang Valid !!!";
        }
    }
 
    @Override
    public String valueToString(Object value) throws ParseException {
        return (String) value;
    }

}
