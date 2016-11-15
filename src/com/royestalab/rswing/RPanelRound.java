/* RPanelRound.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Panel dengan Border Round
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RPanelRound extends JPanel {
    
    private Color colorContent;

    public Color getColorContent() {
        return colorContent;
    }

    public void setColorContent(Color colorContent) {
        this.colorContent = colorContent;
        repaint();
    }
    
    public RPanelRound() {
        super();
        
        setOpaque(false);
        setColorContent(Color.BLACK);
        setBorderColor(new Color(255, 255, 255, 200));
    }
    
    private Color borderColor;

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        
        int x = 1;
        int y = 1;
        
        int w = getWidth() - 3;
        int h = getHeight() - 3;
        
        int arc = 30;
        
        final Graphics2D gd = (Graphics2D)g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setColor(getColorContent());
        
        gd.fillRoundRect(x, y, w, h, arc, arc);
        
        gd.setStroke(new BasicStroke(3f));
        gd.setColor(getBorderColor());
        gd.drawRoundRect(x, y, w, h, arc, arc);
        
        gd.dispose();
    }
    
}
