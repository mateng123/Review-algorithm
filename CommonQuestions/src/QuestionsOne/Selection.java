package QuestionsOne;

/**
 * 查找第k小的数
 */
public class Selection {

    private static int partition(Comparable[] arr,int L, int R){
        //随机选择partition的值
        swap(arr,L,(int)(Math.random()*(R-L+1))+L);

        Comparable c = arr[L];
        int j=L;
        for (int i = L+1;i<=R;i++){
            if (arr[i].compareTo(c)<0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,j,L);

        return j;
    }

    // 寻找nums数组中第k小的元素
    // 注意: 在我们的算法中, k是从0开始索引的, 即最小的元素是第0小元素, 以此类推
    // 如果希望我们的算法中k的语意是从1开始的, 只需要在整个逻辑开始进行k--即可, 可以参考solve2
    public static Comparable solve(Comparable nums[],int k){
        assert nums != null && k>=0 && k<nums.length;
        return solve(nums,0,nums.length-1,k);
    }

    //求出nums[l...r]范围里第k小的数
    private static Comparable solve(Comparable[] nums,int L,int R,int k){
        if (L == R){
            return nums[L];
        }

        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(nums,L,R);

        if (p == k){
            return nums[p];
        }else if (p > k){
            return solve(nums,p+1,R,k);
        }else {
            return solve(nums,L,p-1,k);
        }
    }

    // 寻找nums数组中第k小的元素, k从1开始索引, 即最小元素是第1小元素, 以此类推
    public static Comparable solve2(Comparable nums[], int k) {

        return Selection.solve(nums, k - 1);
    }

    private static void swap(Object[] arr,int i,int j ){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    //测试Selection
    public static void main(String[] args){

        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10000;
        Integer[] arr = TestHelper.generateOrderedArray(N);
        TestHelper.shuffleArray(arr);

        // 验证Selection.solve, 对arr数组求第i小元素, 应该为i
        for( int i = 0 ; i < N ; i ++ ){
            assert solve(arr, i).compareTo(i)==0;
            System.out.println("test " + i + " complete.");
        }
        System.out.println("Test QuestionsOne.Selection.solve completed.");
        System.out.println();

        arr = TestHelper.generateOrderedArray(N);
        TestHelper.shuffleArray(arr);

        // 验证Selection.solve2, 对arr数组求第i小元素, 应该为i-1
        // 因为在Selection.solve2中, 第k小元素的k是从1索引的
        for( int i = 0 ; i < N ; i ++ ){
            assert solve2(arr, i) .compareTo( i - 1)==0;
            System.out.println("test " + i + " complete.");
        }
        System.out.println("Test QuestionsOne.Selection.solve2 completed.");

    }
}
