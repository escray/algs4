import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class StringSorter {
  public static void main(String[] args) {
    In in = new In(args[0]);
    String[] a = in.readAllStrings();
    Insertion.sort(a);
    for (int i = 0; i < a.length; i++)
      StdOut.println(a[i]);
  }
}