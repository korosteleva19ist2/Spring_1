package ru.appline.logic;

public class Pet {
    private String name;
    private String type;
    private int age;


    public void setName(String name) {
        this.name = name;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }


    public Pet(){
        super();
    }
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

    }
}
