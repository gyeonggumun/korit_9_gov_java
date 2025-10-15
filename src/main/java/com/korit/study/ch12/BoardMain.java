package com.korit.study.ch12;

public class BoardMain {
    public static void main(String[] args) {
//        Board배열 - boards -> 게시글 2개

//        Board - id(정수), title(문자열), contents(문자열), writer(Writer), comments(Comment[])

//        Writer - id(정수), name(문자열)

//        Comment - id(정수), contents(문자열), writer(Writer)

        Writer writer1 = new Writer(1, "김준일");
        Writer writer2 = new Writer(2, "김준이");
        Writer writer3 = new Writer(3, "김준삼");
        Writer[] writers = new Writer[] {writer1, writer2, writer3};

        Comment comment1 = new Comment(1, "국비 후기 내용1", writers[1]);
        Comment comment2 = new Comment(2, "학교 수업 후기1", writers[0]);
        Comment comment3 = new Comment(3, "국비 후기 내용2", writers[2]);
        Comment comment4 = new Comment(4, "학교 수업 후기2", writers[1]);
        Comment comment5 = new Comment(5, "학교 수업 후기3", writers[0]);
        //댓글 의 배열을 두개 만들어야 하기 때문에 2차원 배열을 활용하여 작성
        Comment[][] comments = new Comment[][]{{comment1, comment3},{comment2, comment4, comment5}};

        Board board1 = new Board(1, "국비 수업", "국비에서 배우는 내용", writers[1], comments[0]);
        Board board2 = new Board(2, "학교 수업", "학교에서 배우는 내용", writers[0], comments[1]);
        Board[] boards = new Board[] {board1, board2};

        BoardprintService boardprintService = new BoardprintService();
        boardprintService.printAll(boards);

    }
}
