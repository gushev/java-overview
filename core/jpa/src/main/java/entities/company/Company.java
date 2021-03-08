package entities.company;

import embeddables.Address;
import entities.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @Embedded
  // The number column is actually called address_number in the company table
  @AttributeOverride(name = "number", column = @Column(name = "address_number"))
  private Address address;

  @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
  private List<Employee> employees = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
