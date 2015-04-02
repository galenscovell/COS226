
/**
 * Sorting-based algorithm for solving the 3-Sum problem.
 * Utilizes binary search, only works with non-duplicate data set.
 *
 * Using array accesses as the cost model and tilde notation...
 *    Best case: ~1
 * Average case: ~lg(N)
 *   Worst case: ~lg(N)
 */

import java.util.Arrays;


public class SortBased {
    private int[] a;

    public SortBased(int[] a) {
        this.a = a;
    }

    public int solve() {
        int n = a.length;
        Arrays.sort(a);
        int results = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) {
                    results++;
                }
                
            }
        }
        return results;
    }
}


