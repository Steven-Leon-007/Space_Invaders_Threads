package com.estivman.space_invaders.models;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import com.estivman.space_invaders.pojos.DirectionsEnum;
import com.estivman.space_invaders.pojos.Martian;

public class MartianManager {
    private Martian martian;

    public boolean isThreadRunning = false;
    private int increment = 10;
    private int containerWidth;
    private int containerHeight;

    public MartianManager(int containerWidth, int containerHeight) {
        this.containerWidth = containerWidth;
        this.containerHeight = containerHeight;
        this.martian = new Martian();
        this.martian.setAlive(true);
        this.martian.setOutside(false);
        randomSize();
        randomSpeed();
        setImage();
        randomStartPosition(containerWidth, containerHeight);
        threadMartians();
    }

    private void setImage() {
        ImageIcon imageIcon = new ImageIcon("src/com/estivman/space_invaders/assets/pixel-art-ufo.png");
        this.martian.setImage(imageIcon.getImage());
    }

    private void randomStartPosition(int width, int height) {
        int halfHeight = height / 2;
        boolean isLeft = ThreadLocalRandom.current().nextBoolean();
        int randomY = ThreadLocalRandom.current().nextInt(0, halfHeight + 1 - martian.getHeight());

        int randomX;
        if (isLeft) {
        randomX = 0 - martian.getWidth();
        martian.setDirection(DirectionsEnum.RIGHT);
        } else {
        randomX = width;
        martian.setDirection(DirectionsEnum.LEFT);
        }


        this.martian.setxPos(randomX);
        this.martian.setyPos(randomY);
    }

    private void randomSize() {
        // Definir el rango de tamaño deseado
        int minSize = 20;
        int maxSize = 60;

        // Generar un tamaño aleatorio dentro del rango
        int randomSize = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);

        // Asignar el tamaño aleatorio al marciano
        this.martian.setWidth(randomSize);
        this.martian.setHeight(randomSize);
    }

    private void randomSpeed() {
        int minSpeed = 20;
        int maxSpeed = 60;

        this.martian.setSpeed(ThreadLocalRandom.current().nextInt(minSpeed, maxSpeed + 1));
    }

    private void move() {
        switch (martian.getDirection()) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    private void moveLeft() {
        martian.setxPos(martian.getxPos() - increment);
        if (martian.getxPos() + martian.getWidth() < 0) {
            martian.setOutside(true);
        }
    }

    private void moveRight() {
        martian.setxPos(martian.getxPos() + increment);
        if (martian.getxPos() > containerWidth) {
            martian.setOutside(true);
        }
    }

    public void stopThread() {
        this.isThreadRunning = false;
    }

    public void threadMartians() {
        isThreadRunning = true;
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (!martian.isOutside()) {
                    try {
                        Thread.sleep(martian.getSpeed());
                        move();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public Martian getMartian() {
        return martian;
    }

}
