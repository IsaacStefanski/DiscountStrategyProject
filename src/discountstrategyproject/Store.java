package discountstrategyproject;

import java.util.Objects;

/**
 *
 * @author Isaac
 */
public class Store {
    private String name;
    private String address;
    private int storeNum;
    
    public Store (String name, String address, int storeNum){
        setName(name);
        setAddress(address);
        setStoreNum(storeNum);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) throws IllegalArgumentException {
        if(name != null){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Store name cannot be null");
        }
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) throws IllegalArgumentException {
        if(address != null || !address.isEmpty()){
            this.address = address;
        }
        else {
            throw new IllegalArgumentException("Store address cannot be null");
        }
    }

    public final int getStoreNum() {
        return storeNum;
    }

    public final void setStoreNum(int storeNum) throws IllegalArgumentException {
        if(storeNum > 0){
            this.storeNum = storeNum;
        }
        else {
            throw new IllegalArgumentException("Store number cannot be 0");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.address);
        hash = 19 * hash + this.storeNum;
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
        final Store other = (Store) obj;
        if (this.storeNum != other.storeNum) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
    @Override
    public final String toString(){
        return name + "\n" + address + "\nStore #" + storeNum; 
    }
}