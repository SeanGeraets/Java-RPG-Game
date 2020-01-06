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
public class blueMoonMagicShop {
    public String[] inventory = new String[5];

    public blueMoonMagicShop() {
        for(int i=0; i< inventory.length;i++)
            inventory[i] = new String();
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }
}
