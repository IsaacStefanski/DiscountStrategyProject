package discountstrategyproject;

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

    public final void setName(String name) {
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

    public final void setAddress(String address) {
        if(address != null){
            this.address = address;
        }
        else {
            throw new IllegalArgumentException("Store address cannot be null");
        }
    }

    public final int getStoreNum() {
        return storeNum;
    }

    public final void setStoreNum(int storeNum) {
        if(storeNum > 0){
            this.storeNum = storeNum;
        }
        else {
            throw new IllegalArgumentException("Store number cannot be 0");
        }
    }
    
    @Override
    public final String toString(){
        return name + "\n" + address + "\nStore #" + storeNum; 
    }
}