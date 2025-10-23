package com.korit.study.ch24;

public class Comment {
    String writer;
    String content;

    public Comment(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "writer=" + writer +
                ", content='" + content + '\'' +
                '}';
    }
}
