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