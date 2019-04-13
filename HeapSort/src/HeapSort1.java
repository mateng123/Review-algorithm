public class HeapSort1 {

//    // 对整个arr数组使用HeapSort1排序
//    // HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
//    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
//    // 整个堆排序的整体时间复杂度为O(nlogn)
//    public static void sort(Comparable[] arr){
//
//        int n = arr.length;
//        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
//        for (int i=0;i<n;i++){
//            maxHeap.add(arr[i]);
//        }
//
//        for (int i = n-1;i>=0;i--){
//            arr[i] = maxHeap.extractMax();
//        }
//    }

    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }

    // 测试 HeapSort1
    public static void main(String[] args) {

        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("HeapSort1", arr);
        System.out.println(SortTestHelper.isSorted(arr)+"  ");
        return;
    }
}
