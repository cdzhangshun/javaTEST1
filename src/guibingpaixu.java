import java.util.concurrent.LinkedTransferQueue;

public class guibingpaixu {
    public static void main(String[] args) {
        int a[]={1,12,4,18,29,19,10,23,24,54,6,9};
        int temp[]=new int[a.length];
        fenhe(a,0, a.length-1, temp);
        for (int i=0;i< a.length;i++){
            System.out.println(a[i]);
        }


    }
    public static void fenhe(int[] arr,int left,int right,int[] temp){
        if (left<right) {
            int mid = (left + right) / 2;
            //向左递归
            fenhe(arr,left,mid,temp);
            //向右递归
            fenhe(arr,mid+1,right,temp);
            //继续和递归
            sort(arr,left,mid,right,temp);
        }

    }

    /**
     *
     * @param arr   原数组
     * @param left  起始位置
     * @param mid   中间索引
     * @param right  右边
     * @param temp    创立的新数组，后面用来复制
     */
    public static void sort(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid&&j<=right) {  //从左边开始导入创立的新数组
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
            while (i<=mid){
                temp[t] = arr[i];    //左边剩余的全部放进去
                t++;
                i++;
            }
            while (j<=right){
                temp[t] = arr[j];   //右边剩余的也全部放进去
                t++;
                j++;
            }
            //开始拷贝数组到原数组中去，这个是重点(有些不理解，每次拷贝的不是全部数组）只有最后一次是的
              t=0;
            int k=left;  //最后一次合并才是k=0,right=arr.lenght-1;
            System.out.println("k"+k+"right"+right);
            while (k<=right){
                arr[k]=temp[t];
                k++;
                t++;
            }






    }
}


