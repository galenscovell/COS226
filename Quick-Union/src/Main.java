
/**
 * Quick-Union Algorithm
 * [Lazy approach utilizing trees]
 *
 * connected(p, q): Check if p and q have the same root ID.
 * union(p, q): Merge components containing p and q, set ID of p's root 
 * to the ID of q's root.
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

        System.out.println("\n1 connected to 2: " + qu.connected(1, 2));
        System.out.println("\t(Root of 2 is " + qu.root(2) + ")");
        System.out.println("Connect 2 to 1.");
        qu.union(1, 2);
        System.out.println("1 connected to 2: " + qu.connected(1, 2));
        System.out.println("\t(Root of 2 is " + qu.root(2) + ")");
        System.out.println("\t\t[Size of 1 tree: " + qu.sizeOf(1) + "]");

        System.out.println("\n3 connected to 1: " + qu.connected(1, 3));
        System.out.println("\t(Root of 3 is " + qu.root(3) + ")");
        System.out.println("Connect 3 to 2.");
        qu.union(2, 3);
        System.out.println("3 connected to 1: " + qu.connected(1, 3));
        System.out.println("\t(Root of 3 is " + qu.root(3) + ")");
        System.out.println("\t\t[Size of 1 tree: " + qu.sizeOf(1) + "]");
    }
}