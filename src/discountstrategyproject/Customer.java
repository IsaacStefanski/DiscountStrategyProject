package discountstrategyproject;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.customerID);
        hash = 71 * hash + Objects.hashCode(this.name);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerID, other.customerID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", name=" + name + '}';
    }
}