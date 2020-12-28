package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
public @interface CustomAnnotation {
  NestedAnnotation nestedAnnotation();
  String value();
}
