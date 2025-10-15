package com.korit.study.ch08;


import java.util.Scanner;
public class Array05 {

public static String[] Products = new String[] {"아이폰8", "아이폰9", "아이폰10", "아이폰11", "아이폰12", "아이폰13", "아이폰14", "아이폰15", "아이폰16"};
public static int[] Prices = new int[] {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000};
    public static void main(String[] args) {
        //CRUD
        //추가(Create), 조회(Read), 수정(Update), 삭제(Delete)
        System.out.println("[ 이름 관리 시스템 ]");
        showMainMenuView();
    }

    //showMainMenuView 함수 정의 - 뷰 화면을 보여주는 기능
    public static void showMainMenuView() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 조회");
            System.out.println("3. 상품 수정");
            System.out.println("4. 상품 삭제");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int selectedNumber = scanner.nextInt();
            scanner.nextLine();    //엔터 날리기용

            if (selectedNumber == 0) {          //0번 입력 시
                isExit =true;
            } else if (selectedNumber == 1) {   //1번 입력 시
                register();
            } else if (selectedNumber == 2) {   //2번 입력 시
                showNameList();
            }
        }
    }
    //  이름 추가 함수
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        String newName = null;
        while (true) {
            System.out.print("상품 입력: ");
            newName = scanner.nextLine();
            if (findByName(newName) == null) {
                break;  // null이 맞으면 중복이름이 없는 것이기 때문에 while문 탈출
            }
            // null이 맞지 않다면 같은 이름이 있다는 것임으로 while문 다시 실행
            System.out.println("이미 존재하는 이름입니다. 다시 입력하세요.");
        }
        System.out.print("가격 입력: ");
        int price = scanner.nextInt();
        add(newName, price);
        System.out.println("<< 상품 추가 완료. >>");
    }

    public static String findByName(String name) {
        for(String n : Products) {   // for과 다른 점 : for은 인덱스값이 있고 foreach는 인덱스 값이 없음
            if (n.equals(name)) { // names에 입력 받은 값이 있는지 확인
                return n;
            }
        }
        return null;
    }


    //  추가한 이름을 배열에 추가시키는 함수
    public static void add(String product, int price) {
        String[] newProductArray = new String[Products.length + 1];
        int[] newPriceArray = new int[Prices.length + 1];
        for (int i = 0; i < Products.length; i++) {
            newProductArray[i] = Products[i];
        }
        newProductArray[newProductArray.length - 1] = product;
        Products = newProductArray;
        for (int i = 0; i < Prices.length; i++) {
            newPriceArray[i] = Prices[i];
        }
        newPriceArray[newPriceArray.length - 1] = price;
        Prices = newPriceArray;
    }

    public static void showNameList() {
        Scanner scanner = new Scanner(System.in);
        int size = 4;
        while (true) {
            System.out.println("사용자 정보 조회");
            System.out.println("뒤로가려면 0을 입력하세요.");
            System.out.printf("페이지 번호 입력(1 ~ %d): ", getLastPage(size));
            int selectedPage = scanner.nextInt();
            scanner.nextLine();

            if (selectedPage == 0) {
                break;
            } else if (selectedPage > getLastPage(size)) {
                System.out.println("해당 페이지를 찾을 수 없습니다.");
            } else {
                String[] namesOfPagination = pagination(selectedPage, size);
                for (int i = 0; i < namesOfPagination.length; i++) {
                    System.out.printf("%d. %s\n", i + 1, namesOfPagination[i]);
                }
                System.out.println();
            }
        }
    }
    //  마지막 페이지 판별 함수
    public static int getLastPage(int size) {
        return Products.length % size == 0 ? Products.length / size : Products.length / size + 1;
    }

    //  조회 하는 함수 => 페이지에 몇개를 띄울 것인지
    public static String[] pagination(int page, int size) {
        int startIndex = (page - 1) * size; // (1 - 1) * 10 => 0, (2 - 1) * 10 => 10 한페이지에 size개 보는 공식
        int lastPage = getLastPage(size);
        boolean isLast = page == lastPage;
        int paginationArraySize = isLast && Products.length % size != 0 ? Products.length % size : size;
        String[] paginationArray = new String[paginationArraySize];
        for (int i = startIndex; i < startIndex + paginationArraySize; i++) {
            paginationArray[i - startIndex] = Products[i] + " " + Prices[i];
        }
        return paginationArray;
    }
}
