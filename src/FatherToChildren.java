public class FatherToChildren {
    /*
       总结：
       1.由结果可知，父类引用虽然可以指向子类的对象，但是执行的还是子类重写的方法
       2.声明的虽然是父类，但是实际指向的还是子类的一个对象
     */

    public void func1(){
        func2();
    }

    public void func2(){
        System.out.println("这是父类的方法");
    }

    public void func1(int i) {
    }
}

class Child extends FatherToChildren{
    //func1(int i)是对func1()方法的一个重载，主要不是重写！
    //由于在父类中没有定义这个方法，所以它不能被父类类型的引用调用
    //所以在下面的main方法中child.func1(68)是不对的
    public void func1(int i){
        System.out.println("这是子类的方法111111");
    }
    //func2()重写了父类FatherToChildren中的func2()方法
    //如果父类类型的引用中调用了func2()方法，那么必然是子类中重写的这个方法
    public void func2(){
        System.out.println("这是子类的方法222222");
    }
}

class ResultTest {
    public static void main(String[] args) {
        FatherToChildren child = new Child();
        child.func1();                    //打印结果全还是子类的方法，没有改变
        child.func1(68);
        child.func2();                   //父类类型的引用中调用了func2()方法，那么必然是子类中重写的这个方法

    }
}

