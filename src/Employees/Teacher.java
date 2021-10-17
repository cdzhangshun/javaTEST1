package Employees;

import java.io.Serializable;

public class Teacher implements Serializable {

    private int age;
    private String name;

    public Teacher(int age ,String name){
        this.age=age;
        this.name=name;


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
