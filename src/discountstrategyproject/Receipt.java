package discountstrategyproject;

import java.sql.Time;
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
    
    public Receipt(Store store, Customer customer){
        incrementReceiptCount();
        orderDate = new Date();
        setStore(store);
        setCustomer(customer);
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
    
    public final String printReceipt(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Order Number: " + getReceiptNum());
        sb.append("Customer: " + customer.getCustomerID());
        sb.append("");
        sb.append(store.toString());
        sb.append("");
        for (LineItem l : lineItems){
            sb.append("\n" + l);
        }
        
        return sb.toString();
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
}