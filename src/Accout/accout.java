package Accout;

import java.util.Date;

public class accout {
    static double allmoney;
    private String name;
    private String id;
    private double balance;
    private Date datetime;
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getBalance(){
        allmoney=allmoney+this.balance;
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    public accout(String id, String name, double balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
        this.datetime=new Date();    //这里采用系统所给的时间，不是我们产生的。
    }
    //构造另外一个方法，利用set来赋值，这是十分重要的。
    public accout(){
        this.id="";
        this.name="";
        this.balance=0;
        this.datetime=new Date();

    }
    public void deposite(double money){
        this.balance=this.balance+money;

    }
    public void  withdraw(double money){
        if (this.balance<money){
            System.out.println("余额不足，不能取出");
            return;

        }
        this.balance=this.balance-money;
    }
    //转账方法，这个账户对象转给另外一个账户对象，这是重点。。。
    public void changeMoney(accout other, double money){
        if (this.balance<money){
            System.out.println("余额不足，不能转账");
            return;

        }
        this.balance=this.balance-money;
        other.balance=other.balance+money;  //别的账号加上钱数

    }

    public void print(){
        System.out.println("账户："+id+" 户名："+name+" 余额；"+balance);
    }
//这个打印的函数也可以省略

    public double getAllmoney(){
        return allmoney;
    }



     }






