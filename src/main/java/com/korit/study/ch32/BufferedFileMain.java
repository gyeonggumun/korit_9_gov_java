package com.korit.study.ch32;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BufferedFileMain {
    public static void main(String[] args) {
        final String FILE_NAME = "student.txt";

        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<>();
            while (true) {
                String line = bufferedReader.readLine();
                if (Objects.isNull(line)){
                    break;
                }
                lines.add(line);
            }
            bufferedReader.close();
            System.out.println(lines);

            FileWriter fileWriter = new FileWriter(FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            lines.reversed().forEach(line -> {
                try {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {

                }
            });
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
    }
}
