package com.mayura.examples.persistant;

import com.mayura.examples.model.Student;
import com.mayura.examples.model.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MainClass {

    public static void main(String[] args) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            for (int i = 0; i < 10; i++) {
                Teacher teacher = new Teacher("A" + i, "B" + i);
                teacher.setName("A" + i);
                session.save(teacher);
            }
            for (int i = 0; i < 10; i++) {
                Student student = new Student("DFA" + i, "BB" + i);
                student.setName("AA" + i);

                session.save(student);
            }
            loadData();
            System.out.println("Waiting...");
            Thread.sleep(5000);
            loadData();
            System.out.println("done");
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        for (int i = 0; i < 10; i++) {
            final Student studentA = (Student) session.get(Student.class, i);
        }
        for (int i = 0; i < 10; i++) {
            final Teacher teacherA = (Teacher) session.get(Teacher.class, i);
        }
    }

}
