import helpers.Customer;
import helpers.CustomerGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example4Optional {
  public static void main(String[] args) {

    List<Customer> customers = CustomerGenerator.getCustomers(10);
    List<Customer> emptyCustomers = CustomerGenerator.getCustomers(0);

    Optional<Customer> emptyOptionalCustomer = emptyCustomers.stream().findAny();
    Optional<Customer> optionalCustomer = customers.stream().findAny();

    customers.stream()
        .map(Customer::age)
        .min(Comparator.comparingInt(c -> c))
        .ifPresent(System.out::println);

    customers.stream()
        .map(Customer::age)
        .collect(Collectors.maxBy(Comparator.comparingInt(c -> c)))
        .ifPresent(System.out::println);
  }
}
