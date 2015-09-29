import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {
  private Node first = null;

  private class Node {
    String item;
    Node next;
  }

  private int count;

  public LinkedStackOfStrings() {
    count = 0;
  }

  void push(String item) {
    count++;
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }

  String pop() {
    count--;
    String item = first.item;
    first = first.next;
    return item;
  }

  boolean isEmpty() {
    return first == null;
  }

  int size() {
    return count;
  }

  public static void main(String[] args) {
    StackOfStrings stack = new StackOfStrings();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(stack.pop());
      else               stack.push(s);
    }
  }
}