package com.mayura.examples.model;

public class Teacher extends User {

    private String teacherClass;
    private String course;

    public Teacher() {
    }

    public Teacher(String teacherClass, String course) {
        this.teacherClass = teacherClass;
        this.course = course;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherClass='" + teacherClass + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
