package com.thoughtworks.capability.gtb.entrancequiz.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;

    private List<Integer> member = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addMember(int id) {
        this.member.add(id);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMember() {
        return member;
    }

    public void clearMember() {
        member.clear();
    }
}
