
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionUF {
	
	private int[] parent;
	private int[] size;
	private int count;

	public WeightedQuickUnionUF(int N) {
		count = N;
		parent = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
			size[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		validate(p);
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	private void validate(int p) {
		int N = parent.length;
		if (p < 0 || p >= N) {
			throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));
		}
	}

	private boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void  union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ ) {
			return;
		}

		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}

		count--;
	}
	

	public static void main(String[] args) {
		
		
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
		
		String result = "";
		String size = "";
		for(int i = 0; i < N; i++)
		{
			result += uf.parent[i] + " ";
			size += uf.size[i] + " ";
		}

		StdOut.println(result);
		StdOut.println(size);

	}
	
}