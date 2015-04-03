
/**
 * Simulation JPanel for Percolation simulator
 */

package ui;

import logic.Percolation;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements Runnable {
    private Percolation percolation;
    private Thread thread;
    private JLabel statsLabel;
    private JLabel timeLabel;

    final int framerate = 120;
    private boolean running = false;
    private double runTimeStart;
    private int tileSize;
    private int margin;

    public SimulationPanel(int x, int y, int tileSize, int margin) {
        setPreferredSize(new Dimension(x, y));
        this.tileSize = tileSize;
        this.margin = margin;
        this.percolation = new Percolation(40);

        setLayout(new BorderLayout());
        Font customFont = new Font("Source Code Pro", Font.PLAIN, 12);

        JPanel detailPanel = new JPanel();
        detailPanel.setPreferredSize(new Dimension(x, 30));
        detailPanel.setLayout(new BorderLayout());

        this.statsLabel = new JLabel("", JLabel.CENTER);
        statsLabel.setPreferredSize(new Dimension(x - 150, 30));
        statsLabel.setBackground(Color.WHITE);
        statsLabel.setFont(customFont);
        statsLabel.setOpaque(true);
        detailPanel.add(statsLabel, BorderLayout.LINE_START);

        this.timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setPreferredSize(new Dimension(x - 450, 30));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(customFont);
        timeLabel.setOpaque(true);
        detailPanel.add(timeLabel, BorderLayout.LINE_END);

        add(detailPanel, BorderLayout.PAGE_END);
    }

    private void updateLabels() {
        int totalSites = percolation.getTotalSites();
        int openSites = percolation.getOpenSites();
        double ratio = percolation.getRatio();
        this.statsLabel.setText("Total sites: " + totalSites + " | Open sites: " + openSites + " | Ratio: " + ratio);

        double runTime = (System.currentTimeMillis() - runTimeStart) / 1000;
        this.timeLabel.setText("Runtime: " + runTime + "s");
    }

    public void run() {
        long start, end, sleepTime;
        this.runTimeStart = System.currentTimeMillis();

        while (running) {
            start = System.currentTimeMillis();

            percolation.open();
            percolation.analyzeFlow();
            repaint();
            if (percolation.percolates()) {
                updateLabels();
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