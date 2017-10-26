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
public class PercentOffDiscountTest {
    private PercentOffDiscount discount;
    
    public PercentOffDiscountTest() {
    }
    
    @Before
    public void setUp() {
        discount = new PercentOffDiscount(0.10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDiscountAmt method, of class PercentOffDiscount.
     */
    @Test
    public void testGetDiscountAmtIsPercentOffGivenAmt() {
        assertTrue(discount.getDiscountAmt(10.00, 2) == 2.00);
    }  
}