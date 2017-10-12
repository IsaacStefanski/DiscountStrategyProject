package discountstrategyproject;

import java.util.Date;

/**
 *
 * @author Isaac
 */
public class Receipt {
    private static int receiptNum = 0;
    private Date orderDate;
    private Store store;
    private Customer customer;
    private LineItem[] lineItems;
    private ReceiptDataAccessStrategy db;
    private double total = 0.00;
    
    public Receipt(Store store, String customerID, ReceiptDataAccessStrategy db){
        setDatabase(db);
        incrementReceiptCount();
        orderDate = new Date();
        setStore(store);
        setCustomer(db.findCustomer(customerID));
        lineItems = new LineItem[0];
    }
    
    private final void incrementReceiptCount(){
        receiptNum++;
    }
    
    private final void addToLineItemsArray(final LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    public final void addItem(String prodID, double qty){
        addToLineItemsArray(new LineItem(db.findProduct(prodID), qty));
    }
    
    public final String buildReceipt(){
        String s = "";        
        s += "Order Number: " + getReceiptNum();
        s += "\n";
        s += "Customer: " + customer.getCustomerID() + " " + customer.getName();
        s += "\n";
        s += store.toString();
        s += "\n";
        for (LineItem l : lineItems){
            s += ("\n" + l.toString());
        }
        s += total;
        return s;
    }
    
    public final void calcTotal(){
        for (LineItem l : lineItems){
            total += (l.getItemSubtotal() - l.findDiscountAmt());
        }
    }

    public final static int getReceiptNum() {
        return receiptNum;
    }

    public final Date getOrderDate() {
        return orderDate;
    }

    public final void setOrderDate(Date orderDate) {
        if(orderDate != null){
            this.orderDate = orderDate;
        } else {
            throw new IllegalArgumentException("Order Date cannot be null");
        }
    }

    public final Store getStore() {
        return store;
    }

    public final void setStore(Store store) {
        if(store != null){
            this.store = store;
        } else {
            throw new IllegalArgumentException("Store cannot be null");
        }
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        if(customer != null){
            this.customer = customer;
        } else {
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        if(lineItems != null){
            this.lineItems = lineItems;
        } else {
            throw new IllegalArgumentException("LineItems[] cannot be null");
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
}