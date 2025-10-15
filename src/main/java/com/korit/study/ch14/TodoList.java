package com.korit.study.ch14;

public class TodoList {
    Todo[] todos;

    TodoList () {
        todos = new Todo[0];
    }

    int generatedTodoId() {
        // todos배열이 0인지 확인하여 0이면 id=1이고 아니라면 id + 1을 해주는 코드
        return todos.length == 0 ? 1 : todos[todos.length - 1].id + 1;
    }

    void add(Todo todo) {
        Todo[] temp = new Todo[todos.length + 1];
        for (int i = 0; i < todos.length; i++) {
            temp[i] = todos[i];
        }
        temp[temp.length - 1] = todo;
        todos = temp;
    }

    // 다건조회 findAll
    Todo[] findAllByUserId(int userId) {
        int foundTodoCount = 0;
        for (Todo todo : todos) {
            if (todo.user.id == userId) {
                foundTodoCount++;
            }
        }
        Todo[] foundTodos = new Todo[foundTodoCount];
        for (int i = 0, j = 0; i < todos.length; i++) {
            if (todos[i].user.id == userId) {
                foundTodos[j] = todos[i];
                j++;
            }
        }
        return foundTodos;
    }
}
