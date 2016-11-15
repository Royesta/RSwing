/* RGlassPanePanelBlock.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.glasspane;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Glass Pane Panel Block
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RGlassPanePanelBlock extends JPanel {
    
    public RGlassPanePanelBlock() {
        super();
        setLayout(null);
        setOpaque(false);
        setLayout(new AbsoluteLayout());
        
        addMouseListener(new MouseAdapter() {});
        addKeyListener(new KeyAdapter() {});
    }
    
    @Override
    protected void paintComponent(final Graphics g){
        super.paintComponent(g);
        
        final Color dark = new Color(0,0,0,50);
        final Color light = new Color(0,0,0,150);
        
        final GradientPaint paint = new GradientPaint(0, 0, dark, getWidth(),getHeight(), light);
        
        final Graphics2D gd = (Graphics2D)g.create();
        gd.setComposite(AlphaComposite.SrcOver.derive(0.5F));
        gd.setPaint(paint);
        gd.fillRect(0, 0, getWidth(), getHeight());
        
        gd.dispose();
    }
    
    public void showPanel (final JPanel panel){
        removeAll();
        
        int x = (getSize().width - panel.getPreferredSize().width) / 2;
        if (x < 0) {
            x = 0;
        }
        int y = (getHeight() - panel.getPreferredSize().height) / 2;
        if (y < 0) {
            y = 0;
        }
        
        add(panel, new AbsoluteConstraints(x, y));
    }
    
}
