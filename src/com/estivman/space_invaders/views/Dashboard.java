package com.estivman.space_invaders.views;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.estivman.space_invaders.presenters.ContractGame;
import com.estivman.space_invaders.presenters.ContractGame.Presenter;

public class Dashboard extends JFrame implements ContractGame.View {

    public ContractGame.Presenter presenter;
    private GamePanel gamePanel;

    private StatsPanel statsPanel;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Dashboard() {
        setTitle("Space Invaders - By Steven León");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        initializePanels();

        // Obtener el tamaño de la pantalla
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        int frameWidth = 900;
        int frameHeight = 700;
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        setBounds(x, y, frameWidth, frameHeight);
        windowResizeListener();
    }

    @Override
    public void run() {
        gamePanel.threadPaintMartians();
        setVisible(true);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    private void initializePanels() {
        gamePanel = new GamePanel(this);
        statsPanel = new StatsPanel(this);

        // Agrega los paneles al JFrame
        add(gamePanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.NORTH);
    }

    private void windowResizeListener() {
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                int width = gamePanel.getWidth();
                int height = gamePanel.getHeight();
                presenter.setGamePanelSize(width, height);
            }

        });
    }

}
