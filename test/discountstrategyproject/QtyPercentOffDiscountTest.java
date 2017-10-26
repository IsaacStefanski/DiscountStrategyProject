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
public class QtyPercentOffDiscountTest {
    private QtyPercentOffDiscount discount;
    
    public QtyPercentOffDiscountTest() {
    }
    
    @Before
    public void setUp() {
        discount = new QtyPercentOffDiscount(0.10, 3);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getDiscountAmt method, of class QtyPercentOffDiscount.
     */
    @Test
    public void testGetDiscountAmtNotMinimumQtyRequired() {
        assertTrue(discount.getDiscountAmt(10.00, 2) == 0.00);
    }
    
    @Test
    public void testGetDiscountAmtWithMinimumQtyRequired() {
        assertTrue(discount.getDiscountAmt(10.00, 3) == 3.00);
    }  
}