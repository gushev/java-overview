import classes.SimpleGenericsClass;

public class Basics {
  public static void main(String[] args) {
    SimpleGenericsClass<Integer> t1; // locked to Integer
    SimpleGenericsClass<?> t2; // any object
    SimpleGenericsClass<? extends Number> t3; // any class inheriting Number
    SimpleGenericsClass<? super Number> t4; // any super class to Number

    t1 = new SimpleGenericsClass<>(10);
    System.out.println(t1.getField());

    t2 = new SimpleGenericsClass<>("Test");
    System.out.println(t2.getField());

    t3 = new SimpleGenericsClass<>(10.0);
    System.out.println(t3.getField());

    t4 = new SimpleGenericsClass<>(new Object());
    System.out.println(t4.getField());
  }
}
