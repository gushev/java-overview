import helpers.Customer;
import helpers.CustomerGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Example1Basics {
  public static void main(String[] args) {
    List<Customer> customers = CustomerGenerator.getCustomers(20);

    System.out.println("All customers younger than 30:");
    customers.stream()
      .filter(c -> c.age() <= 30)
      .forEach(System.out::println);

    IntStream mappedToAgeStream = customers.stream().mapToInt(Customer::age);

    System.out.println("Total age of all customers: " + mappedToAgeStream.sum());

    double averageAge = customers.stream()
      .mapToDouble(Customer::age)
      .average()
      .orElse(Double.NaN);

    System.out.println("Average age of all customers: " + averageAge);

    long johns = customers.stream()
      .filter(c -> c.firstName().equals("John"))
      .count();

    System.out.println("People called 'John': " + johns);
  }
}
