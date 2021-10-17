package Employees;

import java.io.*;
public class EmployeeObjectOut implements PersonInformation{

    public static void main(String[] args) throws Exception{
        EmployeeObjectOut test=new EmployeeObjectOut();
        Employee employee=new Employee(25,"张三",5000);
        Student student=new Student(17,"李四");
        Teacher teacher=new Teacher(45,"王五");
        test.WriteObj(employee);
        test.WriteObj(student);
        test.WriteObj(teacher);

    }


    //将对象写入的操作方法
    public void WriteObj(Object obj) throws Exception{
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        fileOutputStream=new FileOutputStream("D:\\Git--Space");
        objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();


    }
}
