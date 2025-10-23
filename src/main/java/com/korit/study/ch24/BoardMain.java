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

        // 댓글 작성자의 이름과 댓글 내용이 들어갈 Map
        Map<String, String> strMap1 = new HashMap<>();
        strMap1.put("writer", "김준이");
        strMap1.put("content", "댓글 내용1");
        Map<String, String> strMap2 = new HashMap<>();
        strMap2.put("writer", "김준삼");
        strMap2.put("content", "댓글 내용2");
        Map<String, String> strMap4 = new HashMap<>();
        strMap4.put("writer", "김준오");
        strMap4.put("content", "댓글 내용11");
        Map<String, String> strMap5 = new HashMap<>();
        strMap5.put("writer", "김준육");
        strMap5.put("content", "댓글 내용22");

        // 댓글들을 담을 리스트
        List<Object> strList1 = new ArrayList<>();
        strList1.add(strMap1);
        strList1.add(strMap2);
        List<Object> strList2 = new ArrayList<>();
        strList2.add(strMap4);
        strList2.add(strMap5);

        // writer의 이름과 나이를 담는 Map
        Map<String, Object> userMap1 = new HashMap<>();
        userMap1.put("name", "김준일");
        userMap1.put("age", 32);
        Map<String, Object> userMap2 = new HashMap<>();
        userMap2.put("name", "김준사");
        userMap2.put("age", 34);

        // 마지막 게시글1 내용들을 전체적으로 담는 Map
        Map<String, Object> strMap3 = new HashMap<>();
        strMap3.put("content", "게시판 내용1");
        strMap3.put("comments", strList1);
        strMap3.put("title", "게시판 제목1");
        strMap3.put("writer", userMap1);
        Map<String, Object> strMap6 = new HashMap<>();
        strMap6.put("content", "게시판 내용2");
        strMap6.put("comments", strList2);
        strMap6.put("title", "게시판 제목3");
        strMap6.put("writer", userMap2);

        // 모든내용을 담을 리스트
        List<Object> AllList = new ArrayList<>();
        AllList.add(strMap3);
        AllList.add(strMap6);

        // 강사님 풀이 ==========================================================================================
        ArrayList<HashMap<String, String>> l1 = new ArrayList<>();
        l1.add(new HashMap<String, String>());
        l1.add(new HashMap<String, String>());
        l1.get(0).put("writer", "김준이");
        l1.get(0).put("content", "댓글내용1");
        l1.get(1).put("writer", "김준삼");
        l1.get(1).put("content", "댓글내용2");

        HashMap<String, Object> boardMap1 = new HashMap<String, Object>();
        boardMap1.put("title", "게시판 제목1");
        boardMap1.put("writer", new HashMap<String, Object>());
        ((HashMap<String, Object>) boardMap1.get("writer")).put("name","김준일");
        ((HashMap<String, Object>) boardMap1.get("writer")).put("age", 32);
        boardMap1.put("content", "게시판 내용1");
        boardMap1.put("comments", new ArrayList<HashMap<String, String>>());
        ((ArrayList<HashMap<String, String>>) boardMap1.get("comments")).add(new HashMap<String, String>());
        ((ArrayList<HashMap<String, String>>) boardMap1.get("comments")).add(new HashMap<String, String>());
        ((ArrayList<HashMap<String, String>>) boardMap1.get("comments")).get(0).put("writer", "김준이");
        ((ArrayList<HashMap<String, String>>) boardMap1.get("comments")).get(0).put("content", "댓글내용1");
        ((ArrayList<HashMap<String, String>>) boardMap1.get("comments")).get(1).put("writer", "김준삼");
        ((ArrayList<HashMap<String, String>>) boardMap1.get("comments")).get(1).put("content", "댓글내용2");

        ArrayList<HashMap<String, String>> l2 = new ArrayList<>();
        l2.add(new HashMap<String, String>());
        l2.add(new HashMap<String, String>());
        l2.get(0).put("writer", "김준오");
        l2.get(0).put("content", "댓글내용1");
        l2.get(1).put("writer", "김준육");
        l2.get(1).put("content", "댓글내용2");

        HashMap<String, Object> boardMap2 = new HashMap<String, Object>();
        boardMap2.put("title", "게시판 제목1");
        boardMap2.put("writer", new HashMap<String, Object>());
        ((HashMap<String, Object>) boardMap2.get("writer")).put("name","김준사");
        ((HashMap<String, Object>) boardMap2.get("writer")).put("age", 34);
        boardMap2.put("content", "게시판 내용1");
        boardMap2.put("comments", new ArrayList<HashMap<String, String>>());
        ((ArrayList<HashMap<String, String>>) boardMap2.get("comments")).add(new HashMap<String, String>());
        ((ArrayList<HashMap<String, String>>) boardMap2.get("comments")).add(new HashMap<String, String>());
        ((ArrayList<HashMap<String, String>>) boardMap2.get("comments")).get(0).put("writer", "김준오");
        ((ArrayList<HashMap<String, String>>) boardMap2.get("comments")).get(0).put("content", "댓글내용1");
        ((ArrayList<HashMap<String, String>>) boardMap2.get("comments")).get(1).put("writer", "김준육");
        ((ArrayList<HashMap<String, String>>) boardMap2.get("comments")).get(1).put("content", "댓글내용2");

        ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
        boardList.add(boardMap1);
        boardList.add(boardMap2);

        System.out.println(boardList);














        System.out.println(AllList);

        Writer writer1 = new Writer("김준일", 32);
        Writer writer2 = new Writer("김준사", 34);


        Comment comment1 = new Comment("김준이", "댓글 내용1");
        Comment comment2 = new Comment("김준삼", "댓글 내용2");
        ArrayList<Comment> comments1 = new ArrayList<>();
        comments1.add(comment1);
        comments1.add(comment2);

        Comment comment3 = new Comment("김준오", "댓글 내용11");
        Comment comment4 = new Comment("김준육", "댓글 내용22");
        ArrayList<Comment> comments2 = new ArrayList<>();
        comments2.add(comment3);
        comments2.add(comment4);

        Title title1 = new Title("게시판 제목1", writer1, "게시판 내용1",comments1);
        Title title2 = new Title("게시판 제목2", writer2, "게시판 내용2",comments2);
        System.out.println(title1);
        System.out.println(title2);


    }
}
