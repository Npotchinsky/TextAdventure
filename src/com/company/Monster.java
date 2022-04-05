package com.company;

import java.util.Random;

public class Monster {
    static Random random = new Random();
    static MonsterNames monsterNames = new MonsterNames();
    private int maxHealth;
    private int health = maxHealth;
    private int xpValue;
    private String name;
    private int damage;
    private boolean reasonable;
    private static Character player;

    public Monster(int maxHealth, int xpValue, String name, int damage, boolean reasonable) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.xpValue = xpValue;
        this.name = name;
        this.damage = damage;
        this.reasonable = reasonable;
    }

    public Monster(Character character){

        this.maxHealth = character.getLevel()*random.nextInt(2,5);
        this.health = maxHealth;
        this.xpValue = character.getLevel()* random.nextInt(1, 3);
        this.name = monsterNames.getMonsterNames().get(random.nextInt(0,monsterNames.getMonsterNames().size()-1));
        this.damage = character.getLevel();
        this.reasonable = false;
    }

    public void dies(Character player){
        player.setXp(player.getXp() + getXpValue());
        System.out.println("Congratulations! you slayed the " + getName());
        player.levelUp();
        player.dropItem();
    }
    public void attacks(Character player){
        System.out.println(getName() + " has " + getHealth() + "/" + getMaxHealth());
        System.out.println(getName() + " attacks you for " + getDamage());
        player.setHealth(player.getHealth() - getDamage());
        if (player.getHealth() <= 0) {
            System.out.println("You have died!");
            player.setAlive(false);

        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getXpValue() {
        return xpValue;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }
}
