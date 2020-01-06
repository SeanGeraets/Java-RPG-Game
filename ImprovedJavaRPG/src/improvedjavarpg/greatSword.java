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
public class greatSword {
    private final int attack;
    private int buyPrice;
    private int sellPrice;
    private String rarity;

    public greatSword() {
        attack = 5;
        buyPrice = 50;
        sellPrice = 25;
        rarity = "Uncommon";
    }

    public int getAttack() {
        return attack;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
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
