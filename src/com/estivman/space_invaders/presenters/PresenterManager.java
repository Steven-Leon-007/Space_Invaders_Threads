package com.estivman.space_invaders.presenters;

import com.estivman.space_invaders.models.ModelManager;
import com.estivman.space_invaders.presenters.ContractGame.Model;
import com.estivman.space_invaders.presenters.ContractGame.View;
import com.estivman.space_invaders.views.Dashboard;

public class PresenterManager implements ContractGame.Presenter {

    private ContractGame.Model model;
    private ContractGame.View view;

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    public void makeMVP() {
        Dashboard dashboard = new Dashboard();
        dashboard.setPresenter(this);
        this.view = dashboard;

        ModelManager modelManager = new ModelManager();
        modelManager.setPresenter(this);
        this.model = modelManager;

    }

    @Override
    public void run() {
        makeMVP();
        view.run();
    }

    @Override
    public void setGamePanelSize(int width, int height) {
        if (model != null) {
            model.setGamePanelSize(width, height);
        }
    }

}
