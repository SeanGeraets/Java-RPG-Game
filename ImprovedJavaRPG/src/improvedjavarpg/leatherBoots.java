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
public class leatherBoots {
    private final int defense;
    private int sellPrice;
    private String rarity;

    public leatherBoots() {
        defense = 1;
        sellPrice = 1;
        rarity = "Common";
    }
    public int getDefense(){
        return defense;
    }
    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    
}
