public class QuickSort2Ways {

    private static int partition(Comparable[] arr,int L,int R){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr,L,(int)(Math.random()*(R-L+1))+L);

        Comparable v =arr[L];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i=L+1,j=R;
        while (true){
            while (i<=R && arr[i].compareTo(v)<0) i++;
            while (j>=L+1 && arr[j].compareTo(v)>0) j--;

            if (i>j){
                break;
            }

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, L, j);

        return j;
    }

    //递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr,int L,int R){
        if (R-L <= 15){
            InsertionSort.sort(arr,L,R);
            return;
        }

        int p = partition(arr,L,R);
        sort(arr,L,p-1);
        sort(arr,p+1,R);
    }


    public static void sort(Comparable[] arr){
        int n =arr.length;
        sort(arr,0,n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        QuickSort2Ways.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
