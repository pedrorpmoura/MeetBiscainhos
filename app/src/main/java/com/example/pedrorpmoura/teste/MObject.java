package com.example.pedrorpmoura.teste;

public class MObject {

    private String name;
    private String description;
    private int pic;

    public MObject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {

        return this.name;
    }

    public String getDescription() {

        return this.description;
    }

    public int getPic() {

        return this.pic;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setPic(int pic) {

        this.pic = pic;
    }
}
