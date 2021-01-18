package com.thoughtworks.capability.gtb.entrancequiz.entity;

public class Student {
    static int count = 0;
    private int id;
    private String name;

    public Student(String name) {
        this.id = ++count;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }
}
