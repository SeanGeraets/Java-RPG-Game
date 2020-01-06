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
public class player {
    private String playerName;
     //Variable to store the player's current health
    private int playerCurrentHealth; 
    //Variable to store the player's max health
    private int playerMaxHealth; 
    //Variable to store the players current mana
    private int currentMP;
    //Variable to store the players max mana
    private int maxMP;
    //Variable to store the player's attack
    private int playerAttack; 
    //Variable to store the total attack of the player (Player + Weapon)
    private int totalAttack;
    //Variable to store the player's defense
    private int playerDefense; 
    //Variable to store the total defense of the player(Player + Armor)
    private int totalDefense;
    //Variable to store the player's level
    private int playerLevel; 
    //Variable to store the player's experience
    private int playerExperience; 
    //Variable to store the player's gold
    private int playerGold;
    //Variable to store the player's strength
    private int strength;
    //Variable to store the players vitality
    private int vitality;
    //Variable to store the player's intelligence
    private int intelligence;
    //Variable to store the player's stat points
    private int statPoints;
    //Variable to store the equipped helmet
    public String [] playerHelmet = {""};
    //Variable to store the equipped chestplate
    public String [] playerChestPlate = {""};
    //Variable to store the equipped weapon
    public String [] playerWeapon = {""};
    //Variable to store the equipped boots
    public String [] playerBoots = {""};
    //Variable to store the equipped gloves
    public String [] playerGloves = {""};
    //Array to store the player's inventory
    public String [] playerBag = new String[16];
    public String [] spellList = new String[16];
    public String [] questList = new String[16];
    
    //Constructor to create the player
    public player() { 
        playerName = "";
        playerCurrentHealth = 30;
        playerMaxHealth = 30;
        playerAttack = 5;
        playerDefense = 0;
        playerLevel = 1;
        playerExperience = 0;
        playerGold = 5000;
        strength = 0;
        vitality = 0;
        intelligence = 0;
        currentMP = 10;
        maxMP = 10;
        for(int i=0; i< playerBag.length;i++){
            playerBag[i] = new String();
        }
        for(int i=0; i < spellList.length;i++){
            spellList[i] = new String();
        }
        for(int i=0; i < questList.length;i++){
            questList[i] = new String();
        }
    }
    //Function to return the player's current health
    public int getPlayerCurrentHealth() { 
        return playerCurrentHealth;
    }
    //Function to set the players current health
    public void setPlayerCurrentHealth(int playerCurrentHealth) {
        this.playerCurrentHealth = playerCurrentHealth;
    }
    //Function to return the players max health
    public int getPlayerMaxHealth(){ 
        return playerMaxHealth;
    }
    //Function to set the players max health
    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }
    //Function to return the player's attack
    public int getPlayerAttack() { 
        return playerAttack;
    }
    //Function to set the players attack
    public void setPlayerAttack(int playerAttack){
        this.playerAttack = playerAttack;
    }
    //Function to return the player's defense
    public int getPlayerDefense() { 
        return playerDefense;
    }
    //Function to set the players defense
    public void setPlayerDefense(int playerDefense){
        this.playerDefense = playerDefense;
    }
    //Function to return the player's leve
    public int getPlayerLevel() { 
        return playerLevel;
    }
    //Function to set the players level
    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
    //Function to return the player's experience
    public int getPlayerExperience(){ 
        return playerExperience;
    }
    //Function to set the player's experience
    public void setPlayerExperience(int playerExperience) {
        this.playerExperience = playerExperience;
    }
    //Function to return the player's gold
    public int getPlayerGold(){
        return playerGold;
    }
    //Function to set the player's gold
    public void setPlayerGold(int playerGold){
        this.playerGold = playerGold;
    }  
    //Function to return the player's helmet
    public String[] getPlayerHelmet() {
        return playerHelmet;
    }
    //Function to set the player's helmet
    public void setPlayerHelmet(String playerHelmet) {
        this.playerHelmet[0] = playerHelmet;
    }
    //Function to return the player's chest plate
    public String[] getPlayerChestPlate() {
        return playerChestPlate;
    }
    //Function to set the player's chest plate
    public void setPlayerChestPlate(String[] playerChestPlate) {
        this.playerChestPlate = playerChestPlate;
    }
    //Function to return the player's weapon
    public String[] getPlayerWeapon() {
        return playerWeapon;
    }
    //Function to set the player's weapon
    public void setPlayerWeapon(String[] playerWeapon) {
        this.playerWeapon = playerWeapon;
    }
    //Function to return the player's bag
    public String[] getPlayerBag() {
        return playerBag;
    }
    //Function to set the player's bag
    public void setPlayerBag(String[] playerBag) {
        this.playerBag = playerBag;
    }
    //Function to return the player's total attack
    public int getTotalAttack() {
        return totalAttack;
    }
    //Function to set the player's total attack
    public void setTotalAttack(int totalAttack) {
        this.totalAttack = totalAttack;
    }
    //Function to return the player's total defense
    public int getTotalDefense() {
        return totalDefense;
    }
    //Function to set the player's total defense
    public void setTotalDefense(int totalDefense) {
        this.totalDefense = totalDefense;
    }
    //Function to get the players name
    public String getPlayerName() {
        return playerName;
    }
    //Function to set the players name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    //Function to get the players current mp
    public int getCurrentMP() {
        return currentMP;
    }
    //Function to set the players current mp
    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }
    //Function to get the players max mp
    public int getMaxMP() {
        return maxMP;
    }
    //Function to set the players max mp
    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }
    //Function to get the players strength
    public int getStrength() {
        return strength;
    }
    //Functoin to set the players strength
    public void setStrength(int strength) {
        this.strength = strength;
    }
    //Function to get the players vitality
    public int getVitality() {
        return vitality;
    }
    //Function to set the players vitality
    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
    //Function to get the players intelligence
    public int getIntelligence() {
        return intelligence;
    }
    //Function to set the players set intelligence
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    //Function to get the players stat points
    public int getStatPoints() {
        return statPoints;
    }
    //Function to set the players stat points
    public void setStatPoints(int statPoints) {
        this.statPoints = statPoints;
    }
    //Function to get the players spell list
    public String[] getSpellList() {
        return spellList;
    }
    //Function to set the players spell list
    public void setSpellList(String[] spellList) {
        this.spellList = spellList;
    }
    //Function to get the players boots
    public String[] getPlayerBoots() {
        return playerBoots;
    }
    //Function to set the players boots
    public void setPlayerBoots(String[] playerBoots) {
        this.playerBoots = playerBoots;
    }
    //Function to get the players gloves
    public String[] getPlayerGloves() {
        return playerGloves;
    }
    //Function to set the players gloves
    public void setPlayerGloves(String[] playerGloves) {
        this.playerGloves = playerGloves;
    }
    //Function to get the players quest list
    public String[] getQuestList() {
        return questList;
    }
    //Function to set the players quest list
    public void setQuestList(String[] questList) {
        this.questList = questList;
    }
    
    
}
