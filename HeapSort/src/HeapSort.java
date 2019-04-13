// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {

    public static void sort(Comparable[] arr){

        int n = arr.length;

        for (int i = (n-1-1)/2;i>=0;i--){
            siftDown(arr,n,i);
        }

        for (int i= n-1;i>0;i--){
            swap(arr,0,i);
            siftDown(arr,i,0);
        }
    }

    private static void siftDown(Comparable[] arr, int n,int k){
        while (2*k+1<n){
            int j = 2*k+1;
            if (j+1<n&&arr[j+1].compareTo(arr[j])>0) {
                j++;
                //此时data[j]是leftChild 和rightChild 中的最大值
            }
            if (arr[k].compareTo(arr[j])>=0){
                break;
            }else {
                swap( arr, k, j);
                k=j;
            }
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("HeapSort", arr);
        System.out.println(SortTestHelper.isSorted(arr)+"  ");
        return;
    }
}
