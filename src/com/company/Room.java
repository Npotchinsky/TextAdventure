package com.company;

public class Room {
    private int roomLevel;
    private boolean monsterInfested;
    private Monster monster;


    public Room(int roomLevel, boolean monsterInfested, Character player){
        this.roomLevel = roomLevel;
        this.monsterInfested = monsterInfested;
        if(monsterInfested){
            monster =  new Monster(player);
            System.out.println("As you travel down a snaking path you enter into a room,\nThe room contains a "+ monster.getName() + " what would you like to do?");
        }
        else if (roomLevel > 0){
            System.out.println("You come to an empty room");
            player.dropItem();
            System.out.println("you see a path to your left and to your right. which path would you like to follow.");
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
