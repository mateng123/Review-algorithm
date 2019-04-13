import java.util.Arrays;

public class MergeSortBU {

    private static void merge(Comparable[] arr,int l,int mid,int r){

        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);
        int i = l, j=mid+1;
        for (int k=l;k<=r;k++){
            if (i>mid){ // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j++;
            }else if (j>r){
                arr[k] = aux[i-l];
                i++;
            }else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l];
                i ++;
            }else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j ++;
            }
        }

    }

    public static void sort(Comparable[] arr){
        int n = arr.length;

        for (int sz =1;sz<n;sz *=2) {
            for (int i = 0; i < n - sz; i += 2 * sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        MergeSortBU.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
