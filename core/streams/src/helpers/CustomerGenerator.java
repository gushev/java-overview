package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerGenerator {

  private static final String[] firstNames = {"John", "Samantha", "Roger", "Rebecca"};
  private static final String[] lastNames = {"Stevens", "Simpson", "Griffin", "Morgan"};
  private static final Random random = new Random();

  public static List<Customer> getCustomers(int number) {

    List<Customer> customers = new ArrayList<>();

    System.out.println("List of customers: ");

    for (int i = 0; i < number; i++) {
      Customer customer =
          new Customer(
              getRandomNameFromList(firstNames),
              getRandomNameFromList(lastNames),
              getRandomAge(18, 58));

      System.out.println(customer);
      customers.add(customer);
    }

    return customers;
  }

  private static String getRandomNameFromList(String[] list) {
    return list[random.nextInt(list.length)];
  }

  private static int getRandomAge(int from, int to) {
    return random.nextInt(to - from + 1) + from;
  }
}
