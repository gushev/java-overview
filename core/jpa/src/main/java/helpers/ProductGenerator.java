package helpers;

import com.github.javafaker.Faker;
import entities.IProduct;
import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class ProductGenerator {
  private static final Faker faker = new Faker();

  public static <T extends IProduct> T fillWithFakeData(T product) {
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
}
