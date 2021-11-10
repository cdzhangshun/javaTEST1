class WareHouse{
    int[] content=new int[10];
    boolean []available=new boolean[10];
    public synchronized int get(int i){
        while (available[9]==false){
            try {
                wait();
            }catch (InterruptedException e) {}
        }
        available[9]=false;
        notifyAll();
        System.out.println("got "+content[i]);
        return content[i];
    }

    static int i=0;
    public synchronized void put(int value){
        while (available[9]==true){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        content[i]=value;
        i++;
        available[9]=true;
        notifyAll();
    }

}


class Consumer extends Thread{
    private WareHouse wareHouse;
    public Consumer(WareHouse wareHouse){
        this.wareHouse=wareHouse;
    }
    public void run(){
        int value=0;
        for (int i = 0; i <=10; i++) {
            value=wareHouse.get(i);
            System.out.println("Consumer got: "+value);

        }
    }
}

class Producer extends Thread{
    private WareHouse wareHouse;

    public Producer( WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            wareHouse.put(i);
            System.out.println("Producer put: "+i);
            try {
                sleep(100);
            }catch (InterruptedException e)
            {}
        }
    }

}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        WareHouse wareHouse=new WareHouse();
        Producer P1=new Producer(wareHouse);
        Consumer C1=new Consumer(wareHouse);
        P1.start();
        C1.start();

    }

}
