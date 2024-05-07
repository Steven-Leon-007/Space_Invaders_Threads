package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;

import javax.swing.JPanel;

import com.estivman.space_invaders.pojos.Martian;

public class GamePanel extends JPanel {
    private Dashboard dashboard;
    private List<Martian> martians;

    public GamePanel(Dashboard dashboard) {
        setBackground(Color.BLACK);
        martians = new ArrayList<Martian>();
        this.dashboard = dashboard;
        setPreferredSize(new Dimension(900, 650)); // Establecer un tamaño preferido
    }

    public void threadPaintMartians() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        martians = dashboard.presenter.getMartians();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }

        });
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        List<Martian> martiansCopy;
        synchronized (martians) {
            martiansCopy = new ArrayList<>(martians);
        }
        
        for (Martian martian : martiansCopy) {
            if (!martian.isOutside()) {
                g.drawImage(martian.getImage(), martian.getxPos(), martian.getyPos(), martian.getWidth(),
                        martian.getHeight(), null);
            } else {
                dashboard.presenter.addNewMartian();
            }
        }
    }
    

}
