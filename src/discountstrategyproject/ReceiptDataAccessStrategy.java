/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public interface ReceiptDataAccessStrategy {

    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    public abstract Customer findCustomer(final String custId);

    /**
     * Tries to find a Product by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    public abstract Product findProduct(final String prodId);    
    
    /**
     * Tries to find an Employee by employee id.
     * @param employeeId - must not be null or empty
     * @return found Employee or null if not found or bad argument
     */
    public abstract Employee findEmployee(final String employeeId);
}