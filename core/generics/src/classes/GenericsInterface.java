package classes;

public interface GenericsInterface <I, S> {

  I supplier();

  void consumer(S param);
}
