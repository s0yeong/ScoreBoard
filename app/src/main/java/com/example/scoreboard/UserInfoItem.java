package com.example.scoreboard;

public class UserInfoItem {

//    int pos;
    String name;
    int age;
    String sex;

    public UserInfoItem(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    }

//    public UserInfoItem(int pos, String name, int age, String sex) {
//        this.pos = pos;
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }
//
//    public int getPos() {
//        return pos;
//    }
//
//    public void setPos(int pos) {
//        this.pos = pos;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}







