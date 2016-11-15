/* RGambarBuffer.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.buffer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Buffer untuk Gambar
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public abstract class RGambarBuffer {
    
    private final int size;

    public RGambarBuffer(int size) {
        this.size = size;
    }

    public BufferedImage getBufferedImage(File fileName) throws IOException {
        Image img = ImageIO.read(new FileInputStream(fileName));
        int tinggi;
        int lebar;
        // cek size foto, kalau terlalu besar resize ke max Picture Size
        if (img.getHeight(null) > this.size || img.getWidth(null) > this.size) {
            if (img.getHeight(null) > img.getWidth(null)) {
                float scale = (float) img.getHeight(null) / this.size;
                float widthSize = (float) img.getWidth(null) / scale;
                int w = (int) widthSize;
                img = img.getScaledInstance(w, this.size, Image.SCALE_SMOOTH);

                lebar = w;
                tinggi = this.size;
            } else if (img.getWidth(null) > img.getHeight(null)) {
                float scale = (float) img.getWidth(null) / this.size;
                int heightSize = (int) ((float) img.getHeight(null) / scale);
                img = img.getScaledInstance(this.size, heightSize, Image.SCALE_SMOOTH);

                lebar = this.size;
                tinggi = heightSize;
            } else {
                img = img.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);
                lebar = this.size;
                tinggi = this.size;
            }
        } else {
            lebar = img.getWidth(null);
            tinggi = img.getHeight(null);
        }
        System.out.println("Lebar : " + lebar);
        System.out.println("Tinggi : " + tinggi);
        BufferedImage image = new BufferedImage(lebar, tinggi, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gd = (Graphics2D) image.getGraphics();

        gd.setBackground(new Color(0, 0, 0, 0));
        //gd.clearRect(0, 0, image.getWidth(), image.getHeight());
        gd.drawImage(img, (image.getWidth() - img.getWidth(null)) / 2, (image.getHeight() - img.getHeight(null)) / 2, null);

        return image;
    }

    public BufferedImage getBufferGambar(File fileName) throws IOException {
        Image img = ImageIO.read(new FileInputStream(fileName));
        int tinggi;
        int lebar;
        // cek size foto, kalau terlalu besar resize ke max Picture Size
        if (img.getHeight(null) > this.size || img.getWidth(null) > this.size) {
            System.out.println("tinggi atau lebar lebih dari size");

            if (img.getHeight(null) > img.getWidth(null)) {
                float scale = (float) img.getHeight(null) / this.size;
                float widthSize = (float) img.getWidth(null) / scale;
                int w = (int) widthSize;
                img = img.getScaledInstance(w, this.size, Image.SCALE_SMOOTH);

                lebar = w;
                tinggi = this.size;
            } else if (img.getWidth(null) > img.getHeight(null)) {
                float scale = (float) img.getWidth(null) / this.size;
                int heightSize = (int) ((float) img.getHeight(null) / scale);
                img = img.getScaledInstance(this.size, heightSize, Image.SCALE_SMOOTH);

                lebar = this.size;
                tinggi = heightSize;
            } else {
                img = img.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);
                lebar = this.size;
                tinggi = this.size;
            }
        } else {
            System.out.println("tinggi atau lebar kurang dari size");
            lebar = img.getWidth(null);
            tinggi = img.getHeight(null);
        }
        System.out.println("Lebar : " + lebar);
        System.out.println("Tinggi : " + tinggi);
        BufferedImage image = new BufferedImage(lebar, tinggi, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gd = (Graphics2D) image.getGraphics();

        gd.setBackground(new Color(0, 0, 0, 0));
        //gd.clearRect(0, 0, image.getWidth(), image.getHeight());
        gd.drawImage(img, (image.getWidth() - img.getWidth(null)) / 2, (image.getHeight() - img.getHeight(null)) / 2, null);

        return image;
    }

    public BufferedImage getBufferPanelData(File fileName) {
        BufferedImage image = null;
        try {
            Image img = ImageIO.read(new FileInputStream(fileName));
            int tinggi;
            int lebar;

            if (img.getHeight(null) > img.getWidth(null)) {
                float scale = (float) img.getHeight(null) / this.size;
                float widthSize = (float) img.getWidth(null) / scale;
                int w = (int) widthSize;
                img = img.getScaledInstance(w, this.size, Image.SCALE_SMOOTH);

                lebar = w;
                tinggi = this.size;
            } else if (img.getWidth(null) > img.getHeight(null)) {
                float scale = (float) img.getWidth(null) / this.size;
                int heightSize = (int) ((float) img.getHeight(null) / scale);
                img = img.getScaledInstance(this.size, heightSize, Image.SCALE_SMOOTH);

                lebar = this.size;
                tinggi = heightSize;
            } else {
                img = img.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);
                lebar = this.size;
                tinggi = this.size;
            }

            System.out.println("Lebar : " + lebar);
            System.out.println("Tinggi : " + tinggi);
            image = new BufferedImage(lebar, tinggi, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gd = (Graphics2D) image.getGraphics();

            gd.setBackground(new Color(0, 0, 0, 0));
            //gd.clearRect(0, 0, image.getWidth(), image.getHeight());
            gd.drawImage(img, (image.getWidth() - img.getWidth(null)) / 2, (image.getHeight() - img.getHeight(null)) / 2, null);
        } catch (IOException ex) {
            Logger.getLogger(RGambarBuffer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return image;
    }
    
    public BufferedImage getBufferedImage(ImageIcon icon) {
        Image img = icon.getImage();
        int tinggi;
        int lebar;
        // cek size foto, kalau terlalu besar resize ke max Picture Size
        if (img.getHeight(null) > this.size || img.getWidth(null) > this.size) {
            if (img.getHeight(null) > img.getWidth(null)) {
                float scale = (float) img.getHeight(null) / this.size;
                float widthSize = (float) img.getWidth(null) / scale;
                int w = (int) widthSize;
                img = img.getScaledInstance(w, this.size, Image.SCALE_SMOOTH);

                lebar = w;
                tinggi = this.size;
            } else if (img.getWidth(null) > img.getHeight(null)) {
                float scale = (float) img.getWidth(null) / this.size;
                int heightSize = (int) ((float) img.getHeight(null) / scale);
                img = img.getScaledInstance(this.size, heightSize, Image.SCALE_SMOOTH);

                lebar = this.size;
                tinggi = heightSize;
            } else {
                img = img.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);
                lebar = this.size;
                tinggi = this.size;
            }
        } else {
            lebar = img.getWidth(null);
            tinggi = img.getHeight(null);
        }
        System.out.println("Lebar : " + lebar);
        System.out.println("Tinggi : " + tinggi);
        BufferedImage image = new BufferedImage(lebar, tinggi, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gd = (Graphics2D) image.getGraphics();

        gd.setBackground(new Color(0, 0, 0, 0));
        //gd.clearRect(0, 0, image.getWidth(), image.getHeight());
        gd.drawImage(img, (image.getWidth() - img.getWidth(null)) / 2, (image.getHeight() - img.getHeight(null)) / 2, null);

        return image;
    }
    
    public static Image getImageTransparent (String fileNameLocation) {
        BufferedImage image = null;
        try {
            Image img = ImageIO.read(new FileInputStream(new File(fileNameLocation)));
            
            image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D gd = (Graphics2D) image.getGraphics();

            gd.setBackground(new Color(0, 0, 0, 0));
            gd.drawImage(img, (image.getWidth() - img.getWidth(null)) / 2, (image.getHeight() - img.getHeight(null)) / 2, null);
        } catch (IOException ex) {
            System.out.println("==Error: " + ex.getMessage());
        }
        return new ImageIcon(image).getImage();
    }
}
