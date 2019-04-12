public class ShellSort {

    public static void sort(Comparable[] arr){
        int n = arr.length;

        //计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h<n/3){
            h = 3*h+1;
        }

        while (h>= 1){
            for (int i=h;i<n;i++){
                Comparable cur = arr[i];
                int j;
                for (j= i;j>0 && cur.compareTo(arr[j])<0 ;j-=h){
                    arr[j] = arr[j+1];
                }
                arr[j] =(Comparable) cur;
            }
            h /= 3;
        }
    }
    // 测试
    public static void main(String[] args) {

        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        ShellSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
