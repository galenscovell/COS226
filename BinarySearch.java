
/**
 * Binary search algorithm
 *
 * Binary search uses at most 1 + lg(N) compares to search sorted array of size N.
 * By continually dividing N in half this algorithm remains logarithmic in terms of runtime.
 */

import java.util.Arrays;
import java.util.Random;


public class BinarySearch {

    public static boolean binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Random generator = new Random();
        int[] numArray = new int[20];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = generator.nextInt(100);
        }
        Arrays.sort(numArray);

        System.out.print("\n[");
        for (int val : numArray) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");
        
        int key = Integer.parseInt(args[0]);

        System.out.println("Searching for: " + key);
        System.out.println("Value is in array: " + binarySearch(numArray, key));
    }
}