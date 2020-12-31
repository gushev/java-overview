import helpers.Customer;
import helpers.CustomerGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Example3Collectors {
  public static void main(String[] args) {

    List<Customer> customers = CustomerGenerator.getCustomers(20);

    Set<Customer> customerSet = customers.stream().collect(Collectors.toCollection(TreeSet::new));
    System.out.println("Tree set of customers:");
    System.out.println(customerSet);

    Map<String, Integer> customerMap =
        customerSet.stream()
            .collect(
                Collectors.toMap(c -> c.firstName() + c.lastName(), Customer::age, Integer::sum));

    System.out.println("Map of customer Full name -> Age :");
    System.out.println(customerMap);

    String concatenatedNames =
        customers.stream()
            .map(c -> c.firstName() + " " + c.lastName())
            .collect(Collectors.joining(", "));
    System.out.println("All names concatenated: " + concatenatedNames);

    var teeing =
        customers.stream()
            .map(c -> c.firstName() + " " + c.lastName())
            .collect(
                Collectors.teeing(
                    Collectors.counting(), Collectors.joining(", ", "'", "'"), List::of));

    System.out.println("Teeing example 1:");
    System.out.println(teeing);

    var teeing2 =
        customers.stream()
            .collect(
                Collectors.mapping(
                    c -> c.firstName() + " " + c.lastName(),
                    Collectors.teeing(
                        Collectors.counting(), Collectors.joining(", ", "'", "'"), List::of)));

    System.out.println("Teeing example 2:");
    System.out.println(teeing2);


    Map<Boolean, List<Customer>> oldYoung =
        customers.stream().collect(Collectors.partitioningBy(c -> c.age() > 44));

    System.out.println("Young and Old:");
    System.out.println(oldYoung);


    Map<Boolean, List<String>> oldYoungNames =
        customers.stream()
            .collect(
                Collectors.partitioningBy(
                    c -> c.age() > 44,
                    Collectors.mapping(
                        c -> c.firstName() + " " + c.lastName(), Collectors.toList())));

    System.out.println("Young and Old - names only:");
    System.out.println(oldYoungNames);


    Map<String, List<Customer>> groupedByFirstName =
      customers.stream()
        .collect(Collectors.groupingBy(c -> c.firstName()));

    System.out.println("Grouped by first name:");
    System.out.println(groupedByFirstName);

    Map<String, Long> countedNames =
      customers.stream()
        .collect(Collectors.groupingBy(c -> c.firstName(), Collectors.counting()));

    System.out.println("Number of a first name occurrence:");
    System.out.println(countedNames);

    Integer sumAges = customers.stream().collect(Collectors.summingInt(Customer::age)) ;
    System.out.println("Sum of age of all customers:" + sumAges);

    Double avgAge = customers.stream().collect(Collectors.averagingInt(Customer::age)) ;
    System.out.println("Average age between all customers:" + avgAge);

    IntSummaryStatistics summaryStatistics = customers.stream().mapToInt(Customer::age).summaryStatistics();
    System.out.println("Summary statistics:");
    System.out.println(summaryStatistics);

    Integer summaryInt = customers.stream().collect(Collectors.summingInt(Customer::age));
    System.out.println("Summarize int:");
    System.out.println(summaryInt);
  }
}
