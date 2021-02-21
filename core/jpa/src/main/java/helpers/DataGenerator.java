package helpers;

import com.github.javafaker.Faker;
import entities.price.Currency;
import entities.price.Price;
import entities.product.IProduct;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataGenerator {
  private static final Faker faker = new Faker();

  public static <T extends IProduct> T fillProductWithFakeData(T product) {
    product.setName(faker.commerce().productName());
    product.setPrice(Double.parseDouble(faker.commerce().price(0d, 1000d)));
    product.setExpirationDate(
        faker
            .date()
            .future(100, TimeUnit.DAYS)
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate());
    return product;
  }

  public static Price fillPriceWithFakeData(Price price) {
    Currency currency = Currency.randomCurrency();
    price.setAmount(Double.parseDouble(faker.commerce().price(0d, 1000d)));
    price.setCurrency(currency);
    price.setCurrencyString(currency);
    price.setDatetimeCreated(new Date());
    return price;
  }
}
