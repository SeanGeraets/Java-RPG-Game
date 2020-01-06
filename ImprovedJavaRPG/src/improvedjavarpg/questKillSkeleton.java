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
public class questKillSkeleton {
    String objective;
    int goldReward;
    String itemReward;
    int currentKillCount;
    int objectiveKillCount;
    public questKillSkeleton() {
        objective = "Kill 10 skeletons";
        goldReward = 100;
        itemReward = "Iron Helmet";
        currentKillCount = 0;
        objectiveKillCount = 10;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public String getItemReward() {
        return itemReward;
    }

    public void setItemReward(String itemReward) {
        this.itemReward = itemReward;
    }

    public int getCurrentKillCount() {
        return currentKillCount;
    }

    public void setCurrentKillCount(int currentKillCount) {
        this.currentKillCount = currentKillCount;
    }

    public int getObjectiveKillCount() {
        return objectiveKillCount;
    }

    public void setObjectiveKillCount(int objectiveKillCount) {
        this.objectiveKillCount = objectiveKillCount;
    }
    
}
