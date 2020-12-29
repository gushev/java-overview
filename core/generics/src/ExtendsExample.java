import classes.ExtendsGenericsClass;
import classes.ImplementsGenericsClass;

public class ExtendsExample {
  public static void main(String[] args) {
    ExtendsGenericsClass<Double, String> e1 = new ExtendsGenericsClass<>("This is my number as int:");
    e1.printAsInt(13.0);
    System.out.println(e1.getField());

    ImplementsGenericsClass<Integer> implementsGenericsClass = new ImplementsGenericsClass<>();

    System.out.println(implementsGenericsClass.supplier());
    implementsGenericsClass.consumer(10);
  }
}
