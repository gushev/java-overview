import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
  public static void main(String[] args) {

    List<String> arrayList = new ArrayList<>();
    arrayList.add("Some Item");
    arrayList.add("Another Item");

    System.out.println("Array List items:");
    System.out.println(arrayList);

    arrayList.remove(0);

    LinkedList<String> linkedList = new LinkedList<>();

    linkedList.addFirst("Some Item");
    linkedList.addLast("Another Item");

    System.out.println("Linked List items:");
    System.out.println(linkedList);

    linkedList.removeLast();
  }
}
