package discountstrategyproject;

/**
 *
 * @author Isaac
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //configuration info
        Store store = new Store("Kohl's", "Howell Avenue, Oak Creek, WI  53154", 2);
        
        //initialize POS system
        POSRegister pos = new POSRegister(store);
        
        //start transactions
        pos.startNewSale(new Customer("AB12001", "John Smith"));
        pos.addItemToSale("A101", "Baseball Hat", 1);
        pos.addItemToSale("B202", "Men's Leather Belt", 1);
        pos.addItemToSale("C303", "Men's Tie", 2);
        pos.endSale();
    }    
}