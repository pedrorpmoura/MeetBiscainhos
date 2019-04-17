package com.example.pedrorpmoura.teste;

public class MObject {

    private String name;
    private String dating;
    private String material;
    private String dimension;
    private String description;
    private int pic;

    public MObject(String name, String dating, String material,
                   String dimension, String description, int pic) {
        this.name = name;
        this.dating = dating;
        this.material = material;
        this.dimension = dimension;
        this.description = description;
        this.pic = pic;
    }

    public String getName() {

        return this.name;
    }

    public String getDating() {
        return this.dating;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getDimension() {
        return this.dimension;
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

    public void setDating(String dating) {
        this.dating = dating;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
