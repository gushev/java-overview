import java.util.function.*;

public class Main {
  public static void main(String[] args) {

    // Consumer - consumes one value, returns nothing
    Consumer<Integer> consumer = c -> System.out.println(c.floatValue());
    consumer.accept(123);

    // BiConsumer - consumes two values, returns nothing
    BiConsumer<Integer, String> biConsumer = (i, s) -> System.out.println(s + i);
    biConsumer.accept(12, "The number is: ");

    // Supplier - accepts nothing, returns one value
    Supplier<Integer> supplier = () -> 10;
    System.out.println(supplier.get());

    // Function - accepts one parameter, returns one value
    Function<String, Integer> function = i -> i.length();
    System.out.println(function.apply("SixSix"));

    // BiFunction - accepts two parameter, returns one value
    BiFunction<String, String, Integer> biFunction = (i, u) -> i.length() + u.length();
    System.out.println(biFunction.apply("String One", "String Two"));

    // Predicate - accepts one parameter, returns boolean
    Predicate<Integer> predicate = i -> i > 10;
    System.out.println(predicate.test(10));

    // BiPredicate - accepts two parameters, returns boolean
    BiPredicate<Integer, Integer> biPredicate = (i, u) -> i > u;
    System.out.println(biPredicate.test(10, 5));

    // UnaryOperator - accepts one parameter, returns one value of the same type
    UnaryOperator<Integer> unaryOperator = i -> i + 1;
    System.out.println(unaryOperator.apply(10));

    // BinaryOperator - accepts two parameters of the same type, returns one value again from that type as well
    BinaryOperator<Integer> binaryOperator = (i, u) -> i + u;
    System.out.println(binaryOperator.apply(10, 5));

    // CustomFunction - copy of BiFunction
    CustomFunction<String, Integer, Integer> customFunction = (s, i) -> s.length() + i;
    System.out.println(customFunction.apply("Some string", 10));
  }
}
