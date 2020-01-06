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
public class ironBoots {
    private final int defense;
    private int buyPrice;
    private int sellPrice;
    private String rarity;

    public ironBoots() {
        defense = 2;
        buyPrice = 25;
        sellPrice = 10;
        rarity = "Uncommon";
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

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
    
}
