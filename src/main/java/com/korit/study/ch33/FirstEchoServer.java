package com.korit.study.ch33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class FirstEchoServer {
    public static void main(String[] args) {
        final int PORT = 5000;
        // PORT (서버 포트)
        // 단방향 -> HTTP
        // 양방향 -> 소켓통신
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);  // 내pc에서 실행하는 것이기 때문에 PORT번호만 입력
            System.out.println("에코 서버 실행");

            Socket socket = serverSocket.accept();      // 클라이언트의 접속을 기다림
            System.out.println("클라이언트 연결");
            System.out.println("IP: " + socket.getInetAddress());
            System.out.println("포트번호: " + socket.getPort());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            String message = reader.readLine();    // inputStream으로 데이터가 들어 올 때 까지 기다리는 행위
            System.out.println("메세지 내용: " + message);
            writer.println("서버 응답 내용: " + message);
            writer.flush();

            reader.close();
            writer.close();
            socket.close();
            serverSocket.close();

            System.out.println("서버 종료");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
