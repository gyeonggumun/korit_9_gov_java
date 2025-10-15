package com.korit.study.ch11;

public class StudyMain {
    public static void main(String[] args) {
        // 과목명: JAVA 기초
        // 담당 선생님 이름 : 김준일
        // 담당 선생님 나이: 32
        // 학생1 ID: 20250001
        // 학생1 이름: 박재현
        // 학생1 나이: 24
        // 학생2 ID: 20250002
        // 학생2 이름: 고대한
        // 학생2 나이: 19
        // 학생3 ID: 20250003
        // 학생3 이름: 양재원
        // 학생3 나이: 27
        // 스터디 객체를 생성하시오.

        Student student1 = new Student (20250001, "박재헌", 24);
        Student student2 = new Student (20250002, "고대한", 19);
        Student student3 = new Student (20250003, "양재원", 27);
        Student[] students = new Student[] {student1, student2, student3};
        Teacher teacher = new Teacher("김준일", 32);
        Subject subject = new Subject("JAVA 기초", teacher);
        Study study = new Study(subject, students);
        System.out.println("과목명: " + study.subject.name);
        System.out.println("담당 선생님 이름 : " + study.subject.teacher.name);
        System.out.println("담당 선생님 나이 : " + study.subject.teacher.age);
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + i +" ID: " + study.students[i].id);
            System.out.println("학생"+ i +" 이름: " + study.students[i].name);
            System.out.println("학생"+ i +" 나이: " + study.students[i].age);
        }
        StudyPrintService studyPrintService = new StudyPrintService();
        studyPrintService.printInfoAll(study);
        System.out.println("==========================");
        studyPrintService.printInfoSubject(study.subject);
        System.out.println("==========================");
        studyPrintService.printInfoTeacher(study.subject.teacher);
        System.out.println("==========================");
        studyPrintService.printInfoStudent(study.students[0]);




    }
}
