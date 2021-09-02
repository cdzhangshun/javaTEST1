import java.util.Scanner;
public class test4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a[]=new int[10];
        int sum=0;
        for (int i=0;i<10;i++){
            a[i]=scanner.nextInt();
            sum=sum+a[i];
        }
        int n=sum/10;
        for (int i=0;i<10;i++){
            if (a[i]>n){
                System.out.println("这些元素为："+a[i]);
            }
        }
    }
}
