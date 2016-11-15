/* RAbstractGlassPane.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.glasspane;

import com.royestalab.rswing.RPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Class Abstract untuk GlassPane
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public abstract class RAbstractGlassPane extends JPanel {

    private final RPanel panel;
    private final JLabel label;
    private boolean block;
    private final Image image;

    public RAbstractGlassPane(final String strImage, Color color1, Color color2) {
        super();
        setOpaque(false);
        setBlock(false);

        this.image = new ImageIcon(getClass().getResource("/com/royestalab/rswing/images/" + strImage)).getImage();

        panel = new RPanel();
        panel.setColor1(color1);
        panel.setColor2(color2);
        panel.setLayout(new BorderLayout(20, 20));
        panel.setPreferredSize(new Dimension(250, 100));
        panel.setBorder(new LineBorder(Color.BLACK, 3));

        this.label = new JLabel();
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.label.setForeground(Color.WHITE);
        this.label.setOpaque(false);
        this.panel.add(this.label);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);

        addMouseListener(new MouseAdapter() {
        });
        addKeyListener(new KeyAdapter() {
        });
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(final boolean block) {
        this.block = block;
        repaint();
        setVisible(block);
    }

    private Color labelForeground;

    public void setTextForeground(Color textForeground) {
        this.labelForeground = textForeground;
        this.label.setForeground(textForeground);
    }

    private Font labelFont;

    public void setTextFont(Font textFont) {
        this.labelFont = textFont;
        this.label.setFont(textFont);
    }

    public RPanel getPanel() {
        return this.panel;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        if (isBlock()) {
            final Graphics2D gd = (Graphics2D) g.create();
            gd.setColor(new Color(1F, 1F, 1F, 0.6F));
            gd.fillRect(0, 0, getWidth(), getHeight());
            if (this.image != null) {
                final Point p = new Point(getWidth() - this.image.getWidth(null), getHeight() - this.image.getHeight(null));
                gd.drawImage(this.image, p.x, p.y, null);
            }
            gd.dispose();
        }
    }

    public void setMessage(final String message) {
        this.label.setText(message);
    }

    @Override
    public void setVisible(final boolean aFlag) {
        if (isBlock()) {
            addMouseListener(new MouseAdapter() {

            });

            addKeyListener(new KeyAdapter() {
            });
            super.setVisible(aFlag);
        } else {
            super.setVisible(false);
        }
    }
}
