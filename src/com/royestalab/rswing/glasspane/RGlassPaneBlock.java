/* RGlassPaneBlock.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.glasspane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

/**
 * Glass Pane untuk melakukan block pada event Keyboard dan event Mouse
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RGlassPaneBlock extends JPanel {
    
    private final MouseAdapter adapter1  = new MouseAdapter(){
    };
    
    private final KeyAdapter adapter2 = new KeyAdapter() {
    };
    
    private boolean block;
    
    public RGlassPaneBlock() {
        super();
        setBlock(false);
        setOpaque(false);
    }
    
    public boolean isBlock () {
        return this.block;
    }
    
    public void setBlock (final boolean block){
        this.block = block;
        if (block) {
            addMouseListener(this.adapter1);
            addKeyListener(this.adapter2);
        } else {
            removeMouseListener(this.adapter1);
            removeKeyListener(this.adapter2);
        }
        repaint();
        setVisible(block);
    }
    
    @Override
    protected void paintComponent (final Graphics g){
        super.paintComponent(g);
        
        if (isBlock()) {
            final Graphics2D gd = (Graphics2D)g.create();
            gd.setColor(new Color(0F, 0F, 0F, 0.7F));
//            gd.setColor(new Color(1F, 1F, 1F, 0.8F));
            gd.fillRect(0, 0, getWidth(), getHeight());
            gd.dispose();
        }
    }
    
    @Override
    public void setVisible (final boolean aFlag){
        if (isBlock()) {
            super.setVisible(aFlag);
        } else {
            super.setVisible(false);
        }
    }
    
}

