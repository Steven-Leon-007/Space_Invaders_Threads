package com.estivman.space_invaders.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.estivman.space_invaders.pojos.Martian;
import com.estivman.space_invaders.presenters.ContractGame;
import com.estivman.space_invaders.presenters.ContractGame.Presenter;

public class ModelManager implements ContractGame.Model {
    private ContractGame.Presenter presenter;
    private int gamePanelWidth;
    private int gamePanelHeight;
    private boolean firstRun = false;
    private List<MartianManager> martiansManagerList;


    public ModelManager() {
        martiansManagerList = new ArrayList<MartianManager>();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setGamePanelSize(int width, int height) {
        this.gamePanelWidth = width;
        this.gamePanelHeight = height;

        if (!firstRun) {
            createMartians();
            firstRun = true;
        }

        for (MartianManager martianManager : martiansManagerList) {
            martianManager.setSize(width, height);
        }

    }

    public void createMartians() {
        for (int i = 0; i < 10; i++) {
            MartianManager martian = new MartianManager(gamePanelWidth, gamePanelHeight);
            martiansManagerList.add(martian);
        }
    }

    @Override
    public List<Martian> getMartians() {
        List<Martian> martians = new ArrayList<Martian>();
        for (MartianManager martianManager : martiansManagerList) {
            martians.add(martianManager.getMartian());
        }
        return martians;
    }

    @Override
    public void startMartianThreads() {
        for (MartianManager martianManager : martiansManagerList) {
            martianManager.threadMartians();
        }
    }

    @Override
    public void stopMartianThreads() {
        for (MartianManager martianManager : martiansManagerList) {
            martianManager.stopThread();
        }
    }

    @Override
    public synchronized void addNewMartian() {
        MartianManager newMartianManager = new MartianManager(gamePanelWidth, gamePanelHeight);
        martiansManagerList.add(newMartianManager);
        System.out.println(martiansManagerList.size());
    }
    

}
