package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class ReceiptPrinter implements ReceiptOutput{
    private Receipt receipt;
    
    public ReceiptPrinter(Receipt receipt){
        setReceipt(receipt);
    }
    
    @Override
    public void outputReceipt() {
        System.out.println(receipt.buildReceipt());
    }
    
    public final void setReceipt(Receipt receipt){
        if(receipt != null){
            this.receipt = receipt;
        } else {
            throw new IllegalArgumentException("Null receipt");
        }
    }
}