package com.estivman.space_invaders.models;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

import com.estivman.space_invaders.pojos.Bullet;
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
    private ArrayList<BulletManager> bulletManagerList = new ArrayList<BulletManager>();
    private int martiansDeleted = 0;

    public ModelManager() {
        martiansManagerList = new ArrayList<MartianManager>();
        addMartianThread();
        deleteMartians();
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
    public void initShooter(int width, int height) {
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
    public synchronized void addNewMartian() {
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

    @Override
    public synchronized void shotBullet() {
        int[] positions = calcBulletPositions();
        BulletManager bulletManager = new BulletManager(positions[0], positions[1]);
        bulletManagerList.add(bulletManager);
        bulletManager.startBulletShoot();
    }

    public int[] calcBulletPositions() {
        int xBulletPos = shooterManager.getShooter().getxPosShooter() + 30;
        int yBulletPos = shooterManager.getShooter().getyPosShooter();
        int[] positions = { xBulletPos, yBulletPos };
        return positions;
    }

    @Override
    public ArrayList<Bullet> getBullets() {
        ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
        for (BulletManager bulletManager : bulletManagerList) {
            bulletList.add(bulletManager.getBullet());
        }
        return bulletList;
    }

    private void doesBulletImpact(Bullet bulletTarget, Martian martianTarget) {

        Rectangle martianHitBox = new Rectangle(martianTarget.getxPos(), martianTarget.getyPos(),
                martianTarget.getWidth(),
                martianTarget.getHeight());
        Rectangle bulletHitbox = new Rectangle(bulletTarget.getxPosBullet(), bulletTarget.getyPosBullet(),
                bulletTarget.getWidth(),
                bulletTarget.getHeight());

        if (bulletHitbox.intersects(martianHitBox)) {
            martianTarget.setAlive(false);
            martianTarget.setOutside(true);
            bulletTarget.setShouldDelete(true);
            martiansDeleted++;
        }
    }

    public void deleteMartians() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    removeShooted();
                }
            }
        });
        thread.start();
    }

    private synchronized void removeShooted() {
        for (BulletManager bulletManager : bulletManagerList) {
            for (MartianManager martianManager : martiansManagerList) {
                Martian martian = martianManager.getMartian();
                Bullet bullet = bulletManager.getBullet();
                if (martian.isAlive() && !bullet.isShouldDelete()) {
                    doesBulletImpact(bullet, martian);
                }
            }
        }
    }

    @Override
    public int getMartiansDeleted() {
        return martiansDeleted;
    }

}
