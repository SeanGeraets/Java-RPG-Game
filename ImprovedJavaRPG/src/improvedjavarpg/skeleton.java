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
public class skeleton {
    //Variable to store the skeleton's current health
    public int skeletonCurrentHealth; 
    //Variable to store the skeleton's max health
    private int skeletonMaxHealth; 
    //Variable to store the skeleton's attack
    private int skeletonAttack; 
    //Variable to store the skeleton's defense
    private int skeletonDefense; 
    //Variable to store the skeleton's experience it gives upon death
    public int skeletonExperience; 
    //Variable to store the amount of gold dropped by the skeleton
    public int skeletonGoldDropped;
    //Constructor to create the skeleton
    public skeleton() { 
        //Sets the skeleton current health to 5 upon creation
        skeletonCurrentHealth = 5; 
        //Sets the skeleton max health to 5 upon creation
        skeletonMaxHealth = 5; 
        //Sets the skeleton attack to 1 upon creation
        skeletonAttack = 1; 
        //Sets the skeletond defense to 0 upon creation
        skeletonDefense = 0;  
        //Sets the experience the skeleton gives upon death 
        skeletonExperience = 1000; 
        //Sets the gold dropped by the skeleton upon death
        skeletonGoldDropped = 3;
    }
    //function to return the skeleton current health
    public int getSkeletonCurrentHealth() { 
        return skeletonCurrentHealth;
    }
    //function to set the skeleton current health
    public void setSkeletonCurrentHealth(int skeletonCurrentHealth) {
        this.skeletonCurrentHealth = skeletonCurrentHealth;
    }
    //function to return the skeleton max health
    public int getSkeletonMaxHealth(){ 
        return skeletonMaxHealth;
    }
    //function to set the skeleton max health
    public void setSkeletonMaxHealth(int skeletonMaxHealth) {
        this.skeletonMaxHealth = skeletonMaxHealth;
    }
    //function to return the skeleton's defense
    public int getSkeletonDefense() { 
        return skeletonDefense;
    }
    //function to set the skeleton's defense
    public void setSkeletonDefense(int skeletonDefense) {
        this.skeletonDefense = skeletonDefense;
    }
    //function to return the skeleton's attack
    public int getSkeletonAttack() { 
        return skeletonAttack;
    }
    //function to set the skeleton's attack
    public void setSkeletonAttack(int skeletonAttack) {
        this.skeletonAttack = skeletonAttack;
    }       
    //function to return the skeleton's experience it gives upon death
    public int getSkeletonExperience(){ 
        return skeletonExperience;
    }
    //function to set the skeleton's experience it gives upon death
    public void setSkeletonExperience(int skeletonExperience){
        this.skeletonExperience = skeletonExperience;
    }
    //Function to return the gold dropped by the skeleton upon death
    public int getSkeletonGoldDropped(){
        return skeletonGoldDropped;
    }
    //Function to set the gold dropped by the skeleton upon death
    public void setSkeletonGoldDropped(int skeletonGoldDropped){
        this.skeletonGoldDropped = skeletonGoldDropped;
    }
}
