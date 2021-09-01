import java.util.Scanner;
public class test3 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符串");
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char[] arr=str.toCharArray();//将字符串转化为字符数组
        char[] dic=new char[58];
        for(int i=0;i<dic.length;i++){
            dic[i]=(char)(i+65);
        }
        int[] counts=new int[58];//创建一个记录字母次数的数组
        for(int i=0;i<arr.length;i++){//判断字母出现次数
            for(int j=0;j<dic.length;j++){
                if(arr[i]==dic[j]){
                    counts[j]++;
                }
            }
        }
        for (int i=0;i<counts.length;i++){
            System.out.println(dic[i]+"次数"+counts[i]);
        };
        }


    }

