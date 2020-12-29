package classes;

public class ImplementsGenericsClass<T> implements GenericsInterface<String, T> {

  @Override
  public String supplier() {
    return "from supplier";
  }

  @Override
  public void consumer(T param) {
    System.out.println("Printing from consumer: " + param);
  }
}
