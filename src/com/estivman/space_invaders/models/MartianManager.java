package com.estivman.space_invaders.models;

import java.util.concurrent.ThreadLocalRandom;

import com.estivman.space_invaders.pojos.DirectionsEnum;
import com.estivman.space_invaders.pojos.Martian;

public class MartianManager {
    private Martian martian;

    public boolean isThreadRunning = false;
    private int increment = 10;
    private int containerWidth;
    private int containerHeight;

    public MartianManager(int containerWidth, int containerHeight) {
        this.martian = new Martian();
        this.containerWidth = containerWidth;
        this.containerHeight = containerHeight;
        this.martian.setAlive(true);
        this.martian.setOutside(false);
        randomSize();
        randomSpeed();
        randomStartPosition(containerWidth, containerHeight);
    }

    private void randomStartPosition(int width, int height) {
        // Calcular la mitad de la altura
        int halfHeight = height / 2;
        boolean isLeft = ThreadLocalRandom.current().nextBoolean();
        int randomY = ThreadLocalRandom.current().nextInt(0, halfHeight + 1 - martian.getHeight());

        int randomX;
        if (isLeft) {
            randomX = martian.getWidth();
            martian.setDirection(DirectionsEnum.RIGHT);
        } else {
            randomX = width - martian.getWidth();
            martian.setDirection(DirectionsEnum.LEFT);
        }

        this.martian.setxPos(randomX);
        this.martian.setyPos(randomY);
    }

    private void randomSize() {
        // Definir el rango de tamaño deseado
        int minSize = 20;
        int maxSize = 80;

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
        int currentPositionX = this.martian.getxPos();

        int newPositionX;
        if (martian.getDirection() == DirectionsEnum.LEFT) {
            newPositionX = currentPositionX - increment;
        } else {
            newPositionX = currentPositionX + increment;
        }

        if (newPositionX <= 0 || newPositionX >= containerWidth) {
            martian.setOutside(true);
        } else {
            martian.setxPos(newPositionX);
        }

    }

}
