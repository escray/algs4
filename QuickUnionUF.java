public class QuickUnionUF
{
	private int[] id;

	public QuickUnionUF(int N)
	{

		id = new int[N];
		// set id of each object to itself (N array access)
		for (int i = 0; i < N; i++)
		{
			id[i] = 1;
		}
	}

	private int root(int i)
	{
		// chase parent pointers until reach root
		while ( i != id[i] )
		{
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q)
	{
		// check if p and q have same root (depth of p and q array access) 
		return root(p) == root(q);
	}

	public void union(int p, int q)
	{
		// change root of p to point to root of q (depth of p and q array access)
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}