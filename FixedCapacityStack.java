import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class FixedCapacityStack<Item>
{
  private Item[] a;
  private int N = 0;

  public FixedCapacityStack(int cap)
  {
    // the way it should be
    // s = new Item[cap];
    // generic array creation not allow in java
    // the ugly cast
    a = (Item[]) new Object[cap];
  }

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size()
  {
    return N;
  }

  public void push(Item item)
  {
    if (N == a.length)
    {
      resize(2*a.length);
    }
    a[N++] = item;
  }

  public Item pop()
  {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length/4)
    {
      resize(a.length/2);
    }
    return item;
  }

  private void resize(int max)
  {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++)
    {
      temp[i] = a[i];
    }
    a = temp;
  }

  public static void main(String[] args)
  {
    FixedCapacityStack<String> s;
    s = new FixedCapacityStack<String>(100);
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

  private class ReverseArrayIterator implements Iterator<Item>
  {
    private int i = N;

    public boolean hasNext()
    {
      return i > 0;
    }

    public Item next()
    {
      return a[--i];
    }

    public void remove()
    {
      
    }
  }
}