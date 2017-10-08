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
    private double qty;
    private double extCost;
    private Discount discount;

    public Product(String prodId, String prodName, double unitCost, Discount discount) {
        setProdId(prodId);
        setProdName(prodName);
        setUnitCost(unitCost);
        setDiscount(discount);
    }
    
    public final double getDiscountAmt(double qty){
        return discount.getDiscountAmt(unitCost, qty);
    }
    
    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(String prodId) {
        if(prodId != null){
            this.prodId = prodId;
        } else {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        if(unitCost >= 0.00){
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit Cost must be at least 0.00");
        }
    }

    public final String getProdName() {
        return prodName;
    }

    public final void setProdName(String prodName) {
        if(prodName != null){
            this.prodName = prodName;
        } else {
            throw new IllegalArgumentException("Product Name cannot be null");
        }
    }

    public final Discount getDiscount() {
        return discount;
    }

    public final void setDiscount(Discount discount) {
        if(discount != null){
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Discount cannot be null");
        }
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        if(qty >= 0.00){
            this.qty = qty;
        } else {
            throw new IllegalArgumentException("Quantity must be at least 0.00");
        }
    }

    public double getExtCost() {
        return extCost;
    }

    public void setExtCost(double extCost) {
        if(extCost >= 0.00){
            this.extCost = extCost;
        } else {
            throw new IllegalArgumentException("Extended Cost must be at least 0.00");
        }
    }
}