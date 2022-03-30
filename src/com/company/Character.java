package com.company;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private int level = 1;
    private int health = 10;
    private int maxHealth = 10;
    private int xp = 0;
    private Weapon equippedWeapon;
    private List<Item> inventory = new ArrayList<>();
    private boolean alive = true;

    public Character(String name) {
        this.name = name;
        Weapon knife = new Weapon("Knife",true, 2,"Stab");
        inventory.add(knife);
        equipWeapon(knife);
    }


    public void equipWeapon(Weapon weapon){
    this.equippedWeapon = weapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void attack(Monster monster){
        monster.setHealth(monster.getHealth()-equippedWeapon.getDamageAmount());
        System.out.println("You " + equippedWeapon.getDamageType() + " " + monster.getName() + " for "+ equippedWeapon.getDamageAmount() + " damage!");
        if (monster.getHealth()<=0){
            setXp(getXp()+ monster.getXpValue());
            System.out.println("Congratulations! you slayed the " + monster.getName());
        }
        else {
            System.out.println(monster.getName() + " has " + monster.getMaxHealth() + "/" + monster.getHealth());
            System.out.println(monster.getName() + " attacks you for" + monster.getDamage());
            setHealth(getHealth()- monster.getDamage());
            if(getHealth() <= 0){
                System.out.println("You have died!");
                alive = false;
            }
        }
    }

    public void drinkPotion(HealthPotion potion){
        setHealth(getHealth()+potion.getAmountToHeal());
        if (getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());
        }

    }

    public void getItem(Item item){
        inventory.add(item);
    }


    public boolean isAlive() {
        return alive;
    }
}

