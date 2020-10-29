package com.andela.taccolation.presentation.model;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private String sex;
    private List<String> courseCodeList; // unique course codes can be used to query the db to retrieve the Course details
    private String imageUrl;
    private String id;
    private Map<String, StudentStatistics> studentDetailsMap; //map of course code to statistics for the course code for this student

    public Student(String firstName, String lastName, String sex, List<String> courseCodeList, String imageUrl, String id, Map<String, StudentStatistics> studentDetailsMap) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.courseCodeList = courseCodeList;
        this.imageUrl = imageUrl;
        this.id = id;
        this.studentDetailsMap = studentDetailsMap;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public List<String> getCourseCodeList() {
        return courseCodeList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, StudentStatistics> getStudentDetailsMap() {
        return studentDetailsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getFirstName().equals(student.getFirstName()) &&
                getLastName().equals(student.getLastName()) &&
                getSex().equals(student.getSex()) &&
                Objects.equals(getCourseCodeList(), student.getCourseCodeList()) &&
                Objects.equals(getImageUrl(), student.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getSex(), getCourseCodeList(), getImageUrl());
    }

    @NonNull
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", courseCodeList=" + courseCodeList +
                ", imageUrl='" + imageUrl + '\'' +
                ", id='" + id + '\'' +
                ", mStudentDetailsMap=" + studentDetailsMap +
                '}';
    }
}
