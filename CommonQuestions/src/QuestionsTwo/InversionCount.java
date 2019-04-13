package QuestionsTwo;

import java.util.Arrays;

/**
 * 求逆序对数
 */
public class InversionCount {

    private static long merge(Comparable[] arr,int L,int mid,int R){
        Comparable[] aux = Arrays.copyOfRange(arr,L,R+1);

        //初始化逆序数对数 res =0
        long res = 0L;

        //初始化，i指向左半部分的起始索引位置L,j指向右半部分索引位置mid+1
        int i = L,j=mid+1;
        for (int k=L;k<=R;k++){
            if (i>mid){ //如果左半部分已经处理完
                arr[k] = aux[j-L];
                j++;
            }else if (j>R){ //右半部分已经处理完
                arr[k] = aux[i-L];
                i++;
            }else if (aux[i-L].compareTo(aux[j-L])<=0){ // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i-L];
                i++;
            }else { // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j-L];
                j++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res += (long)(mid-i+1);
            }

        }
        return res;
    }

    // 求arr[l..r]范围的逆序数对个数
    private static long solve(Comparable[] arr,int L,int R){
        if (L>=R){
            return 0L;
        }
        int mid = L+(R-L)/2;
        // 求出 arr[l...mid] 范围的逆序数
        long res1 = solve(arr, L, mid);
        // 求出 arr[mid+1...r] 范围的逆序数
        long res2 = solve(arr, mid + 1, R);

        return res1 + res2 + merge(arr, L, mid, R);
    }

    public static long solve(Comparable[] arr){

        int n = arr.length;
        return solve(arr, 0, n-1);
    }

    // 测试 InversionCount
    public static void main(String[] args) {

        int N = 5;

        // 测试1: 测试随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " :" + solve(arr) );

        // 测试2: 测试完全有序的数组
        // 结果应该为0
        arr = SortTestHelper.generateOrderedArray(N);
        System.out.println("Test Inversion Count for Ordered Array, n = " + N + " :" + solve(arr) );

        // 测试3: 测试完全逆序的数组
        // 结果应改为 N*(N-1)/2
        arr = SortTestHelper.generateInversedArray(N);
        System.out.println("Test Inversion Count for Inversed Array, n = " + N + " :" + solve(arr) );


        return;
    }

}
