package classes;

import java.lang.reflect.InvocationTargetException;

public class MethodGenericsClass {

  public static <T> T getBean(String name, Class<T> tClass) {

    try {
      return tClass.getConstructor(int.class).newInstance(10);
    } catch (NoSuchMethodException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      e.printStackTrace();
    }

    return null;
  }
}
