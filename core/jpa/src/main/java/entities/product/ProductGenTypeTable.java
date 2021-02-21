package entities.product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product_gen_type_table")
public class ProductGenTypeTable implements IProduct {

  @Id
  // These are all the default values
  // I've only added them to have an example on how to change if needed
  @TableGenerator(
      name = "key_generator",
      table = "key_generator",
      pkColumnName = "sequence_name",
      pkColumnValue = "product_gen_type_table",
      valueColumnName = "next_val",
      allocationSize = 50)
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
  private int id;

  private String name;
  private double price;

  @Column(name = "expiration_date")
  private LocalDate expirationDate;

  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  @Override
  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }
}
