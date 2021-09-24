package Students;

import java.util.Scanner;

public class StudentsFUNCTION {

    public  void addStudent() {
        Scanner input = new Scanner(System.in);

        Student[] students = new Student[10];
        System.out.println("编号:");
        int no = input.nextInt();
        System.out.println("姓名:");
        String name = input.next();
        System.out.println("性别:");
        char sex = input.next().charAt(0);
        System.out.println("年龄:");
        int age = input.nextInt();
        System.out.println("电话:");
        String tel = input.next();

        //创建学生对象
        Student stu = new Student(no, name, sex, age, tel);

        for(int i=0;i<students.length;i++) {
            if(students[i] == null) {
                students[i] = stu;
                break;//一次只能添加一个学生对象
            }
        }
    }



}
