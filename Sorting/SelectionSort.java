
/**
 * Selection Sort algorithm.
 *
 * Beginning with i = 0, check all values to right of i and swap with i if larger until i = length.
 * This algorithm is quadratic time even if input is already sorted.
 */


public class SelectionSort {

    public static void sort(int[] contents) {
        int n = contents.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(contents[j], contents[min])) {
                    min = j;
                }
            }
            exchange(contents, i, min);
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