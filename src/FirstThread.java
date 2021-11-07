public class FirstThread extends Thread{
    private String name;
    public FirstThread(String name){
        super(name);
        System.out.println(name+"这个创建成功");

    }
    public void run(){
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(2000);
            }catch (Exception e){};
            System.out.println(Thread.currentThread().getName()+"  "+"第"+i+"次运行");
            Thread.yield();

        }
    }

    public static void main(String[] args) {
        FirstThread t1=new FirstThread("第一个线程");
        FirstThread t2=new FirstThread("第二个线程");
        FirstThread t3=new FirstThread("第三个线程");
        FirstThread t4=new FirstThread("第四个线程");
        FirstThread t5=new FirstThread("第五个线程");
        FirstThread t6=new FirstThread("第六个线程");
        System.out.println("开始启动t1~t6线程");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        System.out.println("main方法执行完毕");
/*
当把t1.start();改成t1.run(),结果如下

只会有main线程，不会有"第一线程"什么的了，不是启动线程，就只不过是普通方法调用，成为单线程
 */

//        t1.run();
//        t2.run();
//        t3.run();
    }
}
