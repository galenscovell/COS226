
/**
 * Percolation Test class
 * Percolation process separated from graphics processing.
 * Used for algorithmic analysis separate from the simulation.
 */

package logic;


import java.util.Random;


public class PercolationTest {
    private QuickUnion qu;
    private int n;
    private boolean[][] grid;

    public PercolationTest(int n) {
        this.n = n;
        this.qu = new QuickUnion(n + (n * n));
        this.grid = new boolean[n][n];

        // Initialize grid as all closed tiles
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                grid[x][y] = false;
            }
        }
        
        for (int x = 0; x < n - 1; x++) {
            // Connect all top tiles
            qu.union(tile(x, 0), tile(x + 1, 0));
            // Connect all bottom tiles
            qu.union(tile(x, n - 1), tile(x + 1, n - 1));
        }
    }

    public void open() {
        int randomX, randomY;
        Random random = new Random();
        boolean opening = true;

        while (opening) {
            randomX = random.nextInt(n);
            randomY = random.nextInt(n);
            if (!isOpen(randomX, randomY)) {
                grid[randomX][randomY] = true;
                opening = false;
            }
        }
    }

    public boolean percolates() {
        // Check if first tile of top row is connected to final tile of bottom row
        return qu.connected(0, tile(n - 1, n - 1));
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

    private void flow(int x, int y) {
        int thisTile = tile(x, y);

        if (x - 1 >= 0) {
            int left = tile(x - 1, y);
            if (!qu.connected(thisTile, left) && isOpen(x - 1, y)) {
                qu.union(thisTile, left);
            }
        }
        if (x + 1 < n) {
            int right = tile(x + 1, y);
            if (!qu.connected(thisTile, right) && isOpen(x + 1, y)) {
                qu.union(thisTile, right);
            }
        }
        if (y - 1 >= 0) {
            int top = tile(x, y - 1);
            if (!qu.connected(thisTile, top) && isOpen(x, y - 1)) {
                qu.union(thisTile, top);
            }
        }
        if (y + 1 < n) {
            int bottom = tile(x, y + 1);
            if (!qu.connected(thisTile, bottom) && isOpen(x, y + 1)) {
                qu.union(thisTile, bottom);
            }
        }
    }

    private boolean isOpen(int x, int y) {
        return grid[x][y] == true;
    }

    private boolean isFull(int x, int y) {
        if (isOpen(x, y)) {
            // Check if tile is connected to first tile of top row
            if (qu.connected(tile(x, y), 0)) {
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