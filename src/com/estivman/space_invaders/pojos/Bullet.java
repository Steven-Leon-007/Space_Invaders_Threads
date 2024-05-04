package com.estivman.space_invaders.pojos;

public class Bullet {
    private int xPosBullet;
    private int yPosBullet;
    private int speed;
    private int width;

    public Bullet(int xPosBullet, int yPosBullet, int speed, int width) {
        this.xPosBullet = xPosBullet;
        this.yPosBullet = yPosBullet;
        this.speed = speed;
        this.width = width;
    }

    public Bullet() {
    }

    public int getxPosBullet() {
        return xPosBullet;
    }

    public void setxPosBullet(int xPosBullet) {
        this.xPosBullet = xPosBullet;
    }

    public int getyPosBullet() {
        return yPosBullet;
    }

    public void setyPosBullet(int yPosBullet) {
        this.yPosBullet = yPosBullet;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
