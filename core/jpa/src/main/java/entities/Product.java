package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product implements IProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private double price;

  @Column(name = "expiration_date")
  private LocalDate expiration_date;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public LocalDate getExpirationDate() {
    return expiration_date;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expiration_date = expirationDate;
  }
}
