import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        System.out.println("请输入一个人的出生月份");
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int a=0;
        int i=n+100;
        while (n<=i){
            if (n%4==0||n%400==0) {
                a=a+1;
            }
            n++;
        }
        System.out.println("这个人能过"+a+"个闰年");
    }


}
