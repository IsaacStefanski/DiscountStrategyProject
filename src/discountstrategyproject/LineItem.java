package discountstrategyproject;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

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
    
    public final Product getProduct(){
        return product;
    }
    
    public final void setProduct(Product product)throws IllegalArgumentException {
        if(product != null){
            this.product = product;
        } else {
            throw new IllegalArgumentException("Requires valid product");
        }
    }

    public final double getQty() {
        return qty;
    }

    public final void setQty(double qty)throws IllegalArgumentException {
        if(qty >= 0.0){
            this.qty = qty;
        } else {
            throw new IllegalArgumentException("Invalid product quantity");
        }
    }
    
    public final double getItemSubtotal() {
        return itemSubtotal;
    }

    public final void setItemSubtotal(double itemSubtotal) throws IllegalArgumentException  {
        if(itemSubtotal >= 0.0){
            this.itemSubtotal = itemSubtotal;
        } else {
            throw new IllegalArgumentException("Item subtotal must be at least $0.00");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.product);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.qty) ^ (Double.doubleToLongBits(this.qty) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.itemSubtotal) ^ (Double.doubleToLongBits(this.itemSubtotal) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.discountAmt) ^ (Double.doubleToLongBits(this.discountAmt) >>> 32));
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
        final LineItem other = (LineItem) obj;
        if (Double.doubleToLongBits(this.qty) != Double.doubleToLongBits(other.qty)) {
            return false;
        }
        if (Double.doubleToLongBits(this.itemSubtotal) != Double.doubleToLongBits(other.itemSubtotal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.discountAmt) != Double.doubleToLongBits(other.discountAmt)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
    @Override
    public final String toString(){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return product.getProdId() + "  " + product.getProdName().toUpperCase() +
                "  " + getQty() + " @ " + currencyFormatter.format(product.getUnitCost()) +
                "\n       Item subtotal: " + currencyFormatter.format(itemSubtotal) + "   Discount: " + currencyFormatter.format(discountAmt);
    }
}