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
public class EmployeeTest {
    private Employee e;
    
    public EmployeeTest() {
    }
    
    @Before
    public void setUp() {
        e = new Employee("A123", "John Smith");
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of getID method, of class Employee.
     */
    @Test
    public void verifyEmployeeIDisNotNull() {
        assertTrue(e.getID() != null);
    }
}