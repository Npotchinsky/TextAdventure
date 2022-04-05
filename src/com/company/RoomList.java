package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomList {
    private Random random = new Random();
    private List<Room> bossList = new ArrayList<>();
    private List<Room> roomList = new ArrayList<>();
       private Room goblinBoss = new Room(3, true, new Monster(18, 10, "Yeeg'Maath the liar", 4, false));
       private Room skeletonBoss = new Room(3, true, new Monster(10, 6, "Bone General",5,false));
       private Room wolfBoss = new Room(3, true, new Monster(12, 10, "Silver Claws", 6, false));
       private Room dungeonBoss = new Room(6, true, new Monster(25, 30, "Dungeon Lord", 8,false));

    public RoomList(Character character){
        bossList.add(goblinBoss);
        bossList.add(skeletonBoss);
        bossList.add(wolfBoss);
        bossList.add(dungeonBoss);
        for (Room bossRoom:bossList) {
            if (character.getLevel() >= bossRoom.getRoomLevel())
                roomList.add(bossRoom);
        }
    }
    public Room getBossRoom(){
           return bossList.get(random.nextInt(roomList.size()));
    }

}
