package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public interface Discount {
    public abstract double getDiscountAmt(double unitCost, double qty);
}