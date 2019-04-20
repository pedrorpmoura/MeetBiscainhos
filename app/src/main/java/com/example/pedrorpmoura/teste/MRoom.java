package com.example.pedrorpmoura.teste;

import java.util.ArrayList;
import java.util.List;

public class MRoom {

    private int ala;
    private String name;
    private String description;
    private int[] room_pics;
    private int sound;
    private List<MObject> room_objects = new ArrayList<>();


    public MRoom(int ala, String name, String description,
                 int[] room_pics, int sound, List<MObject> room_objects) {
        this.ala = ala;
        this.name = name;
        this.description = description;
        this.room_pics = room_pics;
        this.sound = sound;
        this.room_objects = room_objects;
    }

    public int getAla() {
        return this.ala;
    }

    public String getName() {
        return this.name;
    }


    public String getDescription() {
        return this.description;
    }

    public int[] getRoomPics() {
        return this.room_pics;
    }

    public int getSound() { return this.sound;}

    public List<MObject> getRoom_objects() {
        return this.room_objects;
    }


    public void setAla(int ala) {
        this.ala = ala;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomPics(int[] room_pics) {
        this.room_pics = room_pics;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public void setRoom_objects(List<MObject> room_objects) {

        this.room_objects = room_objects;
    }


    public int[] getObj_pics() {
        int[] obj_pics = new int[this.room_objects.size()];

        int i = 0;
        for(MObject obj : this.room_objects) {
            obj_pics[i++] = obj.getPic();
        }

        return obj_pics;
    }
}