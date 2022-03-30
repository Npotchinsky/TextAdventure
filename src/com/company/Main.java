package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {
boolean monsterInRoom = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dungeon!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        Character player = new Character(name);
        while (player.isAlive()) {
            System.out.println("Alright, " + player.getName() + " time to begin your adventure. You enter The Dungeon you step into a room and see a tunnel to your left and to your right what would you like to do?");
            String playerResponse = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (playerResponse.contains("left")){
                System.out.println("You walk through the left path feeling a light breeze coming from within. as you travel down a snaking path the tunnel opens to a small room.\nIn the room you see a Goblin! what would you like to do?");
                String goblinResponse = scanner.nextLine().toLowerCase(Locale.ROOT);
                Monster goblin = new Monster(3,2, "Goblin", 1, false);
                if (goblinResponse.contains("attack")){
                    while(goblin.getHealth()>0){
                        player.attack(goblin);
                        if (goblin.getHealth()>0){
                            System.out.println("would you like to attack again?");
                            if (scanner.nextLine().toLowerCase(Locale.ROOT).contains("yes")){
                               continue;
                            }
                            else{
                                System.out.println("You run away");
                                break;
                            }
                        }
                    }
            }
                else  if(playerResponse.contains("right")){
                System.out.println("You go right");
                }
            }
        }
    }
}
