
/**
 * Percolation project main entry
 */

import logic.PercolationTest;
import ui.MainFrame;

import javax.swing.SwingUtilities;


public class Main {

    public static double analyzeAlgorithm(int n) {
        long startTime = System.currentTimeMillis();

        PercolationTest pt = new PercolationTest(n);
        while (!pt.percolates()) {
            pt.open();
            pt.analyzeFlow();
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        if (args[0].equals("test")) {
            int inputSize = Integer.parseInt(args[1]);
            double totalRunTime = 0;
            int runs = 0;
            for (int i = 0; i <= 9; i++) {
                double runtime = (analyzeAlgorithm(inputSize) / 1000);
                System.out.println("N: " + inputSize + ", T(N): " + runtime + "s");
                totalRunTime += runtime;
                runs++;
            }
            System.out.println("Average T(N): " + (totalRunTime / runs));
        } else {
            MainFrame mainFrame = new MainFrame(606, 660);
            SwingUtilities.invokeLater(mainFrame);
        }
    }
}