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
    private double salesTaxPercent;
    
    public POSRegister(Store store, ReceiptDataAccessStrategy db, double salesTaxPercent) {
        setStore(store);
        setDatabase(db);
        setSalesTax(salesTaxPercent);
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
        receipt = new Receipt(store, customerID, db, salesTaxPercent);
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
    
    public final double getSalesTax(){
        return salesTaxPercent;
    }
    
    public final void setSalesTax(double salesTaxPercent){
        if(salesTaxPercent >= 0.00){
            this.salesTaxPercent = salesTaxPercent;
        }
        else {
            throw new IllegalArgumentException("Sales tac must be more than 0.00");
        }
    }
}