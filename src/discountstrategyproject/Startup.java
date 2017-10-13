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
        Store store = new Store("Kohl's", "Howell Avenue, Oak Creek, WI  53154", 10);
        InMemoryDatabase db = new InMemoryDatabase();
        
        //initialize POS system
        POSRegister pos = new POSRegister(store, db, 0.056);
        
        //start transactions
        pos.startNewSale("100");
        pos.addItemToSale("A101", 1);
        pos.addItemToSale("A102", 1);
        pos.addItemToSale("B204", 2);
        pos.endSale();
        
        pos.startNewSale("200");
        pos.addItemToSale("C222", 3);
        pos.addItemToSale("C233", 2);
        pos.addItemToSale("C244", 1);
        pos.endSale();
        
        pos.startNewSale("300");
        pos.addItemToSale("B200", 2);
        pos.addItemToSale("B204", 3);
        pos.addItemToSale("B205", 4);
        pos.endSale();
    }    
}