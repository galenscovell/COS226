
/**
 * Percolation Test class
 * Percolation process separated from graphics processing.
 * Used for algorithmic analysis separate from the simulation.
 */

package logic;


import java.util.Random;


public class PercolationTest {
    private UnionFind uf;
    private int n;
    private boolean[][] grid;
    private int openSites;

    public PercolationTest(int n) {
        this.n = n;
        this.uf = new UnionFind(n + (n * n));
        this.grid = new boolean[n][n];
        this.openSites = 0;

        // Initialize grid as all closed tiles
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                grid[x][y] = false;
            }
        }
        
        for (int x = 0; x < n - 1; x++) {
            // Connect all top tiles
            uf.union(tile(x, 0), tile(x + 1, 0));
            // Connect all bottom tiles
            uf.union(tile(x, n - 1), tile(x + 1, n - 1));
        }
    }

    public void open() {
        int randomX, randomY;
        Random random = new Random();
        boolean opening;

        // Open more sites equal (to N*N / 100)
        for (int i = 0; i < ((n*n) / 100); i++) {
            opening = true;
            while (opening) {
                randomX = random.nextInt(n);
                randomY = random.nextInt(n);
                if (!isOpen(randomX, randomY)) {
                    grid[randomX][randomY] = true;
                    opening = false;
                    openSites++;
                }
            }
        }
    }

    public boolean percolates() {
        // Check if first tile of top row is connected to final tile of bottom row
        return uf.connected(0, tile(n - 1, n - 1));
    }

    public void analyzeFlow() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (isOpen(x, y)) {
                    flow(x, y);
                }
            }
        }
    }

    public double getRatio() {
        return (double) openSites / (n*n);
    }

    private void flow(int x, int y) {
        int thisTile = tile(x, y);

        if (x - 1 >= 0 && isOpen(x - 1, y)) {
            int left = tile(x - 1, y);
            if (!uf.connected(thisTile, left)) {
                uf.union(thisTile, left);
            }
        }

        if (x + 1 < n && isOpen(x + 1, y)) {
            int right = tile(x + 1, y);
            if (!uf.connected(thisTile, right)) {
                uf.union(thisTile, right);
            }
        }
                
        if (y - 1 >= 0 && isOpen(x, y - 1)) {
            int top = tile(x, y - 1);
            if (!uf.connected(thisTile, top)) {
                uf.union(thisTile, top);
            }
        }

        if (y + 1 < n && isOpen(x, y + 1)) {
            int bottom = tile(x, y + 1);
            if (!uf.connected(thisTile, bottom)) {
                uf.union(thisTile, bottom);
            }
        }
    }

    private boolean isOpen(int x, int y) {
        return grid[x][y] == true;
    }

    private boolean isFull(int x, int y) {
        if (isOpen(x, y)) {
            // Check if tile is connected to first tile of top row
            if (uf.connected(tile(x, y), 0)) {
                return true;
            }
        }
        return false;
    }

    private int tile(int x, int y) {
        // Convert from [x, y] to unique integer
        return x + (y * n);
    }
}