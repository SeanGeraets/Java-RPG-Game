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
public class heavenSmitingDevilSlayerSword {
    private int attack;
    private String rarity;
    private int devilMultiplier;

    public heavenSmitingDevilSlayerSword() {
        attack = 100;
        rarity = "Divine Artifact";
        devilMultiplier = 2;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getDevilMultiplier() {
        return devilMultiplier;
    }

    public void setDevilMultiplier(int devilMultiplier) {
        this.devilMultiplier = devilMultiplier;
    }
    
}
