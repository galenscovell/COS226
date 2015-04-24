
/**
 * Non-recursive Mergesort implementation.
 *
 * This sorting algorithm utilizes divide and conquer for extreme efficiency, however it is not an in-place sort.
 * Uses at most N lg(n) compares and 6N lg(N) array accesses to sort any array of size N.
 * Uses extra space proportional to N as it needs to create an auxillary copy array.
 */

import java.util.Random;


public class BottomUpMergeSort {

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

    public static void sort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        for (int size = 1; size < n; size = size + size) {
            for (int lo = 0; lo < n - size; lo += size + size) {
                merge(a, aux, lo, lo + size - 1, Math.min(lo + size + size - 1, n - 1));
            }
        }
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

        sort(randomArray);

        System.out.print("\n[");
        for (int val : randomArray) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");
    }
}