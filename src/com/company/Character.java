package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Character {
    Random random = new Random();
    private String name;
    private int level = 1;
    private int health = 10;
    private int maxHealth = 10;
    private int xp = 0;
    private Weapon equippedWeapon;
    private List<Item> inventory = new ArrayList<>();
    private boolean alive = true;
    private Room location = new Room(0, false);
    private int xpToLevel = 10;

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

    public void levelUp() {
        this.level = this.level+1;
        this.maxHealth = this.maxHealth+2;
        this.health = this.maxHealth;
        this.xp = 0;
        this.xpToLevel = this.xpToLevel +(this.level*10);

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
            if (getXp()>=xpToLevel){
                levelUp();
                System.out.println("You leveled up! You are now level " + getLevel());
            }
            System.out.println("would you like to go left or right?");
        }
        else {
            System.out.println(monster.getName() + " has " + monster.getHealth() + "/" + monster.getMaxHealth());
            System.out.println(monster.getName() + " attacks you for " + monster.getDamage());
            setHealth(getHealth()- monster.getDamage());
            if(getHealth() <= 0){
                System.out.println("You have died!");
                alive = false;
            }
        }
    }

    public void getRoom(){
        boolean hasMonster = true;
        if(random.nextInt(1,10)>3){
            hasMonster = true;
        }
        else hasMonster = false;
        Room thisRoom = new Room(getLevel(),hasMonster);
        setLocation(thisRoom);
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

    public void setLocation(Room location) {
        this.location = location;
    }

    public Room getLocation() {
        return location;
    }
}

