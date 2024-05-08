package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

public class StatsPanel extends JPanel {

    private Dashboard dashboard;
    private JLabel timerLabel;
    private JLabel killedMartians;
    private Timer timer;
    private int seconds;

    public StatsPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(900, 50));
        initComponents();
    }

    private void initComponents() {
        initTimer();
        setStatsLabel();
    }

    private void initTimer() {
        timerLabel = new JLabel("Tiempo: 0 Horas, 0 Minutos, 0 Segundos");
        timerLabel.setForeground(Color.WHITE);
        seconds = 0;
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                updateTimerLabel();
            }

        });
        add(timerLabel);
    }

    private void updateTimerLabel() {
        int horas = seconds / 3600;
        int minutos = (seconds % 3600) / 60;
        int segundos = seconds % 60;
        timerLabel.setText(String.format("Tiempo: %d Horas, %d Minutos, %d Segundos", horas, minutos, segundos));
    }

    public void startTimer() {
        timer.start();
    }

    private void setStatsLabel() {
        killedMartians = new JLabel("Naves destruidas: 0");
        killedMartians.setForeground(Color.WHITE);

        add(killedMartians);
    }

    public void initMartiansKilledStats() {
        killedMartians.setText("Naves destruidas: " + dashboard.presenter.getMartiansDeleted() + " destruidas.");
    }
}