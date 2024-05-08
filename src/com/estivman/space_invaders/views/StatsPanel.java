package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

public class StatsPanel extends JPanel {
    
    private Dashboard dashboard;
    private JLabel timerLabel;
    private Timer timer;
    private int seconds;

    public StatsPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(900, 50));
        timerLabel = new JLabel("0 ");
        initComponents();
    }

    private void initComponents() {

    }

}