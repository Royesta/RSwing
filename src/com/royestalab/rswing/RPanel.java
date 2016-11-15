/*
 * RPanel.java
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
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/**
 * Panel dengan gradient color yang dapat diatur.
 *
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RPanel extends JPanel{
    
    protected Color color1;
    protected Color color2;
    
    public RPanel() {
        super();
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        
        final Graphics2D gd = (Graphics2D)g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color color_1 = Color.BLACK;
        Color color_2 = Color.BLUE;
        
        if (this.color1 != null) color_1 = this.color1;
        if (this.color2 != null) color_2 = this.color2;
        
        GradientPaint paint = new GradientPaint(0, 0, color_1, 
                0, getHeight() - (getHeight() / 3),color_2);
        
        gd.setPaint(paint);
        gd.fillRect(0, 0, getWidth(), getHeight());
        
        final int width = getWidth();
        final int height = getHeight() * 3 / 100;
        
        final Color dark = new Color(1F, 1F, 1F, 0F);
        final Color light = new Color(1F, 1F, 1F, 0.5F);
        
        paint = new GradientPaint(0, 0, light, 0, height, dark);
        
        GeneralPath path = new GeneralPath();
        path.moveTo(0, 0);
        path.lineTo(0, height);
        path.curveTo(0, height, width/2, height/2, width, height);
        path.lineTo(width, 0);
        path.closePath();
        
        gd.setPaint(paint);
        gd.fill(path);
        
        paint = new GradientPaint(0, getHeight(), light, 0, getHeight()-height, dark);
        
        path = new GeneralPath();
        path.moveTo(0, getHeight());
        path.lineTo(0, getHeight()-height);
        path.curveTo(0, getHeight()-height, width/2, getHeight()-height/2, width, getHeight()-height);
        path.lineTo(width, getHeight());
        path.closePath();
        
        gd.setPaint(paint);
        gd.fill(path);

    }
    
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                
//                frame.setSize(500, 300);
//                frame.setLayout(new BorderLayout());
//                
//                RPanel panel = new RPanel();
//                panel.setColor1(new Color(255, 255, 255));
//                panel.setColor2(new Color(0, 0, 0, 50));
//                
//                frame.add(panel, BorderLayout.CENTER);
//                
//                frame.setVisible(true);
//            }
//        });
//    }

}
