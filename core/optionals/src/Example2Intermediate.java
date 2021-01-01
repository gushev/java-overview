import java.util.Optional;

public class Example2Intermediate {
  public static void main(String[] args) {
    Optional<Integer> integerOptional = Optional.of(10);

    Integer resultOfMap = integerOptional.map(v -> v * 2).orElse(5);
    Integer resultOfFlatMap = integerOptional.flatMap(v -> Optional.of(v * 2)).orElse(5);
    integerOptional.ifPresentOrElse(
      System.out::println, () -> System.out.println("No value"));
  }
}
