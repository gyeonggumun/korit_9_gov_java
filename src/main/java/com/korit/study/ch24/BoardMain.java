package com.korit.study.ch24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardMain {
    public static void main(String[] args) {
        // 게시판
        /**
         * [
         *      {
         *          "title": "게시판 제목1",
         *          "writer": {
         *              "name": "김준일",
         *              "age": 32
         *          },
         *          "content": "게시판 내용1",
         *          "comments": [
         *              {
         *                  "writer": "김준이",
         *                  "content": "댓글 내용1"
         *              },
         *              {
         *                  "writer": "김준삼",
         *                  "content": "댓글 내용2"
         *              },
         *          ]
         *      },
         *      {
         *          "title": "게시판 제목2",
         *          "writer": {
         *              "name": "김준사",
         *              "age": 34
         *          },
         *          "content": "게시판 내용2",
         *          "comments": [
         *              {
         *                  "writer": "김준오",
         *                  "content": "댓글 내용11"
         *              },
         *              {
         *                  "writer": "김준육",
         *                  "content": "댓글 내용22"
         *              },
         *          ]
         *      },
         * ]
         */


        List<Object> AllList = new ArrayList<>();

        Map<String, String> strMap1 = new HashMap<>();
        Map<String, String> strMap2 = new HashMap<>();

        List<Object> strList1 = new ArrayList<>();

        Map<String, Object> strMap3 = new HashMap<>();
        Map<String, Object> userMap1 = new HashMap<>();

        Map<String, String> strMap4 = new HashMap<>();
        Map<String, String> strMap5 = new HashMap<>();

        List<Object> strList2 = new ArrayList<>();

        Map<String, Object> strMap6 = new HashMap<>();
        Map<String, Object> userMap2 = new HashMap<>();

        userMap1.put("name", "김준일");
        userMap1.put("age", 32);

        strMap1.put("writer", "김준이");
        strMap2.put("writer", "김준삼");

        strMap1.put("content", "댓글 내용1");
        strMap2.put("content", "댓글 내용2");

        strList1.add(strMap1);
        strList1.add(strMap2);

        strMap3.put("content", "게시판 내용1");
        strMap3.put("comments", strList1);
        strMap3.put("title", "게시판 제목1");
        strMap3.put("writer", userMap1);

        userMap2.put("name", "김준사");
        userMap2.put("age", 34);

        strMap4.put("writer", "김준오");
        strMap5.put("writer", "김준육");

        strMap4.put("content", "댓글 내용11");
        strMap5.put("content", "댓글 내용22");

        strList2.add(strMap4);
        strList2.add(strMap5);

        strMap6.put("content", "게시판 내용2");
        strMap6.put("comments", strList2);
        strMap6.put("title", "게시판 제목3");
        strMap6.put("writer", userMap2);

        AllList.add(strMap3);
        AllList.add(strMap6);

        System.out.println(AllList);

        Writer writer = new Writer();

    }
}
