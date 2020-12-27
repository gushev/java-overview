import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Example2Generated {
  public static void main(String[] args) {

    Supplier<Integer> supplier = () -> new Random().nextInt();

    // Generate values in a Stream using a Supplier
    // Limit the number of results to 5
    System.out.println("Using Generator: ");
    Stream.generate(supplier).limit(5).forEach(System.out::println);

    System.out.println("Using Generator with take while: ");
    Stream.generate(supplier).takeWhile(i -> i < 0).forEach(System.out::println);

    // Illustrating how a stream can be used as a for loop
    System.out.println("Illustrating for loop: ");

    Stream.iterate(0, i -> i <= 30, i -> i + 3)
        .filter(i -> i % 2 == 0)
        .forEach(System.out::println);

    System.out.println("Using skip: ");
    Stream.iterate(0, i -> i + 1).limit(10).skip(8).forEach(System.out::println);

    System.out.println("Using skip with peek before: ");
    Stream.iterate(0, i -> i + 1)
        .peek(System.out::println)
        .limit(10)
        .skip(8)
        .forEach(System.out::println);

    System.out.println("Using Iterator  with drop while: ");
    Stream.of(10, 15, 60, 717).dropWhile(i -> i < 60).forEach(System.out::println);
  }
}
