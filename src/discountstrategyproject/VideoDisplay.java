package discountstrategyproject;

import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class VideoDisplay implements ReceiptOutput {
    private Receipt receipt;
    
    @Override
    public void outputReceipt() {
        JOptionPane.showConfirmDialog(null, receipt.printReceipt());
    }
}