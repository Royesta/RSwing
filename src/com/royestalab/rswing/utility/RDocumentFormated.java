/* RDocumentFormated.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.utility;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Utility untuk Format Document Swing
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RDocumentFormated {
    
    /**
     * construct DocumentFormated and not filtering max input
     */
    public RDocumentFormated() {
        this.length = 0;
    }

    int length;

    /**
     * construct DocumentFormated with length max input
     *
     * @param length max input
     */
    public RDocumentFormated(int length) {
        this.length = length;
    }

    /**
     * get plain document with filter max input
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilter(final JTextField textField) {
        PlainDocument filter = new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet at) throws BadLocationException {
                int x = textField.getText().length();

                if (x < length) {
                    super.insertString(offset, str, at);
                }
            }
        };

        return filter;
    }

    /**
     * get plain document with filter max input and only digit
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilterOnlyDigit(final JTextField textField) {
        PlainDocument filterdigit = new PlainDocument() {

            @Override
            public void insertString(final int offs,
                    final String str,
                    final AttributeSet a) throws BadLocationException {

                if (length > 0 && textField.getText().length() < length) {
                    final char[] array = str.toCharArray();
                    boolean valid = false;

                    for (final char c : array) {
                        if (Character.isDigit(c)) {
                            valid = true;
                        } else {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        super.insertString(offs, str, a);
                    } else {
                        // DI BLOKIR TEKSNYA
                    }
                }

            }
        };

        return filterdigit;
    }
    
    /**
     * get plain document with filter max input and only digit
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilterOnlyTeleponOrFax(final JTextField textField) {
        PlainDocument filterdigit = new PlainDocument() {

            @Override
            public void insertString(final int offs,
                    final String str,
                    final AttributeSet a) throws BadLocationException {

                if (length > 0 && textField.getText().length() < length) {
                    final char[] array = str.toCharArray();
                    boolean valid = false;

                    for (final char c : array) {
                        if (Character.isDigit(c)) {
                            valid = true;
                        } else if (c == '-') {
                            valid = true;
                        } else {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        super.insertString(offs, str, a);
                    } else {
                        // DI BLOKIR TEKSNYA
                    }
                }

            }
        };

        return filterdigit;
    }

    /**
     * get plain document with filter max input and only letter
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilterOnlyLetter(final JTextField textField) {
        PlainDocument filterHuruf = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet ats)
                    throws BadLocationException {

                if (length > 0 && textField.getText().length() < length) {
                    StringBuffer buf = new StringBuffer();
                    int c = 0;
                    char[] tInput = str.toCharArray();

                    //memeriksa semua karakter yang dimasukkan
                    for (int i = 0; i < tInput.length; i++) {
                        /// menyaring apakah input huruf
                        boolean isOnlyLetter = Character.isLetter(tInput[i]) || tInput[i] == ',' || tInput[i] == '.';
                        if (isOnlyLetter == true) {
                            tInput[c] = tInput[i];
                            c++;
                        } else {
                            boolean isSpasi = Character.isSpaceChar(tInput[i]);
                            if (isSpasi == true) {
                                tInput[c] = tInput[i];
                                c++;
                            }
                        }
                    }
                    buf.append(tInput, 0, c);
                    super.insertString(offs, new String(buf), ats);
                }
            }
        };
        return filterHuruf;
    }

    /**
     * get plain document with filter max input and lower case
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilterLower(final JTextField textField) {
        PlainDocument lower = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet ats)
                    throws BadLocationException {
                if (length > 0 && textField.getText().length() < length) {
                    char[] low = str.toCharArray();
                    for (int i = 0; i < low.length; i++) {
                        low[i] = Character.toLowerCase(low[i]);
                    }
                    super.insertString(offs, new String(low), ats);
                }
            }
        };
        return lower;
    }

    /**
     * get plain document with filter max input and upper case
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilterUpper(final JTextField textField) {
        PlainDocument upper = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet ats)
                    throws BadLocationException {

                if (length > 0 && textField.getText().length() < length) {
                    char[] upp = str.toCharArray();
                    for (int i = 0; i < upp.length; i++) {
                        upp[i] = Character.toUpperCase(upp[i]);
                    }
                    super.insertString(offs, new String(upp), ats);
                }
            }
        };
        return upper;
    }

    /**
     * get plain document with filter max input, upper case, and only letter
     *
     * @param textField object instance JTextField
     * @return document
     */
    public PlainDocument getFilterOnlyLetterUpper(final JTextField textField) {
        PlainDocument letterUpper = new PlainDocument() {

            @Override
            public void insertString(final int offs,
                    final String str,
                    final AttributeSet a) throws BadLocationException {

                if (length > 0 && textField.getText().length() < length) {
                    final char[] array = str.toCharArray();
                    boolean valid = false;

                    for (int i = 0; i < array.length; i++) {
                        if (Character.isDigit(array[i])) {
                            valid = false;
                            break;
                        } else {
                            valid = true;
                            array[i] = Character.toUpperCase(array[i]);
                        }
                    }

                    if (valid) {

                        super.insertString(offs, new String(array), a);
                    } else {
                        // DI BLOKIR TEKSNYA
                    }
                }

            }
        };

        return letterUpper;
    }

    /**
     * Get Only Letter from teks
     *
     * @return letter as PlainDocument
     */
    public PlainDocument getOnlyLetter() {
        PlainDocument filterHuruf = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet ats)
                    throws BadLocationException {
                StringBuffer buf = new StringBuffer();
                int c = 0;
                char[] tInput = str.toCharArray();

                //memeriksa semua karakter yang dimasukkan
                for (int i = 0; i < tInput.length; i++) {
                    /// menyaring apakah input huruf
                    boolean isOnlyLetter = Character.isLetter(tInput[i]) || tInput[i] == ',' || tInput[i] == '.';
                    if (isOnlyLetter == true) {
                        tInput[c] = tInput[i];
                        c++;
                    } else {
                        boolean isSpasi = Character.isSpaceChar(tInput[i]);
                        if (isSpasi == true) {
                            tInput[c] = tInput[i];
                            c++;
                        }
                    }
                }
                buf.append(tInput, 0, c);
                super.insertString(offs, new String(buf), ats);
            }
        };
        return filterHuruf;
    }

    public PlainDocument getOnlyLetterTitleUpper() {
        PlainDocument letterUpper = new PlainDocument() {

            @Override
            public void insertString(final int offs,
                    final String str,
                    final AttributeSet a) throws BadLocationException {

                final char[] array = str.toCharArray();
                boolean valid = false;

                for (int i = 0; i < array.length; i++) {
                    if (Character.isDigit(array[i])) {
                        valid = false;
                        break;
                    } else {
                        valid = true;
                        if (i == 0) {
                            array[i] = Character.toUpperCase(array[i]);
                        } else if (array[i - 1] == ' ') {
                            array[i] = Character.toUpperCase(array[i]);
                        } else {
                            array[i] = Character.toLowerCase(array[i]);
                        }
                        //array[i] = Character.toTitleCase(array[i]);
                    }
                }

                if (valid) {

                    super.insertString(offs, new String(array), a);
                } else {
                    // DI BLOKIR TEKSNYA
                }

            }
        };

        return letterUpper;
    }

    /**
     * Get Only Letter and Upper from teks
     *
     * @return letterupper as PlainDocument
     */
    public PlainDocument getOnlyLetterUpper() {
        PlainDocument letterUpper = new PlainDocument() {

            @Override
            public void insertString(final int offs,
                    final String str,
                    final AttributeSet a) throws BadLocationException {

                final char[] array = str.toCharArray();
                boolean valid = false;

                for (int i = 0; i < array.length; i++) {
                    if (Character.isDigit(array[i])) {
                        valid = false;
                        break;
                    } else {
                        valid = true;
                        array[i] = Character.toUpperCase(array[i]);
                    }
                }

                if (valid) {

                    super.insertString(offs, new String(array), a);
                } else {
                    // DI BLOKIR TEKSNYA
                }

            }
        };

        return letterUpper;
    }

    /**
     * Get Only Digit from teks
     *
     * @return digit as PlainDocument
     */
    public PlainDocument getOnlyDigit() {
        PlainDocument digit = new PlainDocument() {

            @Override
            public void insertString(final int offs,
                    final String str,
                    final AttributeSet a) throws BadLocationException {

                final char[] array = str.toCharArray();
                boolean valid = false;

                for (final char c : array) {
                    if (Character.isDigit(c)) {
                        valid = true;
                    } else {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    super.insertString(offs, str, a);
                } else {
                    // DI BLOKIR TEKSNYA
                }

            }
        };

        return digit;
    }

    /**
     * Get Upper of teks
     *
     * @return upper as PlainDocument
     */
    public PlainDocument getUpper() {
        PlainDocument upper = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet ats)
                    throws BadLocationException {
                char[] upp = str.toCharArray();
                for (int i = 0; i < upp.length; i++) {
                    upp[i] = Character.toUpperCase(upp[i]);
                }
                super.insertString(offs, new String(upp), ats);
            }
        };
        return upper;
    }

    /**
     * Get Lower of teks
     *
     * @return lower as PlainDocument
     */
    public PlainDocument getLower() {
        PlainDocument lower = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet ats)
                    throws BadLocationException {
                char[] low = str.toCharArray();
                for (int i = 0; i < low.length; i++) {
                    low[i] = Character.toLowerCase(low[i]);
                }
                super.insertString(offs, new String(low), ats);
            }
        };
        return lower;
    }

    public String PecahDigitHargaINDO(String nilai) {
        String harga = "";
        String sementara = "";
        String s = "";
        int j;
        
        String tanda = "";
        
        if (nilai.startsWith("-")) {
            tanda = "-";
            nilai = nilai.replace("-", "");
        }

        if (nilai.length() > 3) {      // jika panjang nilai lebih dari 3
            // dari panjang nilai sampai akhir karakter nilai
            for (int i = nilai.length(); i > 0; i--) {
                sementara = sementara + nilai.substring(i - 1, i);
                if (sementara.length() == 3) {
                    if (harga.equals("")) {
                        for (j = 3; j > 0; j--) {
                            harga = harga + sementara.substring(j - 1, j);
                        }
                    } else {
                        for (j = sementara.length(); j > 0; j--) {
                            s = s + sementara.substring(j - 1, j);
                            //    harga = sementara.substring(j-1,j) + harga;
                            //    System.out.print(sementara.substring(j-1,j));
                        }

                        harga = s + "." + harga;
                        s = "";
                    }

                    sementara = "";

                }
            }

            if (sementara.equals("")) {

            } else {
                s = "";
                for (j = sementara.length(); j > 0; j--) {
                    s = s + sementara.substring(j - 1, j);
                }
                harga = s + "." + harga;
            }
        } else {
            harga = nilai;
        }
        
        if (!tanda.trim().isEmpty()) {
            harga = tanda + harga;
        }

        return harga;
    }
}
