package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }
}
