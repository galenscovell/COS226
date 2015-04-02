
/**
 * Quick-Union Data Structure
 */


public class QuickUnion {
    private int[] parent;
    private int[] size;
    private int components;

    public QuickUnion(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.components = n;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        // Follow links until root is reached 
        // (when i is same as value at position parent[i])
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // Path compression optimization
            i = parent[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        // Sites are connected if they are within the same component
        // (they have matching roots)
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        // Check tree sizes of sites p and q
        // Change root of smaller tree to root of larger tree
        int rootP = find(p);
        int rootQ = find(q);
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        components--;
    }

    public int componentCount() {
        return components;
    }

    public void printSites() {
        System.out.print("\nSites        [");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");
    }

    public void printParents() {
        System.out.print("Site parents [");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.print("]\n");
    }

    public void printSizes() {
        System.out.print("Tree sizes   [");
        for (int i = 0; i < size.length; i++) {
            System.out.print(size[i] + " ");
        }
        System.out.print("]\n");
    }
}