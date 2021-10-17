package Employees;

import java.io.*;
public class EmployeeObjectInput {
    public static void main(String[] args) throws Exception {
        EmployeeObjectInput aaa=new EmployeeObjectInput();
        System.out.println(((Employee) aaa.ReadObj()).getName());

    }

    //读取配置的信息，从文件中读取Employee等等的对象。
    public static Object ReadObj() throws Exception{
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        Object obj=null;
        fileInputStream=new FileInputStream("D:\\Git--Space");
        objectInputStream=new ObjectInputStream(fileInputStream);
        obj=objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return obj;
    }
}
