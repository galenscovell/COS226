
/**
 * Simulation JPanel for Percolation simulator
 */

package ui;

import logic.Percolation;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class SimulationPanel extends JPanel implements Runnable {
    private Percolation percolation;
    private Thread thread;

    final int framerate = 60;
    private boolean running = false;
    private int tileSize;
    private int margin;

    public SimulationPanel(int x, int y, int tileSize, int margin) {
        setPreferredSize(new Dimension(x, y));
        this.tileSize = tileSize;
        this.margin = margin;
        this.percolation = new Percolation(40);
    }

    @Override
    public void run() {
        long start, end, sleepTime;
        while (running) {
            start = System.currentTimeMillis();
            percolation.open();
            percolation.analyzeFlow();
            repaint();
            if (percolation.percolates()) {
                stop();
            }
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
        percolation.draw(gfx, tileSize, margin);
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