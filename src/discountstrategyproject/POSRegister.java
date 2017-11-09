package discountstrategyproject;

import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class POSRegister {
    private Store store;
    private Receipt receipt;
    private ReceiptDataAccessStrategy db;
    private double salesTaxPercent;
    private Employee employee;
    private VideoDisplay display;
    
    public POSRegister(Store store, ReceiptDataAccessStrategy db, double salesTaxPercent) {
        setStore(store);
        setDatabase(db);
        setSalesTax(salesTaxPercent);
        employee = loginEmployee();
        display = new VideoDisplay();
    }
    
    //runs when a POSRegister is created, before transactions can begin; uses employee id to find the employee in the database
    public final Employee loginEmployee(){
        String userID = JOptionPane.showInputDialog("Enter Employee ID to use register: ");
        Employee employee = db.findEmployee(userID);
        JOptionPane.showMessageDialog(null, employee.getName() + " Logged In Successfully");
        return employee;
    }
    
    public final Store getStore() {
        return store;
    }

    public final void setStore(Store store)throws IllegalArgumentException {
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
    
    public final void setDatabase(ReceiptDataAccessStrategy db)throws IllegalArgumentException {
        if(db != null){
            this.db = db;
        }
        else {
            throw new IllegalArgumentException("Database cannot be null");
        }
    }
    
    //starting a new sale creates a new ("blank") receipt for each transaction
    public final void startNewSale(String customerID){
        receipt = new Receipt(store, employee, customerID, db, salesTaxPercent);
    }
    
    //adds item to the transaction through product id and qty
    public final void addItemToSale(String prodId, double qty){
        receipt.addItem(prodId, qty);
    }
    
    //outputs receipt to a VideoDisplay for customer approval, then prints receipt to concole
    public final void endSale(){
        VideoDisplay display = new VideoDisplay(receipt);
        display.outputReceipt();
        
        ReceiptPrinter printer = new ReceiptPrinter(receipt);
        printer.outputReceipt();
    }
    
    public final double getSalesTax(){
        return salesTaxPercent;
    }
    
    public final void setSalesTax(double salesTaxPercent) throws IllegalArgumentException {
        if(salesTaxPercent >= 0.00){
            this.salesTaxPercent = salesTaxPercent;
        }
        else {
            throw new IllegalArgumentException("Sales tax must be more than 0.00");
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
    
    public final VideoDisplay getDisplay(){
        return display;
    }
    
    public final void setDisplay(VideoDisplay display) throws IllegalArgumentException {
        if(display != null){
            this.display = display;
        }
        else {
            throw new IllegalArgumentException("Display must not be null");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.store);
        hash = 29 * hash + Objects.hashCode(this.receipt);
        hash = 29 * hash + Objects.hashCode(this.db);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.salesTaxPercent) ^ (Double.doubleToLongBits(this.salesTaxPercent) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.employee);
        hash = 29 * hash + Objects.hashCode(this.display);
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
        final POSRegister other = (POSRegister) obj;
        if (Double.doubleToLongBits(this.salesTaxPercent) != Double.doubleToLongBits(other.salesTaxPercent)) {
            return false;
        }
        if (!Objects.equals(this.store, other.store)) {
            return false;
        }
        if (!Objects.equals(this.receipt, other.receipt)) {
            return false;
        }
        if (!Objects.equals(this.db, other.db)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.display, other.display)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POSRegister{" + "store=" + store + ", receipt=" + receipt + ", db=" + db + ", salesTaxPercent=" + salesTaxPercent + ", employee=" + employee + ", display=" + display + '}';
    }
}