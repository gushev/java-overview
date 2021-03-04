package entities;

import embeddables.Address;

import javax.persistence.*;

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
}
