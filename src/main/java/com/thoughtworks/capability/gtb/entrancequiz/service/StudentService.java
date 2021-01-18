package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import com.thoughtworks.capability.gtb.entrancequiz.entity.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentService {

    private final List<Student> students = new ArrayList<Student>() {{
        add(new Student("成吉思汗"));
        add(new Student("鲁班七号"));
        add(new Student("太乙真人"));
        add(new Student("钟无艳"));
        add(new Student("花木兰"));
        add(new Student("雅典娜"));
        add(new Student("芈月"));
        add(new Student("白起"));
        add(new Student("刘禅"));
        add(new Student("庄周"));
        add(new Student("马超"));
        add(new Student("刘备"));
        add(new Student("哪吒"));
        add(new Student("大乔"));
        add(new Student("蔡文姬"));
    }};

    private List<Team> partition = new ArrayList<Team>() {{
        add(new Team("1 组"));
        add(new Team("2 组"));
        add(new Team("3 组"));
        add(new Team("4 组"));
        add(new Team("5 组"));
        add(new Team("6 组"));
    }};

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }

    public List<Team> getPartition() { return partition;}

    public void newPartition() {
        List<Student> shuffledList = new ArrayList<Student>(students);
        Collections.shuffle(shuffledList);

        for(Team team : partition) {
            team.clearMember();
        }
        int j = 0;
        for(Student student : shuffledList) {
            Team team = partition.get(j % 6);
            team.addMember(student.getId());
            ++j;
        }
    }
}
