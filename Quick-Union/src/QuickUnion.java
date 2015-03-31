
/**
 * Quick-Union Data Structure
 */


public class QuickUnion {
    private int[] id;
    private int[] size;

    public QuickUnion(int n) {
        this.id = new int[n];
        this.size = new int[n];
        // Set ID of each object to itself
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int i) {
        // Chase parent until root is reached
        while (i != id[i]) {
            id[i] = id[id[i]]; // Path compression optimization
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        // Change root of p to point to root of q
        int i = root(p);
        int j = root(q);
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    public int sizeOf(int n) {
        return size[n];
    }
}