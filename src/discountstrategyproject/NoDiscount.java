package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class NoDiscount implements Discount {

    //no applicable discount, same as 0% off the price
    @Override
    public double getDiscountAmt(double unitCost, double qty) {
        return 0.0;
    }
}