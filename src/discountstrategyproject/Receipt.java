package discountstrategyproject;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

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
    private double salesTaxPercent;
    
    public Receipt(Store store, String customerID, ReceiptDataAccessStrategy db, double salesTaxPercent){
        setDatabase(db);
        incrementReceiptCount();
        orderDate = new Date();
        setStore(store);
        setCustomer(db.findCustomer(customerID));
        lineItems = new LineItem[0];
        setSalesTax(salesTaxPercent);
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
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        String s = "";        
        s += "Order Number: " + getReceiptNum() + "  Date of Sale:" + orderDate;
        s += "\nCustomer: " + customer.getCustomerID() + " " + customer.getName();
        s += "\n\n";
        s += store.toString();
        s += "\n\n";
        s +=   "ID    NAME                 QTY  $EA     $SUB    $DISC";
        s += "\n--------------------------------------------------------------------";
        for (LineItem l : lineItems){
            s += ("\n" + l.toString());
        }
        s += "\n\n";
        s += "TOTAL BEFORE DISCOUNTS:  " + currencyFormatter.format(calcTotalBeforeDiscounts());
        s += "\nTOTAL AFTER DISCOUNTS:   " + currencyFormatter.format(calcTotalAfterDiscounts());
        s += "\nSALES TAX DUE:           " + currencyFormatter.format(calcSalesTaxAmt());
        s += "\nTOTAL AMOUNT DUE:        " + currencyFormatter.format(calcTotalDue());
        s += "\n\n";
        s += "YOU SAVED " + currencyFormatter.format(calcAmtSaved()) + " TODAY!";
        s += "\n\n";
        s += "Thank you for shopping at " + store.getName() + "!";
        return s;
    }
    
    public final double calcTotalBeforeDiscounts(){
        double orderTotalBD = 0.00;
        for (LineItem l : lineItems){
            orderTotalBD += (l.getItemSubtotal());
        }
        return orderTotalBD;
    }
    
    public final double calcTotalAfterDiscounts(){
        double orderTotalAD = 0.00;
        for (LineItem l : lineItems){
            orderTotalAD += (l.getItemSubtotal() - l.findDiscountAmt());
        }
        return orderTotalAD;
    }
    
    public final double calcSalesTaxAmt(){
        return calcTotalAfterDiscounts() * salesTaxPercent;
    }
    
    public final double calcTotalDue(){
        return calcTotalAfterDiscounts() + calcSalesTaxAmt();
    }
    
    public final double calcAmtSaved(){
        double amtSaved = 0.00;
        for (LineItem l : lineItems){
            amtSaved += l.findDiscountAmt();
        }
        return amtSaved;
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