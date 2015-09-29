import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings {
  private int count;

  public StackOfStrings() {
    count = 0;
  }

  void push(String item) {
    count++;
  }

  String pop() {
    count--;
    return "";
  }

  boolean isEmpty() {
    if (count == 0) {
      return true;
    }
    return false;
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