package entities.student;

import entities.professor.Professor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToMany(mappedBy = "students")
  private List<Professor> professors;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
