/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvedjavarpg;

/**
 *
 * @author nh228u08
 */
public class shopKeeper {
    public String[] shopKeeperInventory = new String[5];

    public shopKeeper() {
        for(int i=0; i< shopKeeperInventory.length;i++)
            shopKeeperInventory[i] = new String();
    }

    public String[] getShopKeeperInventory() {
        return shopKeeperInventory;
    }

    public void setShopKeeperInventory(String[] shopKeeperInventory) {
        this.shopKeeperInventory = shopKeeperInventory;
    }
}
