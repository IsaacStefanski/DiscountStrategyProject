package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class ReceiptPrinter implements ReceiptOutput{
    private Receipt receipt;
    
    @Override
    public void outputReceipt() {
        receipt.printReceipt();
    }
}