package helpers;

public record Customer(String firstName, String lastName, Integer age) implements Comparable<Customer> {

  @Override
  public int compareTo(Customer o) {
    return age - o.age();
  }

  public boolean isOlderThan30() {
    return age > 30;
  }

  public boolean isYoungerThan35() {
    return age < 35;
  }
}
