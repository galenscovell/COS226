
/**
 * Main entry for analyzing Selection, Insertion and Shell sorting algorithms.
 */

import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] contents = new int[40];

        for (int i = 0; i < 40; i++) {
            contents[i] = random.nextInt(100);
        }

        System.out.print("\n[");
        for (int val : contents) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");

        long start = System.nanoTime();
        ShellSort.sort(contents);
        long end = System.nanoTime();
        double runtime = (end - start);

        System.out.print("\n[");
        for (int val : contents) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");

        System.out.println("Sort took " + runtime + "ns.");
    }
}