
/**
 * Main JFrame for Percolation simulator
 */

package ui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;


public class MainFrame implements Runnable {
    private int width;
    private int height;
    private JFrame frame;

    public MainFrame(int x, int y) {
        this.width = x;
        this.height = y;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Percolation");
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents(frame);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        SimulationPanel simPanel = new SimulationPanel(width, height, 13, 2);
        container.add(simPanel);
        simPanel.start();
    }
}