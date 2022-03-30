package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();

    static Character player;

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dungeon!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        player = new Character(name);
        System.out.println("Alright, " + player.getName() + " time to begin your adventure. You enter The Dungeon you step into a room and see a tunnel to your left and to your right what would you like to do?");
        while (player.isAlive()) {
            String playerResponse = scanner.nextLine().toLowerCase(Locale.ROOT);
                System.out.println("You walk through the " + playerResponse + " path feeling a light breeze coming from within.");
                player.getRoom(player);
                if (player.getLocation().isMonsterInfested()){
                String goblinResponse = scanner.nextLine().toLowerCase(Locale.ROOT);
                if (goblinResponse.contains("attack")){
                    while(player.getLocation().getMonster().getHealth()>0 && player.isAlive()){
                        player.attack(player.getLocation().getMonster());
                        if (player.getLocation().getMonster().getHealth()>0 && player.isAlive()){
                            System.out.println("would you like to attack again?");
                            if (scanner.nextLine().toLowerCase(Locale.ROOT).contains("y")){
                               continue;
                            }
                            else{
                                System.out.println("You run away");
                                break;
                            }
                        }
                        }
                    }
            }
            }
        }
    }
