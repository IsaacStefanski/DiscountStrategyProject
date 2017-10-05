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
public class PercentOffDiscount implements Discount {
    private double percentOff;
    
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

    public final void setPercentOff(double percentOff) {
        if(percentOff < 0){
            throw new IllegalArgumentException("...");
        }
        this.percentOff = percentOff;
    }
}