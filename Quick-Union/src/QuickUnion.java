
/**
 * Quick-Union Data Structure
 */


public class QuickUnion {
    private int[] node;
    private int[] size;

    public QuickUnion(int n) {
        this.node = new int[n];
        this.size = new int[n];
        // Set value of each node to its beginning index
        for (int i = 0; i < n; i++) {
            node[i] = i;
            size[i] = 1;
        }
    }

    public int root(int i) {
        while (i != node[i]) {
            node[i] = node[node[i]]; // Path compression optimization
            i = node[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        // Change root of smaller tree to root of larger tree
        int i = root(p);
        int j = root(q);
        if (size[i] < size[j]) {
            node[i] = j;
            size[j] += size[i];
        } else {
            node[j] = i;
            size[i] += size[j];
        }
    }

    public void printNodes() {
        System.out.print("\nNode roots [");
        for (int i = 0; i < node.length - 1; i++) {
            System.out.print(node[i] + ", ");
        }
        System.out.print(node[node.length - 1] + "]\n");
    }

    public void printSizes() {
        System.out.print("Tree sizes [");
        for (int i = 0; i < size.length - 1; i++) {
            System.out.print(size[i] + ", ");
        }
        System.out.print(size[size.length - 1] + "]\n");
    }
}