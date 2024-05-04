package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(900, 650)); // Establecer un tamaño preferido
    }
}
