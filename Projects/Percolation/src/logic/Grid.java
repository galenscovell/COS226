
/**
 * Grid class for Percolation project
 * Creates grid by placing tile objects
 */

package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.List;


public class Grid {
    private int columns;
    private int rows;
    private int tileSize;
    private int margin;
    private List<Tile> tiles;

    public Grid(int columns, int rows, int tileSize, int margin) {
        this.columns = columns;
        this.rows = rows;
        this.tileSize = tileSize;
        this.margin = margin;
        this.tiles = new ArrayList<Tile>();
        build();
    }

    private void build() {
        int value = 0;
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                Tile tile = new Tile(x, y, value);
                tiles.add(tile);
                value++;
            }
        }
    }

    public void draw(Graphics2D gfx) {
        int screenX, screenY;
        Color closed = new Color(0x2c3e50);
        Color open = new Color(0x34495e);
        Color filled = new Color(0x2980b9);

        for (Tile tile : tiles) {
            screenX = (tile.getX() * (tileSize + margin));
            screenY = (tile.getY() * (tileSize + margin));
            if (tile.state() == 0) {
                gfx.setColor(closed);
            } else if (tile.state() == 1) {
                gfx.setColor(open);
            } else {
                gfx.setColor(filled);
            }
            gfx.fillRect(screenX, screenY, tileSize, tileSize);
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}