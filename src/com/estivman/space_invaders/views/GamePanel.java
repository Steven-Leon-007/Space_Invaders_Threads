package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;

import com.estivman.space_invaders.pojos.Martian;
import com.estivman.space_invaders.pojos.Shooter;

public class GamePanel extends JPanel {
    private Dashboard dashboard;
    private List<Martian> martians;
    private Shooter shooter;
    private Image backgroundImage;

    public GamePanel(Dashboard dashboard) {
        setBackground(Color.BLACK);
        martians = new ArrayList<Martian>();
        this.dashboard = dashboard;
        backgroundImage = new ImageIcon("src/com/estivman/space_invaders/assets/space_background.png").getImage();
        setPreferredSize(new Dimension(900, 650)); // Establecer un tamaño preferido
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
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

    public void initShooter(){
        shooter = dashboard.presenter.getShooter();
    }

    public void shooterMoves() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        dashboard.presenter.moveToLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        dashboard.presenter.moveToRight();
                        break;
                }
            }
        });
        this.setFocusable(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Martian martian : martians) {
            if (!martian.isOutside()) {
                g.drawImage(martian.getImage(), martian.getxPos(), martian.getyPos(), martian.getWidth(),
                        martian.getHeight(), null);
            }
            if (shooter != null) {
                g.drawImage(shooter.getImage(), shooter.getxPosShooter(), shooter.getyPosShooter(),
                shooter.getWidthShooter(), shooter.getHeightShooter(), null);
                
            }

        }

    }

}
