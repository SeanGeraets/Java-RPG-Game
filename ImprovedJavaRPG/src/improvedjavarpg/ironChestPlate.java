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
public class ironChestPlate {
    private final int defense;
    private int buyPrice;
    private int sellPrice;
    private String rarity;

    public ironChestPlate() {
        defense = 3;
        buyPrice = 35;
        sellPrice = 15;
        rarity = "Unommon";
    }
    public int getDefense(){
        return defense;
    }
    public int sellPrice() {
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
