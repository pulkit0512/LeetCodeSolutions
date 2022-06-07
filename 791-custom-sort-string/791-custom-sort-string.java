class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        int sLen = s.length();
        for(int i=0;i<sLen;i++){
            map[s.charAt(i)-'a']++;
        }
        char[] arr = new char[sLen];
        int oLen = order.length();
        int idx = 0;
        for(int i=0;i<oLen;i++){
            while(map[order.charAt(i)-'a']!=0) {
                arr[idx++] = order.charAt(i);
                map[order.charAt(i)-'a']--;
            }
        }
        for(int i=0;i<26;i++){
            while(map[i]!=0) {
                arr[idx++] = (char)(i+'a');
                map[i]--;
            }
        }
        return String.valueOf(arr);
    }
}