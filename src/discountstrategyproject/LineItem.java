package discountstrategyproject;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Isaac
 */
public class LineItem {
    private Product product;
    private double qty;
    private double itemSubtotal;
    private double discountAmt;
    
    public LineItem(Product product, double qty){
        setProduct(product);
        setQty(qty);
        itemSubtotal = findItemSubtotal();
        discountAmt = findDiscountAmt();
    }
    
    //uses qty and unit cost to get the item's subtotal
    public final double findItemSubtotal(){
        return qty * product.getUnitCost();
    }
    
    //returns the amount to remove from the subtotal of an item
    public final double findDiscountAmt(){
        return product.getDiscount().getDiscountAmt(product.getUnitCost(), qty);
    }
    
    public final void setProduct(Product product){
        if(product != null){
            this.product = product;
        } else {
            throw new IllegalArgumentException("Requires valid product");
        }
    }

    public final double getQty() {
        return qty;
    }

    public final void setQty(double qty) {
        if(qty >= 0.0){
            this.qty = qty;
        } else {
            throw new IllegalArgumentException("Invalid product quantity");
        }
    }
    
    public final double getItemSubtotal() {
        return itemSubtotal;
    }

    public final void setItemSubtotal(double itemSubtotal) {
        if(itemSubtotal >= 0.0){
            this.itemSubtotal = itemSubtotal;
        } else {
            throw new IllegalArgumentException("Item subtotal must be at least $0.00");
        }
    }
    
    //format the lineItem to be output as Product ID | Name | Qty | Unit Cost | Item Subtotal | Discount Amount
    @Override
    public final String toString(){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return product.getProdId() + "  " + product.getProdName() + "  " + getQty() + "  " +
                currencyFormatter.format(product.getUnitCost()) + "  " + currencyFormatter.format(itemSubtotal) +
                "  " + currencyFormatter.format(discountAmt);
    }
}