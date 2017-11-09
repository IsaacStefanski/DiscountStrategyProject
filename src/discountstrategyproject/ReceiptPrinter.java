package discountstrategyproject;

import java.util.Objects;

/**
 *
 * @author Isaac
 */
public class ReceiptPrinter implements ReceiptOutput{
    private Receipt receipt;
    
    public ReceiptPrinter(Receipt receipt){
        setReceipt(receipt);
    }
    
    //outputs receipt to console to simulate a printed receipt
    @Override
    public final void outputReceipt() {
        System.out.println(receipt.buildReceipt());
    }
    
    public final Receipt getReceipt(){
        return receipt;
    }
    
    public final void setReceipt(Receipt receipt) throws IllegalArgumentException {
        if(receipt != null){
            this.receipt = receipt;
        } else {
            throw new IllegalArgumentException("Null receipt");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.receipt);
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
        final ReceiptPrinter other = (ReceiptPrinter) obj;
        if (!Objects.equals(this.receipt, other.receipt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReceiptPrinter{" + "receipt=" + receipt + '}';
    }
}