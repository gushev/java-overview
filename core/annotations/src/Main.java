import annotations.MethodAnnotation;
import annotations.TypeAnnotation;

import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) {
    SomeClass someClass = new SomeClass();
    Class<?> cl = someClass.getClass();

    // Type Annotation
    TypeAnnotation typeAnnotation = cl.getAnnotation(TypeAnnotation.class);
    System.out.println("Value of type annotation: " + typeAnnotation.value());

    // Method Annotation
    try {
      Method m = cl.getMethod("someMethod", int.class);
      System.out.println("Value of method annotation: " + m.getAnnotation(MethodAnnotation.class).value());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}
