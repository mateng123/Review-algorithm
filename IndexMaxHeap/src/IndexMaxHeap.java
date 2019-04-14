import java.util.Arrays;

public class IndexMaxHeap<E extends Comparable> {
    private Array<E> data;
    private int[] indexes;  //最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    private int[] reverse;  //最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置

    public IndexMaxHeap(int capacity){
        data = new Array<>(capacity);
        indexes = new int[capacity];
        reverse = new int[capacity];
        for (int i=0;i<capacity;i++){
            reverse[i] = -1;
        }
    }

    public IndexMaxHeap(){
        data = new Array<>();
        indexes = new int[data.getSize()];
        reverse = new int[data.getSize()];
        for (int i=0;i<data.getSize();i++){
            reverse[i] = -1;
        }
    }

    public IndexMaxHeap(E[] arr){
        data = new Array<>(arr);
        indexes = new int[arr.length];
        reverse = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            reverse[i] = -1;
        }
        for (int i=parent(arr.length-1);i>=0;i--){
            siftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if (index==0){
            throw new IllegalArgumentException("Index 0 does not has parent");
        }
        return (index-1)/2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index+1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index+2;
    }

    //向堆中添加元素
    public void add(int i,E e){

        assert i>=0 && i <=size();

        data.add(i,e);
        indexes[size()-1] =i;
        reverse[i] = indexes[size()-1];
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k){

        while (k>0 && data.get(indexes[parent(k)]).compareTo(data.get(indexes[k]))<0){
            swapIndexes(k,parent(k));
            k = parent(k);
        }
    }

    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    //看堆中的最大元素
    public E findMax(){
        if (data.getSize()==0){
            throw new IllegalArgumentException("Can not findMax when IndexMaxHeap is empty");
        }
        return data.get(indexes[0]);
    }

    //取出堆中最大元素
    public E extractMax(){
        E res = findMax();

        data.swap(0,data.getSize()-1);
        reverse[indexes[0]] = 0;
        reverse[indexes[size()-1]] = -1;
        data.removeLast();
        siftDown(0);
        return res;
    }

    // 从最大索引堆中取出堆顶元素的索引
    public int extractMaxIndex(){
        assert size() > 0;

        int ret = indexes[0];
        data.swap(0,data.getSize()-1);
        reverse[indexes[0]] = 0;
        reverse[indexes[size()-1]] = -1;
        data.removeLast();
        siftDown(0);

        return ret;
    }

    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex(){
        assert size()>0;
        return indexes[0];
    }

    // 看索引i所在的位置是否存在元素
    boolean contain( int i ){
        assert  i  >= 0 && i + 1 <= size()-1;
        return reverse[i] != -1;
    }

    // 获取最大索引堆中索引为i的元素
    public E getItem(int i){
        assert contain(i);
        return data.get(i);
    }

    // 获取最大索引堆中的堆顶元素
    public E getMax(){
        assert size() > 0;
        return data.get(indexes[0]);
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i,E newE){

        assert contain(i);

        data.set(i,newE);

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
//        for (int j=0;j<=size()-1;j++){
////            if (indexes[j] == i){
////                siftUp(j);
////                siftDown(j);
////                return;
////            }
////        }

        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        siftUp( reverse[i] );
        siftDown( reverse[i] );
    }

    private void siftDown(int k){
        while (leftChild(k)<data.getSize()){
            int j = leftChild(k);
            if (j+1<data.getSize()&&data.get(indexes[j+1]).compareTo(data.get(indexes[j]))>0) {
                j++;
                //此时data[j]是leftChild 和rightChild 中的最大值
            }
            if (data.get(indexes[k]).compareTo(data.get(indexes[j]))>=0){
                break;
            }else {
                swapIndexes(k,j);
                k=j;
            }
        }
    }

    //取出堆中最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    // 测试索引堆中的索引数组index和反向数组reverse
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes(){

        int[] copyIndexes = new int[size()];
        int[] copyReverseIndexes = new int[size()];

        for( int i = 0 ; i <= size()-1 ; i ++ ) {
            copyIndexes[i] = indexes[i];
            copyReverseIndexes[i] = reverse[i];
        }

        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...count这count个索引
        boolean res = true;
        for( int i = 1 ; i <= size()-1 ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i-1] + 1 != copyReverseIndexes[i] ){
                res = false;
                break;
            }

        if( !res ){
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    // 测试 IndexMaxHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.add( i , (int)(Math.random()*N) );
        assert indexMaxHeap.testIndexes();
    }
}
