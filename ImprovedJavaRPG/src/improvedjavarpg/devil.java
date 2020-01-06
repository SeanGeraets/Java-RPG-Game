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
public class devil {
    private int devilAttack;
    private int devilDefense;
    private int devilCurrentHealth;
    private int devilMaxHealth;
    private int devilExperience;
    private int devilGold;
    public devil() {
        devilAttack = 2;
        devilDefense = 0;
        devilCurrentHealth = 30;
        devilMaxHealth = 30;
        devilExperience = 1000;
        devilGold = 100;
    }

    public int getDevilAttack() {
        return devilAttack;
    }

    public void setDevilAttack(int devilAttack) {
        this.devilAttack = devilAttack;
    }

    public int getDevilDefense() {
        return devilDefense;
    }

    public void setDevilDefense(int devilDefense) {
        this.devilDefense = devilDefense;
    }

    public int getDevilCurrentHealth() {
        return devilCurrentHealth;
    }

    public void setDevilCurrentHealth(int devilCurrentHealth) {
        this.devilCurrentHealth = devilCurrentHealth;
    }

    public int getDevilMaxHealth() {
        return devilMaxHealth;
    }

    public void setDevilMaxHealth(int devilMaxHealth) {
        this.devilMaxHealth = devilMaxHealth;
    }

    public int getDevilExperience() {
        return devilExperience;
    }

    public void setDevilExperience(int devilExperience) {
        this.devilExperience = devilExperience;
    }

    public int getDevilGold() {
        return devilGold;
    }

    public void setDevilGold(int devilGold) {
        this.devilGold = devilGold;
    }
    
}
