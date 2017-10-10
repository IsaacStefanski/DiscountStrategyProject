package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class POSRegister {
    private Store store;
    private Receipt receipt;
    
    public POSRegister(Store store) {
        this.store = store;
    }
    
    public final Store getStore() {
        return store;
    }

    public final void setStore(Store store) {
        if(store != null){
            this.store = store;
        }
        else {
            throw new IllegalArgumentException("Store cannot be null");
        }
    }
    
    public final Receipt startNewSale(Customer customer){
        Receipt receipt = new Receipt(store, customer);
        return receipt;
    }
    
    public final void addItemToSale(String prodId, String prodName, double qty){
        
    }
    
    public final void endSale(){
        VideoDisplay display = new VideoDisplay();
        display.outputReceipt();
        
        ReceiptPrinter printer = new ReceiptPrinter();
        printer.outputReceipt();
    }
}