package com.korit.study.ch32;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Stream (데이터의 흐름)
 * 입력 스트림 (InputStream) : 파일 -> 프로그램
 * 출력 스트림 (OutputStream) : 프로그램 -> 파일
 * 종류 : 바이트 스트림(byte stream), 문자 스트림(text stream)
 * 1. 바이트 스트림 (이미지, 음성, 영상 등....)
 *  - InputStream / OutputStream
 *  - FileInputStream / FileOutputStream
 *  - BufferedInputStream / BufferedOutputStream
 *
 *  2. 문자 스트림 (텍스트)
 *  - Reader / Writer
 *  - FileReader / FileWriter
 *  - BufferedReader / BufferedWriter
 */

public class FileMain {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("text.txt");// 덮어쓰기
            fileWriter.write("이름: 문경구\n");
            fileWriter.write("나이 : 25\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("text.txt", true); // 이어쓰기
            fileWriter.write("이름: 김준일\n");
            fileWriter.write("나이 : 32\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");

        try {
            FileReader fileReader = new FileReader("text.txt");
            StringBuilder builder = new StringBuilder();
            while (true) {
                int readData = fileReader.read();
                if (readData == -1) {
                    break;
                }
                char text = (char) readData;
                builder.append(text);
            }
            System.out.println(builder);
            List<String> textList = Arrays.asList(builder.toString().split("\n"));
            System.out.println(textList);
        } catch (FileNotFoundException e) {
            System.out.println("해당 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("FileReader 객체를 통해 데이터를 읽는데 실패하였습니다.");
        }



    }
}
