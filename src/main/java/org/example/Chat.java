package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

//1.Выполнить все задания семинара, если они не были решены, без ограничений по времени;

//2.Отправлять сообщения из текстового поля сообщения в лог по нажатию кнопки
// или по нажатию клавиши Enter на поле ввода сообщения;

//3.Продублировать импровизированный лог (историю) чата в файле;

//4.При запуске клиента чата заполнять поле истории из файла, если он существует.
// Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение
// истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.


public class Chat extends JFrame{
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    private static final String MESSAGE_HISTORY_FILE = "message_history.txt";
    JButton btnSend = new JButton("Отправить.");
    JLabel lblLogin = new JLabel("Login:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblIP = new JLabel("IP:");
    JLabel lblMessage = new JLabel("Сообщение:");

    JButton btnSave = new JButton("Сохранить историю");
    JTextField txtFieldLogin = new JTextField();
    JTextField txtFieldPassword = new JTextField();
    JTextField txtFieldIP = new JTextField();
    JTextField txtFieldMessage = new JTextField();
    JTextArea areaMessage = new JTextArea();
    static JTextArea textArea = new JTextArea(10, 5);
    JPanel panServer = new JPanel(new GridLayout(10, 2));
    JPanel panClient = new JPanel(new GridLayout(10, 1));
    String login;
    String password;
    String IP;
    String message;



    JScrollPane scrollPane = new JScrollPane(textArea);

    JButton showHistoryButton = new JButton("Показать историю переписки");
    JButton hideHistoryButton = new JButton("Скрыть историю переписки");



    Chat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatWindow");
        setResizable(false);
        panServer.add(lblLogin);
        panServer.add(txtFieldLogin);
        panServer.add(lblPassword);
        panServer.add(txtFieldPassword);
        panServer.add(lblIP);
        panServer.add(txtFieldIP);
        panClient.add(lblMessage);
        panClient.add(areaMessage);
        panClient.add(txtFieldMessage);
        panClient.add(btnSend);
        panClient.add(btnSave);
        panClient.add(BorderLayout.PAGE_START, textArea);
        panClient.add(scrollPane, BorderLayout.CENTER);
        panClient.setVisible(true);
        panClient.add(showHistoryButton);
        panClient.add(hideHistoryButton);
        textArea.setEditable(false);
        hideHistoryButton.setEnabled(false);


        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        txtFieldMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChatHistory();
            }
        });

        hideHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                showHistoryButton.setEnabled(true);
                hideHistoryButton.setEnabled(false);
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessageHistory();
                showHistoryButton.setEnabled(false);
                hideHistoryButton.setEnabled(true);
            }
        });

        setLayout(new GridLayout(2,1));
        add(panServer);
        add(panClient);
        setVisible(true);
    }

    private void sendMessage() {
        message = txtFieldLogin.getText() + ": " + txtFieldMessage.getText() + "\n";
        areaMessage.append(message);
        System.out.println("Отправлено сообщение: " + message);
        txtFieldMessage.setText("");
    }

    private void saveChatHistory() {
        try {
            FileWriter writer = new FileWriter(MESSAGE_HISTORY_FILE, true);
            writer.write(areaMessage.getText());
            writer.close();

            System.out.println("История чата сохранена в файл chat_history.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean isMessageHistoryFileExists() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(MESSAGE_HISTORY_FILE);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main(String[] args) {

        new Chat();

        if (isMessageHistoryFileExists()) {

            displayMessageHistory();
        }

    }

    private static void displayMessageHistory() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(MESSAGE_HISTORY_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                textArea.setText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}