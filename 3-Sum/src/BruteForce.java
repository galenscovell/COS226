
/**
 * Brute-force algorithm for solving the 3-Sum problem
 * Uses triple for loops to check every integer against each other
 *
 * Using array accesses as the cost model and tilde notation...
 *    Best case: ~1/2N^3
 * Average case: ~1/2N^3
 *   Worst case: ~1/2N^3
 */


public class BruteForce {
    private int[] a;

    public BruteForce(int[] a) {
        this.a = a;
    }

    public int solve() {
        int n = a.length;
        int results = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        results++;
                    }
                }
            }
        }
        return results;
    }
}