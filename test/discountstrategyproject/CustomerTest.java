/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isaac
 */
public class CustomerTest {
    private Customer c;
    
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
        c = new Customer("A123", "John Smith");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class Customer.
     */
    @Test
    public void verifyCustomerIDisNotNull() {
        assertTrue(c.getID() != null);
    }    
}