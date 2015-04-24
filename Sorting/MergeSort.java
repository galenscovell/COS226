
/**
 * Recursive Mergesort implementation.
 *
 * This sorting algorithm utilizes divide and conquer for extreme efficiency, however it is not an in-place sort.
 * Uses at most N lg(n) compares and 6N lg(N) array accesses to sort any array of size N.
 * Uses extra space proportional to N as it needs to create an auxillary copy array.
 *
 * Mergesort is an optimal algorithm in terms of #compares because its upper-bound and lower-bound are both ~N lg(N).
 */

import java.util.Random;


public class MergeSort {

    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // Copy
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Merge
        int i = lo; // Left side beginning index
        int j = mid + 1; // Right side beginning index
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(int[] a, int[] aux, int lo, int hi) {
        // Recursively repeat sort and merge
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void beginSort(int[] a) {
        // Create auxillary array
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static boolean less(int w, int v) {
        return w < v;
    }

    public static void exchange(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Random generator = new Random();
        int[] randomArray = new int[100];
        for (int i = 0; i < 100; i++) {
            randomArray[i] = generator.nextInt(100);
        }
        System.out.print("\n[");
        for (int val : randomArray) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");

        beginSort(randomArray);

        System.out.print("\n[");
        for (int val : randomArray) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");
    }
}