package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@CustomAnnotation(value = "Custom Annotation", nestedAnnotation = @NestedAnnotation("Nested"))
public @interface TypeAnnotation {
  String value();
}
