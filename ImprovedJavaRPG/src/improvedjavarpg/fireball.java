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
public class fireball {
    private int mpCost;
    private int baseDamage;
    private int BuyPrice;

    public fireball() {
        mpCost = 2;
        baseDamage = 5;
        BuyPrice = 40;
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(int BuyPrice) {
        this.BuyPrice = BuyPrice;
    }
    
}
