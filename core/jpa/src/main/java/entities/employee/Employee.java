package entities.employee;

import entities.company.Company;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @JoinColumn(name = "company_id")
  @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
  private Company company;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Company getDepartment() {
    return company;
  }

  public void setDepartment(Company company) {
    this.company = company;
    this.company.addEmployee(this);
  }
}
