package org.example.thread_philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * В этой программе мы создаем 5 вилок, представленных замками (locks).
 * Философы пытаются захватить левую вилку, а затем пытаются захватить правую вилку.
 * Если правая вилка занята, философ отпускает левую вилку и начинает размышлять.
 * Иначе, он обедает в течение 500 миллисекунд.
 * Философы пообедают три раза и затем закончат свою работу.
 * Каждый философ представляет собой отдельный поток и выполняется параллельно другим философам.
 * В конце программы мы ожидаем завершения работы всех потоков (философов).
 */
public class DiningPhilosophers {
    public static void main(String[] args) {
        Lock[] forks = new Lock[5];
        for ( int i = 0; i < 5; i++ ) {
            forks[i] = new ReentrantLock();
        }

        Philosopher[] philosophers = new Philosopher[5];
        for ( int i = 0; i < 5; i++ ) {
            Philosopher philosopher = new Philosopher( "Философ " + (i + 1), forks[i], forks[(i + 1) % 5] );
            philosophers[i] = philosopher;
            philosopher.start();
            System.out.println(philosophers[i].toString());

        }

        try {
            for ( Philosopher philosopher : philosophers ) {
                philosopher.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
