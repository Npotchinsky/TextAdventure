package com.company;

public class Room {
    private int roomLevel;
    private boolean monsterInfested;
    private Monster monster;

    public Room(int roomLevel, boolean monsterInfested){
        this.roomLevel = roomLevel;
        this.monsterInfested = monsterInfested;
        if(monsterInfested){
            monster =  new Goblin();
            System.out.println("As you travel down a snaking path you enter into a room,\n The room contains a "+ monster.getName() + " what would you like to do?");
        }
        else if (roomLevel > 0){
            System.out.println("The room is empty because Nathan hasn't coded anything else yet. would you like to go left or right?");
        }

    }


    public boolean isMonsterInfested() {
        return monsterInfested;
    }

    public void setMonsterInfested(boolean monsterInfested) {
        this.monsterInfested = monsterInfested;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
