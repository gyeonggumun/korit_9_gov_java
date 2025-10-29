package com.korit.study.ch30;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public EmployeeDTO toDto () {
        return new EmployeeDTO(String.format("Mr./Ms/%s" , name), String.format("$%f", salary));
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

        List<EmployeeDTO> employeeDTOS = employees.stream()
                .map(Employee::toDto)
                .toList();
        System.out.println(employees);
        System.out.println(employeeDTOS);

        List<String> fileNames = filePaths.stream()
                .map(f -> f.replaceAll("\\\\", "/"))
                .map(f -> f.substring(f.lastIndexOf("/") + 1))
                .toList();
        System.out.println(fileNames);

        // filter 문제
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers2.stream().filter( num -> num % 2 == 0).toList());

        List<String> words2 = Arrays.asList("cat", "elephant", "dog", "butterfly", "ant", "tiger");
        System.out.println(words2.stream().filter(str -> str.length() >= 5).toList());

        List<String> names2 = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Andrew", "David");
//        System.out.println(names2.stream().filter(str -> str.substring(1) == 'A').toList());

        List<Integer> mixedNumbers = Arrays.asList(-5, 3, -2, 8, -1, 0, 7, -9, 4);
        System.out.println(mixedNumbers.stream().filter(num -> num > 0 ).toList());

        List<Product> products = Arrays.asList(
                new Product("노트북", 1500000),
                new Product("마우스", 30000),
                new Product("키보드", 80000),
                new Product("모니터", 300000),
                new Product("USB", 15000)
        );
        System.out.println(products.stream().filter(n -> n.price <= 500000 && n.price >= 50000).map(n -> n.name).toList());

        List<String> emails2 = Arrays.asList(
                "user1@gmail.com",
                "admin@company.com",
                "support@gmail.com",
                "info@naver.com",
                "hello@gmail.com",
                "test@daum.net"
        );
        System.out.println(emails2.stream().filter(str -> str.substring(str.indexOf("@")+1).equals("gmail.com")).toList());

        List<Person2> people2 = Arrays.asList(
                new Person2("김철수", 25),
                new Person2("이영희", 17),
                new Person2("박민수", 30),
                new Person2("정지원", 16),
                new Person2("최수현", 22)
        );
        System.out.println(people2.stream().filter(num -> num.age >= 19).map(p -> p.name+ "(" + p.age + ")").toList());

        List<Student2> students2 = Arrays.asList(
                new Student2("김철수", 85, 90),
                new Student2("이영희", 92, 88),
                new Student2("박민수", 65, 70),
                new Student2("정지원", 78, 85),
                new Student2("최수현", 95, 92)
        );
        System.out.println(students2.stream().filter(s -> s.englishScore >= 80 && s.mathScore >= 80).map(s -> s.name).toList());

        List<String> articles = Arrays.asList(
                "Java 프로그래밍 기초",
                "Python으로 배우는 머신러닝",
                "Java Stream API 완벽 가이드",
                "JavaScript 최신 기능",
                "Java Spring Boot 실전",
                "React 입문 강좌"
        );
//        articles.stream().filter(str -> str.)

        List<Item2> items2 = Arrays.asList(
                new Item2("노트북", 5, true, 1000000),
                new Item2("마우스", 0, true, 30000),
                new Item2("키보드", 10, false, 50000),
                new Item2("헤드셋", 3, true, 80000),
                new Item2("웹캠", 0, false, 60000)
        );
        System.out.println(items2.stream().filter(item -> item.onSale == true && item.stock > 0).map(item -> item.name).toList());

        List<String> data = Arrays.asList("apple", null, "banana", "", null, "cherry", "");
        System.out.println(data.stream().filter(str -> str != null && !str.isBlank()).toList());

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 5, 8);
        System.out.println(numbers3.stream()
                .filter(num -> numbers3
                .stream()
                .filter(num2 -> num2 == num)
                .count() == 1)
                .toList());
        // stream을 사용하지 않고 for문을 돌린 버전
        List<Integer> filteringNumbers2 = new ArrayList<>();
        for (Integer num : numbers3) {
            int count = 0;
            for (Integer num2 : numbers3) {
                if (num2 == num) {
                    count++;
                }
            }
            if (count == 1) {
                filteringNumbers2.add(num);
            }
        }
        System.out.println(filteringNumbers2);

        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2024, 1, 1),  // 월요일
                LocalDate.of(2024, 1, 6),  // 토요일
                LocalDate.of(2024, 1, 7),  // 일요일
                LocalDate.of(2024, 1, 10), // 수요일
                LocalDate.of(2024, 1, 13), // 토요일
                LocalDate.of(2024, 1, 14)  // 일요일
        );
        System.out.println(LocalDate.of(2024,1,6).getDayOfWeek());

        List<LocalDate> filteringDates = dates.stream()
                .filter(localDate -> localDate.getDayOfWeek().name().equals("SATURDAY")
                        || localDate.getDayOfWeek().name().equals("SUNDAY")).toList();
        System.out.println(filteringDates);
    }
}
class Product {
    String name;
    int price;

    public Product(String name, int price) {
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
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Student2 {
    String name;
    int mathScore;
    int englishScore;

    public Student2(String name, int mathScore, int englishScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }
}

class Item2 {
    String name;
    int stock;
    boolean onSale;
    int price;

    public Item2(String name, int stock, boolean onSale, int price) {
        this.name = name;
        this.stock = stock;
        this.onSale = onSale;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item2{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", onSale=" + onSale +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public int getPrice() {
        return price;
    }
}
