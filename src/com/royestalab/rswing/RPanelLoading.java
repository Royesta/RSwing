/* RPanelLoading.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Panel dengan animasi loading
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RPanelLoading extends JPanel implements ActionListener {

    private Timer timer;
    private int count;
    private final int INITIAL_DELAY = 200;
    private final int DELAY = 80;
    private final int NUMBER_OF_LINES = 8;
    private final int STROKE_WIDTH = 3;

    private final double[][] trs = {
        {0.0, 0.15, 0.30, 0.5, 0.65, 0.8, 0.9, 1.0},
        {1.0, 0.0, 0.15, 0.30, 0.5, 0.65, 0.8, 0.9},
        {0.9, 1.0, 0.0, 0.15, 0.30, 0.5, 0.65, 0.8},
        {0.8, 0.9, 1.0, 0.0, 0.15, 0.30, 0.5, 0.65},
        {0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.30, 0.5},
        {0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.30},
        {0.30, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15},
        {0.15, 0.30, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0}
    };

    public RPanelLoading() {
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void doDrawing(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();

        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int width = getWidth();
        int height = getHeight();

        gd.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        gd.translate(width / 2, height / 2);

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            float alpha = (float) trs[count % NUMBER_OF_LINES][i];
            AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            gd.setComposite(acomp);

            gd.rotate(Math.PI / 4f);
            gd.drawLine(0, -10, 0, -40);
        }

        gd.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        count++;
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                JFrame frame = new JFrame();
//
//                frame.add(new RPanelLoading());
//                
//                frame.setTitle("Waiting");
//                frame.setSize(300, 200);
//                frame.setLocationRelativeTo(null);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                
//                frame.setVisible(true);
//            }
//        });
//
//    }

}

