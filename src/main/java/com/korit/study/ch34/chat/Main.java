package com.korit.study.ch34.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static Socket socket;

    public static void main(String[] args) {
        JDialog connectionDialog = new JDialog();
        JPanel textFiledPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JTextField ipFiled = new JTextField();
        JTextField portFiled = new JTextField();
        ipFiled.setText("localhost");
        portFiled.setText("5000");
        textFiledPanel.add(ipFiled);
        textFiledPanel.add(portFiled);

        JButton connectButton = new JButton("접속");
        connectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String ip = ipFiled.getText();
                    Integer port = Integer.parseInt(portFiled.getText());
                    System.out.println(ip + ", " + port);
                    try {
                        socket = new Socket(ip, port);
                        connectionDialog.dispose();
                        new MainForm();
                    } catch (IOException ex) {
                        System.out.println("서버 연결 실패");
                        connectionDialog.dispose();
                    }
                } catch (NumberFormatException exception) {

                }
            }
        });

        connectionDialog.setContentPane(new JPanel(new BorderLayout(5, 5)));
        connectionDialog.setName("클라이언트 접속");
        connectionDialog.add(textFiledPanel, BorderLayout.CENTER);
        connectionDialog.add(connectButton, BorderLayout.SOUTH);
        connectionDialog.setSize(300, 100);
        connectionDialog.setVisible(true);



    }
}
