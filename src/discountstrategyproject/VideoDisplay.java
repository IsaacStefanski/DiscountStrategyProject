package discountstrategyproject;

import javax.swing.JOptionPane;
/**
 *
 * @author Isaac
 */
public class VideoDisplay implements ReceiptOutput {
    private Receipt receipt;
    
    public VideoDisplay(Receipt receipt){
        setReceipt(receipt);
    }
    
    //outputs a "preview" of the receipt to a JOptionPane
    @Override
    public final void outputReceipt() {
        JOptionPane.showMessageDialog(null, receipt.buildReceipt());
    }
    
    public final Receipt getReceipt(){
        return receipt;
    }
    
    public final void setReceipt(Receipt receipt){
        if(receipt != null){
            this.receipt = receipt;
        } else {
            throw new IllegalArgumentException("Null receipt");
        }
    }
}