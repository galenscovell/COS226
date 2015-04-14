
/**
 * Insertion Sort algorithm.
 *
 * In iteration i, swap a[i] with each larger entry to its left.
 * Uses ~1/4 N^2 exchanges on average; partially-sorted data runs in linear time, descending input worst-case
 */


public class InsertionSort {

    public static void sort(int[] contents) {
        int n = contents.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(contents[j], contents[j - 1]); j--) {
                exchange(contents, j, j - 1);
            }
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