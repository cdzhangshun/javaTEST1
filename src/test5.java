import java.util.Random;
import java.util.Scanner;

public class test5 {
    public static void main(String[] args){
        System.out.println("请输入生成几个随机数");
        Scanner scanner= new Scanner(System.in);
        int x=scanner.nextInt();
        int[] arrays=new int[x];
        Random random=new Random();
        for(int i=0;i<arrays.length;i++)
        {
            int y=random.nextInt(459)+77;
            arrays[i]=y;
            System.out.println("随机数"+y);
        }
        int sum=0;
        int max=0;
        int min=0;
        for(int i=0;i<arrays.length;i++)
        {
            sum=sum+arrays[i];
            if(max<=arrays[i])
                max=arrays[i];
            if(min>=arrays[i])
                min=arrays[i];
        }
        int aver=sum/x;
        System.out.println("和"+sum);
        System.out.println("平均值"+aver);
        System.out.println("最大值"+max);
        System.out.println("最小值"+min);
    }
}
