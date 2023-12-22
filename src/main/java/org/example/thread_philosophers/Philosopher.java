package org.example.thread_philosophers;

import java.util.concurrent.locks.Lock;


/**
 * Класс отвечает за философа у которого есть поля и методы.
 * У каждого философа есть левая и правая вилки (замки).
 */

class Philosopher extends Thread {
    private String name;
    private Lock leftFork;
    private Lock rightFork;
    private int eatCount;

    public Philosopher(String name, Lock leftFork, Lock rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = 0;
    }

    private void eat() throws InterruptedException {
        Thread.sleep(500); // Время приема пищи
        eatCount++;
    }

    private void think() throws InterruptedException {
        Thread.sleep(500); // Время размышлений
    }

    @Override
    public void run() {
        try {
            while (eatCount < 3) {
                think();
                leftFork.lock(); // Захват левой вилки
                if (rightFork.tryLock()) { // Попытка захвата правой вилки
                    eat();
                    rightFork.unlock();
                }
                leftFork.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "Философы{" +
                "name='" + name + '\'' +
                ", leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                ", eatCount=" + eatCount +
                '}';
    }
}
