/* RFormUtility.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Form Utility
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RFormUtility {
    
    public static int getLebar(int layar, int persen) {
        return (persen*layar)/100;
    }
    
    public static String getTanggal(Date tanggal){
        final SimpleDateFormat dateFormatTanggal =  new SimpleDateFormat("EEEE, dd MMMM yyyy");
        return dateFormatTanggal.format(tanggal);
    }
    
    public static String getShortTanggal(Date tanggal){
        final SimpleDateFormat dateFormatTanggal =  new SimpleDateFormat("dd-MM-yyyy");
        return dateFormatTanggal.format(tanggal);
    }
    
    public static String getStringCustomFormat(Date tanggal, String format) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(tanggal);
    }
    
    public static String getJam(Date tanggal){
        final SimpleDateFormat dateFormatJam =  new SimpleDateFormat("HH : mm : ss a");
        return dateFormatJam.format(tanggal);
    }
    
    public static String getNilaiTelepon(final String str) {
        String nilai = str;
        nilai = nilai.replaceAll("-", "");
        nilai = nilai.replaceAll(" ", "");
        int length = nilai.length();
        
        String kembali = "";
        int cacah = 0;
        
        for (int i=0; i<length;i++) {
            cacah++;
            if (cacah == 4 && i != length - 1) {
                cacah = 0;
                
                kembali += nilai.charAt(i) + "-";
            } else {
                kembali += nilai.charAt(i);
            }
        }
        return kembali;
    }
    
}
