package com.korit.study.ch34.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class MainPanel extends JPanel {
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    public MainPanel(LayoutManager layout) {
        super(layout);
        setSize(600, 500);  // this 생략
        setVisible(true);   // this 생략
        topPanel = new TopPanel(new FlowLayout());
        add(topPanel, BorderLayout.NORTH);
        centerPanel = new CenterPanel(new BorderLayout(10, 10));
        add(centerPanel, BorderLayout.CENTER);
        bottomPanel = new BottomPanel(new BorderLayout(10, 10));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    class TopPanel extends JPanel {
        private JLabel titleLabel;

        public TopPanel(LayoutManager layout) {
            super(layout);
            titleLabel = new JLabel("채팅 클라이언트");
            add(titleLabel, BorderLayout.BEFORE_FIRST_LINE);
            setSize(getMaximumSize());
            setVisible(true);
        }
    }

    class CenterPanel extends JPanel {
        private JTextArea chatTextArea;
        private JScrollPane jScrollPane;
        public CenterPanel(LayoutManager layout) {
            super(layout);
            chatTextArea = new JTextArea();
            jScrollPane = new JScrollPane(chatTextArea);
            chatTextArea.setEnabled(false);
            chatTextArea.setVisible(true);
            add(jScrollPane, BorderLayout.CENTER);
            jScrollPane.setVisible(true);
            setVisible(true);

            Thread messageReceiver = new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(Main.socket.getInputStream()));
                    while (true) {
                        String line = in.readLine();
                        chatTextArea.append(line + "\n");
                    }
                } catch (IOException e) {
                }
            });

            messageReceiver.start();
        }
    }

    class BottomPanel extends JPanel {
        private JTextField messageField;
        private JButton sendButton;

        public BottomPanel(LayoutManager layout) {
            super(layout);

            messageField = new JTextField();
            messageField.setSize(500, 70);
            messageField.setVisible(true);

            sendButton = new JButton("전송");
            sendButton.setSize(80, 70);
            sendButton.setVisible(true);
            sendButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        PrintWriter out = new PrintWriter(Main.socket.getOutputStream());
                        out.println(messageField.getText());
                        out.flush();
                    } catch (IOException ex) {

                    }
                }
            });

            add(messageField, BorderLayout.CENTER);
            add(sendButton, BorderLayout.CENTER);
            setVisible(true);
        }
    }
}

public class MainForm extends JFrame {
    private JPanel mainPanel;

    public MainForm() {
        mainPanel = new MainPanel(new BorderLayout(5, 5));
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

    }
}
