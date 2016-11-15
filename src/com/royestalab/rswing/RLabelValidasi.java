/* RLabelValidasi.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Label untuk validasi
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RLabelValidasi extends JPanel {
    
    private final JLabel labelValidasi;
    private final JLabel labelTeks;
    private Font fontValidasi;
    private Color foregroundValidasi;
    
    private Font fontTeks;
    private Color foregroundTeks;
    
    public RLabelValidasi() {
        super();
        setOpaque(false);
        setLayout(new BorderLayout());
        
        labelValidasi = new JLabel("* ");
        labelValidasi.setFont(new Font("Verdana", Font.BOLD, 14));
        labelValidasi.setForeground(Color.RED);
        
        labelTeks = new JLabel("label Teks");
        
        add(labelValidasi, BorderLayout.WEST);
        add(labelTeks, BorderLayout.CENTER);
    }

    public Font getFontTeks() {
        return fontTeks;
    }

    public void setFontTeks(Font fontTeks) {
        this.fontTeks = fontTeks;
        
        this.labelTeks.setFont(fontTeks);
    }

    public Color getForegroundTeks() {
        return foregroundTeks;
    }

    public void setForegroundTeks(Color foregroundTeks) {
        this.foregroundTeks = foregroundTeks;
        
        this.labelTeks.setForeground(foregroundTeks);
    }

    public Font getFontValidasi() {
        return fontValidasi;
    }

    public void setFontValidasi(Font fontValidasi) {
        this.fontValidasi = fontValidasi;
        
        this.labelValidasi.setFont(fontValidasi);
    }

    public Color getForegroundValidasi() {
        return foregroundValidasi;
    }

    public void setForegroundValidasi(Color foregroundValidasi) {
        this.foregroundValidasi = foregroundValidasi;
        this.labelValidasi.setForeground(foregroundValidasi);
    }
    
    public void setText(String teks) {
        this.labelTeks.setText(teks);
    }
    
    public String getText () {
        return this.labelTeks.getText();
    }
    
    public void setTextValidation(String teks) {
        this.labelValidasi.setText(teks);
    }
    
    public String getTextValidation () {
        return this.labelValidasi.getText();
    }
    
}

