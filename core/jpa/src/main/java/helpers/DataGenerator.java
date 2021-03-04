package helpers;

import com.github.javafaker.Faker;
import embeddables.Address;
import entities.company.Company;
import entities.company.CompanySecondaryTable;
import entities.price.Currency;
import entities.price.Price;
import entities.product.IProduct;
import entities.product.Product;
import entities.product.ProductDetails;

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

  public static ProductDetails fillProductDetailsWithFakeData(ProductDetails productDetails) {
    productDetails.setKcal(String.valueOf(faker.number().numberBetween(1, 5000)));
    productDetails.setProduct(fillProductWithFakeData(new Product()));
    return productDetails;
  }

  public static Price fillPriceWithFakeData(Price price) {
    Currency currency = Currency.randomCurrency();
    price.setAmount(Double.parseDouble(faker.commerce().price(0d, 1000d)));
    price.setCurrency(currency);
    price.setCurrencyString(currency);
    price.setDatetimeCreated(new Date());
    return price;
  }

  public static CompanySecondaryTable fillCompanyWithFakeData(CompanySecondaryTable company) {
    company.setName(faker.company().name());
    company.setNumber(faker.address().streetAddressNumber());
    company.setStreet(faker.address().streetName());
    return company;
  }

  public static Company fillCompanyWithFakeData(Company company) {
    company.setName(faker.company().name());
    company.setAddress(fillAddressWithFakeData(new Address()));
    return company;
  }

  public static Address fillAddressWithFakeData(Address address) {
    address.setCity(faker.address().city());
    address.setNumber(faker.address().streetAddressNumber());
    address.setStreet(faker.address().streetName());
    return address;
  }
}
