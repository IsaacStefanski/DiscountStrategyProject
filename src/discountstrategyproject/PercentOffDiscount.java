package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class PercentOffDiscount implements Discount {
    private double percentOff;
    
    //discount results in removal of a certain percentage of the price
    public PercentOffDiscount(double percentOff){
        setPercentOff(percentOff);
    }
    
    @Override
    public final double getDiscountAmt(double unitCost, double qty){
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
}