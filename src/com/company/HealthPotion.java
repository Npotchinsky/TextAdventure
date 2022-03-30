package com.company;

public class HealthPotion extends Item {
    private int amountToHeal;

    public HealthPotion(String name, int amountToHeal) {
        this.setName(name);
        this.amountToHeal = amountToHeal;
        this.setReusable(false);
    }

    public int getAmountToHeal() {
        return amountToHeal;
    }
}
