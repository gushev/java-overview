import helpers.Customer;
import helpers.CustomerGenerator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Example1Customers {
  public static void main(String[] args) {
    List<Customer> customers = CustomerGenerator.getCustomers(20);

    System.out.println("All customers younger than 30:");
    customers.stream().filter(c -> c.age() <= 30).forEach(System.out::println);

    IntStream mappedToAgeStream = customers.stream().mapToInt(Customer::age);

    System.out.println("Total age of all customers: " + mappedToAgeStream.sum());

    double averageAge = customers.stream().mapToDouble(Customer::age).average().orElse(Double.NaN);

    System.out.println("Average age of all customers: " + averageAge);

    long johns = customers.stream().filter(c -> c.firstName().equals("John")).count();

    System.out.println("People called 'John': " + johns);

    if (customers.stream().anyMatch(c -> c.age() > 55)) {
      System.out.println("There is at least one customer over 55");
    } else {
      System.out.println("There are no customers over 55");
    }

    if (customers.stream().noneMatch(c -> c.age() > 21)) {
      System.out.println("All customers are over 21");
    } else {
      System.out.println("Some customers are younger than 21");
    }

    if (customers.stream()
        .noneMatch(c -> c.firstName().equals("John") && c.lastName().equals("Morgan"))) {
      System.out.println("There are no customers called John Morgan");
    } else {
      System.out.println("There is at least one customer called John Morgan");
    }

    String result =
        customers.stream()
            .filter(c -> c.lastName().startsWith("S"))
            .map(c -> c.firstName())
            .distinct()
            .reduce((a, b) -> a.concat(" " + b))
            .orElse("No results");

    System.out.println("First Names of customers with Last Names starting with S: " + result);

    List<List<Customer>> listsOfCustomers =
        List.of(
            CustomerGenerator.getCustomers(3),
            CustomerGenerator.getCustomers(2),
            CustomerGenerator.getCustomers(5));

    Comparator<Customer> comparator = (c1, c2) -> c1.age() - c2.age();

    System.out.println("List of list of customers ordered by age:");
    listsOfCustomers.stream()
        .flatMap(Collection::stream)
        .sorted(comparator)
        .forEach(System.out::println);
  }
}
