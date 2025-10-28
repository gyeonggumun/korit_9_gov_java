package com.korit.study.ch30;

import java.util.Arrays;
import java.util.List;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    // constructor, getters
}

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeDTO {
    String displayName;
    String salaryInfo;

    public EmployeeDTO(String displayName, String salaryInfo) {
        this.displayName = displayName;
        this.salaryInfo = salaryInfo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSalaryInfo() {
        return salaryInfo;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "displayName='" + displayName + '\'' +
                ", salaryInfo='" + salaryInfo + '\'' +
                '}';
    }
}

class Item {
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}


public class Quiz {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        System.out.println(names.stream().map(str -> str.toUpperCase()).toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().map(num -> num * num).toList());

        List<String> words = Arrays.asList("Java", "Stream", "API", "Programming");
        System.out.println(words.stream().map(s -> s.length()).toList());

        List<Double> prices = Arrays.asList(100.0, 200.0, 150.0, 300.0);
        System.out.println(prices.stream().map(d -> (d * 0.1) + d ).toList());

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        System.out.println(people.stream().map(str -> str.getName()).toList());

        List<String> usernames = Arrays.asList("john", "mary", "steve");
        System.out.println(usernames.stream().map(str -> "User: " + str).toList());

        List<Employee> employees = Arrays.asList(
                new Employee("Kim", 50000),
                new Employee("Lee", 60000)
        );

        List<EmployeeDTO> employeeDTOList = employees.stream()
                .map(str -> new EmployeeDTO("Mr/Ms " + str.name, " Salary: $" + str.salary)).toList();

        System.out.println(employeeDTOList);

        List<String> cities = Arrays.asList("Seoul", "Busan", "Incheon", "Daegu", "Gwangju");
        System.out.println(cities.stream().map(str -> str.substring(0,1)).toList());

        List<Boolean> flags = Arrays.asList(true, false, true, true, false);
        System.out.println(flags.stream().map(b -> !b).toList());

        List<Double> celsius = Arrays.asList(0.0, 25.0, 100.0, -10.0);
        System.out.println(celsius.stream().map(d -> (d * 9/5) + 32).toList());

        List<String> messyData = Arrays.asList("  hello  ", "world   ", "  java", "   stream   ");
        System.out.println(messyData.stream().map(str -> str.trim()).toList());

        List<String> emails = Arrays.asList(
                "user1@gmail.com",
                "admin@company.co.kr",
                "support@naver.com",
                "info@daum.net"
        );
        System.out.println(emails.stream().map(str -> str.substring(str.indexOf("@") + 1, str.length())).toList());

        List<Integer> ages = Arrays.asList(25, 30, 35, 20, 45);
        int currentYear = 2024;
        System.out.println(ages.stream().map( n -> currentYear - n).toList());

        List<Item> items = Arrays.asList(
                new Item("사과", 3000),
                new Item("바나나", 2000),
                new Item("오렌지", 5000)
        );
        System.out.println(items.stream().map(i -> i.name+"("+i.price+"원)").toList());

        List<Student> students = Arrays.asList(
                new Student("김철수", 95),
                new Student("이영희", 82),
                new Student("박민수", 76),
                new Student("정지원", 68)
        );
        System.out.println(students.stream()
                .map(s -> s.name + ":" + (s.score >= 90 ? 'A' : s.score >= 80 ? 'B' : s.score >= 70 ? 'C' : 'D')).toList());

        List<String> filePaths = Arrays.asList(
                "/home/user/documents/report.pdf",
                "/var/log/system.log",
                "C:\\Users\\Admin\\Desktop\\image.jpg",
                "/downloads/music.mp3"
        );
        System.out.println(filePaths.stream()
                .map(str -> str.substring(Math
                        .max(str.lastIndexOf("/"), str.lastIndexOf("\\"))+1)).toList());

        List<String> phoneNumbers = Arrays.asList(
                "01012345678",
                "01098765432",
                "01055556666",
                "01011112222"
        );

        System.out.println(phoneNumbers.stream()
                .map(str -> str.substring(0, 3) + "-" + str.substring(3, 7) + "-" + str.substring(7)).toList());

    }
}
