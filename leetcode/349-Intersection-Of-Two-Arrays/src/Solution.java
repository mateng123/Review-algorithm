import java.util.ArrayList;
import java.util.TreeSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i=0;i<nums1.length;i++){
            treeSet.add(nums1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0;i<nums2.length;i++){
            if (treeSet.contains(nums2[i])){
                list.add(nums2[i]);
                treeSet.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i =0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}