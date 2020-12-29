package classes;

public class ExtendsGenericsClass <N extends  Number, S extends String> extends SimpleGenericsClass<S> {

  private final S message;

  public ExtendsGenericsClass(S message) {
    super(message);
    this.message = message;
  }

  public void printAsInt(N n) {
    System.out.println(message + " " + n.intValue());
  }
}
