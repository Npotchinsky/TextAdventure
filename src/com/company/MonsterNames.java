package com.company;

import java.util.ArrayList;
import java.util.List;

public class MonsterNames {
    private List<String> monsterNames = new ArrayList<String>();

    public MonsterNames(){
        monsterNames.add("Goblin");
        monsterNames.add("Kobold");
        monsterNames.add("Wolf");
        monsterNames.add("Skeleton");
    }

    public List<String> getMonsterNames() {
        return monsterNames;
    }
}

