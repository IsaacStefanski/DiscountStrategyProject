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
public interface Discount {
    public abstract double getDiscountAmt(double unitCost, double qty);
}