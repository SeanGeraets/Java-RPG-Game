/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvedjavarpg;

/**
 *
 * @author Sean
 */
public class blueMoonBlacksmith {
    public String[] binventory = new String[5];

    public blueMoonBlacksmith() {
        for(int i=0; i< binventory.length;i++)
            binventory[i] = new String();
    }

    public String[] getInventory() {
        return binventory;
    }

    public void setInventory(String[] inventory) {
        this.binventory = inventory;
    }
}
