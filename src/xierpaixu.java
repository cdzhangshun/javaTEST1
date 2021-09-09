public class xierpaixu {

    public static void main(String[] args) {
            int a[]={1,12,4,18,29,19,10,23,24,54,6,9};
            sort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }


    }
    public static  void sort (int[] arr) {
        int temp;
        for (int i = arr.length / 2; i >0; i = i / 2) {    //先分组循环，这步重要
            for (int j = i; j < arr.length; j++) {             //遍历分的组
                for (int k = j-i; k >= 0; k -= i) {               //两个两个的比较,其实这个循环好像不需要，就只循环了一次
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }



    }


