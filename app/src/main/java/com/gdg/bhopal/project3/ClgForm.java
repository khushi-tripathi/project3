package com.gdg.bhopal.project3;

import java.io.Serializable;

public class ClgForm implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    String email,pwd,dob,address,mob,course,school,gender;
    int age;

    public ClgForm(String name, String email, String pwd, String dob, String address, String mob, String course, String school, String gender, int age) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.dob = dob;
        this.address = address;
        this.mob = mob;
        this.course = course;
        this.school = school;
        this.gender = gender;
        this.age = age;
    }

}
