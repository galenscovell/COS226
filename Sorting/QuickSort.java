
/**
 * Quicksort implementation.
 * 1. Shuffle array
 * 2. Partition so that for some j: entry a[j] is in place, no larger entry to left of j, no smaller to right
 * 3. Recursively sort each piece
 *
 * In-place sort, uses less space than Mergesort. Slightly more compares than Mergesort, but less data movement.
 * Best case: Everything is divided exactly in half. #compares is ~N log(N)
 * Average case: #compares is ~1.39Nlg(N)
 * Worst case: Random shuffle places items in order. #compares is ~1/2N^2 (extremely unlikely)
 */

import java.util.Collections;


public class QuickSort {

    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            // Find item on left to swap
            // Increment i so long as it is less than lo
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            // Find item on right to swap
            // Decrement j so long as it is greater than lo
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }
            // Check if pointers cross
            if (i >= j) break;
            exchange(a, i, j);
        }
        // Swap with partitioning item
        exchange(a, lo, j);
        // Return index of item now known to be in place
        return j;
    }

    public static void shuffle(int[] a) {
        Collections.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static boolean less(int w, int v) {
        return w < v;
    }

    public static void exchange(int[] a, int i, int j) {
        int copy = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }

    public static void main(String[] args) {

    }
}