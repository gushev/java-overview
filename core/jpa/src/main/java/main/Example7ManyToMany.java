package main;

import entities.professor.Professor;
import entities.student.Student;
import helpers.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Example7ManyToMany {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();

    Professor professor = new Professor();
    Student student = new Student();

    professor.setName("Professor Name");
    student.setName("Student Name");

    professor.setStudents(List.of(student));

    JpaUtil.executeInTransaction(() -> entityManager.persist(professor));
  }
}
