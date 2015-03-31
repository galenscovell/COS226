
/**
 * Tile class for Percolation project
 * Keeps track of state and position in grid.
 * Can be closed(0), open(1) or filled(2)
 */

package logic;


public class Tile {
    private int x;
    private int y;
    private int state;
    private int id;

    public Tile(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.state = 0;
        this.id = id;
    }

    public int getValue() {
        return id;
    }

    public int state() {
        return state;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void open() {
        state = 1;
    }

    public void close() {
        state = 0;
    }
}