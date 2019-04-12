public class InsertionSort {

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i=1;i<n;i++){
            Object cur = arr[i];
            for (int j = i-1;j>0 ;j-- ){
                if (arr[i].compareTo(arr[j])<0){
                    arr[j] = arr[j+1];
                }
                arr[j] = (Comparable)cur;
            }
        }

    }

    // 测试
    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
