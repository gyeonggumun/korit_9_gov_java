package com.korit.study.ch24;

import java.util.List;
import java.util.Objects;

public class Board2 {
    private String title;
    private Writer2 writer;
    private String content;
    private List<Comment2> comments;

    public Board2() {}

    public Board2(String title, Writer2 writer, String content, List<Comment2> comments) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Writer2 getWriter() {
        return writer;
    }

    public void setWriter(Writer2 writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment2> getComments() {
        return comments;
    }

    public void setComments(List<Comment2> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Board2 board2)) return false;
        return Objects.equals(title, board2.title) && Objects.equals(writer, board2.writer) && Objects.equals(content, board2.content) && Objects.equals(comments, board2.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, writer, content, comments);
    }

    @Override
    public String toString() {
        return "Board2{" +
                "title='" + title + '\'' +
                ", writer=" + writer +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}
