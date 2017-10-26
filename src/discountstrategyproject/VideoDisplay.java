package discountstrategyproject;

import javax.swing.JOptionPane;
/**
 *
 * @author Isaac
 */
public class VideoDisplay implements ReceiptOutput {
    private Receipt receipt;
    
    public VideoDisplay(){
        //Default constructor
    }
    
    public VideoDisplay(Receipt receipt){
        setReceipt(receipt);
    }
    
    //outputs a "preview" of the receipt to a JOptionPane
    @Override
    public final void outputReceipt() {
        JOptionPane.showMessageDialog(null, receipt.buildReceipt());
    }
    
    public final void outputErrorMesage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "POS ERROR", 0);
    }
    
    public final Receipt getReceipt(){
        return receipt;
    }
    
    public final void setReceipt(Receipt receipt) throws IllegalArgumentException {
        if(receipt != null){
            this.receipt = receipt;
        } else {
            throw new IllegalArgumentException("Null receipt");
        }
    }
}