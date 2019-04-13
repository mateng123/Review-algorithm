public class InsertionSort {

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i=1;i<n;i++){
            Comparable cur = arr[i];
            int j;
            for (j = i;j>0&&cur.compareTo(arr[j-1])<0 ;j-- ){
                    arr[j] = arr[j-1];
                }
            arr[j] = cur;
            }

        }

    //对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr,int L,int R){
        for (int i=L;i<=R;i++){
            Comparable cur = arr[i];
            int j;
            for (j=i;j>0&&cur.compareTo(arr[j-1])<0;j--){
                arr[j]=arr[j-1];
            }
            arr[j] = cur;
        }
    }

    // 测试
    public static void main(String[] args) {

        Integer[] arr = {10,7,8,9,6,5,4,3,2,1};
        InsertionSort.sort(arr,0,9);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
