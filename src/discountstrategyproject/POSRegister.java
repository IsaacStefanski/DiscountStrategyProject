package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class POSRegister {
    private Store store;
    private Receipt receipt;
    InMemoryDatabase db;
    
    public POSRegister(Store store) {
        setStore(store);
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
    
    public final Receipt startNewSale(String customerID){
        receipt = new Receipt(store, db.findCustomer(customerID));
        return receipt;
    }
    
    public final void addItemToSale(String prodId, double qty){
        LineItem li = new LineItem(db.findProduct(prodId), qty);
    }
    
    public final void endSale(){
        VideoDisplay display = new VideoDisplay();
        display.outputReceipt();
        
        ReceiptPrinter printer = new ReceiptPrinter();
        printer.outputReceipt();
    }
}