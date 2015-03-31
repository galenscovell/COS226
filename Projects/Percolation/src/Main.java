
/**
 * Percolation project main entry
 */

import ui.MainFrame;

import javax.swing.SwingUtilities;


public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(805, 626);
        SwingUtilities.invokeLater(mainFrame);
    }
}