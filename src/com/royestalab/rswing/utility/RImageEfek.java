/* RImageEfek.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */
package com.royestalab.rswing.utility;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Utility untuk efek gambar
 *
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public final class RImageEfek {

    /**
     *
     * @param source
     * @return image
     */
    public static final BufferedImage getBuffered(final Image source) {
        final int width = source.getWidth(null);
        final int height = source.getHeight(null);

        final BufferedImage dest
                = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        final Graphics2D gd = (Graphics2D) dest.getGraphics();
        gd.drawImage(source, 0, 0, null);
        gd.dispose();

        return dest;
    }

    /**
     *
     * @param source
     * @return image
     */
    public static final BufferedImage getMirrorEfect(final BufferedImage source) {
        final BufferedImage dest
                = new BufferedImage(source.getWidth(), source.getHeight() + source.getHeight() / 2, BufferedImage.TYPE_INT_ARGB);

        final Graphics2D gd = (Graphics2D) dest.getGraphics();
        gd.drawImage(source, 0, 0, null);
        gd.scale(1, -1);
        gd.drawImage(source, 0, -source.getHeight() * 2, null);
        gd.scale(1, -1);
        gd.translate(0, source.getHeight());
        gd.setPaint(new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.3F), 0, source.getHeight() / 2, new Color(1F, 1F, 1F, 0F)));

        gd.setComposite(AlphaComposite.DstIn);
        gd.fillRect(0, 0, source.getWidth(), source.getHeight());
        gd.dispose();

        return dest;
    }

    /**
     *
     * @param source
     * @return image
     */
    public static final BufferedImage getMirrorEfect(final Image source) {
        return RImageEfek.getMirrorEfect(RImageEfek.getBuffered(source));
    }

}
