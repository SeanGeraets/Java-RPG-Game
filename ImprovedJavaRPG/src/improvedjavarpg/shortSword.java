/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvedjavarpg;

/**
 *
 * @author Sean Geraets
 */
public class shortSword {
    private final int attack;
    private int sellPrice;
    private String rarity;

    public shortSword() {
        attack = 1;
        sellPrice = 1;
        rarity = "Common";
    }

    public int getAttack() {
        return attack;
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
