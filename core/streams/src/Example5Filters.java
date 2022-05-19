import helpers.Customer;
import helpers.CustomerGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Example5Filters {
  public static void main(String[] args) {
    List<Customer> customers = CustomerGenerator.getCustomers(50);

    List<Customer> filteredList = customers.stream()
        .filter(Customer::isOlderThan30)
        .filter(Customer::isYoungerThan35)
        .collect(Collectors.toList());

    System.out.println(filteredList);
  }
}
