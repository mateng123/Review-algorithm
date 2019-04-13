public class QuickSort3Ways {

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr,int L,int R){

        //对于小规模的数组，使用插入排序
        if (R - L <= 15){
            InsertionSort.sort(arr,L,R);
            return;
        }

        //随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr,L,(int)(Math.random()*(R-L+1))+L);

        Comparable v = arr[L];

        int lt = L; //arr[l+1...lt] < v
        int gt = R+1;  // arr[gt...r] > v
        int i = L+1;  //  arr[lt+1...i) == v
        while (i< gt){
            if (arr[i].compareTo(v)<0){
                lt++;
                swap(arr,i,lt);
                i++;
            }else if (arr[i].compareTo(v)>0){
                gt--;
                swap(arr,i,gt);
            }else { //arr[i] == v
                i++;
            }
        }

        swap(arr,L,lt);

        sort(arr,L,lt-1);
        sort(arr,gt,R);
    }


    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        QuickSort3Ways.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
