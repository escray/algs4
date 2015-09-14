import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
	private double[] tries;
	private int T;

	public PercolationStats(int N, int T) {
		if (N <= 0) {
			throw new IllegalArgumentException("N is lower or equal than 0");
		}	
		if (T <= 0) {
			throw new IllegalArgumentException("T is lower or equal than 0");
		}

		this.T = T;

		tries = new double[T];
		for (int i = 0; i < T; i++) {
			Percolation percolation = new Percolation(N);
			double threshold = 0;
			while (!percolation.percolates()) {
				int row = StdRandom.uniform(N) + 1;
				int column = StdRandom.uniform(N) + 1;

				if (!percolation.isOpen(row, column)) {
					threshold++;
					percolation.open(row, column);
				}
				tries[i] = threshold / (N*N);
			}
		}
	}

	public double mean() {
		return StdStats.mean(tries);
	}

	public double stddev() {
		return StdStats.stddev(tries);
	}

	public double confidenceLo() {
		return mean() - 1.96 * stddev() / Math.sqrt(T);
	}

	public double confidenceHi() {
		return mean() + 1.96 * stddev() / Math.sqrt(T);
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			return;
		}

		try {
			int N = Integer.parseInt(args[0]);
			int T = Integer.parseInt(args[1]);

			PercolationStats percolationStats = new PercolationStats(N, T);
			StdOut.println("mean                    = "
					 + percolationStats.mean());
			StdOut.println("stddev                  = "
					 + percolationStats.stddev());
			StdOut.println("%95 confidence interval = "
					 + percolationStats.confidenceLo() + ", "
					 + percolationStats.confidenceHi());
		} catch (NumberFormatException e) {
			StdOut.println("Argument must be an integer");
			return;
		}

	}
}