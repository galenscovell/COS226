
/**
 * Quick-Find Algorithm
 * Eager approach utilizing only array ID's
 *
 * connected(p, q): Check if p and q have the same ID
 * union(p, q): Merge components containing p and q, 
 * change all entries whose ID equals ID[p] to ID[q]
 *
 * Very slow, takes n^2 (quadratic) time
 */


public class Main {

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);

        System.out.println("\nConnect [2] and [3].");
        qf.union(2, 3);
        System.out.println("[2] is connected to [3]: " + qf.connected(2, 3));

        System.out.println("[9] is connected to [2]: " + qf.connected(9, 2));

        System.out.println("\nConnect [9] and [3].");
        qf.union(9, 3);
        System.out.println("[9] is connected to [2]: " + qf.connected(9, 2));
    }
}