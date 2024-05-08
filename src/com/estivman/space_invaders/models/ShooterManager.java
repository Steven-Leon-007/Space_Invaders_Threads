package com.estivman.space_invaders.models;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import com.estivman.space_invaders.pojos.Shooter;

public class ShooterManager {
    private Shooter shooter;
    private int increment;
    private int containerWidth;
    private int containerHeight;

    public ShooterManager(int containerWidth, int containerHeight) {
        this.containerWidth = containerWidth;
        this.containerHeight = containerHeight;
        shooter = new Shooter();
        increment = 10;
        setSize();
        setShooterImage();
        shooterPosition(containerWidth, containerHeight);
    }

    private void setSize() {
        int width = 80;
        int height = 80;
        shooter.setWidthShooter(width);
        shooter.setHeightShooter(height);
    }

    private void setShooterImage() {
        ImageIcon imageIcon = new ImageIcon("src/com/estivman/space_invaders/assets/Pixel-Art-Spaceship-5.png");
        this.shooter.setImage(imageIcon.getImage());
    }

    private void shooterPosition(int containerWidth, int containerHeight) {

        int posX = ThreadLocalRandom.current().nextInt(shooter.getWidthShooter(),
                containerWidth - shooter.getWidthShooter());
        int posY = containerHeight - shooter.getHeightShooter() - 80;

        shooter.setxPosShooter(posX);
        shooter.setyPosShooter(posY);
    }

    public void moveToLeft() {
        if (shooter.getxPosShooter() > 0) {
            shooter.setxPosShooter(shooter.getxPosShooter() - increment);
        }
    }

    public void moveToRight() {
        if (shooter.getxPosShooter() < containerWidth - shooter.getWidthShooter()) {
            shooter.setxPosShooter(shooter.getxPosShooter() + increment);
        }
    }

    public Shooter getShooter() {
        return shooter;
    }

    public int getIncrement() {
        return increment;
    }
}
