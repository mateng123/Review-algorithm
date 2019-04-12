public class BubbleSort {

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i=0;i<n;i++){
            for (int j=n-1;j>i;j--){
                if (arr[j].compareTo(arr[j-1])<0){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    private static void swap(Object[]arr,int x,int y){
        Object temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        BubbleSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
