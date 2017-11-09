package discountstrategyproject;

import edu.wctc.advjava.ics.dateutilities.DateUtilities;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author Isaac
 */
public class Receipt {
    private static int receiptNum = 0;
    private Date orderDate;
    private DateUtilities util;
    private Store store;
    private Employee employee;
    private Customer customer;
    private LineItem[] lineItems;
    private ReceiptDataAccessStrategy db;
    private double salesTaxPercent;
    
    public Receipt(Store store, Employee employee, String customerID, ReceiptDataAccessStrategy db, double salesTaxPercent){
        setDatabase(db);
        incrementReceiptCount();
        orderDate = new Date();
        setStore(store);
        setEmployee(employee);
        setCustomer(db.findCustomer(customerID));
        lineItems = new LineItem[0];
        setSalesTax(salesTaxPercent);
    }
    
    private final void incrementReceiptCount(){
        receiptNum++;
    }
    
    //increases the size of the lineItems array to add lineItems
    private final void addToLineItemsArray(final LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    //creates a lineItem to add to the lineItems array from a product and its qty in the transaction
    public final void addItem(String prodID, double qty){
        addToLineItemsArray(new LineItem(db.findProduct(prodID), qty));
    }
    
    //returns top portion of receipt
    public final String buildReceiptHeader(){
        String s = "";
        s += "Receipt Number: " + getReceiptNum() + "   Date of Sale: " + orderDate;
        s += "\nYour cashier today is " + employee.getName();
        s += "\nCustomer: " + customer.getCustomerID() + " " + customer.getName();
        s += "\n--------------------------------------------------------------------";
        s += "\n" + store.toString();
        return s;
    }
    
    //returns body of receipt
    public final String buildReceiptBody(){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        String s = "";
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
    
    //returns the receipt as a String
    public final String buildReceipt(){
        return buildReceiptHeader() + buildReceiptBody();
    }
    
    //returns pre-tax total before discounts
    public final double calcTotalBeforeDiscounts(){
        double orderTotalBD = 0.00;
        for (LineItem l : lineItems){
            orderTotalBD += (l.getItemSubtotal());
        }
        return orderTotalBD;
    }
    
    //returns pre-tax total after discounts are applied
    public final double calcTotalAfterDiscounts(){
        double orderTotalAD = 0.00;
        for (LineItem l : lineItems){
            orderTotalAD += (l.getItemSubtotal() - l.findDiscountAmt());
        }
        return orderTotalAD;
    }
    
    //returns sales tax
    public final double calcSalesTaxAmt(){
        return calcTotalAfterDiscounts() * salesTaxPercent;
    }
    
    //returns the final amount to be paid by the customer
    public final double calcTotalDue(){
        return calcTotalAfterDiscounts() + calcSalesTaxAmt();
    }
    
    //returns the amount saved (total of all applied discounts)
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

    public final void setOrderDate(Date orderDate) throws IllegalArgumentException {
        if(orderDate != null){
            this.orderDate = orderDate;
        } else {
            throw new IllegalArgumentException("Order Date cannot be null");
        }
    }

    public final Store getStore() {
        return store;
    }

    public final void setStore(Store store) throws IllegalArgumentException {
        if(store != null){
            this.store = store;
        } else {
            throw new IllegalArgumentException("Store cannot be null");
        }
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) throws IllegalArgumentException {
        if(customer != null){
            this.customer = customer;
        } else {
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) throws IllegalArgumentException {
        if(lineItems != null){
            this.lineItems = lineItems;
        } else {
            throw new IllegalArgumentException("LineItems[] cannot be null");
        }
    } 
    
    public final ReceiptDataAccessStrategy getDatabase(){
        return db;
    }
    
    public final void setDatabase(ReceiptDataAccessStrategy db) throws IllegalArgumentException {
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
    
    public final void setSalesTax(double salesTaxPercent) throws IllegalArgumentException {
        if(salesTaxPercent >= 0.00){
            this.salesTaxPercent = salesTaxPercent;
        }
        else {
            throw new IllegalArgumentException("Sales tac must be more than 0.00");
        }
    }
    
    public final Employee getEmployee(){
        return employee;
    }
    
    public final void setEmployee(Employee employee) throws IllegalArgumentException {
        if(employee != null){
            this.employee = employee;
        }
        else {
            throw new IllegalArgumentException("Employee must not be null");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.orderDate);
        hash = 79 * hash + Objects.hashCode(this.util);
        hash = 79 * hash + Objects.hashCode(this.store);
        hash = 79 * hash + Objects.hashCode(this.employee);
        hash = 79 * hash + Objects.hashCode(this.customer);
        hash = 79 * hash + Arrays.deepHashCode(this.lineItems);
        hash = 79 * hash + Objects.hashCode(this.db);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.salesTaxPercent) ^ (Double.doubleToLongBits(this.salesTaxPercent) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Receipt other = (Receipt) obj;
        if (Double.doubleToLongBits(this.salesTaxPercent) != Double.doubleToLongBits(other.salesTaxPercent)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.util, other.util)) {
            return false;
        }
        if (!Objects.equals(this.store, other.store)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Arrays.deepEquals(this.lineItems, other.lineItems)) {
            return false;
        }
        if (!Objects.equals(this.db, other.db)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Receipt{" + "orderDate=" + orderDate + ", util=" + util + ", store=" + store + ", employee=" + employee + ", customer=" + customer + ", lineItems=" + lineItems + ", db=" + db + ", salesTaxPercent=" + salesTaxPercent + '}';
    }
}