package com.estivman.space_invaders.models;

import com.estivman.space_invaders.presenters.ContractGame;
import com.estivman.space_invaders.presenters.ContractGame.Presenter;

public class ModelManager implements ContractGame.Model {
    private int gamePanelWidth;
    private int gamePanelHeight;

    private ContractGame.Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setGamePanelSize(int width, int height) {
        this.gamePanelWidth = width;
        this.gamePanelHeight = height;

    }
    
}
