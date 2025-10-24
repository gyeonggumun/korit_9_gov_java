package com.korit.study.ch24;

import java.util.Objects;

public class Comment2 {
    private Writer2 writer;
    private String content;

    public Comment2() {}

    public Comment2(Writer2 writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    public Writer2 getWriter2() {
        return writer;
    }

    public void setWriter2(Writer2 writer2) {
        this.writer = writer2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Comment2 comment2)) return false;
        return Objects.equals(writer, comment2.writer) && Objects.equals(content, comment2.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(writer, content);
    }

    @Override
    public String toString() {
        return "Comment2{" +
                "writer2=" + writer +
                ", content='" + content + '\'' +
                '}';
    }
}
