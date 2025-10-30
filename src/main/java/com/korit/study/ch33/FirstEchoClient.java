package com.korit.study.ch33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FirstEchoClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 5000;

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT); // 서버 주소와 port번호를 이용하여 서버 접속
            System.out.println("서버 접속 완료");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            String message = "소켓 통신 전송 데이터입니다";
            System.out.println(message);
            writer.println(message);
            writer.flush();

            String responseMessage = reader.readLine();
            System.out.println("응답 데이터: " + responseMessage);

            reader.close();
            writer.close();
            socket.close();
            System.out.println("클라이언트 종료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
