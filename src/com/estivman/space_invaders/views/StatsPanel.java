package com.estivman.space_invaders.views;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

public class StatsPanel extends JPanel {

    public StatsPanel() {
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(900, 50)); // Establecer un tamaño preferido
        // Agregar aquí componentes de estadísticas, como etiquetas, texto, etc.
    }
}