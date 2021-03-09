package entities.professor;

import entities.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professors")
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "professor_student",
      joinColumns = @JoinColumn(name = "professor_id"),
      inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<Student> students;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }
}
