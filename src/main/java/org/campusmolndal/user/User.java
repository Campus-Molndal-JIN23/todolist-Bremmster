package org.campusmolndal.user;

import org.campusmolndal.helpers.TextManager;

public class User {

    private int id;
    private String name;
    private int age;

    public User(String name) {
        if (name.equals("")) {
            this.name = "Default username";
        } else {
            this.name = name;
        }
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            TextManager.notValidData();
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
