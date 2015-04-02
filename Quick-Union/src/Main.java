
/**
 * Quick-Union Algorithm
 * [Lazy approach utilizing trees]
 *
 * connected(p, q): Check if sites p and q have the same root.
 * union(p, q): Merge components containing sites p and q, set p's root to q's root.
 *
 *
 * OPTIMIZATIONS:
 * 1. Trees can get tall, making connected() expensive. This can be 
 *    solved by utilizing weighting (link roots of smaller trees to 
 *    roots of larger trees).
 *    [Now depth of any node is at most lg(n)] (lg=base-2 logarithm)
 *
 * 2. Path compression: After computing root of p, set ID of each examined
 *    node to point to that root. This flattens the tree considerably.
 */


public class Main {

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);

        qu.printSites();
        qu.printParents();
        qu.printSizes();
        System.out.println("Components: " + qu.componentCount());

        System.out.println("\n\tConnect 1 and 0");
        qu.union(1, 0);
        System.out.println("\tConnect 5 and 0");
        qu.union(5, 0);
        System.out.println("\tConnect 2 and 1");
        qu.union(2, 1);
        System.out.println("\tConnect 7 and 1");
        qu.union(7, 1);
        System.out.println("\tConnect 6 and 5");
        qu.union(6, 5);

        System.out.println("\n\tConnect 8 and 3");
        qu.union(8, 3);
        System.out.println("\tConnect 4 and 3");
        qu.union(4, 3);

        qu.printSites();
        qu.printParents();
        qu.printSizes();
        System.out.println("Components: " + qu.componentCount());

        System.out.println("\n\tConnect 1 and 8");
        qu.union(1, 8);

        qu.printSites();
        qu.printParents();
        qu.printSizes();
        System.out.println("Components: " + qu.componentCount());
    }
}