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
    
    //outputs receipt to console to simulate a printed receipt
    @Override
    public final void outputReceipt() {
        System.out.println(receipt.buildReceipt());
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