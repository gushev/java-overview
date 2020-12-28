import annotations.*;

@TypeAnnotation("Type Annotation")
public class SomeClass {

  @FieldAnnotation("Field Annotation")
  private final int someInt = 8;

  @MethodAnnotation("Method Annotation")
  public void someMethod(@ParameterAnnotation("Param Annotation") int someParam) {

    @LocalVariableAnnotation("Local Var Annotation")
    String someString = "Hello there!";

    System.out.println("Calling the method");
  }
}
