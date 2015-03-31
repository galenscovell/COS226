
/**
 * Percolation class
 * Checks for percolation via Quick-Union data structure
 */

package logic;

import java.util.List;
import java.util.Random;


public class Percolation {
    private int[] ids;
    private int[] sizes;

    public Percolation(int n) {
        this.ids = new int[n];
        this.sizes = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    public void open(List<Tile> tiles) {
        Random random = new Random();
        boolean opening = true;
        while (opening) {
            int value = random.nextInt(tiles.size());
            Tile tile = tiles.get(value);
            if (tile.state() == 0) {
                tile.open();
                opening = false;
            }
        }
    }

    public int root(int i) {
        // Chase parent until root is reached
        while (i != ids[i]) {
            ids[i] = ids[ids[i]]; // Path compression optimization
            i = ids[i];
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
        if (sizes[i] < sizes[j]) {
            ids[i] = j;
            sizes[j] += sizes[i];
        } else {
            ids[j] = i;
            sizes[i] += sizes[j];
        }
    }
}