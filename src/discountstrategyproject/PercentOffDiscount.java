package discountstrategyproject;

/**
 * This class is an instance of the <B>DiscountStrategy</B> abstraction, which
 * provides the amount saved on a particular product, for a specific
 * percent savings and a specific quantity.
 * <p></p>
 * Revision History:
 * <p></p>
 * <ul>
 * <li>2017-11-07: added JavaDoc comments</li>
 * </ul>
 * 
 * @author Isaac Stefanski, istefanski@my.wctc.edu
 * @version 1.01
 * @since 1.0
 */
public class PercentOffDiscount implements Discount {
    private double percentOff;
    
    //discount results in removal of a certain percentage of the price
    public PercentOffDiscount(double percentOff){
        setPercentOff(percentOff);
    }
    
    /**
     * Returns the amount saved based on the cost of the product and the
     * quantity purchased.
     * @param unitCost the original cost of the product for one item
     * @param qty the number of items purchased
     * @return the amount saved
     * @throws IllegalArgumentException if the unitCost less than 0
     */
    @Override
    public final double getDiscountAmt(double unitCost, double qty){
        if(unitCost < 0.00){
            throw new IllegalArgumentException("Invalid unit price");
        }
        return unitCost * qty * percentOff;
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) throws IllegalArgumentException {
        if(percentOff < 0){
            throw new IllegalArgumentException("Invalid amount entered");
        }
        this.percentOff = percentOff;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.percentOff) ^ (Double.doubleToLongBits(this.percentOff) >>> 32));
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
        final PercentOffDiscount other = (PercentOffDiscount) obj;
        if (Double.doubleToLongBits(this.percentOff) != Double.doubleToLongBits(other.percentOff)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PercentOffDiscount{" + "percentOff=" + percentOff + '}';
    }
}