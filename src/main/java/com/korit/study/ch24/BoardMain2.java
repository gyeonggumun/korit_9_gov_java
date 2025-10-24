package com.korit.study.ch24;

import java.util.ArrayList;
import java.util.List;

public class BoardMain2 {
    public static void main(String[] args) {
        // 모든 정보를 담을 큰 리스트 하나 생성
        List<Board2> boards = new ArrayList<>();
        // 리스트 안에 게시글 담을 공간 생성
        boards.add(new Board2());
        // 첫 번째 게시글안에 내용 작성
        boards.get(0).setTitle("게시판 제목1");
        boards.get(0).setWriter(new Writer2("김준일", 32));
        boards.get(0).setContent("게시판 내용1");
        boards.get(0).setComments(new ArrayList<>());
        boards.get(0).getComments().add(new Comment2(new Writer2("김준이", 31), "댓글 내용1"));
        boards.get(0).getComments().add(new Comment2(new Writer2("김준삼", 33), "댓글 내용2"));
        // 두번째 게시글 담을 공간 생성
        boards.add(new Board2());
        boards.get(1).setTitle("게시판 제목2");
        boards.get(1).setWriter(new Writer2("김준사", 34));
        boards.get(1).setContent("게시판 내용2");
        boards.get(1).setComments(new ArrayList<>());
        boards.get(1).getComments().add(new Comment2(new Writer2("김준오", 35), "댓글 내용11"));
        boards.get(1).getComments().add(new Comment2(new Writer2("김준육", 36), "댓글 내용22"));
        System.out.println(boards);
        // 재사용 하지 않는데 변수에 지정을 해서 사용할 이유가 없다

        Board2 board2 = new Board2();
        board2.setTitle("게시판 제목3");
        board2.setWriter(new Writer2("김준사", 34));
        board2.setContent("게시판 내용3");
        List<Comment2> comments = new ArrayList<>();
        comments.add(new Comment2(new Writer2("김준오",35), "댓글 내용1"));
        comments.add(new Comment2(new Writer2("김준육",36), "댓글 내용2"));
        board2.setComments(comments);
        boards.add(board2);

        /// ///////////////////////////////////////////////////////////////////////////////////

        List<Comment2> comments2 = new ArrayList<>();
        comments2.add(new Comment2(new Writer2("김준오",35), "댓글 내용1"));
        comments2.add(new Comment2(new Writer2("김준육",36), "댓글 내용2"));

        Board2 board3 = new Board2("게시판 제목4", new Writer2("김준사", 34), "게시판 내용4", comments2);

        boards.add(board3);

        System.out.println(boards);
    }
}
