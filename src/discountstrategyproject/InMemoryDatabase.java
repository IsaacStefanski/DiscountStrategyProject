package discountstrategyproject;

import java.util.Arrays;

/**
 *
 * @author Isaac
 */
public class InMemoryDatabase implements ReceiptDataAccessStrategy {
    private Customer[] customers = {
        new Customer("100", "John Smith   "),
        new Customer("200", "Sally Jones  "),
        new Customer("300", "Bob Clementi "),
        new Customer("000", "-") //default customer without existing customer ID
    };
    
    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat   ", 19.95, new PercentOffDiscount(0.15)),
        new Product("A102", "NFL Packer's Hat   ", 19.95, new PercentOffDiscount(0.1)),
        new Product("B200", "Men's Leather Belt ", 24.95, new QtyPercentOffDiscount(0.05, 2)),
        new Product("B204", "Men's Tie          ", 14.99, new NoDiscount()),
        new Product("B205", "Men's Dress Shirt  ", 35.50, new PercentOffDiscount(0.15)),
        new Product("C222", "Women's Socks      ", 9.50, new NoDiscount()),
        new Product("C233", "Women's Sweater    ", 19.55, new NoDiscount()),
        new Product("C244", "Women's Dress      ", 29.99, new PercentOffDiscount(0.1))
    };
    
    private Employee[] employees = {
        new Employee("12345", "Billy Bob"),
        new Employee("67890", "Jane Doe")
    };
    
    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    @Override
    public final Customer findCustomer(final String custId) throws IllegalArgumentException {
        // validation is needed for method parameter
        if(custId == null || custId.length() == 0) {
            throw new IllegalArgumentException("Sorry, FakeDatabase.findCustomer method has "
                    + "illegal argument");
        }
        
        Customer customer = null;
        for(Customer c : customers) {
            if(custId.equals(c.getCustomerID())) {
                customer = c;
                break;
            }
        }
        
        return customer;
    }
    
    /**
     * Tries to find a Product by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    @Override
    public final Product findProduct(final String prodId)throws IllegalArgumentException {
        // validation is needed for method parameter
        if(prodId == null || prodId.length() == 0) {
            throw new IllegalArgumentException("Sorry, FakeDatabase.findProduct method has "
                    + "illegal argument");
        }
        
        Product product = null;
        for(Product p : products) {
            if(prodId.equals(p.getProdId())) {
                product = p;
                break;
            }
        }
        
        return product;
    }
    
    /**
     * Tries to find an Employee by employee id.
     * @param employeeId - must not be null or empty
     * @return found Employee or null if not found or bad argument
     */
    @Override
    public final Employee findEmployee(final String employeeId)throws IllegalArgumentException {
        // validation is needed for method parameter
        if(employeeId == null || employeeId.length() == 0) {
            throw new IllegalArgumentException("Sorry, FakeDatabase.findEmployee method has "
                    + "illegal argument");
        }
        
        Employee employee = null;
        for(Employee e : employees) {
            if(employeeId.equals(e.getEmployeeID())) {
                employee = e;
                break;
            }
        }
        
        return employee;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Arrays.deepHashCode(this.customers);
        hash = 29 * hash + Arrays.deepHashCode(this.products);
        hash = 29 * hash + Arrays.deepHashCode(this.employees);
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
        final InMemoryDatabase other = (InMemoryDatabase) obj;
        if (!Arrays.deepEquals(this.customers, other.customers)) {
            return false;
        }
        if (!Arrays.deepEquals(this.products, other.products)) {
            return false;
        }
        if (!Arrays.deepEquals(this.employees, other.employees)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InMemoryDatabase{" + "customers=" + customers + ", products=" + products + ", employees=" + employees + '}';
    }
}