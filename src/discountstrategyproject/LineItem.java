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
public class LineItem {
    private Product product;
    
    public LineItem(Product product){
        setProduct(product);
    }
    
    public final void setProduct(Product product){
        if(product != null){
            this.product = product;
        } else {
            throw new IllegalArgumentException("Requires valid product");
        }
    }
    
    @Override
    public final String toString(){
        return product.getProdId() + "  " + product.getProdName() + "  " + product.getQty() + "  " + product.getUnitCost() + "  " + product.getExtCost() + "  " + product.getDiscount();
    }
}