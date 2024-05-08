package com.estivman.space_invaders.pojos;

import java.awt.Image;

public class Shooter {
    private int xPosShooter;
    private int yPosShooter;
    private int widthShooter;
    private int heightShooter;

    private Image image;


    public Shooter() {
    }

    public int getxPosShooter() {
        return xPosShooter;
    }

    public void setxPosShooter(int xPosShooter) {
        this.xPosShooter = xPosShooter;
    }

    public int getyPosShooter() {
        return yPosShooter;
    }

    public void setyPosShooter(int yPosShooter) {
        this.yPosShooter = yPosShooter;
    }

    public int getWidthShooter() {
        return widthShooter;
    }

    public void setWidthShooter(int widthShooter) {
        this.widthShooter = widthShooter;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getHeightShooter() {
        return heightShooter;
    }

    public void setHeightShooter(int heightShooter) {
        this.heightShooter = heightShooter;
    }


}
