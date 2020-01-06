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
public class greaterHealingPotion {
    private int healthGained;
    private int greaterHealingPotionBuyPrice;
    private int greaterHealingPotionSellPrice;

    public greaterHealingPotion(){
        healthGained = 25;
        greaterHealingPotionBuyPrice = 15;
        greaterHealingPotionSellPrice = 5;
    }

    public int getHealthGained() {
        return healthGained;
    }

    public void setHealthGained(int healthGained) {
        this.healthGained = healthGained;
    }

    public int getGreaterHealingPotionBuyPrice() {
        return greaterHealingPotionBuyPrice;
    }

    public void setGreaterHealingPotionBuyPrice(int greaterHealingPotionBuyPrice) {
        this.greaterHealingPotionBuyPrice = greaterHealingPotionBuyPrice;
    }

    public int getGreaterHealingPotionSellPrice() {
        return greaterHealingPotionSellPrice;
    }

    public void setGreaterHealingPotionSellPrice(int greaterHealingPotionSellPrice) {
        this.greaterHealingPotionSellPrice = greaterHealingPotionSellPrice;
    }
}
