package helpers;

public record Customer(String firstName, String lastName, Integer age) implements Comparable<Customer> {

  @Override
  public int compareTo(Customer o) {
    return age - o.age();
  }
}
