package improvedjavarpg;

import java.util.Random;
import java.util.Scanner;

/**
 *  --ChangeLog--
 * 2/6/19 - Created program
 * 2/7/19 - Implemented method to display the menus
 * 2/8/19 - Implemented method to display the player's stats
 * 2/9/19 - Implemented combat against Skeleton
 * 2/10/19 - Implemented the player's inventory
 * 2/14/19 - Implemented equipping items from the bag
 * 2/15/19 - Implemented items being removed from the bag
 * 2/16/19 - Implemented items being swapped from equipment slots to bag
 * 2/20/19 - Implemented shop
 * 2/21/19 - Implemented buying items from shop
 * 2/26/19 - Implemented selling items to the shop
 * 2/27/19 - Implemented using healing potions
 * 3/1/19 - Implemented using greater healing potions
 * 3/2/19 - Added strength, intelligence, and vitality stats
 * 3/5/19 - Added gaining stat points upon level up
 * 3/7/19 - Implemented allocate stat points menu
 * 3/8/19 - Implemented allocating stat points
 * 3/9/19 - Added MP
 * 3/10/19 - Added HP and MP scaling based on vitality and intelligence
 * 3/11/19 - Added attack scaling based on strength
 * 3/12/19 - Added lots of formatting to make code easier to read
 * 3/13/19 - Significant rework of search option to prepare for more enemies being added in the future
 * 3/14/19 - Added skeleton health and attack scaling based on player level
 * 3/15/19 - Added Scroll of Fireball to item drop list
 * 3/16/19 - Added ability to learn Fireball spell using scroll of fireball from bag
 * 3/17/19 - Added lots of commenting
 * 3/23/19 - Added working Fireball attack
 * 3/25/19 - Implemented player death (Why I added so much before this I have no idea)
 * 3/26/19 - Implemented equipment rarity
 * 3/28/19 - Added devil enemy
 * 3/30/19 - Started devil combat
 * 4/1/19 - Finished devil combat
 * 4/1/19 - Minor bug fixes
 * 4/2/19 - Added skeleton and devil gold dropped scaling based on player level
 * 4/4/19 - Added iron armor
 * 4/6/19 - Reworked total attack and total defense functions
 * 4/7/19 - Created Blue Moon City
 * 4/8/19 - Created Blue Moon City blacksmith, general goods, and magic shop
 * 4/10/19 - Implemented Blue Moon General Goods
 * 4/12/19 - Implemented gloves and boots slots for the player
 * 4/13/19 - Implemented Blue Moon Blacksmith
 * 4/15/19 - Fixed two infinite loop bugs
 * 4/16/19 - Implemented Blue Moon Guild
 * 4/18/19 - Added kill skeletons quest
 * 4/20/19 - Implemented accepting quests
 * 4/20/19 - Fixed attack bug
 * 6/27/19 - Finished displaying equipment rarity
 * 6/27/19 - Fixed Blue Moon General bug
 * 6/27/19 - Fixed Blue Moon Guild bug
 */

/**
 * 2/6/19
 * @author Sean Geraets
 */
/**
 * Bug List
 * 4/20/19 - Players attack at level 1 is 0 instead of 5 - Fixed
 * 6/27/19 - Blue Moon General Store doesnt have an exit option after you try and buy an item - fixed
 * 6/27/19 - Blue Moon Guild doesnt tell you what to enter when accepting quests - fixed 
 * 
 * @author Sean
 */
public class ImprovedJavaRPG {

    public static void main(String[] args) {
        //Array that stores the main menu
        String [] mainMenu = {"Main Menu", "Search", "Stats", "Spells", "Bag", "Quests", "Shop", "Test", "Exit"};
        //Array that stores the shop menu
        String [] shopMenu = {"Shop Menu", "Buy", "Sell", "Exit"};
        //Array that stores the battle menu
        String [] battleMenu = {"Battle Menu", "Attack", "Run"};
        //Array that stores the bag menu
        String [] bagMenu = {"Bag Menu", "Equip", "Use", "Exit"};
        //Array that stores the spell menu
        String [] spellMenu = {"Spell Menu", "Exit"};
        //Array that stores the stat menu
        String [] statMenu = {"Stat Menu", "Allocate Stats", "Exit"};
        //Array that stores the quest menu
        String [] questMenu = {"Quest Menu", "Check", "Exit"};
        //Array that stores the allocate stat menu
        String [] allocateStatMenu = {"Allocate Stats Menu", "Strength", "Intelligence", "Vitality", "Cancel"};
        //Array that stores the blue moon city menu
        String [] blueMoonMenu = {"Blue Moon City", "General Goods", "Blacksmith", "Magic Shop", "Guild", "Exit"};
        //Array that holds the blue moon general menu
        String [] blueMoonGeneralMenu = {"Blue Moon General Goods", "Buy", "Sell", "Exit"};
        //Array that stores the blue moon blacksmith menu
        String [] blueMoonBlacksmithMenu = {"Blue Moon Blacksmith", "Buy", "Sell", "Exit"};
        //Array that stores the blue moon guild menu
        String [] blueMoonGuildMenu = {"Blue Moon Guild", "Accept", "Drop", "Turn-In", "Exit"};
    
        //Variable for the user choice
        String userChoice;
        Random rand = new Random();
        //Variable to keep the program running
        Boolean done = false;
        //Instantiates the player
        player player1 = new player();
        //Gets the player's character name
        player1.setPlayerName(getUserName());
        //Loop that keeps the program running until exited
        while(!done){
            //Variable for the level up loop
            Boolean doneLevel = false;
            //Calculates the players defense
            player1.setTotalDefense(playerTotalDefense(player1.getPlayerHelmet(), player1.getPlayerChestPlate(), player1.getPlayerGloves(), player1.getPlayerBoots(), player1.getPlayerDefense()));
            //Calculates the players attack
            player1.setTotalAttack(playerTotalAttack(player1.getPlayerWeapon(), player1.getPlayerAttack(), player1.getStrength()));
            //Checks to see if they player has leveled up
            while(!doneLevel){
                if(player1.getPlayerExperience() > (player1.getPlayerLevel() * 100)){
                    //Increases the player's level by 1
                    player1.setPlayerLevel(levelUp(player1.getPlayerLevel()));
                    //Subtracts the experience for the level up
                    player1.setPlayerExperience((player1.getPlayerExperience() - ((player1.getPlayerLevel() - 1) * 100)));
                    //Adds a stat point upon level up
                    player1.setStatPoints(gainStatPoints(player1.getStatPoints()));
                    //Fully heals the player
                    player1.setPlayerCurrentHealth(player1.getPlayerMaxHealth());
                    //Fully restores the players mp
                    player1.setCurrentMP(player1.getMaxMP());
                }else{
                    doneLevel = true;
                }
            }
            //Array that stores the player's stats
            Object [] playerStats = {player1.getPlayerName(), player1.getPlayerLevel(), player1.getPlayerExperience(), player1.getPlayerCurrentHealth(), player1.getPlayerMaxHealth(),
                player1.getCurrentMP(), player1.getMaxMP(), player1.getTotalAttack(), player1.getTotalDefense(), player1.getStrength(),
                player1.getIntelligence(), player1.getVitality(), player1.getStatPoints(), player1.getPlayerGold()};
            //Displays the main menu and gets the user decision
            userChoice = getUserChoice(mainMenu);
            //Determines the next course of action
            switch(userChoice){
//******************************************************************************************************************************
                //Starts the battle sequence
                case "1":
                    //Boolean for the battle sequence
                    Boolean battle = true;
                    //Variable to hold the item dropped after monster death
                    String loot;
                    //Variable to hold which encounter was picked
                    String encounterHolder;
                    //Holds the encounter
                    encounterHolder = encounter(player1.getPlayerLevel());
                    switch(encounterHolder){
//******************************************************************************************************************************
                        //Found a skeleton
                        case "Skeleton":
                            //Instantiates a skeleton
                            skeleton Skeleton = new skeleton();
                            //Scales skeleton max health based on player level
                            Skeleton.setSkeletonMaxHealth(skeletonHealthScale(Skeleton.getSkeletonMaxHealth(), player1.getPlayerLevel()));
                            //Puts the skeleton at full health
                            Skeleton.setSkeletonCurrentHealth(Skeleton.getSkeletonMaxHealth());
                            //Scales skeleton attack based on player level
                            Skeleton.setSkeletonAttack(skeletonAttackScale(Skeleton.getSkeletonAttack(), player1.getPlayerLevel()));
                            //Starts the battle loop
                            while(battle){
                                //Displays the battle menu
                                userChoice = getUserChoice(battleMenu);
                                //Checks the user decision
                                switch(userChoice){
//******************************************************************************************************************************
                                    //Attack option
                                    case "1":
                                        //Lists the potential attacks the player can make
                                        System.out.println("\t1) Basic Attack");
                                        for(int i = 0; i < player1.getSpellList().length; i++){
                                            if(player1.spellList[i].equals("")){
                                                break;
                                            }else{
                                                System.out.println("\t" + (i + 2) + ") " + player1.spellList[i]);
                                            }
                                        }
                                        //Gets the user decision
                                        userChoice = getUserInput("What attack do you want to do? \n(Type the name of the attack)");
                                        switch(userChoice){
//******************************************************************************************************************************
                                            //Basic Attack option
                                            case "Basic Attack":
                                                //Calculates the remaining health of the skeleton
                                                Skeleton.setSkeletonCurrentHealth(Skeleton.getSkeletonCurrentHealth() - playerDamageDealt(player1.getTotalAttack(), Skeleton.getSkeletonDefense())); 
                                                //Tells the user how much damage they dealt to the skeleton
                                                System.out.println("You dealt " + playerDamageDealt(player1.getTotalAttack(), Skeleton.getSkeletonDefense()) + " damage to the Skeleton!"); 
                                                //Tells the user how much health the skeleton has remaining
                                                System.out.println("The Skeleton has " + Skeleton.getSkeletonCurrentHealth() + "/" + Skeleton.getSkeletonMaxHealth() + " health left!"); 
                                                //Basic Attack break
                                                break;
//******************************************************************************************************************************
                                            //Fireball option
                                            case "Fireball":
                                                //Creates fireball spell
                                                fireball Fireball = new fireball();
                                                //Calculates the fireball damage and calculates the skeleton health after taking damage
                                                Skeleton.setSkeletonCurrentHealth(Skeleton.getSkeletonCurrentHealth() - fireballDamageScale(Fireball.getBaseDamage(), player1.getPlayerLevel()));
                                                //Tells the player how much damage they dealt
                                                System.out.println("You dealt " + fireballDamageScale(Fireball.getBaseDamage(), player1.getPlayerLevel()) + " damage with Fireball to the Skeleton");
                                                //Tells the user how much health the skeleton has remaining
                                                System.out.println("The Skeleton has " + Skeleton.getSkeletonCurrentHealth() + "/" + Skeleton.getSkeletonMaxHealth() + " health left!"); 
                                                //Reduces the players mp
                                                player1.setCurrentMP(player1.getCurrentMP() - fireballMPScale(Fireball.getMpCost(), player1.getPlayerLevel()));
                                                //Fireball break
                                                break;
                                            default:
                                                System.out.println("Invalid option. Try again.");
                                        }
//******************************************************************************************************************************
                                        //Calculates the remaining health of the player
                                        player1.setPlayerCurrentHealth(player1.getPlayerCurrentHealth() - monsterDamageDealt(Skeleton.getSkeletonAttack(), player1.getTotalDefense())); 
                                        //Tells the player how much damage the skeleton dealto to the player
                                        System.out.println("The Skeleton dealt " + monsterDamageDealt(Skeleton.getSkeletonAttack(), player1.getTotalDefense()) + " damage to you!"); 
                                         //Tells the user how much health they have left
                                        System.out.println("You have " + player1.getPlayerCurrentHealth() + "/" + player1.getPlayerMaxHealth() + " health left!");
                                        System.out.println("You have " + player1.getCurrentMP() + "/" + player1.getMaxMP() + " MP");
//******************************************************************************************************************************
                                        //Checks if skeleton is dead
                                        if(Skeleton.getSkeletonCurrentHealth() <= 0){
                                            //Ends the battle while loop
                                            battle = false;
                                            //Tells the user they have killed the enemy
                                            System.out.println("You have killed the Skeleton!");
                                            //Tells the user how much gold they gained
                                            System.out.println("You gained " + Skeleton.getSkeletonGoldDropped() + " gold");
                                            //Adds the gold to the users gold amount
                                            player1.setPlayerGold(player1.getPlayerGold() + skeletonGoldScale(Skeleton.getSkeletonGoldDropped(), player1.getPlayerLevel()));
                                            //Tells the user how much experience they have gained
                                            System.out.println("You gain " + Skeleton.getSkeletonExperience() + " experience!");
                                            //Calculates the player's experience
                                            player1.setPlayerExperience (experienceTally(player1.getPlayerExperience(), Skeleton.getSkeletonExperience()));
                                            //Function is called to determine the item dropped and stores it in variable
                                            loot = itemDrop(rand.nextInt(5));
                                            //Checks to see if an item was actually dropped
                                            if(loot.equals("")){
                                                //Tells the user that no item was dropped
                                                System.out.println("No item dropped.");
                                            }else{                         
                                                //Places the item in the first open space in the player's inventory
                                                player1.setPlayerBag(placeInBag(loot,player1.getPlayerBag()));
                                                //Tells the user which item they god
                                                System.out.println("You got: " + loot + "!");
                                            }
                                        }
//******************************************************************************************************************************
                                        //Checks if the player has died
                                        if(player1.getPlayerCurrentHealth() <= 0){
                                            System.out.println("You have died");
                                            //Exits the battle sequence
                                            battle = false;
                                            //Ends the game
                                            done = true;
                                        }
                                        //Attack option 1 break
                                        break;
//******************************************************************************************************************************
                                    //Run option
                                    case "2":
                                        //Runs from the battle and goes back to the main menu
                                        System.out.println("You have fled from the " + encounterHolder);
                                        //Ends the battle sequence
                                        battle = false;
                                        //Run option 2 break
                                        break;
                                    default:
                                        System.out.println("Invalid option. Try again.");
                                }
                            }
                            //Skeleton encounter break
                            break;
//******************************************************************************************************************************
                        //Devil encounter
                        case "Devil":
                            //Creates a devil
                            devil Devil = new devil();
                            //Scales skeleton max health based on player level
                            Devil.setDevilMaxHealth(devilHealthScale(Devil.getDevilMaxHealth(), player1.getPlayerLevel()));
                            //Puts the skeleton at full health
                            Devil.setDevilCurrentHealth(Devil.getDevilMaxHealth());
                            //Scales skeleton attack based on player level
                            Devil.setDevilAttack(devilAttackScale(Devil.getDevilAttack(), player1.getPlayerLevel()));
                            //Starts the battle loop
                            while(battle){
                                //Displays the battle menu
                                userChoice = getUserChoice(battleMenu);
                                //Checks the user decision
                                switch(userChoice){
//******************************************************************************************************************************
                                    //Attack option
                                    case "1":
                                        //Lists the potential attacks the player can make
                                        System.out.println("\t1) Basic Attack");
                                        for(int i = 0; i < player1.getSpellList().length; i++){
                                            if(player1.spellList[i].equals("")){
                                                break;
                                            }else{
                                                System.out.println("\t" + (i + 2) + ") " + player1.spellList[i]);
                                            }
                                        }
                                        //Gets the user decision
                                        userChoice = getUserInput("What attack do you want to do? \n(Type the name of the attack)");
                                        switch(userChoice){
//******************************************************************************************************************************
                                            //Basic Attack option
                                            case "Basic Attack":
                                                //Calculates the remaining health of the devil
                                                Devil.setDevilCurrentHealth(Devil.getDevilCurrentHealth() - playerDamageDealt(player1.getTotalAttack(), Devil.getDevilDefense())); 
                                                //Tells the user how much damage they dealt to the devil
                                                System.out.println("You dealt " + playerDamageDealt(player1.getTotalAttack(), Devil.getDevilDefense()) + " damage to the Devil!"); 
                                                //Tells the user how much health the devil has remaining
                                                System.out.println("The Devil has " + Devil.getDevilCurrentHealth() + "/" + Devil.getDevilMaxHealth() + " health left!"); 
                                                //Basic Attack break
                                                break;
//******************************************************************************************************************************
                                            //Fireball option
                                            case "Fireball":
                                                //Creates fireball spell
                                                fireball Fireball = new fireball();
                                                //Calculates the fireball damage and calculates the devil health after taking damage
                                                Devil.setDevilCurrentHealth(Devil.getDevilCurrentHealth() - fireballDamageScale(Fireball.getBaseDamage(), player1.getPlayerLevel()));
                                                //Tells the user how much health the devil has remaining
                                                System.out.println("The Devil has " + Devil.getDevilCurrentHealth() + "/" + Devil.getDevilMaxHealth() + " health left!"); 
                                                //Tells the player how much damage they dealt
                                                System.out.println("You dealt " + fireballDamageScale(Fireball.getBaseDamage(), player1.getPlayerLevel()) + " damage with Fireball to the Devil");
                                                //Reduces the players mp
                                                player1.setCurrentMP(player1.getCurrentMP() - fireballMPScale(Fireball.getMpCost(), player1.getPlayerLevel()));
                                                //Fireball break
                                                break;
                                            default:
                                                System.out.println("Invalid option. Try again.");
                                        }
//******************************************************************************************************************************
                                        //Calculates the remaining health of the player
                                        player1.setPlayerCurrentHealth(player1.getPlayerCurrentHealth() - monsterDamageDealt(Devil.getDevilAttack(), player1.getTotalDefense())); 
                                        //Tells the player how much damage the devil dealt to the player
                                        System.out.println("The Devil dealt " + monsterDamageDealt(Devil.getDevilAttack(), player1.getTotalDefense()) + " damage to you!"); 
                                         //Tells the user how much health they have left
                                        System.out.println("You have " + player1.getPlayerCurrentHealth() + "/" + player1.getPlayerMaxHealth() + " health left!");
                                        System.out.println("You have " + player1.getCurrentMP() + "/" + player1.getMaxMP() + " MP");
//******************************************************************************************************************************
                                        //Checks if the devil died
                                        if(Devil.getDevilCurrentHealth() <= 0){
                                            //Ends the battle while loop
                                            battle = false;
                                            //Tells the user they have killed the enemy
                                            System.out.println("You have killed the Devil!");
                                            //Tells the user how much gold they gained
                                            System.out.println("You gained " + Devil.getDevilGold() + " gold");
                                            //Adds the gold to the users gold amount
                                            player1.setPlayerGold(player1.getPlayerGold() + devilGoldScale(Devil.getDevilGold(), player1.getPlayerLevel()));
                                            //Tells the user how much experience they have gained
                                            System.out.println("You gain " + Devil.getDevilExperience() + " experience!");
                                            //Calculates the player's experience
                                            player1.setPlayerExperience (experienceTally(player1.getPlayerExperience(), Devil.getDevilExperience()));
                                            //Function is called to determine the item dropped and stores it in variable
                                            loot = itemDrop(rand.nextInt(5));
                                            //Checks to see if an item was actually dropped
                                            if(loot.equals("")){
                                                //Tells the user that no item was dropped
                                                System.out.println("No item dropped.");
                                            }else{                         
                                                //Places the item in the first open space in the player's inventory
                                                player1.setPlayerBag(placeInBag(loot,player1.getPlayerBag()));
                                                //Tells the user which item they god
                                                System.out.println("You got: " + loot + "!");
                                            }
                                        }
//******************************************************************************************************************************
                                        //Checks if the player has died
                                        if(player1.getPlayerCurrentHealth() <= 0){
                                            System.out.println("You have died");
                                            //Exits the battle sequence
                                            battle = false;
                                            //Ends the game
                                            done = true;
                                        }
                                        //Attack option break
                                        break;
//******************************************************************************************************************************
                                    //Run option
                                    case "2":
                                        //Runs from the battle and goes back to the main menu
                                        System.out.println("You have fled from the " + encounterHolder);
                                        //Ends the battle sequence
                                        battle = false;
                                        //Run option 2 break
                                        break;
                                    default:
                                        System.out.println("Invalid option. Try again.");
                                }
                            }
                            //Devil encounter break
                            break;
//******************************************************************************************************************************
                        case "Blue Moon City":
                            Boolean visit = false;
                            while(!visit){
                                userChoice = getUserChoice(blueMoonMenu);
                                switch(userChoice){
//******************************************************************************************************************************
                                    //General Goods option
                                    case "1":
                                        blueMoonGeneralGoods BlueMoonGeneral = new blueMoonGeneralGoods();
                                        //Creates healing potion
                                        healingPotion HealingPotion = new healingPotion();
                                        //Creates greater healing potion
                                        greaterHealingPotion GreaterHealingPotion = new greaterHealingPotion();
                                        //Populates the shopkeeper's inventory with items
                                        BlueMoonGeneral.setInventory(populateBlueMoonGeneral(BlueMoonGeneral.getInventory()));
                                        //Displays the shop menu and asks the player what they want to do
                                        userChoice = getUserChoice(blueMoonGeneralMenu);
                                        //Variable for shop loop
                                        Boolean shopExit = false;
                                        while(!shopExit){
                                            switch(userChoice){
//******************************************************************************************************************************
                                                //Buy Item
                                                case "1":
                                                    //Diplays the shop keeper inventory
                                                    displayShopInventory(BlueMoonGeneral.getInventory());
                                                    //Gets what item the user wants to buy
                                                    String buyChoice = getUserInput("What item do you want to buy? \n(Type the name of the item)");
                                                    switch(buyChoice){
//******************************************************************************************************************************
                                                        //Buy Healing Potion
                                                        case "Healing Potion":
                                                            //Checks to see if the player has the gold to buy the healing potion
                                                            if(player1.getPlayerGold() >= HealingPotion.getHealingPotionBuyPrice()){
                                                                //Subtracts the price of the healing potion from the player's gold total
                                                                player1.setPlayerGold(player1.getPlayerGold() - HealingPotion.getHealingPotionBuyPrice());
                                                                //Puts the healing potion in the player's bag
                                                                player1.setPlayerBag(placeInBag("Healing Potion", player1.playerBag));
                                                                //Tells the player they bought a healing potion
                                                                System.out.println("You bought Healing Potion");
                                                                //Quits the shop
                                                                shopExit = true;
                                                                //Healing Potion option break
                                                                break;
                                                            //If the player doesnt have the gold to buy a healing potino
                                                            }else if(buyChoice.equals("Healing Potion") && (player1.getPlayerGold() < HealingPotion.getHealingPotionBuyPrice())){
                                                                //Tells the player they dont have the gold to buy a healing player
                                                                System.out.println("You do not have the gold to buy that item!");
                                                                //Quits the shop
                                                                shopExit = true;
                                                                //Healing Potion option break
                                                                break;
                                                            } 
//******************************************************************************************************************************
                                                        //Buy Greater Healing Potion
                                                        case "Greater Healing Potion":
                                                            //Checks to see if the player has the gold to buy a greater healing potion
                                                            if(player1.getPlayerGold() >= GreaterHealingPotion.getGreaterHealingPotionBuyPrice()){
                                                                //Subtracts the price of the greater healing potino from the players gold total
                                                                player1.setPlayerGold(player1.getPlayerGold() - GreaterHealingPotion.getGreaterHealingPotionBuyPrice());
                                                                //Places the greater healing potion in the players bag
                                                                player1.setPlayerBag(placeInBag("Greater Healing Potion", player1.playerBag));
                                                                //Tells the player they bought a greater healing potion
                                                                System.out.println("You bought Greater Healing Potion");
                                                                //Quits the shop
                                                                shopExit = true;
                                                                //Greater Healing Potion option break
                                                                break;
                                                            //If they player doesnt have the gold to buy a greater healing potion
                                                            }else if(buyChoice.equals("Greater Healing Potion") && (player1.getPlayerGold() < GreaterHealingPotion.getGreaterHealingPotionBuyPrice())){
                                                                //Tells the player they dont have the gold to buy a greater healing potion
                                                                System.out.println("You do not have the gold to buy that item!");
                                                                //Quits the shop
                                                                shopExit = true;
                                                                //Greater Healing Potion option break
                                                                break;
                                                            }
                                                        case "Exit":
                                                            shopExit = true;
                                                            break;
                                                        default:
                                                            System.out.println("Invalid option. Try again.");
                                                    }
                                                    //Buy option 1 break
                                                    break;
//******************************************************************************************************************************
                                                //Sell Item
                                                case "2":
                                                    //Variable to hold which item is being sold
                                                    String itemSold;
                                                    //Displays the items in the bag and asks for which item to sell
                                                    itemSold = displayItemFromBag(player1.playerBag, "Sell");
                                                    //Adds the value of the sold item to the player's gold
                                                    player1.setPlayerGold(player1.getPlayerGold() + sellGold(itemSold));
                                                    //Removes the sold item from the player's bag
                                                    player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemSold));
                                                    //Tells the player which item they sold and how much gold they gained
                                                    System.out.println("You sold: " + itemSold);
                                                    System.out.println("You gained: " + sellGold(itemSold) + " gold");
                                                    shopExit = true;
                                                    //Sell option 2 break
                                                    break;
//******************************************************************************************************************************
                                                //Exit Item
                                                case "3":
                                                    shopExit = true;
                                                    //Sell option 3 break
                                                    break;
                                                default:
                                                    System.out.println("Invalid option. Try again.");
                                                    shopExit = true;
                                                    break;
                                            }
                                        }
                                        //Blue Moon General Goods option 1 break
                                        break;
//******************************************************************************************************************************
                                    //Blacksmith option
                                    case "2":
                                        blueMoonBlacksmith BlueMoonBlacksmith = new blueMoonBlacksmith();
                                        //Creates iron helmet
                                        ironHelmet IronHelmet = new ironHelmet();
                                        //Creates iron chest plate
                                        ironChestPlate IronChestPlate = new ironChestPlate();
                                        //Creates iron gloves
                                        ironGloves IronGloves = new ironGloves();
                                        //Creates iron boots
                                        ironBoots IronBoots = new ironBoots();
                                        //Populates the shopkeeper's inventory with items
                                        BlueMoonBlacksmith.setInventory(populateBlueMoonBlacksmith(BlueMoonBlacksmith.getInventory()));
                                        //Displays the shop menu and asks the player what they want to do
                                        displayShopInventory(BlueMoonBlacksmith.getInventory());
                                        userChoice = getUserChoice(blueMoonBlacksmithMenu);
                                        //Variable for shop loop
                                        Boolean blacksmithExit = false;
                                        while(!blacksmithExit){
                                            switch(userChoice){
//******************************************************************************************************************************
                                                //Buy Item
                                                case "1":
                                                    //Diplays the blacksmith inventory
                                                    displayShopInventory(BlueMoonBlacksmith.getInventory());
                                                    //Gets what item the user wants to buy
                                                    String buyChoice = getUserInput("What item do you want to buy? \n(Type the name of the item)");
                                                    switch(buyChoice){
//******************************************************************************************************************************
                                                        //Buy Iron Helmet
                                                        case "Iron Helmet":
                                                            //Checks to see if the player has the gold to buy the iron helmet
                                                            if(player1.getPlayerGold() >= IronHelmet.getBuyPrice()){
                                                                //Subtracts the price of the iron helmet from the player's gold total
                                                                player1.setPlayerGold(player1.getPlayerGold() - IronHelmet.getBuyPrice());
                                                                //Puts the iron helmet in the player's bag
                                                                player1.setPlayerBag(placeInBag("Iron Helmet", player1.playerBag));
                                                                //Tells the player they bought a iron helmet
                                                                System.out.println("You bought Iron Helmet");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Helmet option break
                                                                break;
                                                            //If the player doesnt have the gold to buy a iron helmet
                                                            }else if(buyChoice.equals("Iron Helmet") && (player1.getPlayerGold() < IronHelmet.getBuyPrice())){
                                                                //Tells the player they dont have the gold to buy a iron helmet
                                                                System.out.println("You do not have the gold to buy that item!");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Healing Potion option break
                                                                break;
                                                            } 
//******************************************************************************************************************************
                                                        //Buy Iron Chest Plate
                                                        case "Iron Chest Plate":
                                                            //Checks to see if the player has the gold to buy a iron boots
                                                            if(player1.getPlayerGold() >= IronChestPlate.getBuyPrice()){
                                                                //Subtracts the price of the iron chest plate from the players gold total
                                                                player1.setPlayerGold(player1.getPlayerGold() - IronChestPlate.getBuyPrice());
                                                                //Places the iron chest plate in the players bag
                                                                player1.setPlayerBag(placeInBag("Iron Chest Plate", player1.playerBag));
                                                                //Tells the player they bought a iron chest plate
                                                                System.out.println("You bought Iron Chest Plate");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Boots option break
                                                                break;
                                                            //If they player doesnt have the gold to buy a iron chest plate
                                                            }else if(buyChoice.equals("Iron Chest Plate") && (player1.getPlayerGold() < IronChestPlate.getBuyPrice())){
                                                                //Tells the player they dont have the gold to buy a iron chest plate
                                                                System.out.println("You do not have the gold to buy that item!");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Chest Plate option break
                                                                break;
                                                            }
                                                        //Buy iron boots
                                                        case "Iron Boots":
                                                            //Checks to see if the player has the gold to buy a iron boots
                                                            if(player1.getPlayerGold() >= IronBoots.getBuyPrice()){
                                                                //Subtracts the price of the iron boots from the players gold total
                                                                player1.setPlayerGold(player1.getPlayerGold() - IronBoots.getBuyPrice());
                                                                //Places the iron boots in the players bag
                                                                player1.setPlayerBag(placeInBag("Iron Boots", player1.playerBag));
                                                                //Tells the player they bought a iron boots
                                                                System.out.println("You bought Iron Boots");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Boots option break
                                                                break;
                                                            //If they player doesnt have the gold to buy a iron boots
                                                            }else if(buyChoice.equals("Iron Boots") && (player1.getPlayerGold() < IronBoots.getBuyPrice())){
                                                                //Tells the player they dont have the gold to buy a iron boots
                                                                System.out.println("You do not have the gold to buy that item!");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Boots option break
                                                                break;
                                                            }
                                                        case "Iron Gloves":
                                                            //Checks to see if the player has the gold to buy a iron gloves
                                                            if(player1.getPlayerGold() >= IronGloves.getBuyPrice()){
                                                                //Subtracts the price of the iron gloves from the players gold total
                                                                player1.setPlayerGold(player1.getPlayerGold() - IronGloves.getBuyPrice());
                                                                //Places the iron gloves in the players bag
                                                                player1.setPlayerBag(placeInBag("Iron Gloves", player1.playerBag));
                                                                //Tells the player they bought a iron gloves
                                                                System.out.println("You bought Iron Gloves");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Gloves option break
                                                                break;
                                                            //If they player doesnt have the gold to buy a iron gloves
                                                            }else if(buyChoice.equals("Iron Gloves") && (player1.getPlayerGold() < IronGloves.getBuyPrice())){
                                                                //Tells the player they dont have the gold to buy a iron gloves
                                                                System.out.println("You do not have the gold to buy that item!");
                                                                //Quits the shop
                                                                blacksmithExit = true;
                                                                //Iron Chest Plate option break
                                                                break;
                                                            }
                                                        default:
                                                            System.out.println("Invalid option. Try again.");
                                                            break;   
                                                    }
                                                    //Buy option 1 break
                                                    break;
//******************************************************************************************************************************
                                                //Sell Item
                                                case "2":
                                                    //Variable to hold which item is being sold
                                                    String itemSold;
                                                    //Displays the items in the bag and asks for which item to sell
                                                    itemSold = displayItemFromBag(player1.playerBag, "Sell");
                                                    //Adds the value of the sold item to the player's gold
                                                    player1.setPlayerGold(player1.getPlayerGold() + sellGold(itemSold));
                                                    //Removes the sold item from the player's bag
                                                    player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemSold));
                                                    //Tells the player which item they sold and how much gold they gained
                                                    System.out.println("You sold: " + itemSold);
                                                    System.out.println("You gained: " + sellGold(itemSold) + " gold");
                                                    blacksmithExit = true;
                                                    //Sell option 2 break
                                                    break;
//******************************************************************************************************************************
                                                //Exit Item
                                                case "3":
                                                    blacksmithExit = true;
                                                    //Sell option 3 break
                                                    break;
                                                default:
                                                    System.out.println("Invalid option. Try again.");
                                                    blacksmithExit = true;
                                                    break;
                                            }
                                        }
                                        //Blue Moon Blacksmith option 1 break
                                        break;
//******************************************************************************************************************************
                                    //Magic Shop option
                                    case "3":
                                        //Blue Moon Magic Shop option 3 break
                                        break;
//******************************************************************************************************************************
                                    //Guild option
                                    case "4":
                                        blueMoonGuild BlueMoonGuild = new blueMoonGuild();
                                        //Populates the shopkeeper's inventory with items
                                        BlueMoonGuild.setQuestList(populateBlueMoonGuild(BlueMoonGuild.getQuestList()));
                                        //Displays the guild menu and asks the player what they want to do
                                        userChoice = getUserChoice(blueMoonGuildMenu);
                                        //Variable for guild loop
                                        Boolean guildExit = false;
                                        while(!guildExit){
                                            switch(userChoice){
//******************************************************************************************************************************
                                                //Accept Quest
                                                case "1":
                                                    displayQuestList(BlueMoonGuild.getQuestList());
                                                    String questChoice = getUserInput("What quest do you want to accept? Type in the name of the quest.");
                                                    switch(questChoice){
                                                        case "Kill Skeletons":
                                                            player1.setQuestList(placeQuest(player1.getQuestList(), "Kill Skeletons"));
                                                            System.out.println("You have accepted the quest: Kill Skeletons");
                                                            guildExit = true;
                                                            break;
                                                    }
                                                    //Accept quest option 1 break
                                                    break;
//******************************************************************************************************************************
                                                //Drop Quest
                                                case "2":
                                                    //Drop quest option 2 break
                                                    break;
//******************************************************************************************************************************
                                                //Turn in quest option 
                                                case "3":
                                                    break;
                                                case "4":
                                                    guildExit = true;
                                                    break;
                                                default:
                                                    System.out.println("Invalid option. Try again.");
                                                    break;
                                            }
                                        }
                                        //Blue Moon Magic Shop option 4 break
                                        break;
//******************************************************************************************************************************
                                    //Exit option
                                    case "5":
                                        visit = true;
                                        //Blue Moon Exit option 5 break
                                        break;
                                    default:
                                        System.out.println("Invalid option. Try again.");
                                }
                            }
                            //Blue Moon Encounter break;
                            break;
                        default:
                            //Encounter break
                            break;
                    }
                    //Search option 1 break
                    break;
//******************************************************************************************************************************
                //Starts the stats sequence
                case "2":
                    //Displays the player stats
                    displayPlayerStats(playerStats, player1.getPlayerHelmet(), player1.getPlayerChestPlate(), player1.getPlayerWeapon(), player1.getPlayerGloves(), player1.getPlayerBoots());
                    userChoice = getUserChoice(statMenu);
                    switch(userChoice){
//******************************************************************************************************************************
                        //Allocate Stats option
                        case "1":
                            userChoice = getUserChoice(allocateStatMenu);
                            switch(userChoice){
//******************************************************************************************************************************
                                //Add Strength
                                case "1":
                                    //Checks to see if the player has a stat point to spend
                                    if(player1.getStatPoints() > 0){
                                        //Removes stat point
                                        player1.setStatPoints(removeStatPoints(player1.getStatPoints()));
                                        //Increases strength by 1
                                        player1.setStrength(gainStrength(player1.getStrength()));    
                                    }else{
                                        //Tells the player they dont have any stat points to spend
                                        System.out.println("You don't have any stat points to allocate.");
                                    }
                                    //Strength option 1 break
                                    break;
//******************************************************************************************************************************
                                //Add Intelligence
                                case "2":
                                    //Checks to see if the player has a stat point to spend
                                    if(player1.getStatPoints() > 0){
                                        //Removes stat point
                                        player1.setStatPoints(removeStatPoints(player1.getStatPoints()));
                                        //Increases intelligence by 1
                                        player1.setIntelligence(gainIntelligence(player1.getIntelligence()));
                                        //Increases the players max mp based on intelligence
                                        player1.setMaxMP(maxMp(player1.getMaxMP()));
                                    }else{
                                        //Tells the player they dont have any stat points to spend
                                        System.out.println("You don't have any stat points to allocate.");
                                    }
                                    //Intelligence option 2 break
                                    break;
//******************************************************************************************************************************
                                //Add Vitality
                                case "3":
                                    //Checks to see if the player has a stat point to spend
                                    if(player1.getStatPoints() > 0){
                                        //Removes stat point
                                        player1.setStatPoints(removeStatPoints(player1.getStatPoints()));
                                        //Increases vitality by 1
                                        player1.setVitality(gainVitality(player1.getVitality()));
                                        //Increases the players max health base on vitality
                                        player1.setPlayerMaxHealth(maxHealth(player1.getPlayerMaxHealth()));
                                    }else{
                                        //Tells the player they dont have any stat points to spend
                                        System.out.println("You don't have any stat points to allocate.");
                                    }
                                    //Vitality opion 3 break
                                    break;
//******************************************************************************************************************************
                                //Cancel
                                case "4":
                                    //Cancel option 4 break
                                    break;
                                default:
                                    System.out.println("Invalid option. Try again.");
                            }
                            //Allocate stats option 1 break
                            break;
//******************************************************************************************************************************
                        //Exits the stat menu
                        case "2":
                            //Exit option 2 break
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                    //Stats option 2 break
                    break;
//******************************************************************************************************************************
                case "3":
                    //Variable to store spell exit
                    Boolean spellExit = false;
                    //Loop to display spell list
                    while(!spellExit){
                        //Display spell list
                        displayBag(player1.getSpellList());
                        //Get user choice
                        userChoice = getUserChoice(spellMenu);
                        switch(userChoice){
                            //Exit option
                            case "1":
                                spellExit = true;
                                //Exit option 1 break
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    //Spells option 3 break
                    break;
//******************************************************************************************************************************
                //Starts the bag sequence
                case "4":
                    //Variable for the bag sequence
                    Boolean bagExit = false;
                    //Variable to hold which item to equip
                    String itemChosen;
                    //Variable to hold which item was in the equipment slot
                    String previousItem;
                    //Enters the bag sequence based on user response
                    while(!bagExit){
                        //Displays the player's bag
                        displayBag(player1.getPlayerBag());
                        //Displays the bag menu
                        userChoice = getUserChoice(bagMenu);
                        //Checks user choice
                        switch(userChoice){
                            //Equip an item sequence
                            case "1":
                                //Runs function to choose an item to equip
                                itemChosen = displayItemFromBag(player1.playerBag, "Equip");
                                //Checks which item was chosen to equip
                                switch(itemChosen){
//******************************************************************************************************************************
                                    //If helmet was chosen to equip
                                    case "Leather Helmet":
                                        //Checks to see if a helmet is already equipped
                                        if(!player1.playerHelmet[0].equals("")){
                                            //Puts the already equipped item in a variable
                                            previousItem = player1.playerHelmet[0];
                                            //Puts the previously equipped item into the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerHelmet[0] = itemChosen;
                                            //Removes the newly equipped item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the item chosen
                                            player1.playerHelmet[0] = itemChosen;
                                            //Removes the item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Leather Helmet");
                                        //Helmet option break
                                        break;
//******************************************************************************************************************************
                                    //If chest player was chosen to equip
                                    case "Leather Chest Plate":
                                        //Checks to see if a chest plate is already equipped
                                        if(!player1.playerChestPlate[0].equals("")){
                                            //Puts the already equipped item in a variable
                                            previousItem = player1.playerChestPlate[0];
                                            //Puts the previously equipped item into the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerChestPlate[0] = itemChosen;
                                            //Removes the newly equipped item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the item chosen
                                            player1.playerChestPlate[0] = itemChosen;
                                            //Removes the item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Leather Chest Plate");
                                        //Chest Plate option break
                                        break;
//******************************************************************************************************************************
                                    //If short sword was chosen to equip
                                    case "Short Sword":
                                        //Checks to see if a weapon is already equipped
                                        if(!player1.playerWeapon[0].equals("")){
                                            //Puts the already equipped item in a variable
                                            previousItem = player1.playerWeapon[0];
                                            //Puts the previously equipped item into the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerWeapon[0] = itemChosen;
                                            //Removes the newly equipped item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the item chosen
                                            player1.playerWeapon[0] = itemChosen;
                                            //Removes the item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Short Sword");
                                        //Short Sword option break
                                        break;
//******************************************************************************************************************************
                                    //If long sword was chosen to equip
                                    case "Long Sword":
                                        //Checks to see if a weapon is already equipped
                                        if(!player1.playerWeapon[0].equals("")){
                                            //Puts the equipped item in a variable
                                            previousItem = player1.playerWeapon[0];
                                            //Places the previous equipped item in the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerWeapon[0] = itemChosen;
                                            //Removes the new item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped    
                                        }else{
                                            //Equips the selected item
                                            player1.playerWeapon[0] = itemChosen;
                                            //Removes the selected item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Long Sword");
                                        //Long Sword option break
                                        break;
//******************************************************************************************************************************
                                    //If great sword was selected
                                    case "Great Sword":
                                        //Checks to see if a weapon is already equipped
                                        if(!player1.playerWeapon[0].equals("")){
                                            //Puts the equipped item in a variable
                                            previousItem = player1.playerWeapon[0];
                                            //Places the previous equipped item in the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerWeapon[0] = itemChosen;
                                            //Removes the new item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the selected item
                                            player1.playerWeapon[0] = itemChosen;
                                            //Removes the selected item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped GreatSword");
                                        //Great Sword option break
                                        break;
//******************************************************************************************************************************
                                    //If iron helmet was selected
                                    case "Iron Helmet":
                                        //Checks to see if a helmet is already equipped
                                        if(!player1.playerHelmet[0].equals("")){
                                            //Puts the equipped item in a variable
                                            previousItem = player1.playerHelmet[0];
                                            //Places the previous equipped item in the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerHelmet[0] = itemChosen;
                                            //Removes the new item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the selected item
                                            player1.playerHelmet[0] = itemChosen;
                                            //Removes the selected item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Iron Helmet");
                                        //Iron Helmet option break
                                        break;
//******************************************************************************************************************************
                                    //If iron chest plate was selected
                                    case "Iron Chest Plate":
                                        //Checks to see if a chest plate is already equipped
                                        if(!player1.playerChestPlate[0].equals("")){
                                            //Puts the equipped item in a variable
                                            previousItem = player1.playerChestPlate[0];
                                            //Places the previous equipped item in the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerChestPlate[0] = itemChosen;
                                            //Removes the new item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the selected item
                                            player1.playerChestPlate[0] = itemChosen;
                                            //Removes the selected item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Iron Chest Plate");
                                        //Iron Chest Plate option break
                                        break;
//******************************************************************************************************************************
                                    //If iron boots was selected
                                    case "Iron Boots":
                                        //Checks to see if a boots is already equipped
                                        if(!player1.playerBoots[0].equals("")){
                                            //Puts the equipped item in a variable
                                            previousItem = player1.playerBoots[0];
                                            //Places the previous equipped item in the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerBoots[0] = itemChosen;
                                            //Removes the new item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the selected item
                                            player1.playerBoots[0] = itemChosen;
                                            //Removes the selected item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Iron Boots");
                                        //Iron Boots option break
                                        break;
//******************************************************************************************************************************
                                    //If iron gloves was selected
                                    case "Iron Gloves":
                                        //Checks to see if a gloves is already equipped
                                        if(!player1.playerGloves[0].equals("")){
                                            //Puts the equipped item in a variable
                                            previousItem = player1.playerGloves[0];
                                            //Places the previous equipped item in the bag
                                            player1.setPlayerBag(placeInBag(previousItem, player1.getPlayerBag()));
                                            //Equips the new item
                                            player1.playerGloves[0] = itemChosen;
                                            //Removes the new item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //If no item was already equipped
                                        }else{
                                            //Equips the selected item
                                            player1.playerGloves[0] = itemChosen;
                                            //Removes the selected item from the bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        }
                                        //Tells the player the item was equipped
                                        System.out.println("You equipped Iron Gloves");
                                        //Iron Gloves option break
                                        break;
//******************************************************************************************************************************
                                    case "Exit":
                                        //Exit option break
                                        break;
                                    default:
                                        System.out.println("Invalid option. Try again."); 
                                }
                                //Equip option 1 break
                                break;
//******************************************************************************************************************************
                            //Use Item
                            case "2":
                                //Displays the useable items from the bag
                                itemChosen = displayItemFromBag(player1.playerBag, "Use");
                                switch(itemChosen){
//******************************************************************************************************************************
                                    //Use healing potion
                                    case "Healing Potion":
                                        //Creates a healing potion
                                        healingPotion HealingPotion = new healingPotion();
                                        //Checks to see if the player is injured
                                        if(player1.getPlayerCurrentHealth() < player1.getPlayerMaxHealth()){
                                            //Tells the player they used a healing potion
                                            System.out.println("You used " +  itemChosen);
                                            //Removes the healing potion from the players bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                            //Checks if the players missing health is less than the health restored by the healing potion
                                            if((player1.getPlayerMaxHealth() - player1.getPlayerCurrentHealth() < HealingPotion.getHealthGained())){
                                                //Tells the player how much health they gained
                                                System.out.println("You gained " + (player1.getPlayerMaxHealth() - player1.getPlayerCurrentHealth()) + " health");
                                                //Sets the players health to max
                                                player1.setPlayerCurrentHealth(player1.getPlayerMaxHealth());
                                            //If the players missing health is greater than the health restored by the healing potion
                                            }else{
                                                //Tells the player how much health they gained
                                                System.out.println("You gained " + HealingPotion.getHealthGained() + " health");
                                                //Restores the players health by the amount given by the healing potion
                                                player1.setPlayerCurrentHealth(player1.getPlayerCurrentHealth() + HealingPotion.getHealthGained());
                                            }
                                        //If you are not injured
                                        }else{
                                            //Tells the player they cannot use a healing potion
                                            System.out.println("You are at full health and cannot use that item");
                                        }
                                        //Healing Potion option break
                                        break;
//******************************************************************************************************************************
                                    //Use Greater Healing Potion
                                    case "Greater Healing Potion":
                                        //Creates a greater healing potion
                                        greaterHealingPotion GreaterHealingPotion = new greaterHealingPotion();
                                        //Checks to see if the player is injured
                                        if(player1.getPlayerCurrentHealth() < player1.getPlayerMaxHealth()){
                                            //Tells the player they used a greater healing potion
                                            System.out.println("You used " +  itemChosen);
                                            //Removes the greater healing potion from the players bag
                                            player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                            //If the players missing health is less than the health restored by the greater healing potion
                                            if((player1.getPlayerMaxHealth() - player1.getPlayerCurrentHealth() < GreaterHealingPotion.getHealthGained())){
                                                //Tells the player how much health they gained
                                                System.out.println("You gained " + (player1.getPlayerMaxHealth() - player1.getPlayerCurrentHealth()) + " health");
                                                //Restores the player to max health
                                                player1.setPlayerCurrentHealth(player1.getPlayerMaxHealth());
                                            //If they players missing health is greater than the health restored by the greater healing potion
                                            }else{
                                                //Tells the player how much health they gained
                                                System.out.println("You gained " + GreaterHealingPotion.getHealthGained() + " health");
                                                //Restores the players health by the amount given by the greater healing potion
                                                player1.setPlayerCurrentHealth(player1.getPlayerCurrentHealth() + GreaterHealingPotion.getHealthGained());
                                            }
                                        //If the player is not injured
                                        }else{
                                            //Tells the player they cannot use a greater healing potion
                                            System.out.println("You are at full health and cannot use that item");
                                        }
                                        //Greater Healing Potion option break
                                        break;
//******************************************************************************************************************************
                                    case "Scroll of Fireball":
                                        //Removes scroll of fireball from bag
                                        player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemChosen));
                                        //Tells the player they have learned the fireball spell
                                        System.out.println("You have learned: Fireball");
                                        //Add fireball to spell list
                                        player1.setSpellList(placeInBag("Fireball", player1.getSpellList()));
                                        //Scroll of Fireball option break
                                        break;
//******************************************************************************************************************************
                                    case "Exit":
                                        //Exit option break
                                        break;
                                    default:
                                        System.out.println("Invalid Option. Try again.");
                                }//Use option 2 break
                                break;
//******************************************************************************************************************************
                            //Exit
                            case "3":
                                //Exits the bag sequence
                                bagExit = true;
                                //Exit option 3 break
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }//Bag option 4 break
                    break;
//******************************************************************************************************************************
                //Quests Menu
                case "5":
                    Boolean questExit = false;
                    while(!questExit){
                        //Displays the bag menu
                        userChoice = getUserChoice(questMenu);
                        //Checks user choice
                        switch(userChoice){
//******************************************************************************************************************************
                            //Check quest option
                            case "1":
                                //Displays the player's bag
                                displayQuest(player1.getQuestList());
                                String questChoice = getUserInput("Which quest do you want to check? Type in the name of the quest.");
                                String[] questList = new String[16];
                                questList = player1.getQuestList();
                                switch(questChoice){
                                    /*case "Kill Skeletons":
                                        for(int i = 0; i < questList.length; i++){
                                            if(questList[1].getName().equals("Kill Skeletons")){
                                                killSkeletonQuest kSQ = questList[1];
                                                if(kSQ.isQuestComplete().equals("false")){
                                                    System.out.println("Quest Status: Incomplete");
                                                } else {
                                                    System.out.println("Quest Status: Complete");
                                                }
                                            }
                                        }
                                        
                                        System.out.println("");
                                        break;*/
                                }
                                //Check quest option 1 break
                                break;
//******************************************************************************************************************************
                            //Exit option
                            case "2":
                                questExit = true;
                                //Exit option 2 break
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    }
                    break;
//***************************************************************************************************************************
                //Starts the shop sequence
                case "6":
                    //Creates the shopkeeper
                    shopKeeper ShopKeeper = new shopKeeper();
                    //Creates healing potion
                    healingPotion HealingPotion = new healingPotion();
                    //Creates greater healing potion
                    greaterHealingPotion GreaterHealingPotion = new greaterHealingPotion();
                    //Creates long sword
                    longSword LongSword = new longSword();
                    //Creates great sword
                    greatSword GreatSword = new greatSword();
                    //Populates the shopkeeper's inventory with items
                    ShopKeeper.setShopKeeperInventory(populateShopKeeperInventory(ShopKeeper.getShopKeeperInventory()));
                    //Displays the shop menu and asks the player what they want to do
                    userChoice = getUserChoice(shopMenu);
                    //Variable for shop loop
                    Boolean shopExit = false;
                    while(!shopExit){
                        switch(userChoice){
//******************************************************************************************************************************
                            //Buy item
                            case "1":
                                //Diplays the shop keeper inventory
                                displayShopInventory(ShopKeeper.getShopKeeperInventory());
                                //Gets what item the user wants to buy
                                String buyChoice = getUserInput("What item do you want to buy? \n(Type the name of the item)");
                                switch(buyChoice){
//******************************************************************************************************************************
                                    //Buys healing potion
                                    case "Healing Potion":
                                        //Checks to see if the player has the gold to buy the healing potion
                                        if(player1.getPlayerGold() >= HealingPotion.getHealingPotionBuyPrice()){
                                            //Subtracts the price of the healing potion from the player's gold total
                                            player1.setPlayerGold(player1.getPlayerGold() - HealingPotion.getHealingPotionBuyPrice());
                                            //Puts the healing potion in the player's bag
                                            player1.setPlayerBag(placeInBag("Healing Potion", player1.playerBag));
                                            //Tells the player they bought a healing potion
                                            System.out.println("You bought Healing Potion");
                                            //Quits the shop
                                            shopExit = true;
                                            //Healing Potion option break
                                            break;
                                        //If the player doesnt have the gold to buy a healing potino
                                        }else if(buyChoice.equals("Healing Potion") && (player1.getPlayerGold() < HealingPotion.getHealingPotionBuyPrice())){
                                            //Tells the player they dont have the gold to buy a healing player
                                            System.out.println("You do not have the gold to buy that item!");
                                            //Quits the shop
                                            shopExit = true;
                                            //Healing Potion option break
                                            break;
                                        } 
//******************************************************************************************************************************
                                    //Buys a greater healing potion
                                    case "Greater Healing Potion":
                                        //Checks to see if the player has the gold to buy a greater healing potion
                                        if(player1.getPlayerGold() >= GreaterHealingPotion.getGreaterHealingPotionBuyPrice()){
                                            //Subtracts the price of the greater healing potino from the players gold total
                                            player1.setPlayerGold(player1.getPlayerGold() - GreaterHealingPotion.getGreaterHealingPotionBuyPrice());
                                            //Places the greater healing potion in the players bag
                                            player1.setPlayerBag(placeInBag("Greater Healing Potion", player1.playerBag));
                                            //Tells the player they bought a greater healing potion
                                            System.out.println("You bought Greater Healing Potion");
                                            //Quits the shop
                                            shopExit = true;
                                            //Greater Healing Potion option break
                                            break;
                                        //If they player doesnt have the gold to buy a greater healing potion
                                        }else if(buyChoice.equals("Greater Healing Potion") && (player1.getPlayerGold() < GreaterHealingPotion.getGreaterHealingPotionBuyPrice())){
                                            //Tells the player they dont have the gold to buy a greater healing potion
                                            System.out.println("You do not have the gold to buy that item!");
                                            //Quits the shop
                                            shopExit = true;
                                            //Greater Healing Potion option break
                                            break;
                                        }
//***************************************************************************************************************************
                                    //Buys a long sword
                                    case "Long Sword":
                                        //Checks if the player has enough gold to buy a long sword
                                        if(player1.getPlayerGold() >= LongSword.getBuyPrice()){
                                            //Subtracts the price of the long sword from the players gold total
                                            player1.setPlayerGold(player1.getPlayerGold() - LongSword.getBuyPrice());
                                            //Places the long sword in the players bag
                                            player1.setPlayerBag(placeInBag("Long Sword", player1.playerBag));
                                            //Tells the player they bought a long sword
                                            System.out.println("You bought Long Sword");
                                            //Quits the shop
                                            shopExit = true;
                                            //Long Sword option break
                                            break;
                                        //If the player doesnt have the gold to buy a long sword
                                        }else if(buyChoice.equals("Long Sword") && (player1.getPlayerGold() < LongSword.getBuyPrice())){
                                            //Tells the player they dont have the gold to buy a long sword
                                            System.out.println("You do not have the gold to buy that item!");
                                            //Quits the shop
                                            shopExit = true;
                                            //Long Sword option break
                                            break;
                                        }
//****************************************************************************************************************************
                                    //Buys a great sword
                                    case "Great Sword":
                                        //Checks if teh player has enough gold to buy a great sword
                                        if(player1.getPlayerGold() >= GreatSword.getBuyPrice()){
                                            //Subtracts the price of the great sword from the players gold total
                                            player1.setPlayerGold(player1.getPlayerGold() - GreatSword.getBuyPrice());
                                            //Places the great sword in the players bag
                                            player1.setPlayerBag(placeInBag("Great Sword", player1.playerBag));
                                            //Tells the player they bought a great sword
                                            System.out.println("You bought Great Sword");
                                            //Quits the shop
                                            shopExit = true;
                                            //Great Sword option break
                                            break;
                                        //If the player doesnt have the gold to buy a great sword
                                        }else if(buyChoice.equals("Great Sword") && (player1.getPlayerGold() < GreatSword.getBuyPrice())){
                                            //Tells the player they dont have the gold to buy a great sword
                                            System.out.println("You do not have the gold to buy that item!");
                                            //Quits the shop
                                            shopExit = true;
                                            //Great Sword option break
                                            break;
                                        }
                                    //If any other option is typed
                                    default:
                                        System.out.println("Invalid option. Try again.");
                                        shopExit = true;
                                        break;
                                }
                                //Buy option 1 break
                                break;
//****************************************************************************************************************************
                            //Sell item
                            case "2":
                                //Variable to hold which item is being sold
                                String itemSold;
                                //Displays the items in the bag and asks for which item to sell
                                itemSold = displayItemFromBag(player1.playerBag, "Sell");
                                //Adds the value of the sold item to the player's gold
                                player1.setPlayerGold(player1.getPlayerGold() + sellGold(itemSold));
                                //Removes the sold item from the player's bag
                                player1.setPlayerBag(removeFromBag(player1.getPlayerBag(), itemSold));
                                //Tells the player which item they sold and how much gold they gained
                                System.out.println("You sold: " + itemSold);
                                System.out.println("You gained: " + sellGold(itemSold) + " gold");
                                shopExit = true;
                                //Sell option 2 break
                                break;
//***************************************************************************************************************************
                            //Exit shop
                            case "3":
                                shopExit = true;
                                //Exit option 3 break
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;
//****************************************************************************************************************************
                //Starts the test sequence
                case "7":
                    player1.setPlayerLevel(7);
                    //Test option 6 break
                    break;
//****************************************************************************************************************************
                //Exits out of the game
                case "8":
                    System.out.println("Exiting the game");
                    done = true;
                    //Exit option 7 break
                    break;
                //Tells the user to try again
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("\nProgram Complete");
    }
    /**Function that prints the designated menu from the array and gets the user response
     * 
     * @return 
     */
    private static String getUserName(){
        Scanner in = new Scanner(System.in);
        System.out.print("What is your character's name?");
        return in.nextLine();
    }
    /**Function that displays the menu and gets the users choice
     * 
     * @param menu
     * @return 
     */
    private static String getUserChoice(String[] menu){
        System.out.println("");
        for(int i = 0; i < menu.length; i++){
            if(i == 0){
                System.out.println("\t--" + menu[i] + "--");   
            }
            else{
                System.out.println("\t" + i + ") " + menu[i]);
            }
        }
        System.out.print("Please enter your choice: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    /**Function to get user input
     * 
     * @param prompt
     * @return 
     */
    private static String getUserInput(String prompt){ 
        Scanner in = new Scanner(System.in);
        System.out.print(prompt);
        return in.nextLine();
    }
    /**Function that displays the player stats
     * 
     * @param stats 
     */
    private static void displayPlayerStats(Object[] stats, String[] helmetSlot, String[] chestSlot, String[] weaponSlot, String[] glovesSlot, String[] bootsSlot){
            System.out.println("Name: " + stats[0]);
            System.out.println("Level: " + stats[1]);
            System.out.println("Experience: " + stats[2]);
            System.out.println("HP: " + stats[3] + "/" + stats[4]);
            System.out.println("MP: " + stats[5] + "/" + stats[6]);
            System.out.println("Attack: " + stats[7]);
            System.out.println("Defense: " + stats[8]);
            System.out.println("Strength: " + stats[9]);
            System.out.println("Intelligence: " + stats[10]);
            System.out.println("Vitality: " + stats[11]);
            System.out.println("Stat Points Available: " + stats[12]);
            System.out.println("Gold: " + stats[13]);
            System.out.println("Helmet: [" + helmetSlot[0] + "]" + "{" + getItemRarity(helmetSlot) + "}");
            System.out.println("Chest Plate: [" + chestSlot[0] + "]" + "{" + getItemRarity(chestSlot) + "}");
            System.out.println("Gloves: [" + glovesSlot[0] + "]" + "{" + getItemRarity(glovesSlot) + "}");
            System.out.println("Boots: [" + bootsSlot[0] + "]" + "{" + getItemRarity(bootsSlot) + "}");
            System.out.println("Weapon: [" + weaponSlot[0] + "]" + "{" + getItemRarity(weaponSlot) + "}");
    }
    /**Function that increases max health using vitality
     * 
     * @param health
     * @return 
     */
    private static int maxHealth(int health){
        int mHealth = 0;
        mHealth = health + 5;
        return mHealth;   
    }
    /**Function that adds stat points upon level up
     * 
     * @param statPoints
     * @return 
     */
    private static int gainStatPoints(int statPoints){
        statPoints++;
        System.out.println("You have " + statPoints + " stat points available.");
        return statPoints;
    }
    /**Function that increases max mp using intelligence
     * 
     * @param mp
     * @return 
     */
    private static int maxMp(int mp){
        int mMP = 0;
        mMP = mp + 5;
        return mMP;
    }
    /**Function that removes stat points upon allocation
     * 
     * @param statPoints
     * @return 
     */
    private static int removeStatPoints(int statPoints){
        statPoints--;
        return statPoints;
    }
    /**Function that increases strength
     * 
     * @param strength
     * @return 
     */
    private static int gainStrength(int strength){
        strength++;
        System.out.println("You gain 1 strength");
        return strength;
    }
    /**Function that increases intelligence
     * 
     * @param intelligence
     * @return 
     */
    private static int gainIntelligence(int intelligence){
        intelligence++;
        System.out.println("You gain 1 intelligence");
        return intelligence;
    }
    /**Function that increases vitality
     * 
     * @param vitality
     * @return 
     */
    private static int gainVitality(int vitality){
        vitality++;
        System.out.println("You gain 1 vitality");
        return vitality;
    }
    /**Function that manages the encounter list
     * 
     * @return 
     */
    private static String encounter(int playerLevel){
        String encounterType;
        int number = 0;
        Random rand = new Random();
        if(playerLevel > 6){
            number = rand.nextInt(4);
        }else if(playerLevel > 4){
            number = rand.nextInt(3);
        }else{
            number = rand.nextInt(2);
        }
        switch(number){
            case 1:
                System.out.println("You found a Skeleton!");
                encounterType = "Skeleton";
                break;
            case 2:
                System.out.println("You found a Devil!");
                encounterType = "Devil";
                break;
            case 3:
                System.out.println("You have found Blue Moon City.");
                encounterType = "Blue Moon City";
                break;
            default:
                System.out.println("You didn't find anything.");
                encounterType = "nothing";
                break;
        }
        return encounterType; 
    }
    /**Function that determines which item is dropped when the enemy is killed and returns that item
     * 
     * @param number
     * @return 
     */
    private static String itemDrop(int number){
        String itemDropped;
        switch(number){
            case 1:
                itemDropped = "Short Sword";
                break;  
            case 2:
                itemDropped = "Leather Helmet";
                break;
            case 3:
                itemDropped = "Leather Chest Plate";
                break;
            case 4:
                itemDropped = "Scroll of Fireball";
                break;
            default:
                itemDropped = "";
        }
        return itemDropped;
    }
    /**Function that calculates the players total defense
     * 
     * @param helmetEquip
     * @param chestPlateEquip
     * @param playerDefense
     * @return 
     */
    private static int playerTotalDefense(String [] helmetEquip, String [] chestPlateEquip, String [] bootsEquip, String [] glovesEquip, int playerDefense){
        int totalDefense;
        int bootsDefense = 0;
        int chestDefense = 0;
        int glovesDefense = 0;
        int helmetDefense = 0;
        leatherHelmet LeatherHelmet = new leatherHelmet();
        leatherBoots LeatherBoots = new leatherBoots();
        leatherGloves LeatherGloves = new leatherGloves();
        leatherChestPlate LeatherChestPlate = new leatherChestPlate();
        ironHelmet IronHelmet = new ironHelmet();
        ironChestPlate IronChestPlate = new ironChestPlate();
        ironBoots IronBoots = new ironBoots();
        ironGloves IronGloves = new ironGloves();
        switch(helmetEquip[0]){
            case "Leather Helmet":
                helmetDefense = LeatherHelmet.getDefense();
                break;
            case "Iron Helmet":
                helmetDefense = IronHelmet.getDefense();
                break;
        }
        switch(bootsEquip[0]){
            case "Leather Boots":
                bootsDefense = LeatherBoots.getDefense();
                break;
            case "Iron Boots":
                bootsDefense = IronBoots.getDefense();
                break;
        }
        switch(chestPlateEquip[0]){
            case "Leather Chest Plate":
                chestDefense = LeatherChestPlate.getDefense();
                break;
            case "Iron Chest Plate":
                chestDefense = IronChestPlate.getDefense();
                break;
        }
        switch(glovesEquip[0]){
            case "Leather Gloves":
                glovesDefense = LeatherGloves.getDefense();
                break;
            case "Iron Gloves":
                glovesDefense = IronGloves.getDefense();
                break;
        }
        totalDefense = playerDefense + helmetDefense + chestDefense + glovesDefense + bootsDefense;
        return totalDefense;
    }
    /**Function that calculates the players total attack
     * 
     * @param weaponEquip
     * @param playerAttack
     * @return 
     */
    private static int playerTotalAttack(String [] weaponEquip, int playerAttack, int strength){
        int totalAttack = 0;
        int shortSwordAttack;
        int greatSwordAttack;
        int longSwordAttack;
        int hongerAttack;
        shortSword ShortSword = new shortSword();
        longSword LongSword = new longSword();
        greatSword GreatSword = new greatSword();
        heavenSmitingDevilSlayerSword Honger = new heavenSmitingDevilSlayerSword();
        switch(weaponEquip[0]){
            case "Short Sword":
                shortSwordAttack = ShortSword.getAttack();
                totalAttack = playerAttack + strength + shortSwordAttack;
                break;
            case "Long Sword":
                longSwordAttack = LongSword.getAttack();
                totalAttack = playerAttack + strength + longSwordAttack;
                break;
            case "Great Sword":
                greatSwordAttack = GreatSword.getAttack();
                totalAttack = playerAttack + strength + greatSwordAttack;
                break;
            case "Heaven Smiting Devil Slayer Sword":
                hongerAttack = Honger.getAttack();
                totalAttack = playerAttack + strength + hongerAttack;
                break;
            default:
                totalAttack = playerAttack + strength;
                break;
        }
        return totalAttack;
    }
    /**Function that calculates the damage dealt by the player to the monster
     * 
     * @param playerAttack
     * @param monsterDefense
     * @return 
     */
    private static int playerDamageDealt(int playerAttack, int monsterDefense){
        int playerDamageDealt;
        playerDamageDealt = (playerAttack - monsterDefense);
        return playerDamageDealt;
    }
    /**Function that calculates the damage the monster dealt to the player
     * 
     * @param monsterAttack
     * @param playerDefense
     * @return 
     */
    private static int monsterDamageDealt(int monsterAttack, int playerDefense){
        int monsterDamageDealt;
        monsterDamageDealt = (monsterAttack - playerDefense);
        if(monsterDamageDealt < 0){
            monsterDamageDealt = 0;
            return monsterDamageDealt;
        }else{
            return monsterDamageDealt;
        }
    }
    /**Function that displays the bag
     * 
     * @param bag 
     */
    private static void displayBag(String[] bag){
        for(int i=0; i<bag.length; i++){
            //Checks to see if slots 4, 8, or 12 are empty
            if((i == 4 || i == 8 || i == 12) && bag[i].equals("")){
                System.out.print("\n|  ");
                System.out.print("-");
                System.out.print("  |");
            //Checks if there is an item in slots 4, 8, or 12
            }else if (i == 4 || i == 8 | i == 12){
                System.out.print("\n|  ");
                System.out.print(bag[i]);
                System.out.print("  |");
            //Checks if all other slots are empty
            }else if(bag[i].equals("")){
                System.out.print("|  ");
                System.out.print("-");
                System.out.print("  |");
            //All other slots have an item and is printed out
            }else{
                System.out.print("|  ");
                System.out.print(bag[i]);
                System.out.print("  |");
            }
        }
    }
    private static void displayQuest(Object[] questList){
        for(int i=0; i<questList.length; i++){
            //Checks to see if slots 4, 8, or 12 are empty
            if((i == 4 || i == 8 || i == 12) && questList[i].equals("")){
                System.out.print("\n|  ");
                System.out.print("-");
                System.out.print("  |");
            //Checks if there is an item in slots 4, 8, or 12
            }else if (i == 4 || i == 8 | i == 12){
                System.out.print("\n|  ");
                System.out.print(questList[i]);
                System.out.print("  |");
            //Checks if all other slots are empty
            }else if(questList[i].equals("")){
                System.out.print("|  ");
                System.out.print("-");
                System.out.print("  |");
            //All other slots have an item and is printed out
            }else{
                System.out.print("|  ");
                System.out.print(questList[i]);
                System.out.print("  |");
            }
        }
    }
    /**Function to place an item in the user's inventory
     * 
     * @param item
     * @param inventory
     * @return 
     */
    private static String[] placeInBag(String item, String[] inventory){
        for(int i=0; i<inventory.length; i++){
            if(inventory[i].equals("")){
                inventory[i] = item;
                break;
            }
        }
        return inventory;
    }
    private static String[] placeQuest(String[] questList, String quest){
        for(int i = 0; i < questList.length; i++){
            if(questList[i].equals("")){
                questList[i] = quest;
                break;
            }
        }
        return questList;
    }
    /**Function to display items to be equipped from the inventory and select which item is to be equipped
     * 
     * @param inventory
     * @return 
     */
    private static String displayItemFromBag(String[] inventory, String option){
        String itemToDoAction;
        int counter = 1;
        if(option.equals("Equip")){
            for(int i = 0; i < inventory.length; i++){
                if(inventory[i].equals("Short Sword") || inventory[i].equals("Leather Helmet") || inventory[i].equals("Leather Chest Plate")
                    || inventory[i].equals("Long Sword") || inventory[i].equals("Great Sword") || inventory[i].equals("Iron Helmet") 
                        ||inventory[i].equals("Iron Chest Plate") || inventory[i].equals("Iron Boots") || inventory[i].equals("Iron Gloves")){
                System.out.println("\t" + counter + ") " + inventory[i]);
                counter++;
                }
            }
            System.out.println("\t" + counter + ") Exit");
            itemToDoAction = getUserInput("Which item would you like to equip? \n(Type the name of the item) ");
        }else if(option.equals("Sell")){
            for(int i = 0; i < inventory.length; i++){
                if(inventory[i].equals("Short Sword") || inventory[i].equals("Leather Helmet") || inventory[i].equals("Leather Chest Plate")
                    || inventory[i].equals("Long Sword") || inventory[i].equals("Great Sword") || inventory[i].equals("Iron Helmet") 
                        ||inventory[i].equals("Iron Chest Plate") || inventory[i].equals("Iron Boots") || inventory[i].equals("Iron Gloves")){
                System.out.println("\t" + counter + ") " + inventory[i]);
                counter++;
                }
            }
            System.out.println("\t" + counter + ") Exit");
            itemToDoAction = getUserInput("Which item would you like to sell? \n(Type the name of the item) ");
        }else if(option.equals("Use")){
            System.out.println("we here");
            for(int i = 0; i < inventory.length; i++){
                if(inventory[i].equals("Healing Potion") || inventory[i].equals("Greater Healing Potion") || inventory[i].equals("Scroll of Fireball")){
                    System.out.println("\t" + counter + ") " + inventory[i]);
                    counter++;
                }
            }
            System.out.println("\t" + counter + ") Exit");
            itemToDoAction = getUserInput("Which item would you like to use? \n(Type the name of the item) ");
        }else{
            itemToDoAction = "";
        }
        return itemToDoAction;
    }
    /**Function to remove said item from inventory
     * 
     * @param inventory
     * @param item
     * @return 
     */
    private static String[] removeFromBag(String[] inventory, String item){
        for(int i=0; i<inventory.length; i++){
            if(inventory[i].equals(item)){
                inventory[i] = "";
                break;
            }
        }
        return inventory;
    } 
    /**Function that tallies the experience of the player
     * 
     * @param playerExperience
     * @param monsterExperience
     * @return 
     */
    private static int experienceTally(int playerExperience, int monsterExperience){
        int totalExperience;
        totalExperience = playerExperience + monsterExperience;
        return totalExperience;
    }
    /**Function that Levels the player up
     * 
     * @param playerLevel
     * @return 
     */
    private static int levelUp(int playerLevel){
        int level = playerLevel + 1;
        System.out.println("You have leveled up!"); 
        //Tells the user what level they are
        System.out.println("You are now level " + level + "!");
        return level;
    }
    /**Function to populate the shop keepers inventory with items
     * 
     * @param shopKeeperInventory
     * @return 
     */
    private static String[] populateShopKeeperInventory(String[] shopKeeperInventory){
        shopKeeperInventory[0] = "Healing Potion";
        shopKeeperInventory[1] = "Greater Healing Potion";
        shopKeeperInventory[2] = "Long Sword";
        shopKeeperInventory[3] = "Great Sword";
        return shopKeeperInventory;
    }
    /**Function to populate the Blue Moon City Blacksmith inventory
     * 
     * @param blacksmithInventory
     * @return 
     */
    private static String[] populateBlueMoonBlacksmith(String[] blacksmithInventory){
        blacksmithInventory[0] = "Iron Helmet";
        blacksmithInventory[1] = "Iron Chest Plate";
        blacksmithInventory[2] = "Iron Boots";
        blacksmithInventory[3] = "Iron Gloves";
        return blacksmithInventory;
    }
    /**Function to populate the Blue Moon City GeneralGoods inventory
     * 
     * @param generalInventory
     * @return 
     */
    private static String[] populateBlueMoonGeneral(String[] generalInventory){
        generalInventory[0] = "Healing Potion";
        generalInventory[1] = "Greater Healing Potion";
        return generalInventory;
    }
    /**Function to populate the Blue Moon City Guild with quests
     * 
     * @param questList
     * @return 
     */
    private static String[] populateBlueMoonGuild(String[] questList){
        questList[0] = "Kill Skeletons";
        return questList;
    }
    /**Function to display quests
     * 
     * @param questList 
     */
    private static void displayQuestList(String[] questList){
        for(int i = 0; i < questList.length; i++){
            switch(questList[i]){
                case "Kill Skeletons":
                    System.out.println((i + 1) + ") " + questList[i]);
                    break;
            }
        }
    }
    /**Function to display the shop keepers inventory
     * 
     * @param shopInventory 
     */
    private static void displayShopInventory(String[] shopInventory){
        for(int i=0; i<shopInventory.length; i++){
            switch(shopInventory[i]){
                case "Healing Potion":
                    healingPotion HealingPotion = new healingPotion();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + HealingPotion.getHealingPotionBuyPrice());
                    break;
                case "Greater Healing Potion":
                    greaterHealingPotion GreaterHealingPotion = new greaterHealingPotion();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + GreaterHealingPotion.getGreaterHealingPotionBuyPrice());
                    break;
                case "Long Sword":
                    longSword LongSword = new longSword();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + LongSword.getBuyPrice());
                    break;
                case "Great Sword":
                    greatSword GreatSword = new greatSword();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + GreatSword.getBuyPrice());
                    break;
                case "Iron Helmet":
                    ironHelmet IronHelmet = new ironHelmet();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + IronHelmet.getBuyPrice());
                    break;
                case "Iron Chest Plate":
                    ironChestPlate IronChestPlate = new ironChestPlate();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + IronChestPlate.getBuyPrice());
                    break;
                case "Iron Boots":
                    ironBoots IronBoots = new ironBoots();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + IronBoots.getBuyPrice());
                    break;
                case "Iron Gloves":
                    ironGloves IronGloves = new ironGloves();
                    System.out.println((i + 1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + IronGloves.getBuyPrice());
                    break;
                case "Scroll of Fireball":
                    fireball Fireball = new fireball();
                    System.out.println((i+1) + ") " + shopInventory[i]);
                    System.out.println("Price: " + Fireball.getBuyPrice());
            }
        }
    }
    /**Function to get the sell price of the item being sold
     * 
     * @param itemToSell
     * @return 
     */
    private static int sellGold(String itemToSell){
        int goldReceived = 0;
        if(itemToSell.equals("Leather Helmet")){
            leatherHelmet LeatherHelmet = new leatherHelmet();
            goldReceived = LeatherHelmet.getSellPrice();
            return goldReceived;
        }else if(itemToSell.equals("Chest Plate")){
            leatherChestPlate LeatherChestPlate = new leatherChestPlate();
            goldReceived = LeatherChestPlate.getSellPrice();
            return goldReceived;
        }else if(itemToSell.equals("Short Sword")){
            shortSword ShortSword = new shortSword();
            goldReceived = ShortSword.getSellPrice();
            return goldReceived;
        }else if(itemToSell.equals("Long Sword")){
            longSword LongSword = new longSword();
            goldReceived = LongSword.getSellPrice();
            return goldReceived;
        }else if(itemToSell.equals("Great Sword")){
            greatSword GreatSword = new greatSword();
            goldReceived = GreatSword.getSellPrice();
            return goldReceived;
        }else if(itemToSell.equals("Healing Potion")){
            healingPotion HealingPotion = new healingPotion();
            goldReceived = HealingPotion.getHealingPotionSellPrice();
            return goldReceived;
        }else if(itemToSell.equals("Greater Healing Potion")){
            greaterHealingPotion GreaterHealingPotion = new greaterHealingPotion();
            goldReceived = GreaterHealingPotion.getGreaterHealingPotionSellPrice();
            return goldReceived;
        }else{
            return goldReceived;
        }
    }  
    /**Function that scales skeleton health based on player level
     * 
     * @param skeletonHealth
     * @param playerLevel
     * @return 
     */
    private static int skeletonHealthScale(int skeletonHealth, int playerLevel){
        if(playerLevel > 1){
            skeletonHealth = skeletonHealth + (5 * playerLevel);
            return skeletonHealth;
        }else{
            return skeletonHealth;
        }
    }
    /**Function that scales skeleton attack based on player level
     * 
     * @param skeletonAttack
     * @param playerLevel
     * @return 
     */
    private static int skeletonAttackScale(int skeletonAttack, int playerLevel){
        if(playerLevel > 1){
            skeletonAttack = skeletonAttack + (1 * playerLevel);
            return skeletonAttack;
        }else{
            return skeletonAttack;
        }
    }
    /**Function that scales skeleton gold dropped based on level
     * 
     * @param skeletonGold
     * @param playerLevel
     * @return 
     */
    private static int skeletonGoldScale(int skeletonGold, int playerLevel){
        if(playerLevel > 1){
            skeletonGold = skeletonGold + ( 1* playerLevel);
            return skeletonGold;
        }else{
            return skeletonGold;
        }
    }
    /**Function that scales the health of the devil
     * 
     * @param devilHealth
     * @param playerLevel
     * @return 
     */
    private static int devilHealthScale(int devilHealth, int playerLevel){
        if(playerLevel > 4){
            devilHealth = devilHealth + ((10 * (playerLevel - 4)));
        }
        return devilHealth;
    }
    /**Function that scales the attack of the devil
     * 
     * @param devilAttack
     * @param playerLevel
     * @return 
     */
    private static int devilAttackScale(int devilAttack, int playerLevel){
        if(playerLevel > 4){
            devilAttack = devilAttack + ((2 * (playerLevel - 4)));
            
        }
        return devilAttack;
    }
    /**Function that scales devil gold dropped based on level
     * 
     * @param devilGold
     * @param playerLevel
     * @return 
     */
    private static int devilGoldScale(int devilGold, int playerLevel){
        if(playerLevel > 4){
            devilGold = devilGold + ( 1* playerLevel);
            return devilGold;
        }else{
            return devilGold;
        }
    }
    /**Function that scales the fireball damage based on player level
     * 
     * @param fireballDamage
     * @param playerLevel
     * @return 
     */
    private static int fireballDamageScale(int fireballDamage, int playerLevel){
        int totalDamage = 0;
        totalDamage = fireballDamage + (2 * playerLevel);
        return totalDamage;
    }
    /**Function that scales the fireball mp cost based on player level
     * 
     * @param fireballCost
     * @param playerLevel
     * @return 
     */
    private static int fireballMPScale(int fireballCost, int playerLevel){
        int MPCost = 0;
        MPCost = fireballCost + (1 * playerLevel);
        return MPCost;
    }
    /**Function that gets the rarity of the item
     * 
     * @param itemSlot
     * @return 
     */
    private static String getItemRarity(String[] itemSlot){
        String rarity = "";
        if(itemSlot[0].equals("Leather Helmet")){
            leatherHelmet LeatherHelmet = new leatherHelmet();
            rarity = LeatherHelmet.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Leather Chest Plate")){
            leatherChestPlate LeatherChestPlate = new leatherChestPlate();
            rarity = LeatherChestPlate.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Leather Boots")){
            leatherBoots LeatherBoots = new leatherBoots();
            rarity = LeatherBoots.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Leather Gloves")){
            leatherGloves LeatherGloves = new leatherGloves();
            rarity = LeatherGloves.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Iron Boots")){
            ironBoots IronBoots = new ironBoots();
            rarity = IronBoots.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Iron Helmet")){
            ironHelmet IronHelmet = new ironHelmet();
            rarity = IronHelmet.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Iron Chest Plate")){
            ironChestPlate IronChestPlate = new ironChestPlate();
            rarity = IronChestPlate.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Iron Gloves")){
            ironGloves IronGloves = new ironGloves();
            rarity = IronGloves.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Short Sword")){
            shortSword ShortSword = new shortSword();
            rarity = ShortSword.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Long Sword")){
            longSword LongSword = new longSword();
            rarity = LongSword.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Great Sword")){
            greatSword GreatSword = new greatSword();
            rarity = GreatSword.getRarity();
            return rarity;
        }else if(itemSlot[0].equals("Heaven Smiting Devil Slayer Sword")){
            heavenSmitingDevilSlayerSword Honger = new heavenSmitingDevilSlayerSword();
            rarity = Honger.getRarity();
            return rarity;
        }
        return rarity;
    }
}
