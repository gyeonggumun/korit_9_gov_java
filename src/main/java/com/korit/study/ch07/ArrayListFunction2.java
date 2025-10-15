package com.korit.study.ch07;

import java.util.Scanner;

public class ArrayListFunction2 {

    public static void PrintTicketNamber(int[] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            System.out.print("[" + tickets[i] + "]");
        }
    }


    public static int[] addToArray (int[] tickets, int[] newTickets, int number) {
        for (int j = 0; j < tickets.length; j++) {
            newTickets[j] = tickets[j];
        }
        newTickets[newTickets.length - 1] = number;
        return newTickets;
    }


    public static int[] inputNumberToTickets(int[] tickets){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.print("복권 번호 입력: ");
            int[] newTickets = new int[tickets.length + 1];
            int number = scanner.nextInt();
            if (number > 45 || number <= 0) {
                System.out.println("0 이상 45 이하만 번호로 입력 가능합니다.");
                i -= 1;
            } else {
                tickets = addToArray(tickets, newTickets, number);
            }
        }
        return tickets;
    }


    public static void main(String[] args) {
        // 복권번호 6자리 입력
        int[] tickets = new int[0];

        tickets = inputNumberToTickets(tickets);
        PrintTicketNamber(tickets);
        }
    }

