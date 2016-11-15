/* RLabelShadow.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

/**
 * Label dengan efek Shadow
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RLabelDropShadow extends JLabel{
    
    private int distance;
    private Color dropShadowColor;

    /**
     * 
     * @return 
     */
    public int getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance 
     */
    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public Color getDropShadowColor() {
        return dropShadowColor;
    }

    public void setDropShadowColor(final Color dropShadowColor) {
        this.dropShadowColor = dropShadowColor;
    }
    
    public RLabelDropShadow(){
        super();
        
        setDistance(2);
        setForeground(Color.RED);
        setDropShadowColor(new Color(0, 0, 0, 50));
    }
    
    
    /**
     * Override dari JLabel
     * @return 
     */
    @Override
    public Dimension getPreferredSize() {
        final Dimension d = super.getPreferredSize();
        d.height += getDistance() + 10;
        d.width += getDistance() + 10;
        return d;
    }
    
    /**
     * Di Override dari Kelas JLabel
     * @param g 
     */
    @Override
    protected void paintComponent(final Graphics g){
        final FontMetrics metric = getFontMetrics(getFont());
        
        final Graphics2D gd =(Graphics2D)g.create();
        
        gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gd.setFont(getFont());
        gd.setColor(getDropShadowColor());
        gd.drawString(getText(), getDistance(), metric.getHeight() + getDistance());
        gd.setColor(getForeground());
        gd.drawString(getText(), 0, metric.getHeight());
        
    }

}

