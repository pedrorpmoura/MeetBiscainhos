package com.example.pedrorpmoura.teste;

//import android.support.v7.app.AppCompatActivity;

//import java.util.ArrayList;

public class MRoom {

    private int ala;
    private String name;
    private String description;
    //private String[] room_pics;
    //private ArrayList<MObject> room_objects;


    public MRoom(int ala, String name, String description) {
        this.ala = ala;
        this.name = name;
        this.description = description;
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

    /*public String[] getRoom_pics() {
        return this.room_pics;
    }

    public ArrayList<MObject> getRoom_objects() {
        return this.room_objects;
    }*/


    public void setAla(int ala) {
        this.ala = ala;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public void setRoom_pics(String[] room_pics) {
        this.room_pics = room_pics;
    }

    public void setRoom_objects(ArrayList<MObject> room_objects) {
        this.room_objects = room_objects;
    }*/
}