public class kuaisupaixu {
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,k;
        i=low;
        j=high;
        if (i>j){
            return;
        }
        temp=arr[low];
        while (i<j){
            while (temp<=arr[j]&&i<j){    //先看右边
                j--;
            }
            while (temp>=arr[i]&&i<j){   //再看左边，顺序不能错
                i++;
            }
            if (i<j) {
                k= arr[j];
                arr[j] = arr[i];
                arr[i] =k;
            }

        }
        arr[low]=arr[i];
        arr[i]=temp;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);

    }

    public static void main(String[] args) {
        int a[]={1,12,4,18,29,19,10,23,24,54,6,9};
        quickSort(a,0, a.length-1);
        for (int i=0;i< a.length;i++){
            System.out.println(a[i]);
        }



    }

    }
