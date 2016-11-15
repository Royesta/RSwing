/* RButton.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Button
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RButton extends JButton {

    private boolean over;
    private boolean press;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        if (isEnabled()) {
            this.over = over;
            repaint();
        }
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        if (isEnabled()) {
            this.press = press;
            repaint();
        }
    }

    public RButton() {
        super();

        setForeground(Color.BLACK);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);

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

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                setFocus(true);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocus(false);
            }
        });
    }

    private boolean focus;

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;

        if (focus == true) {
            setFont(getFont().deriveFont(Font.BOLD));
        } else {
            setFont(getFont().deriveFont(Font.PLAIN));
        }

        repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paintComponent(g);

        Color dark = new Color(1F, 1F, 1F, 0.8F);
        Color light = new Color(1F, 1F, 1F, 0.1F);
        GradientPaint paint = null;

        if (isEnabled()) {
            if (over) {
                if (press) {
                    paint = new GradientPaint(0, 0, dark, 0, getHeight(), dark);
                } else {
                    paint = new GradientPaint(0, 0, dark, 0, getHeight(), light);
                }
            } else {
                paint = new GradientPaint(0, 0, light, 0, getHeight(), light);
            }
        } else {
            paint = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        }

        g2.setPaint(paint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());

        if (isFocus()) {
            g2.setColor(Color.LIGHT_GRAY);
        } else {
            g2.setColor(Color.GRAY);
        }

        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());
        g2.dispose();
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                JPanel panel = new JPanel();
//                panel.setLayout(new FlowLayout());
//
//                XButton button1 = new XButton();
//                button1.setText("Button Enabled");
//                XButton button2 = new XButton();
//                button2.setText("Button Disabled");
//                button2.setEnabled(false);
//                XButton button3 = new XButton();
//                button3.setText("Button Enabled");
//
//                panel.add(button1);
//                panel.add(button2);
//                panel.add(button3);
//
//                frame.add(panel);
//                frame.setSize(500, 300);
//                frame.setVisible(true);
//
//            }
//        });
//    }

}
