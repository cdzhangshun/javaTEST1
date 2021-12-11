import java.util.*;

class Vehicle implements Comparable<Vehicle>{
    private int speed;
    private String color;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int compareTo(Vehicle v){
        return this.speed- v.speed;
    }
    public Vehicle(int speed, String color){
        this.speed=speed;
        this.color=color;

    }
    class Bus extends Vehicle {
        private int price;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Bus(int speed, String color, int price) {
            super(speed, color);
            this.price = price;

        }

        public class GenericComplex {
            public static <T extends Comparable<? super T>> T max(List<T> list) {
                if (list.size() == 0)
                    return null;
                T t = list.get(0);



                return t;
            }

            public static void main(String[] args) {
                List<Integer> list1=new ArrayList<Integer>();
                list1.add(10);
                list1.add(8);
                list1.add(16);
                list1.add(22);
                Integer max=max(list1);
                System.out.println("max="+max);
                List<Vehicle> list2=new ArrayList<Vehicle>();
                //下面使用的都是匿名类，这是需要注意的
                list2.add(new Vehicle(80,"blue"));
                list2.add(new Vehicle(150,"black"));
                //list1,2都用<T extend Comparable<T>>就可以了
                Vehicle vehicle=max(list2);
                System.out.println("MAX Vehicle:"+vehicle.getSpeed());


            }


            }


        }
    }



