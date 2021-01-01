import java.util.Optional;

public class Example1Basics {
  public static void main(String[] args) {
    Optional<Integer> emptyOptional = Optional.empty();
    Optional<Integer> integerOptional = optionalInteger(10);

    if (integerOptional.isPresent()) {
      Integer optionalResult = integerOptional.get();
    }

    Integer alternativeResult = integerOptional.orElse(-2);
    Integer alternativeWithSupplier = integerOptional.orElseGet(() -> -1);
    Integer alternativeWithException = integerOptional.orElseThrow(RuntimeException::new);
    Integer alternativeWithOr = integerOptional.or(() -> emptyOptional).orElse(-1);
    integerOptional.ifPresentOrElse(
        v -> System.out.println("Will execute if there is a values: " + v),
        () -> System.out.println("No value"));
  }

  static Optional<Integer> optionalInteger(Integer value) {
    return Optional.of(value);
  }
}
