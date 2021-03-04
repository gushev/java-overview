package entities.company;

import javax.persistence.*;

@Entity
@Table(name = "company")
@SecondaryTable(name = "company_address")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @Column(table = "company_address")
  private String street;

  @Column(table = "company_address")
  private String number;

  public String getName() {
    return name;
  }

  public String getStreet() {
    return street;
  }

  public String getNumber() {
    return number;
  }
}
