package com.estivman.space_invaders.models;

import com.estivman.space_invaders.pojos.Bullet;
import javax.swing.ImageIcon;

public class BulletManager {
    private Bullet bullet;

    private Object lock = new Object();

    public BulletManager(int shooterXpos, int shooterYpos) {
        bullet = new Bullet();
        bullet.setSpeed(30);
        bullet.setWidth(20);
        bullet.setHeight(30);
        bullet.setShouldDelete(false);
        setImage();
        bulletPosition(shooterXpos, shooterYpos);
    }

    private void bulletPosition(int shooterXpos, int shooterYpos) {
        bullet.setxPosBullet(shooterXpos);
        bullet.setyPosBullet(shooterYpos);
    }

    private void setImage() {
        ImageIcon imageIcon = new ImageIcon("src/com/estivman/space_invaders/assets/bullet-ship.png");
        this.bullet.setImage(imageIcon.getImage());
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void shoot(){
        bullet.setyPosBullet(bullet.getyPosBullet() - bullet.getSpeed());
        if(bullet.getyPosBullet() < 0){
            bullet.setShouldDelete(true);
            lock.notify();
        }
    }

    public void letBulletBeShooted(){
        synchronized(lock){
            bullet.setShouldDelete(false);
        }
    }

    public void startBulletShoot() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (bullet == null) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try{
                            Thread.sleep(bullet.getSpeed());
                            shoot();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
        thread.start();
    }
}
