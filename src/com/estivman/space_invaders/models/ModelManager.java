package com.estivman.space_invaders.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.estivman.space_invaders.pojos.Martian;
import com.estivman.space_invaders.pojos.Shooter;
import com.estivman.space_invaders.presenters.ContractGame;
import com.estivman.space_invaders.presenters.ContractGame.Presenter;

public class ModelManager implements ContractGame.Model {
    private ContractGame.Presenter presenter;
    private int gamePanelWidth;
    private int gamePanelHeight;
    private boolean firstRun = true;
    private List<MartianManager> martiansManagerList;
    private ShooterManager shooterManager;

    public ModelManager() {
        martiansManagerList = new ArrayList<MartianManager>();
        addMartianThread();

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setGamePanelSize(int width, int height) {
        this.gamePanelWidth = width;
        this.gamePanelHeight = height;
        if (firstRun) {
            createMartians();
            firstRun = false;
        }
    }

    @Override
    public void initShooter(int width, int height){
        shooterManager = new ShooterManager(width, height);
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
    public void addNewMartian() {
        MartianManager newMartianManager = new MartianManager(gamePanelWidth, gamePanelHeight);
        martiansManagerList.add(newMartianManager);
    }

    public void addMartianThread() {

        Thread addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    addNewMartian();
                }
            }
        });
        addThread.start();
    }

    @Override
    public void moveToRight() {
        shooterManager.moveToRight();
    }

    @Override
    public void moveToLeft() {
        shooterManager.moveToLeft();
    }

    @Override
    public Shooter getShooter() {
        return shooterManager.getShooter();
    }

}
