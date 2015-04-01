
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
        QuickUnion qu = new QuickUnion(6);

        qu.printNodes();
        qu.printSizes();
        qu.union(0, 1);
        qu.printNodes();
        qu.printSizes();
        qu.union(0, 2);
        qu.printNodes();
        qu.printSizes();
        qu.union(0, 4);
        qu.printNodes();
        qu.printSizes();
        qu.connected(1, 4);
    }
}