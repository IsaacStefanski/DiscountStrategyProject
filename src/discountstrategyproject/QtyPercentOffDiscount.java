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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.percentOff) ^ (Double.doubleToLongBits(this.percentOff) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.minQty) ^ (Double.doubleToLongBits(this.minQty) >>> 32));
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
        final QtyPercentOffDiscount other = (QtyPercentOffDiscount) obj;
        if (Double.doubleToLongBits(this.percentOff) != Double.doubleToLongBits(other.percentOff)) {
            return false;
        }
        if (Double.doubleToLongBits(this.minQty) != Double.doubleToLongBits(other.minQty)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QtyPercentOffDiscount{" + "percentOff=" + percentOff + ", minQty=" + minQty + '}';
    }
}