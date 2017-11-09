package discountstrategyproject;

import java.util.Objects;

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

    public final void setProdId(String prodId) throws IllegalArgumentException {
        if(prodId != null){
            this.prodId = prodId;
        } else {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) throws IllegalArgumentException {
        if(unitCost >= 0.00){
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit Cost must be at least 0.00");
        }
    }

    public final String getProdName() {
        return prodName;
    }

    public final void setProdName(String prodName) throws IllegalArgumentException {
        if(prodName != null){
            this.prodName = prodName;
        } else {
            throw new IllegalArgumentException("Product Name cannot be null");
        }
    }

    public final Discount getDiscount() {
        return discount;
    }

    public final void setDiscount(Discount discount) throws IllegalArgumentException {
        if(discount != null){
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Discount cannot be null");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.prodId);
        hash = 97 * hash + Objects.hashCode(this.prodName);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.unitCost) ^ (Double.doubleToLongBits(this.unitCost) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.discount);
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
        final Product other = (Product) obj;
        if (Double.doubleToLongBits(this.unitCost) != Double.doubleToLongBits(other.unitCost)) {
            return false;
        }
        if (!Objects.equals(this.prodId, other.prodId)) {
            return false;
        }
        if (!Objects.equals(this.prodName, other.prodName)) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "prodId=" + prodId + ", prodName=" + prodName + ", unitCost=" + unitCost + ", discount=" + discount + '}';
    }
}