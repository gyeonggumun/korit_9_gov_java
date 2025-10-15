package com.korit.study.ch14;

public class TodoListMain {
    public static void main(String[] args) {
        UserList userlist = new UserList();
        UserService userService = new UserService(userlist);
        TodoList todoList = new TodoList();
        TodoService todoService = new TodoService(todoList);
        TodoListView view = new TodoListView(userService, todoService);

        view.homeView();

        System.out.println("==<< 프로그램 종료 >>==");
    }
}
