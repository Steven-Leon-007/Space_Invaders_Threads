package com.estivman.space_invaders.presenters;

import java.util.List;

import com.estivman.space_invaders.models.ModelManager;
import com.estivman.space_invaders.pojos.Bullet;
import com.estivman.space_invaders.pojos.Martian;
import com.estivman.space_invaders.pojos.Shooter;
import com.estivman.space_invaders.presenters.ContractGame.Model;
import com.estivman.space_invaders.presenters.ContractGame.View;
import com.estivman.space_invaders.views.Dashboard;
import java.util.ArrayList;


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
        initShooter(dashboard.getWidth(), dashboard.getHeight());        
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

    @Override
    public List<Martian> getMartians() {
        return model.getMartians();
    }

    @Override
    public synchronized void addNewMartian() {
        model.addNewMartian();
    }

    @Override
    public void moveToRight() {
        model.moveToRight();
    }

    @Override
    public void moveToLeft() {
        model.moveToLeft();
    }

    @Override
    public Shooter getShooter() {
        return model.getShooter();
    }

    @Override
    public void initShooter(int width, int height) {
        model.initShooter(width, height);
    }

    @Override
    public void shotBullet() {
        model.shotBullet();
    }

    @Override
    public ArrayList<Bullet> getBullets() {
        return model.getBullets();
    }

    @Override
    public int getMartiansDeleted() {
        return model.getMartiansDeleted();
    }

}
