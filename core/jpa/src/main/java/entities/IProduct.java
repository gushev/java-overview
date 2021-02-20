package entities;

import java.time.LocalDate;

public interface IProduct {
  void setName(String name);

  void setPrice(double price);

  void setExpirationDate(LocalDate expirationDate);
}
