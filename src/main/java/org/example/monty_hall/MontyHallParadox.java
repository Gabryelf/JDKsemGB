package org.example.monty_hall;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Программа имитирует игру Парадокс Монти Холла и дает
 * итоговое значение вероятности выигрыша по стратегии
 * выбора из 1000 раз запуска. Все значения каждого шага
 * сохранены в HashMap, где ключом является шаг, а значением результат.
 */
public class MontyHallParadox {
    public static void main(String[] args) {
        Map<Integer, Boolean> results = new HashMap<>();
        Random random = new Random();
        int resWin = 0;

        for (int i = 1; i <= 1000; i++) {
            boolean switchDoor = (random.nextInt(2) == 0);

            int prizeDoor = random.nextInt(3) + 1;

            int playerChoice = random.nextInt(3) + 1;

            int openedDoor;
            do {
                openedDoor = random.nextInt(3) + 1;
            } while (openedDoor == prizeDoor || openedDoor == playerChoice);

            if (switchDoor) {
                int newChoice;
                do {
                    newChoice = random.nextInt( 3 ) + 1;
                } while (newChoice == playerChoice || newChoice == openedDoor);
                playerChoice = newChoice;
            }
            boolean win = (playerChoice == prizeDoor);
            if(win){
                resWin += 1;
            }


            results.put(i, win);
        }

        for (Map.Entry<Integer, Boolean> entry : results.entrySet()) {
            System.out.println("Шаг " + entry.getKey() + ": " + (entry.getValue() ? "Выиграл" : "Проиграл"));
        }
        System.out.println("всего  " + resWin + "  выигрышей");
        System.out.println("доля выигрышей  " + (double)resWin / 10 + " %");
    }

}