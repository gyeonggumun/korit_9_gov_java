package com.korit.study.ch31;

import java.io.IOException;
import java.util.List;

public class ExceptionMain2 {
    public static void main(String[] args) {
        List<String> names = List.of("김준일", "김준이");
        try {
            print(names, 3);
        } catch (IOException e) {

        } catch (NullPointerException e) {
            System.out.println("리스트 변수에 null이 들어가 있어");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("배열크기 넘었어");
        } catch (Exception e){ // Exception은 모든 예외들을 처리 할 수 있기 때문에 가장 마지막에 catch 해주어야 한다
            System.out.println("최종적으로 모든 예외 처리");
        } finally {  // 문서를 작성하다 꺼졌을 때 임시 저장을 해주는 역할을 할 수 있음
            System.out.println("프로그램 정상 종료");
        }


    }

    public static void print (List<String> names, int size) throws
            IOException,
            NullPointerException,
            IndexOutOfBoundsException{

        System.out.println(names.size());
        for (int i = 0; i < size; i++) {
            System.out.println(names.get(i));
        }

    }
}
