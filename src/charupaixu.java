public class charupaixu {
    public static void main(String[] args) {
        int a[]={1,12,4,18,29,19,10,23};
        for(int i=0; i<a.length-1; i++){
            for(int j=i; j>=0; j--){
                if(a[j+1]<a[j]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }

            }
        }
        for (int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
        }
    }

}
