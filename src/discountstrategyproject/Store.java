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
public class Store {
    private String name;
    
    public Store (String name){
        setName(name);
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
}