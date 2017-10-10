package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class NoDiscount implements Discount {

    @Override
    public double getDiscountAmt(double unitCost, double qty) {
        return 0.0;
    }
}