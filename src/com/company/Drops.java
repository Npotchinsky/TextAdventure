package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drops {
    static Random random = new Random();
    private static final List<Item> drops = new ArrayList<>();

    public Drops(Character player){
        drops.add(new HealthPotion("Small health potion", 3));
        drops.add(new HealthPotion("Medium health potion", 6));
        drops.add(new Weapon("Sword", true, player.getLevel() * random.nextInt(1,4),"Slash"));
    }

    public static void levelDrops(Character player){
        if (player.getLevel() > 2){
            drops.add(new HealthPotion("Large health potion", 10));
            drops.add(new Weapon("Spear", true, player.getLevel() * random.nextInt(2,5), "Stab"));
            drops.add(new HealthPotion("Max Health potion", player.getMaxHealth()));
        }
    }

    public List<Item> getDrops() {
        return drops;
    }
}
