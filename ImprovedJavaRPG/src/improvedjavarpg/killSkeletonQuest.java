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
public class killSkeletonQuest extends quest{
    private int currentKills;
    private int killsRequired;
    private String questComplete;
    private String name;
    public killSkeletonQuest(){
        currentKills = 0;
        killsRequired = 10;
        name = "Kill Skeletons";
        questComplete = "false";
    }

    public int getCurrentKills() {
        return currentKills;
    }

    public void setCurrentKills(int currentKills) {
        this.currentKills = currentKills;
    }

    public int getKillsRequired() {
        return killsRequired;
    }

    public void setKillsRequired(int killsRequired) {
        this.killsRequired = killsRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String isQuestComplete() {
        return questComplete;
    }

    public void setQuestComplete(String questComplete) {
        this.questComplete = questComplete;
    }

    @Override
    public String toString() {
        return "killSkeletonQuest{" + "currentKills=" + currentKills + ", killsRequired=" + killsRequired + ", name=" + getName() + ", questComplete=" + questComplete + '}';
    }
    
    
}

