package com.korit.study.ch32;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class StudentFileMain {
    public static void main(String[] args) {
        final String FILE_NAME = "student.txt";
        try {
            FileReader fileReader = new FileReader(FILE_NAME); // input과 output에서 꼭 필요한 예외처리를 꼭 해주어야함
            StringBuilder builder = new StringBuilder();
            while (true) {
                int readData = fileReader.read();
                if (readData == -1) {
                    break;
                }
                builder.append((char) readData);
            }
            fileReader.close();

            FileWriter fileWriter = new FileWriter(FILE_NAME);


            Map<String, String> modifyDataMap = Map.of(    // 바꾸고 싶은 내용을 담는 Map생성
                    "이름", "문경구",
                    "나이", "25"
                    );

            List<String> readLineList = new ArrayList<>();
            // split을 이용하여 배열로 만들고 asList로 바꾼 후 만든 리스트에 내용을 추가한다
            readLineList.addAll(Arrays.asList(builder.toString().split("\n")));
            readLineList.stream().map(line -> {
                AtomicReference<String> stringAtomicReference = new AtomicReference<>(line);
                modifyDataMap.entrySet().forEach(entry -> {  // 반복을 돌리기 위해 entrySet을 해줌
                if (stringAtomicReference.get().contains(entry.getKey())) {
                    stringAtomicReference.set(
                    String.format("%s: %s", entry.getKey(),entry.getValue())
                    );
                }
            });
                return stringAtomicReference.get();
            })
                    .toList()
                    .forEach(line -> {
                        try {
                            fileWriter.write(line+"\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            fileWriter.close();
            System.out.println("내용 수정 완료");

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다.");
        } catch (IOException e) {
            System.out.println("파일 내부의 내용을 읽지 못했습니다.");
        }

    }
}
