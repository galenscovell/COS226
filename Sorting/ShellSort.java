
/**
 * Shell Sort algorithm.
 *
 * h-sort: insertion sort skipping backwards by more than 1
 * Worst-case number of compares is O(N^3/2), but analysis model remains largely unknown
 * Fast and hard to best in efficiency except for very large input size.
 */


public class ShellSort {

    public static void sort(int[] contents) {
        int n = contents.length;

        // Find largest h using 3x + 1 increment sequence
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // h-sort
            for (int i = h; i < n; i++) {
                // Insertion sort
                for (int j = i; j >= h && less(contents[j], contents[j - h]); j -= h) {
                    exchange(contents, j, j - h);
                }
            }
            // Move to next increment in sequence
            h /= 3;
        }
    }

    public static boolean less(int first, int second) {
        return first < second;
    }

    public static void exchange(int[] contents, int i, int j) {
        int swap = contents[i];
        contents[i] = contents[j];
        contents[j] = swap;
    }
}