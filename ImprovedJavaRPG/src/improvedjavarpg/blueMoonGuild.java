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
public class blueMoonGuild {
    public String[] questList = new String[5];

    public blueMoonGuild() {
        for(int i=0; i< questList.length;i++)
            questList[i] = new String();
    }

    public String[] getQuestList() {
        return questList;
    }

    public void setQuestList(String[] questList) {
        this.questList = questList;
    }
}
