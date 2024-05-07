package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StatsPanel extends JPanel {
    private JButton btnStart;
    private JButton btnStop;
    private Dashboard dashboard;

    public StatsPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(900, 50));
        initComponents();
    }

    private void initComponents() {
        createStartButton();
        createStopButton();
        this.add(btnStart);
        this.add(btnStop);

    }

    private void createStartButton() {

        btnStart = new JButton();
        btnStart.setText("Start");

        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.startMartianThreads();
            }

        });
    }

    private void createStopButton() {

        btnStop = new JButton();
        btnStop.setText("Stop");

        btnStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.stopMartianThreads();
            }

        });

    }

}