import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num:nums1){
            if (treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num)+1);
            }else {
                treeMap.put(num,1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num:nums2){
            if (treeMap.containsKey(num)&&treeMap.get(num)>0){
                arrayList.add(num);
                treeMap.put(num,treeMap.get(num)-1);
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i=0;i<arrayList.size();i++){
            res[i] = arrayList.get(i);
        }
        return res;
    }
}