package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class LineItem {
    private Product product;
    private double qty;
    private double itemSubtotal;
    
    public LineItem(Product product, double qty){
        setProduct(product);
        setQty(qty);
    }
    
    public final double calcItemSubtotal(){
        return qty * product.getUnitCost();
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
    
    @Override
    public final String toString(){
        return product.getProdId() + "  " + product.getProdName() + "  " + getQty() + "  " + product.getUnitCost() + "  " + calcItemSubtotal() + "  " + product.getDiscount();
    }
}