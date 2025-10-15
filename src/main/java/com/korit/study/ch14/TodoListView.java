package com.korit.study.ch14;

import java.util.Scanner;

public class TodoListView {

    Scanner scanner; // 스캐너를 여러 매서드 안에서 사용하기 위해서 밖에 정의
    User principal; // 기본 값 null대입
    UserService userService;
    TodoService todoService;

    // 커스텀 생성자 -> 사용하고 싶은데로 커스텀하여 생성한 생성자
    TodoListView(UserService userService, TodoService todoService) {
        scanner = new Scanner(System.in);
        this.userService = userService;
        this.todoService = todoService;
    }

    void homeView() {
        while (true) {
            System.out.println("[TodoList]");
            System.out.println("1. TodoList");
            if(principal == null) { // 로그인이 되어있는 상태인지 확인
                System.out.println("2. 회원가입");
                System.out.println("3. 로그인");
            } else {
                System.out.println("2. 로그아웃");
            }
            System.out.println("q. 프로그램 종료");
            System.out.print(">> ");  // 입력 받을 때 옆에 입력받기 위해 println이 아닌 print사용
            String cmd = scanner.nextLine(); // String이 클래스이기 때문에 cmd는 객체이면서 문자열이라 볼 수 있음
            // 클린 코드 법칙  =>   cmd.equals("q") 와 "q".equals(cmd)의 차이점은
            // 안정성의 차이가 있음 cmd.equals("q")의 cmd에 null값이 있을 수 있음으로 안정성이 좋지 않을 수 있음
            if ("q".equals(cmd)) { // equals함수의 리턴 값은 true or false이다
                break; // while문 탈출
            } else if ("1".equals(cmd)) {
                // TodoList 관리
                if (principal == null) { //principal 이 null이라는 것은 로그인 되지 않았다는 것
                    System.out.println("로그인 후 사용가능합니다.");
                    continue; // if문을 탈출하여 while문으로 올라가는 함수
                }
                todoListMenuView();
                System.out.println();
            } else if ("2".equals(cmd) && principal == null) {
                // 회원가입
                signupView(); //principal이 null이면 signupview로 넘어가도록함
            } else if ("2".equals(cmd) && principal != null) {
                //로그아웃
                principal = null;
                System.out.println("==<< 로그아웃 완료!! >>==");
                //null이면 동작을 하도록 하지 않으면 3번을 누르면 항상 동작하기 때문에 principal의 상태를 확인함
            } else if ("3".equals(cmd) && principal == null) {
                // 로그인
                signinView();
            }
        }
    }

    void signinView() {
        System.out.println("[ 로그인 ]");
        System.out.print("username >>");
        String username = scanner.nextLine();
        System.out.print("password >> ");
        String password = scanner.nextLine();
        SigninDto signinDto = new SigninDto(username, password); // 입력 받은 username, password이 들어 있는지 확인
        User foundUser = userService.signin(signinDto);
        if (foundUser == null) { // 아이디나 페스워드가 틀렸을 경우
            System.out.println("사용자 정보를 다시 확인하세요.");
            return;
        }
        principal = foundUser; //아이디와 페스워드 모두 맞았을 경우
        System.out.println("==<< 로그인 성공!! >>==");
    }

    void signupView() {
        System.out.println("[ 회원가입 ]");
        String username = null; //초기화
        while (true) {
            System.out.print("username >> ");
            username = scanner.nextLine();
            if(!userService.isDuplicatedUsername(username)) { // username이 중복인지 확인
               break; // 중복이 아니면 while문 탈출
            }
            // 중복일 경우 if문이 실행되지 않아 프린트 후 while문 다시 실행
            System.out.println("이미 존재하는 사용자이름입니다.");
        }
        System.out.print("password >> ");
        String password = scanner.nextLine();
        System.out.print("name >> ");
        String name = scanner.nextLine();
        SignupDto signupDto = new SignupDto(username, password, name);
        System.out.println(signupDto.toString()); // signupDto 안에 정보가 잘 들어갔는지 확인
        userService.signup(signupDto);
        System.out.println("==<< 회원가입 완료!! >>==");
        userService.printUserListAll();
    }

    void todoListMenuView() {
        while (true) {
            System.out.println("[ TodoList Menu ]");
            System.out.println("1. Todo 등록");
            System.out.println("2. Todo 조회");
            System.out.println("b. 뒤로가기");
            System.out.print(">> ");
            String cmd = scanner.nextLine();

            if ("b".equals(cmd)) {
                break;
            } else if ("1".equals(cmd)) {
                System.out.println("[ Todo 등록 ]");
                System.out.print("오늘 할 일 >> ");
                String contents = scanner.nextLine();
                TodoRegisterDto todoRegisterDto = new TodoRegisterDto(contents, principal);
                todoService.register(todoRegisterDto);
                System.out.println("==<< Todo 등록 완료 >>==");
            } else if ("2".equals(cmd)) {
                System.out.println("[ Todo 조희 ]");
                todoService.printAllByUser(principal);
            }
        }

    }




}
