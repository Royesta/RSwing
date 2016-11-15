/* RButtonMenu.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 * Tombol Menu
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RButtonMenu extends JButton{
    
    private boolean over;
    private boolean press;

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
    
    public RButtonMenu() {
        super();

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        
        setHorizontalTextPosition(JButton.RIGHT);
        setVerticalTextPosition(JButton.CENTER);

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
    }
    
    private Color lightColor = new Color(0.5F, 1F, 0.5F, 0.8F);
    private Color darkColor = new Color(0.5F, 1F, 0.5F, 0.1F);

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
    
    @Override
    protected void paintComponent (final Graphics g){
//        Color light = new Color(0.8F, 1F, 1F, 0.8F);
//        Color dark = new Color(0.8F, 1F, 1F, 0.1F);

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

        RoundRectangle2D.Double kotak = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(paint);
        g2.fill(kotak);
        
        super.paintComponent(g);
    }
    
}
