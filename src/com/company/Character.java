package com.company;

import java.util.*;

public class Character {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private String name;
    private int level = 1;
    private int health = 10;
    private int maxHealth = 10;
    private int xp = 0;
    private Weapon equippedWeapon;
    private List<Item> inventory = new ArrayList<>();
    private boolean alive = true;
    private Room location = new Room(0, false, null);
    private int xpToLevel = 10;
    private Drops drops = new Drops(this);

    public Character(String name) {
        this.name = name;
        Weapon knife = new Weapon("Knife", true, 2, "Stab");
        inventory.add(knife);
        equipWeapon(knife);

    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void equipWeapon(Weapon weapon) {
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
        if (getXp() >= xpToLevel) {
            this.level = this.level + 1;
            this.maxHealth = this.maxHealth + 2;
            this.health = this.maxHealth;
            this.xp = 0;
            this.xpToLevel = this.xpToLevel + (this.level * 10);
            drops.levelDrops(this);
            System.out.println("You leveled up! You are now level " + getLevel());
        }
    }

    public void dropItem() {
        if (random.nextInt(0, 11) % 2 == 0) {
            Item item = drops.getDrops().get(random.nextInt(drops.getDrops().size()));

            inventory.add(item);
            System.out.println("you found a new " + item.getClass().getSimpleName()+ ": " + item.getName());
            if (item instanceof Weapon) {
                System.out.println(item.getName() + " does " + ((Weapon) item).getDamageAmount() + " points of " + ((Weapon) item).getDamageType() + " damage.");
                System.out.println("would you like to equip " + item.getName() + "?");
                String equipResponse = scanner.nextLine();
                if (equipResponse.toLowerCase(Locale.ROOT).contains("y")) {
                    equipWeapon((Weapon) item);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void attack(Monster monster) {

        monster.setHealth(monster.getHealth() - equippedWeapon.getDamageAmount());
        System.out.println("You " + equippedWeapon.getDamageType() + " " + monster.getName() + " for " + equippedWeapon.getDamageAmount() + " damage!");
        if (monster.getHealth() <= 0) {
            monster.dies(this);
        } else if (alive && monster.getHealth() > 0) {
            monster.attacks(this);
            System.out.println("you have " + getHealth() + "/" + getMaxHealth() + "Health remaining");
        }
    }

    public void getRoom(Character player) {
        boolean hasMonster = true;
        if (random.nextInt(1, 10) > 3) {
            hasMonster = true;
        } else hasMonster = false;
        Room thisRoom = new Room(getLevel(), hasMonster, player);
        setLocation(thisRoom);
    }

    public void drinkPotion(HealthPotion potion) {
        setHealth(getHealth() + potion.getAmountToHeal());
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }

    }

    public void getItem(Item item) {
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

    public boolean hasPotion() {
        boolean hasPotion = false;
        for (Item item : inventory) {
            if (item instanceof HealthPotion == true){
                hasPotion = true;
            break;}
        }
        return hasPotion;
    }


    public HealthPotion choosePotion() {
        List<HealthPotion> potions = new ArrayList<>();
        for (Item item : inventory) {
            if (item instanceof HealthPotion) {
                potions.add((HealthPotion) item);
            }
        }
            System.out.println("you have ");
            for (int i = 0; i < potions.size(); i++) {
                System.out.println("(" + (i + 1) + "): " + potions.get(i).getName());
            }
            System.out.println("Which potion would you like to use?");
            return potions.get(scanner.nextInt()-1);
        }
    }


