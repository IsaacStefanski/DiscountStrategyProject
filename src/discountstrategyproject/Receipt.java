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
public class Receipt {
    private LineItem[] lineItems;
    
    public final void printReceipt(){
        for (LineItem l : lineItems){
            System.out.println("\n" + l);
        }
    }
}