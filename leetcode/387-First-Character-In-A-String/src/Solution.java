class Solution {
    public int firstUniqChar(String s) {
        int[] a = new int[26];
        for (int i=0;i<26;i++){
            a[i]=0;
        }
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            a[c-'a']++;
        }
        for (int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if (a[c-'a']==1){
                return i;
            }
        }
        return -1;
    }
}