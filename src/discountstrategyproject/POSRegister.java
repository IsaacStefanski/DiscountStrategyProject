package discountstrategyproject;

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
}