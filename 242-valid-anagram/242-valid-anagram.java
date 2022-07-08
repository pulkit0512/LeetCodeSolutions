class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen!=tLen){
            return false;
        }
        int[] sMap = new int[26];
        for(int i=0;i<sLen;i++){
            char ch = s.charAt(i);
            sMap[ch-'a']++;
        }
        for(int i=0;i<tLen;i++){
            char ch = t.charAt(i);
            if(sMap[ch-'a']==0){
                return false;
            }
            sMap[ch-'a']--;
        }
        return true;
    }
}