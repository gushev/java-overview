package entities.company;

import javax.persistence.*;

@Entity
@Table(name = "company")
@SecondaryTable(name = "company_address")
public class CompanySecondaryTable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @Column(table = "company_address")
  private String street;

  @Column(table = "company_address")
  private String number;

  public void setName(String name) {
    this.name = name;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setNumber(String number) {
    this.number = number;
  }

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
