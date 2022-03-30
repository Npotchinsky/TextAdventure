package com.company;

public class Monster {

    private int maxHealth;
    private int health = maxHealth;
    private int xpValue;
    private String name;
    private int damage;
    private boolean reasonable;

    public Monster(int maxHealth, int xpValue, String name, int damage, boolean reasonable) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.xpValue = xpValue;
        this.name = name;
        this.damage = damage;
        this.reasonable = reasonable;
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
