package com.company;

public class Weapon extends Item{
    private final int damageAmount;
    private final String damageType;

    public int getDamageAmount() {
        return damageAmount;
    }

    public String getDamageType() {
        return damageType;
    }

    public Weapon(String name, boolean isReusable, int damageAmount, String damageType) {
        super(name, isReusable);
        this.damageAmount = damageAmount;
        this.damageType = damageType;

    }


}
