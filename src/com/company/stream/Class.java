package com.company.stream;

import com.company.comparators.Student;

import java.util.Arrays;
import java.util.Collection;

public class Class {
    String subject;
    Collection<Student> students;

    public Class(String subject, Student... st) {
        this.subject = subject;
        this.students = Arrays.asList(st);
    }
}
