package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки
(JButton) – запустить сервер и остановить сервер. Кнопки должны просто логировать нажатие
(имитировать запуск и остановку сервера, соответственно) и выставлять внутри интерфейса
соответствующее булево isServerWorking.
 */
public class ServerRun extends JFrame implements Listener{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");

    Server server = new Server( this );
    ArrayList<String> log;
    boolean isServerWorking;
    ServerRun(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });
        setLayout(new GridLayout(1,2));
        add(btnStart);
        add(btnStop);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerRun();
    }


    @Override
    public void messageRes(String text) {
        //log.add( String.format( text + "\n" ) );
        System.out.println(text);
    }
}
