/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class QtyPercentOffDiscount implements Discount {
    private double percentOff;
    private double minQty;
    
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

    public final void setPercentOff(double percentOff) {
        if(percentOff < 0){
            throw new IllegalArgumentException("...");
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