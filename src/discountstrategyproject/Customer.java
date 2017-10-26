package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class Customer implements Person {
    private String customerID;
    private String name;
    

    public Customer(String customerID, String name) {
        setCustomerID(customerID);
        setName(name);
    }
    
    @Override
    public final String getID(){
        return getCustomerID();
    }

    public final String getCustomerID() {
        return customerID;
    }

    public final void setCustomerID(String customerID) throws IllegalArgumentException {
        if(customerID != null && !customerID.isEmpty()){
            this.customerID = customerID;
        } else {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final void setName(String name) throws IllegalArgumentException {
        if(name != null){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Customer name cannot be null");
        }
    }
}