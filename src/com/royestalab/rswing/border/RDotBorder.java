/* RDotBorder.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.border;

import com.royestalab.rswing.fileenum.Type;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.EnumSet;
import javax.swing.border.EmptyBorder;

/**
 * Dot Border
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RDotBorder extends EmptyBorder {

    private static final BasicStroke DASHED = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, new float[]{1f}, 0f);
    private static final Color DOT_COLOR = new Color(200, 150, 150);
    public EnumSet<Type> type = EnumSet.noneOf(Type.class);

    public RDotBorder(int top, int left, int bottom, int right) {
        super(top, left, bottom, right);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(x, y);
        g2.setPaint(DOT_COLOR);
        g2.setStroke(DASHED);
        if (type.contains(Type.START)) {
            g2.drawLine(0, 0, 0, h);
        }
        if (type.contains(Type.END)) {
            g2.drawLine(w - 1, 0, w - 1, h);
        }
        if (c.getBounds().x % 2 == 0) {
            g2.drawLine(0, 0, w, 0);
            g2.drawLine(0, h - 1, w, h - 1);
        } else {
            g2.drawLine(1, 0, w, 0);
            g2.drawLine(1, h - 1, w, h - 1);
        }
        g2.dispose();
    }
}

