package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class Customer {
    private String customerID;
    private String name;
    

    public Customer(String customerID, String name) {
        setCustomerID(customerID);
        setName(name);
    }

    public final String getCustomerID() {
        return customerID;
    }

    public final void setCustomerID(String customerID) {
        if(customerID != null){
            this.customerID = customerID;
        } else {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if(name != null){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Customer name cannot be null");
        }
    }
}