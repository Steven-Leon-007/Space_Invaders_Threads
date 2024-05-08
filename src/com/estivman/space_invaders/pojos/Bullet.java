package com.estivman.space_invaders.pojos;

import java.awt.Image;

public class Bullet {
    private int xPosBullet;
    private int yPosBullet;
    private int speed;
    private int width;
    private int height;
    private Image image;
    private boolean shouldDelete;

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isShouldDelete() {
        return shouldDelete;
    }

    public void setShouldDelete(boolean shouldDelete) {
        this.shouldDelete = shouldDelete;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
