package com.korit.study.ch12;

public class BoardprintService {

    void printAll (Board[] boards) {
        printInfoBoards(boards);
    }

    void printInfoBoards (Board[] boards) {
        for (Board board : boards) {
            System.out.println();
            printInfoBoard(board);
        }
    }

    void printInfoBoard (Board board) {
        System.out.println("글 ID: " + board.id);
        System.out.println("글 제목: " + board.title);
        System.out.println("글 내용: " + board.contents);
        printInfoWriter(board.writer);
        printInfoComments(board.comments);
    }

    void printInfoWriter (Writer writer) {
        System.out.println(" === 작성자 ===");
        System.out.println("작성자 ID: " + writer.id);
        System.out.println("작성자 이름: " + writer.name);
    }

    void printInfoComment (Comment comment) {
        System.out.println(" === 댓글 내용 === ");
        System.out.println("댓글 ID: " + comment.id);
        System.out.println("댓글 내용: " + comment.contents);
        printInfoWriter(comment.writer);
    }

    void printInfoComments (Comment[] comments) {
        for (Comment comment : comments) {
            printInfoComment(comment);
        }
    }


}
