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
public class healingPotion {
    private int healthGained;
    private int healingPotionBuyPrice;
    private int healingPotionSellPrice;
    
    public healingPotion() {
        healthGained = 10;
        healingPotionBuyPrice = 5;
        healingPotionSellPrice = 1;
    }

    public int getHealthGained() {
        return healthGained;
    }

    public void setHealthGained(int healthGained) {
        this.healthGained = healthGained;
    }

    public int getHealingPotionBuyPrice() {
        return healingPotionBuyPrice;
    }

    public void setHealingPotionBuyPrice(int healingPotionBuyPrice) {
        this.healingPotionBuyPrice = healingPotionBuyPrice;
    }

    public int getHealingPotionSellPrice() {
        return healingPotionSellPrice;
    }

    public void setHealingPotionSellPrice(int healingPotionSellPrice) {
        this.healingPotionSellPrice = healingPotionSellPrice;
    }
    
}
