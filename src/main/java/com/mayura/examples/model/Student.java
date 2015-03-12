package com.mayura.examples.model;

public class Student extends User {

    private String studentClass;
    private String course;

    public Student() {
    }

    public Student(String studentClass, String course) {
        this.studentClass = studentClass;
        this.course = course;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
