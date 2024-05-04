package com.estivman.space_invaders.pojos;

public class Shooter {
    private int xPosShooter;
    private int yPosShooter;
    private int widthShooter;
    private String moveLeftKey;
    private String moveRightKey;
    private String shootKey;

    public Shooter() {
    }

    public Shooter(int xPosShooter, int yPosShooter, int widthShooter, String moveLeftKey, String moveRightKey,
            String shootKey) {
        this.xPosShooter = xPosShooter;
        this.yPosShooter = yPosShooter;
        this.widthShooter = widthShooter;
        this.moveLeftKey = moveLeftKey;
        this.moveRightKey = moveRightKey;
        this.shootKey = shootKey;
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

    public String getMoveLeftKey() {
        return moveLeftKey;
    }

    public void setMoveLeftKey(String moveLeftKey) {
        this.moveLeftKey = moveLeftKey;
    }

    public String getMoveRightKey() {
        return moveRightKey;
    }

    public void setMoveRightKey(String moveRightKey) {
        this.moveRightKey = moveRightKey;
    }

    public String getShootKey() {
        return shootKey;
    }

    public void setShootKey(String shootKey) {
        this.shootKey = shootKey;
    }

}
