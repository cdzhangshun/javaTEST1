package Employees;

import java.io.Serializable;

 class Employee implements Serializable {
     private int age;
     private String name;
     private float salary;
     public Employee(int age ,String name,float salary){
         this.age=age;
         this.name=name;
         this.salary=salary;

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

     public float getSalary() {
         return salary;
     }

     public void setSalary(float salary) {
         this.salary = salary;
     }

     @Override
     public String toString() {
         return "Employees.Employee{" + "age=" + age + ", name='" + name + '\'' + ", salary=" + salary + '}';
     }

 }
