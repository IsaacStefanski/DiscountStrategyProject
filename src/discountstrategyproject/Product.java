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
public class Product {
    private String prodId;
    private String prodName;
    private double unitCost;
    private Discount discount;

    public Product(String prodId, String prodName, double unitCost, Discount discount) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.unitCost = unitCost;
        this.discount = discount;
    }
    
    public final double getDiscountAmt(double qty){
        return discount.getDiscountAmt(unitCost, qty);
    }
    
    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public final String getProdName() {
        return prodName;
    }

    public final void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public final Discount getDiscount() {
        return discount;
    }

    public final void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public static void main(String[] args) {
        Product product1 = new Product("A101", "Baseball Hat", 19.95, new PercentOffDiscount(.10));
        Product product2 = new Product("B200", "Men's Belt", 39.95, new QtyPercentOffDiscount(.10, 5));
        
        double amt1 = product1.getDiscountAmt(2);
        System.out.println("Discount for Baseball Hat should be 3.90, but is " + amt1);
        double amt2 = product2.getDiscountAmt(6);
        System.out.println("Discount for Belt should be 239.70, but is " + amt2);
    }
}
