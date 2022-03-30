package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Goblin extends Monster {
static Random random = new Random();
static MonsterNames monsterNames = new MonsterNames();

    public Goblin() {
        super(random.nextInt(1,5), 2, monsterNames.getMonsterNames().get(random.nextInt(0,monsterNames.getMonsterNames().size()-1))  , random.nextInt(1,3), false);
    }

}
