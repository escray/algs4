// brute-force ThreeSum
import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeSum
{
	public static int count(int[] a)
	{
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = i+1; j < N; j++)
			{
				for (int k = j+1; k < N; k++)
				{
					if (a[i] + a[j] + a[k] == 0)
					{
						count++;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		//In in = new In(args[0]);
		//int[] a = in.readAllInts();
		int N = Integer.parseInt(args[0]);
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
		{
			a[i] = StdRandom.uniform(-1000000, 1000000);
		}
		Stopwatch stopwatch = new Stopwatch();
		int cnt = ThreeSum.count(a);
		//StdOut.println(count(a));
		double time = stopwatch.elapsedTime();

		StdOut.println(cnt + "triples " + time);
	}
}