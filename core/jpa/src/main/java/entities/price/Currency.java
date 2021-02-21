package entities.price;

import java.util.List;
import java.util.Random;

public enum Currency {
  USD,
  GBP,
  BGN;

  private static final List<Currency> VALUES = List.of(values());

  public static Currency randomCurrency() {
    Random random = new Random();
    return VALUES.get(random.nextInt(VALUES.size()));
  }
}
