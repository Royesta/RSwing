/* RButtonLabel.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import com.royestalab.rswing.utility.RImageEfek;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Button Label
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RButtonLabel extends JButton {
    
    private boolean over;
    private boolean press;
    
    private Color lightColor;
    private Color darkColor;

    public Color getLightColor() {
        return lightColor;
    }

    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
        repaint();
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public void setDarkColor(Color darkColor) {
        this.darkColor = darkColor;
        repaint();
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
        repaint();
    }
    
    public RButtonLabel() {
        super();

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);

        setOver(false);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setPress(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }

        });
        
        setDarkColor(new Color(0.6F, 0.6F, 0.6F, 0.1F));
        setLightColor(new Color(0.6F, 0.6F, 0.6F, 0.7F));
    }
    
    @Override
    public void setIcon(Icon defaultIcon){
        if (defaultIcon instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon)defaultIcon;
            
            icon = new ImageIcon(RImageEfek.getMirrorEfect(icon.getImage()));
            super.setIcon(icon);
        } else {
            super.setIcon(defaultIcon);
        }
    }
    
    @Override
    protected void paintComponent (final Graphics g){

        GradientPaint paint = null;

        if (over) {
            if (press) {
                paint = new GradientPaint(0, 0, getLightColor(), 0, getHeight(), getLightColor());
            } else {
                paint = new GradientPaint(0, 0, getLightColor(), 0, getHeight(), getDarkColor());
            }
        } else {
            paint = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0F), 0, getHeight(), new Color(1F, 1F, 1F, 0F));
        }

        int lengkung = getHeight() / 2;
        RoundRectangle2D.Double kotak = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), lengkung, lengkung);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(paint);
        g2.fill(kotak);
        super.paintComponent(g);
    }
    
}

