
/**
 * Simulation JPanel for Percolation simulator
 */

package ui;

import logic.Grid;
import logic.Percolation;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class SimulationPanel extends JPanel implements Runnable {
    private Grid grid;
    private Percolation percolation;
    private Thread thread;

    final int framerate = 10;
    private boolean running = false;

    public SimulationPanel(int x, int y, int tileSize, int margin) {
        setPreferredSize(new Dimension(x, y));
        int columns = x / (tileSize + margin);
        int rows = y / (tileSize + margin);
        
        this.grid = new Grid(columns, rows, tileSize, margin);
        this.percolation = new Percolation((columns * rows) - 1);
    }

    @Override
    public void run() {
        long start, end, sleepTime;
        while (running) {
            start = System.currentTimeMillis();
            percolation.open(grid.getTiles());
            repaint();
            end = System.currentTimeMillis();
            // Sleep to match FPS limit
            sleepTime = (1000 / framerate) - (end - start);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime); 
                } catch (InterruptedException e) {
                    thread.interrupt();
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gfx = (Graphics2D) g;

        // Clear screen
        gfx.setColor(new Color(0x2c3e50));
        gfx.fillRect(0, 0, getWidth(), getHeight());
        // Render next frame
        grid.draw(gfx);
    }

    public synchronized void start() {
        this.thread = new Thread(this, "Simulation");
        this.running = true;
        thread.start(); // call run()
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            thread.interrupt();
        }
    }
}