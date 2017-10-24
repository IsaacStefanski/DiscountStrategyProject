package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class QtyPercentOffDiscount implements Discount {
    private double percentOff;
    private double minQty;
    
    //discount of certain percent off only applicable when required minimum qty is purchased
    public QtyPercentOffDiscount(double percentOff, double minQty){
        setPercentOff(percentOff);
        setMinQty(minQty);
    }
    
    @Override
    public final double getDiscountAmt(double unitCost, double qty){
        double discountAmt = 0;
        
        if(qty >= minQty){
            discountAmt = unitCost * qty * percentOff;
        }
        return discountAmt;
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) throws IllegalArgumentException {
        if(percentOff < 0){
            throw new IllegalArgumentException("Percent off needs to be more than 0");
        }
        this.percentOff = percentOff;
    }

    public final double getMinQty() {
        return minQty;
    }

    public final void setMinQty(double minQty) {
        this.minQty = minQty;
    }   
}