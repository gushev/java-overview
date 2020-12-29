package classes;

public class SimpleGenericsClass<T> {

  private final T field;

  public SimpleGenericsClass(T param) {
    field = param;
  }

  public T getField() {
    return field;
  }
}
