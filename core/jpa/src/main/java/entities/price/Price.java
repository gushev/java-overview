package entities.price;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "price")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private double amount;

  @Enumerated
  private Currency currency;

  @Enumerated(EnumType.STRING)
  @Column(name = "currency_string")
  private Currency currencyString;

  @Column(name = "datetime_created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datetimeCreated;

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public Currency getCurrencyString() {
    return currencyString;
  }

  public void setCurrencyString(Currency currencyString) {
    this.currencyString = currencyString;
  }

  public Date getDatetimeCreated() {
    return datetimeCreated;
  }

  public void setDatetimeCreated(Date datetimeCreated) {
    this.datetimeCreated = datetimeCreated;
  }
}
