package com.korit.study.ch24;

import java.util.List;

public class Title {
    String title;
    Writer writer;
    String content;
    List<Comment> comments;

    public Title(String title, Writer writer, String content, List<Comment> comments) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", writer=" + writer +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }


}
