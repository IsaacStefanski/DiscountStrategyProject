package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isaac
 */
public class LineItemIntegrationTest {
    
    public LineItemIntegrationTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQtyNotZeroOrLess() {
        LineItem item = new LineItem(null, 1);
        item.setQty(0);
    }
}