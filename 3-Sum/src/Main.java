
/**
 * 3-Sum problem:
 * Given N distinct integers, how many triples sum to exactly zero?
 *
 * This problem is deeply related to issues in computational geometry.
 */


public class Main {
    public static void main(String[] args) {
        int[] numArray = new int[args.length];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(args[i]);
        }

        System.out.print("\n[");
        for (int val : numArray) {
            System.out.print(val + " ");
        }
        System.out.print("]\n");

        BruteForce bfa = new BruteForce(numArray);
        SortBased sba = new SortBased(numArray);

        long startTime = System.currentTimeMillis();
        System.out.println("\nSolutions using brute-force: " + bfa.solve());
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println("Solutions using sort-based: " + sba.solve());
        endTime = System.currentTimeMillis();
        System.out.println("Runtime: " + (endTime - startTime) + "ms");
    }
}