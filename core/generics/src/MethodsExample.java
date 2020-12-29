import classes.MethodGenericsClass;

public class MethodsExample {
  public static void main(String[] args) {
    Integer someInt = MethodGenericsClass.getBean("integerBean", Integer.class);

    System.out.println(someInt);
  }
}
