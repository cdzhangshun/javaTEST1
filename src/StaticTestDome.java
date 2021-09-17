public class StaticTestDome{
    static {
        System.out.println("父类-----static开始执行了");
    }

    public StaticTestDome(){
        System.out.println("父类-----构造方法");
    }

    public  void fun(){
        System.out.println("父类-----成员方法");

    }

    {
        System.out.println("父类-----非静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行了。");
        new StaticTest();

    }
}



class StaticTest extends StaticTestDome{
    static {
        System.out.println("子类-----static开始执行了");
    }
    public StaticTest(){
        System.out.println("子类-----构造方法");
    }

    public void fun(){
        super.fun();
        System.out.println("子类-----成员方法");

    }

    {
        System.out.println("子类-----非静态代码块");
    }

}
//java中首先是静态块先执行，静态方法，然后是构造方法，最后是普通方法。这是实验结果。
//父类静态在子类前