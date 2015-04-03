
/**
 * Percolation project main entry
 */

import logic.PercolationTest;
import ui.MainFrame;

import javax.swing.SwingUtilities;


public class Main {
    public static double totalP = 0;

    public static double analyzeAlgorithm(int n) {
        long startTime = System.currentTimeMillis();

        PercolationTest pt = new PercolationTest(n);
        while (!pt.percolates()) {
            pt.open();
            pt.analyzeFlow();
        }
        // Add this percolation p* value to totalP
        totalP += pt.getRatio();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Test mode
        if (args.length > 0 && args[0].equals("test")) {
            int inputSize = Integer.parseInt(args[1]);
            double totalRunTime = 0;

            // Run simulation 10 times and average results
            for (int i = 0; i <= 9; i++) {
                double runtime = (analyzeAlgorithm(inputSize) / 1000);
                System.out.println("N: " + inputSize + ", T(N): " + runtime + "s");
                totalRunTime += runtime;
            }
            System.out.println("Average T(N): " + (totalRunTime / 10));
            System.out.println("Average P*: " + (totalP / 10));

        // Simulation mode
        } else {
            MainFrame mainFrame = new MainFrame(645, 700);
            SwingUtilities.invokeLater(mainFrame);
        }
    }
}