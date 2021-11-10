 class Rectangle{
    private volatile int x,y;
    //public void increase(){      给线程加锁就可以解决x和y不相等问题
     public synchronized void increase(){
        x++;
        y++;
    }

    /*
    还可以用将代码块加锁，这样效率更高，更加节省资源
    public void increase(){
       synchronized(this){
          x++;
          y++;
       }
    }


h
     */
    public void print(){
        System.out.println("x="+x+",  y="+y);

    }

}


public class ThreadIncrease extends Thread{
    Rectangle rectangle;
    public ThreadIncrease(Rectangle rectangle){
        this.rectangle=rectangle;
    }

    public void run(){
        for (int i=0;i<100000;i++){
            rectangle.increase();
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle();
        //都被赋予共享的操作资源，同一个对象rectangle
        ThreadIncrease T1=new ThreadIncrease(rectangle);
        ThreadIncrease T2=new ThreadIncrease(rectangle);
        T1.start();
        T2.start();
        for (int i = 0; i < 5; i++) {
            rectangle.print();
            try {
                Thread.sleep(1);
            }catch (Exception e){

            }

        }


    }

}
