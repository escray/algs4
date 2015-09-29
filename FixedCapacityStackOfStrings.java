import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings
{
  private String[] a;
  private int N = 0;

  public FixedCapacityStackOfStrings(int cap)
  {
    a  = new String[cap];
  }

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size() 
  {
    return N;
  }

  public void push(String item)
  {
    // use to index into array;
    // then increment N
    a[N++] = item;
  }

  public String pop()
  {
    // decrement N;
    // then use to index into array
    String item =  a[--N];
    // avoid loitering
    // garbage collector can relaim memory
    // only if no outstanding references
    s[N] = null;
    return item;
  }

  public static void main(String[] args)
  {
    FixedCapacityStackOfStrings s;
    s = new FixedCapacityStackOfStrings(100);
    while (!StdIn.isEmpty())
    {
      String item = StdIn.readString();
      if (!item.equals("-"))
      {
        s.push(item);
      }
      else if (!s.isEmpty())
      {
        StdOut.print(s.pop() + " ");
      }
    }
    StdOut.println("(" + s.size() + " left on stack)");
  }
}