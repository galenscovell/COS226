
/**
 * Heapsort implementation
 *
 * 1. Build max-heap using bottom-up method.
 * 2. Repeatedly remove max key and sink new root.
 *
 * In-place algorithm with nlog(n) worst-case.
 * Optimal for both time and space... but inner loop is longer than quicksort's, not stable and makes poor use of cache memory.
 *
 * Best: nlog(n)
 * Average: 2n log(n)
 * Worst: 2n log(n)
 */


public class HeapSort {

    public static void sort(int[] pq) {
        // Build max-heap
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        // Repeatedly remove max and sink
        while (n > 1) {
            exchange(pq, 1, n);
            sink(pq, 1, --n);
        }
    }

    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exchange(k, j);
            k = j;
        }
    }

    private static boolean less(int[] pq, int v, int w) {
        return pq[v - 1] < pq[w - 1];
    }

    private static void exchange(int[] pq, int i, int j) {
        int copy = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = copy;
    }
}