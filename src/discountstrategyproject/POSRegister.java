package discountstrategyproject;

import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class POSRegister {
    private Store store;
    private Receipt receipt;
    private ReceiptDataAccessStrategy db;
    
    public POSRegister(Store store, ReceiptDataAccessStrategy db) {
        setStore(store);
        setDatabase(db);
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
    
    public final ReceiptDataAccessStrategy getDatabase(){
        return db;
    }
    
    public final void setDatabase(ReceiptDataAccessStrategy db){
        if(db != null){
            this.db = db;
        }
        else {
            throw new IllegalArgumentException("Database cannot be null");
        }
    }
    
    public final void startNewSale(String customerID){
        receipt = new Receipt(store, customerID, db);
    }
    
    public final void addItemToSale(String prodId, double qty){
        receipt.addItem(prodId, qty);
    }
    
    public final void endSale(){
        VideoDisplay display = new VideoDisplay(receipt);
        display.outputReceipt();
        
        ReceiptPrinter printer = new ReceiptPrinter(receipt);
        printer.outputReceipt();
    }
}