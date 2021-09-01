import java.util.Scanner;
public class test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入两个数");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int k,t;
        if (a<b){
            t=a;
            a=b;
            b=t;
        }
        do {
            k=a%b;
            a=b;
            b=k;
        } while (k!=0);
        System.out.println("最大公约数为"+a);

    }



}
