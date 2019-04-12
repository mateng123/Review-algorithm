public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i=0;i<n;i++){
            int minIndex =i;
            for (int j =i+1;j<n;j++){
                if (arr[j].compareTo(arr[minIndex])<0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(Object[]arr,int x,int y){
        Object temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {

        //测试排序算法辅助的函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("SelectionSort",arr);

    }
}
